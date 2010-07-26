package Forum.Client.ControllerLayer;

import Forum.DomainLayer.Logger.TapuachLogger;
import java.awt.Component;
import java.io.IOException;
import java.util.Observable;

/**
 * This abstract class is in charge of the communication between the UI layer and the Controller layer.
 * 
 * @author Tomer Heber
 */
public abstract class ControllerHandler extends Observable {

    protected ClientConnectionController _connectionController;

    public ControllerHandler() {
        _connectionController = new ClientConnectionController("127.0.0.1", (short) 1234);
    }

    public void Disconnect() {
        try {
            _connectionController.closeConnection();
        } catch (IOException ex) {
            TapuachLogger.getInstance().severe("got IOException while disconnection from server");
        }
    }

    @Override
    public synchronized void notifyObservers(Object o) {
        setChanged();
        super.notifyObservers(o);
    }

    /**
     *
     * @return and encoded view of the forum.<br>
     * An example of such an encoding can be some sort of XML string.<br>
     * For example:<br>
     * <message> id: user: sdfsdf content: fsdfsd
     * 		<message>
     *			...
     *		</message>
     *		<message>
     *			...
     *		</message>
     * </message>
     */
    public abstract String getForumView();

    public abstract void refreshForum(Component comp);

    /**
     * Tries to modify a message.
     *
     * @param id The id of the message to be modified.
     * @param newContent The new content of the message.
     */
    public abstract void modifyMessage(long id, String subject, String body, Component comp);

    public abstract void modifyMessage(long id, String content, Component comp);

    /**
     * Adds a reply message.
     *
     * @param id The id of the message to which we reply.
     * @param string The content of the new message.
     */
    public abstract void addReplyToMessage(long id, String subject, String body, Component comp);

    /**
     * Deletes recursively the message id and all his sons.
     *
     * @param id The id of the message to delete.
     */
    public abstract void deleteMessage(long id, Component comp);

    /**
     * Adds a new message to the forum.
     */
    public abstract void addNewMessage(String subject, String body, Component comp);

    /**
     *  searches
     * @param nickname
     * @param from
     * @param to
     * @param comp
     */
    public abstract void searchByAuthor(String nickname, int from, int to, Component comp);

    /**
     *
     * @param phrase
     * @param from
     * @param to
     * @param comp
     */
    public abstract void searchByContent(String phrase, int from, int to, Component comp);

    /**
     *
     * @param username
     * @param password
     * @param comp
     */
    public abstract void login(String username, String password, Component comp);

    public abstract void logoff(Component comp);

    /**
     *
     * @param firstName
     * @param lastName
     * @param nickname
     * @param email
     * @param username
     * @param password
     * @param comp
     */
    public abstract void register(String firstName, String lastName, String nickname, String email, String username, String password, Component comp);

    public abstract void getMembers(Component comp);

    public abstract void UpgradeUser(String user, Component comp);

    public abstract void getOnlineMembers(Component comp);
}
