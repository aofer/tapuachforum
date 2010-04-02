package Forum.TCPCommunicationLayer;

import Forum.DomainLayer.Forum;
import Forum.Exceptions.MessageNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tomer Heber
 *
 */
public class AddReplyMessage extends ClientMessage {

	private static final long serialVersionUID = 6721172261483674344L;
	
	/**
	 * The id of the message to which the reply message is added to.
	 * (The forum is nested).
	 */
	private long m_parentMessageId;
	
	/**
	 * The content of the reply message.
	 */
	private String m_content;

	public AddReplyMessage(long parentMessageId, String content) {
		m_parentMessageId = parentMessageId;
		m_content = content;
	}

	/* (non-Javadoc)
	 * @see forum.tcpcommunicationlayer.ClientMessage#doOperation(forum.server.domainlayer.ForumFacade)
	 */
	@Override
	public ServerResponse doOperation(Forum forum) {
            ServerResponse tResponse;
        try {
            Forum.getInstance().addReply((int) m_parentMessageId, "noNickYet", "NoSubjectYet", m_content);
            tResponse = new ServerResponse("Reply was added  successfully.", true);
            return tResponse;
        } catch (MessageNotFoundException ex) {
          //  Logger.getLogger(AddReplyMessage.class.getName()).log(Level.SEVERE, null, ex);
            tResponse = new ServerResponse("Message was not found, new reply was not added!", false);
            return tResponse;
        }
     //   return tResponse;
	}

}
