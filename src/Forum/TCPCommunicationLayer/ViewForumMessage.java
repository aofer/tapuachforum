package Forum.TCPCommunicationLayer;

import Forum.DomainLayer.Forum;
import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.DomainLayer.Message;
import java.util.Vector;

/**
 * 
 * @author Tomer Heber 
 */
public class ViewForumMessage extends ClientMessage {

	private static final long serialVersionUID = 923990416696133754L;

	/* (non-Javadoc)
	 * @see forum.tcpcommunicationlayer.ClientMessage#doOperation(forum.server.domainlayer.ForumFacade)
	 */
	@Override
	public ServerResponse doOperation(Forum forum) {
		System.out.println("test");
                Vector<Message> tForum = Forum.getInstance().viewForum();
                String tForumString = "";
                for (int i = 0;i<tForum.size();i++){
                tForumString = tForumString + tForum.elementAt(i).toString() + "\n";
                //System.out.println(tForumString);
                }
                ServerResponse tResponse = new ServerResponse(tForumString, true);
		return tResponse;
	}

}
