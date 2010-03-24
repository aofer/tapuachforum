package Forum.TCPCommunicationLayer;

import Forum.DomainLayer.Forum;
import Forum.Exceptions.BadPasswordException;
import Forum.Exceptions.NicknameExistsException;
import Forum.Exceptions.UserExistsException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tomer Heber
 *
 */
public class RegisterMessage extends ClientMessage {

	private static final long serialVersionUID = -3267419208356408002L;
	
	/**
	 * The users real name.
	 */
	private String m_realname;
	
	/**
	 * The e-mail of the user.
	 */
	private String m_email;
	
	/** 
	 * The username of the user. 
	 */
	private String m_username;
	
	/** 
	 * The password of the user. 
	 */
	private String m_password;

	public RegisterMessage(String realname, String email, String username, String password) {
		m_realname = realname;
		m_email = email;
		m_username = username;
		m_password = password;		
	}

	/* (non-Javadoc)
	 * @see forum.tcpcommunicationlayer.ClientMessage#doOperation(forum.server.domainlayer.ForumFacade)
	 */
	@Override
	public ServerResponse doOperation(Forum forum) {
            Date tDate = new Date();
            ServerResponse tResponse;
        try {
            Forum.getInstance().register(m_username, m_password, "nicknameTBA", m_email, m_realname, "lastNameTBA", tDate);
            tResponse = new ServerResponse("Registeration was successful.", true);
        } catch (UserExistsException ex) {
            //Logger.getLogger(RegisterMessage.class.getName()).log(Level.SEVERE, null, ex);
            String tAns = m_username + " already exist.";
            tResponse = new ServerResponse(tAns, false);
        } catch (NicknameExistsException ex) {
            //Logger.getLogger(RegisterMessage.class.getName()).log(Level.SEVERE, null, ex);
            String tAns = "nicknameTBA" + " already exist.";
            tResponse = new ServerResponse(tAns, false);
        } catch (BadPasswordException ex) {
          //  Logger.getLogger(RegisterMessage.class.getName()).log(Level.SEVERE, null, ex);
            tResponse = new ServerResponse("password does not meet the policy, please choose a different password.", false);
        }
            return tResponse;
	}

}
