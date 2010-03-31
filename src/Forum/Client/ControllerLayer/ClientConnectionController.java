package Forum.Client.ControllerLayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.StringTokenizer;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import Forum.Settings;
import Forum.TCPCommunicationLayer.*;

/**
 * This class handles the communication between the client and the server.
 * 
 * @author Tomer Heber
 */
public class ClientConnectionController extends Thread {

	private Socket m_socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	private static Logger log = Logger.getLogger(Settings.loggerName);
	
	public ClientConnectionController(String addr, short port) throws IOException {
		InetAddress ia = InetAddress.getByName(addr);
		connect(ia,port);
	}
	
	@Override
	public void run() {
		BufferedReader prompt = new BufferedReader(new InputStreamReader(System.in));  
		try {
			printHelp();
			while (true) {
				/* Receives a command from the user. */
				System.out.print("> ");
				String str = prompt.readLine();
				
				if (str == null) {
					break;
				}
				
				if (str.equals("disconnect")) {
					break;
				}
				
				if (str.equals("help")) {
					printHelp();
					continue;
				}
								
				ClientMessage msg;
				try {
					/* Handles the command. */
					msg = handleCommand(str);						
				} catch (BadCommandException e) {
					log.info("The user has inputed an invalid command.");
					e.printStackTrace();
					System.out.println();
					continue;
				}
				/* send the message to the server. */
				out.writeObject(msg);
				/* receive response from the server. */
				Object o = in.readObject();
				if (o == null) {
					log.severe("Lost connection to server.");
					break;
				}
				if (!(o instanceof ServerResponse)) {
					log.severe("Received an invalid response from server.");
					break;
				}
				
				ServerResponse res = (ServerResponse)o;
				/* Check if the server has done the command. */
				if (res.hasExecuted()) {
					System.out.println("done!");
				}
				else {
					System.out.println("failed!");
				}
				/* Print the response from the server */
				System.out.println(res.getResponse());
				
			}
		} catch (ClassNotFoundException e) {
			log.severe("Received an invalid object from the server.");
			e.printStackTrace();
		} catch (IOException e) {
			log.severe("IOException occured while trying to read/send/write.");
			e.printStackTrace();			
		}
		finally {			
			try {
				/* Closing all the streams. */
				prompt.close();
				closeConnection();
			} catch (IOException e) {
				log.severe("IOException while trying to close streams.");
				e.printStackTrace();
			}			
		}
	}
	
	private void printHelp() {
		System.out.println(
				"help menu:" + "\n" +
				"- help " +  "\n" +
				"- add_message <message content>" + "\n" +
				"- add_reply <message id to reply to> <message content>" + "\n" +
				"- modify_message <message id to modify> <new message content>" + "\n" +
				"- view_forum" + "\n" +
				"- logoff" + "\n" +
				"- login <username> <password>" + "\n" +
				"- register <firstname><lastname><nickname> <e-mail> <username> <password>" + "\n" +
                                "- upgrade_user <username to be upgraded>" + "\n" +
                                "- delete_message <message id to delete>" + "\n" +
                                "- search_by_author <author's nickname> <from index><to index>" + "\n" +
                                "- search_by_phrase  <from index><to index><prhase to be searched>" + "\n" +
				"- disconnect" + "\n" +
				"//TODO add more operations (Admin, Moderator, Search)"	+ "\n"			
		);								
		
	}

	/**
	 * This method receives commands and creates the proper message to send to the server.
	 * 
	 * @param str The command to do.
	 * @return The message to send back to the server.
	 * @throws BadCommandException This exception is thrown is the command given by the user is invalid.
	 */
	private ClientMessage handleCommand(String str) throws BadCommandException {		
		try {
			StringTokenizer st = new StringTokenizer(str);
			String command = st.nextToken();
			
			if (command.equals("add_message")) {							
				return new AddMessageMessage(str.substring(command.length()+1));
			}
			if (command.equals("view_forum")) {
				return new ViewForumMessage();
			}
			if (command.equals("login")) {
				return new LoginMessage(st.nextToken(),st.nextToken());
			}
			if (command.equals("logoff")) {
				return new LogoffMessage();
			}
			if (command.equals("register")) {
				return new RegisterMessage(st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken());
			}
			if (command.equals("add_reply")) {
				String messageIdS = st.nextToken();
				long messageId = Long.parseLong(messageIdS);
				return new AddReplyMessage(messageId,str.substring(command.length()+messageIdS.length()+2));
			}			
			if (command.equals("modify_message")) {
				String messageIdS = st.nextToken();
				long messageId = Long.parseLong(messageIdS);
				return new ModifyMessageMessage(messageId,str.substring(command.length()+messageIdS.length()+2));
			}
                        if (command.equals("upgrade_user")){
                                String tusername = st.nextToken();
                                return new UpgradeUserMessage(tusername);

                        }
                         if (command.equals("delete_message")){
                                String tMessageIdS = st.nextToken();
                                long tMessageId = Long.parseLong(tMessageIdS);
                                return new DeleteMessageMessage(tMessageId);

                        }
                        if (command.equals("search_by_author")){
                                String tNickname = st.nextToken();
                                String tFromS = st.nextToken();
                                String tToS = st.nextToken();
                                int tTo = Integer.parseInt(tToS);
                                int tFrom = Integer.parseInt(tFromS);
                                return new SearchByAuthorMessage(tNickname,tFrom,tTo);

                        }
                        if (command.equals("search_by_phrase")){
                                String tFromS = st.nextToken();
                                String tToS = st.nextToken();
                                String tPhrase = st.nextToken();
                                int tTo = Integer.parseInt(tToS);
                                int tFrom = Integer.parseInt(tFromS);
                                return new SearchByContentMessage(tPhrase,tFrom,tTo);

                        }

		}
		catch(Exception e) {
			throw new BadCommandException("The command "+str+" is invalid.");
		}
		
		throw new BadCommandException("The command "+str+" is unknown.");		
	}	

	private void connect(InetAddress addr, short port) throws IOException {
		SocketAddress sa = new InetSocketAddress(addr,port);
		/* Connect to the server */
		m_socket = new Socket();
		m_socket.connect(sa);
		out = new ObjectOutputStream(m_socket.getOutputStream());
		out.flush();
		in = new ObjectInputStream(m_socket.getInputStream());
		log.info("The client is connected to the server.");
	}
	
	private void closeConnection() throws IOException {
		in.close();
		out.close();
		m_socket.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String logFileName = "clientLog"+(int)(Math.random()*1000.0)+".log";
		if (args.length > 0) {
			logFileName = args[0];
		}
		try {
			/* Create a logger for the client (to a file...). */
			FileHandler handler = new FileHandler(logFileName);
			log.addHandler(handler);
		} catch (SecurityException e) {		
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
				
		try {
			/* Start the client */
			Thread thread = new ClientConnectionController("127.0.0.1",(short)1234);
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		} catch (IOException e) {
			log.severe("An IOException was thrown while trying to connect to the server.");
			e.printStackTrace();
		}		
				
		log.info("Exiting...");

	}

}
