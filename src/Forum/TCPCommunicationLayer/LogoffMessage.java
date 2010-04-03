package Forum.TCPCommunicationLayer;

import Forum.DomainLayer.Forum;

/**
 * @author Tomer Heber
 *
 */
public class LogoffMessage extends ClientMessage {

	private static final long serialVersionUID = -5965616226069995574L;

	/* (non-Javadoc)
	 * @see forum.tcpcommunicationlayer.ClientMessage#doOperation(forum.server.domainlayer.ForumFacade)
	 */
	@Override
	public ServerResponse doOperation() {
		Forum.getInstance().logout("toBeAddedLater");
                ServerResponse tResponse = new ServerResponse("user logged off successfully.",true);
		return tResponse;
	}

}
