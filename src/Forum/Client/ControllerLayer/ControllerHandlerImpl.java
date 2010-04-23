package forum.client.controllerlayer;

import Forum.Settings;
import Forum.TCPCommunicationLayer.ClientMessage;
import Forum.TCPCommunicationLayer.ServerResponse;
import java.awt.Component;

import forum.client.ui.events.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.logging.Logger;

/**
 * You need to delete all the code in here and implement it yourself.<br>
 * This code is just for you to understand how to work with the Observer/Observed and GUI.
 * 
 * @author Tomer Heber
 */
public class ControllerHandlerImpl extends ControllerHandler {

    private Socket m_socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private static Logger log = Logger.getLogger(Settings.loggerName);

    /* (non-Javadoc)
     * @see forumtree.contol.ControllerHandler#getForumView()
     */
    public void setConnection(String addr, short port) throws IOException {
        InetAddress ia = InetAddress.getByName(addr);
        connect(ia, port);
    }

    private void connect(InetAddress addr, short port) throws IOException {
        SocketAddress sa = new InetSocketAddress(addr, port);
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

    private void send(ClientMessage msg) {
        try {
            /* send the message to the server. */
            out.writeObject(msg);
            /* receive response from the server. */
        } catch (IOException ex) {
             log.severe("got IOException while sending");
        }
    }

    private void listen() {
        Object o = null;

        try {
            o = in.readObject();
        } catch (IOException ex) {
            log.severe("got IOException while listinnig");
        } catch (ClassNotFoundException ex) {
            log.severe("got ClassNotFoundException while listinnig");
        }
        if (o == null) {
            log.severe("Lost connection to server.");
        } else if (!(o instanceof ServerResponse)) {
            log.severe("Received an invalid response from server.");
        } else {
            ServerResponse res = (ServerResponse) o;
            /* Check if the server has done the command. */
            if (res.hasExecuted()) {
                System.out.println("done!");
            } else {
                System.out.println("failed!");
            }
            /* Print the response from the server */
            System.out.println(res.getResponse());
        }
    }

    @Override
    public String getForumView() {
        return "";
    }

    @Override
    public void modifyMessage(long id, String newContent, Component comp) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        notifyObservers(new ForumTreeRefreshEvent(comp, getForumView()));
        if (Math.random() > 0.5) {
            notifyObservers(new ForumTreeErrorEvent("Failed to modify a message"));
        }
    }

    @Override
    public void addReplyToMessage(long id, String string, Component comp) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        notifyObservers(new ForumTreeRefreshEvent(comp, getForumView()));
        if (Math.random() > 0.5) {
            notifyObservers(new ForumTreeErrorEvent("Failed to reply to a message"));
        }
    }

    @Override
    public void deleteMessage(long id, Component comp) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        notifyObservers(new ForumTreeRefreshEvent(comp, getForumView()));
        if (Math.random() > 0.5) {
            notifyObservers(new ForumTreeErrorEvent("Failed to delete message"));
        }

    }

    @Override
    public void addNewMessage(Component comp) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        notifyObservers(new ForumTreeRefreshEvent(comp, getForumView()));
        if (Math.random() > 0.5) {
            notifyObservers(new ForumTreeErrorEvent("Failed to add a new message"));
        }

    }
}
