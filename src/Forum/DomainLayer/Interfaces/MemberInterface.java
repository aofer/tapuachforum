/*
 * Interface for the member class
 */

package Forum.DomainLayer.Interfaces;

import Forum.Exceptions.MessageNotFoundException;
import Forum.Exceptions.MessageOwnerException;

/**
 *
 * @author Amit Ofer
 */
public interface MemberInterface extends UserInterface {

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
    public  void editMessage(int messageId,String subject,String body)throws MessageNotFoundException,MessageOwnerException;
    /**
     * adds a new reply to a message
     * @param parentId - the id of the parent message
     * @param subject - the subject of the new reply
     * @param body - the body of the new reply
     */
    public void addReply(int parentId,String subject,String body);
}
