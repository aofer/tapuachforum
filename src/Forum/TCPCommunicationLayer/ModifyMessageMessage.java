package Forum.TCPCommunicationLayer;

import Forum.DomainLayer.Forum;
import Forum.Exceptions.MessageNotFoundException;
import Forum.Exceptions.MessageOwnerException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tomer Heber
 *
 */
public class ModifyMessageMessage extends ClientMessage {

	private static final long serialVersionUID = -4738980852130566587L;
	
	/**
	 * The id of the message which the client wants to modify.
	 * (The forum is nested).
	 */
	private long m_messageId;
	
	/**
	 * The new content of the message.
	 */
	private String m_content;

	public ModifyMessageMessage(long messageId, String content) {
		m_messageId = messageId;
		m_content = content;
	}

	/* (non-Javadoc)
	 * @see forum.tcpcommunicationlayer.ClientMessage#doOperation(forum.server.domainlayer.ForumFacade)
	 */
	@Override
	public ServerResponse doOperation(Forum forum) {
            ServerResponse tResponse;
        try {
            Forum.getInstance().editMessage("nickNameTBA", (int) m_messageId,"subjectTBA", m_content);
            tResponse = new ServerResponse("Message was modified successfully.", true);
        } catch (MessageNotFoundException ex) {
            String tAns = "Message " + m_messageId + " does not exist.";
            tResponse = new ServerResponse(tAns, false);
            //Logger.getLogger(ModifyMessageMessage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessageOwnerException ex) {
            String tAns = "You are not the owner of this message.";
            tResponse = new ServerResponse(tAns,false);
           // Logger.getLogger(ModifyMessageMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
		return tResponse;
	}

}
