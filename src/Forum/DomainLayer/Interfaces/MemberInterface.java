/*
 * Interface for the member class
 */

package Forum.DomainLayer.Interfaces;

/**
 *
 * @author Amit Ofer
 */
public interface MemberInterface extends GuestInterface {

    /**
     *logs out of the forum, turns the member back into a guest
     */
    public void logOut();
    /**
     *writes a new message in the forum with the given nickname (taken from the member),subject and body
     * @param subject
     * @param body
     */
    public void writeMessage(String subject,String body);
    /**
     *edits the message that has the given message ID
     * a member can only edit his messages
     * @param messageId
     * @param subject
     * @param body
     */
    public  void editMessage(int messageId,String subject,String body);
}
