/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.DomainGuestInterface;
import Forum.Exceptions.*;
import java.util.Date;

/**
 * this class is for the guest user
 * @author Amit Ofer
 */
public class Guest implements DomainGuestInterface {


    private Forum _forum;

    /**
     *constructor
     * @param forum
     */
    public Guest(Forum forum){
        this._forum = forum;

    }

    /**
     * getter for the forum
     * @return
     */
    public Forum getForum() {
        return _forum;
    }
    /**
     * this method is used when the user requests to read a certain message, by supplying the id of the message
     * that needs to be read
     * @param messageId - the id of the message
     * @return a string containing the subject and content of the mesage
     * @throws MessageNotFoundException - when there is no message with the given messageId
     */
    public String readMessage(int messageId) throws MessageNotFoundException{
        return  this._forum.getMessage(messageId).toString();
    }
    /**
     * this method is used for registering a new user to the forum
     * @param username - the desired username
     * @param password - the desired passowrd
     * @param nickname - the desired nickname
     * @param email - the user's email address
     * @param firstName - the user's firstname
     * @param lastName - the user's lastname
     * @param dateOfBirth - the user's date of birth
     * @throws UserExistsException - is thrown when there is already a member with the same username
     * @throws NicknameExistsException - is thrown when there is already a member with the same nickname
     * @throws BadPasswordException - is thrown when the password doesn't meet the required policy
     */
    public void register(String username, String password, String nickname, String email, String firstName, String lastName, Date dateOfBirth)
            throws UserExistsException,NicknameExistsException,BadPasswordException{
        Member tMember = new Member(this._forum,username,nickname,email,password,firstName,lastName,dateOfBirth);
        this._forum.register(tMember) ;
    }
/**
 * this method is used when a user wants to log into the forum
 * @param username - the user's username
 * @param password - the user's password
 * @throws NoSuchUserException - is thrown when there is no registered user that matches the username
 * @throws WrongPasswordException - is thrown when the user typed the wrong password
 */
    public void logIn(String username, String password) throws NoSuchUserException,WrongPasswordException {
        this._forum.login(username,password);
    }

    
}
