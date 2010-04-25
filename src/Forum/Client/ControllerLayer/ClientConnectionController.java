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
public class ClientConnectionController {

    private Socket m_socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private static Logger log = Logger.getLogger(Settings.loggerName);

    public  ClientConnectionController(String addrres, short port) {
        InetAddress addr;
        try {
            addr = InetAddress.getByName(addrres);
            SocketAddress sa = new InetSocketAddress(addr, port);
            m_socket = new Socket();
            m_socket.connect(sa);
            out = new ObjectOutputStream(m_socket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(m_socket.getInputStream());
            log.info("The client is connected to the server.");
        } catch (IOException ex) {
            log.severe("got IOException while connecting to the server");
        }
    }

    public void send(ClientMessage msg) {
        try {
            /* send the message to the server. */
            out.writeObject(msg);
            /* receive response from the server. */
        } catch (IOException ex) {
            log.severe("got IOException while sending");
        }
    }

    public ServerResponse listen() {
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
           return  (ServerResponse) o;
        }
        return null;
    }

    public void closeConnection() throws IOException {
        in.close();
        out.close();
        m_socket.close();
    }
}
