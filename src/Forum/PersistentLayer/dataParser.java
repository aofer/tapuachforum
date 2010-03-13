/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.PersistentLayer;

import Forum.DomainLayer.Member;
import Forum.DomainLayer.Message;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author Arseny
 */
public interface dataParser {
    // receives a member object and parses it into xml compatible class
    /**
     * add a new memer to the forum
     * @param m a member with all the fields
     * 
     */
    public void addMember(MemberType m);
    
   
    /**
     * add a new message or update an existing message
     * @param m a message
     */
    public void addMessage(MessageType m);

    /**
     *  find a member by his nickname
     * @param nick a nickname
     * @return the member if such exists and null otherwise
     */
    public MemberType getMember(String nick);

    /**
     *  return a list of all members in the forum
     * @return list of members and null if empty
     */
    public List<MemberType> getMembers();

    /**
     *  find a message by it's message ID
     * @param id message ID
     * @return a message if such exists and null otherwise
     */
    public MessageType getMessage(int id);

    /**
     *  returns all the parent messages in the forum
     * @return list of all the parent messages or null if empty
     */
    public List<MessageType> getParentMessages();

    /**
     *  returns all of the direct children of a message
     * @param id message id
     * @return a list of the direct children of this message or null if no children exists
     * @throws NoSuchElementException  in case no such message exist
     */
    public List<MessageType> getChildren(int id) throws NoSuchElementException;


}
