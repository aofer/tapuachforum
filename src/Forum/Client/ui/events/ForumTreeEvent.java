package Forum.Client.ui.events;

import Forum.Client.ui.TreeView.ForumTreeHandler;

/**
 * Classes that implement this interface are events related to the ForumTree.
 * 
 * @author Tomer Heber
 */
public interface ForumTreeEvent {
	
	/**	 	 	 
	 * @param handler The handler for the forum tree GUI.
	 */
	public void respondToEvent(ForumTreeHandler handler);

}
