package Forum.TCPCommunicationLayer;

import Forum.DomainLayer.Forum;
import Forum.Exceptions.NoSuchUserException;
import Forum.Exceptions.WrongPasswordException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tomer Heber
 *
 */
public class LoginMessage extends ClientMessage {

	private static final long serialVersionUID = -2723317717299435031L;
	
	/** 
	 * The username of the user. 
	 */
	private String m_username;
	
	/** 
	 * The password of the user. 
	 */
	private String m_password;

	public LoginMessage(String username, String password) {
		m_username = username;
		m_password = password; 
	}

	/* (non-Javadoc)
	 * @see forum.tcpcommunicationlayer.ClientMessage#doOperation(forum.server.domainlayer.ForumFacade)
	 */
	@Override
	public ServerResponse doOperation() {
            ServerResponse tResponse;
        try {
            Forum.getInstance().login(m_username, m_password);
            String tAns = m_username + " logged in successfully.";
            tResponse = new ServerResponse(tAns,true);
        } catch (NoSuchUserException ex) {
            //Logger.getLogger(LoginMessage.class.getName()).log(Level.SEVERE, null, ex);
            String tAns = m_username + " does not exist.";
            tResponse = new ServerResponse(tAns,false);
        } catch (WrongPasswordException ex) {
            //Logger.getLogger(LoginMessage.class.getName()).log(Level.SEVERE, null, ex);
            String tAns = "Wrong password.";
            tResponse = new ServerResponse(tAns, false);
        }
		return tResponse;
	}

}
