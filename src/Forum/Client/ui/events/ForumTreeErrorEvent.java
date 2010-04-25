package Forum.Client.ui.events;

import Forum.Client.ui.ForumTreeHandler;

/**
 * @author Tomer Heber
 *
 */
public class ForumTreeErrorEvent implements ForumTreeEvent {

	/**
	 * The error message to show the user in the GUI.
	 */
	private String m_errorMessage;
	
	public ForumTreeErrorEvent(String errorMessage) {
		m_errorMessage = errorMessage;
	}

	/* (non-Javadoc)
	 * @see forumtree.contol.ForumTreeEvent#respondToEvent(forumtree.ForumTree)
	 */
	@Override
	public void respondToEvent(ForumTreeHandler handler) {
		handler.NotifyError(m_errorMessage);
	}

}
