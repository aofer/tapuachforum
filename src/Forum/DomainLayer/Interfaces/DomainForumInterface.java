/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer.Interfaces;

import Forum.Exceptions.WrongPasswordException;
import Forum.DomainLayer.Member;
import Forum.DomainLayer.Message;
import Forum.Exceptions.*;

/**
 *
 * @author Amit Ofer
 */
public interface DomainForumInterface {
    /**
     *  this methods is used to get a message from the database
     * @param messageId - the id of the required message
     * @return the message that is required
     * @throws MessageNotFoundException - is thrown when the message does not exist
     */
    public Message getMessage(int messageId)throws MessageNotFoundException;
    /**
     * this method is used to register a new user to the forum
     * @param newMember - the details of the member to be added
     * @throws UserExistsException - is thrown when the user name already exists
     * @throws NicknameExistsException - is thrown when the nickname already exists
     * @throws BadPasswordException - is thrown when the password doesn't meet the required policy
     */
    public void register(Member newMember) throws UserExistsException,NicknameExistsException,BadPasswordException;
    /**
     * this method is used when the user wants to log in
     * @param username -  the user name for the login
     * @param password - the password that is used for login
     * @throws NoSuchUserException - is thrown when there is no such user
     * @throws WrongPasswordException - is thrown when the password doesn't match
     */
    public void login(String username, String password) throws NoSuchUserException,WrongPasswordException ;
    /**
     * this method is used for logging out of the forum
     * @param username - the user name of the user that wants to log out
     */
    public void logout(String username);
    /**
     * this method is used for adding a new message for the forum
     * @param nickname - the nickname of the user that writes the message
     * @param Subject - the subject of the message
     * @param body - the body of the message
     */
    public void addMessage(String nickname,String Subject,String body);
    /**
     * check if the given password meets a certain policy
     * @param password - the given password
     * @return - true if the password is ok false if not
     */
    public boolean checkPasswordPolicy(String password);
    /**
     * this method is used for adding an online member to the forum
     * @param member
     */
    public void addMember(Member member) ;
    /**
     * this method is used for editing a message
     * @param nickname - the nickname of the writer
     * @param messageId -  the message id of the message that needs to be edited
     * @param newSubject -  the new subject
     * @param newBody - the new body
     * @throws MessageNotFoundException - is thrown when the message was not found
     * @throws MessageOwnerException - is thrown when the user that wants to edit the message is not the owner
     * of the message
     */
    public void editMessage(String nickname,int messageId,String newSubject,String newBody)throws MessageNotFoundException,MessageOwnerException;
    /**
     *this method is used for adding a new reply to a certain message
     * @param parentId - the id of the parent of the reply
     * @param nickname - the nickname of the writer of the reply
     * @param subject - the subject of the reply
     * @param body - the body of the reply
     */
    public void addReply(int parentId,String nickname,String subject,String body);
}
