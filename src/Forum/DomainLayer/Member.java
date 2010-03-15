

package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.DomainMemberInterface;
import Forum.Exceptions.MessageNotFoundException;
import Forum.Exceptions.MessageOwnerException;
import java.util.Date;

/**
 *this class represents a registered member in the forum
 * @author Amit Ofer
 */
public class Member  extends Guest implements DomainMemberInterface{
private String _userName;
private String _nickName;
private String _password;
private String _firstName;
private String _lastName;;
private String _email;
private Date _dateJoined;
private Date _dateOfBirth;

/**
 *constructor
 * @param forum
 * @param userName
 * @param nickName
 * @param password
 * @param firstName
 * @param lastName
 * @param email
 * @param dateOfBirth
 */
public Member(Forum forum,String userName,String nickName,String password,String firstName,String lastName,String email,
       Date dateOfBirth){
    super(forum);
    this._userName = userName;
    this._nickName = nickName;
    this._password = password;
    this._firstName = firstName;
    this._lastName = lastName;
    this._email = email;
    this._dateOfBirth = dateOfBirth;
    this._dateJoined = new Date();
}

/**
 *getter for the username
 * @return member's username
 */
public String getUserName() {
        return _userName;
    }

/**
 *getter for the password
 * @return member's password
 */
public String getPassword() {
        return _password;
    }

/**
 *getter for nickName
 * @return member's nickname
 */
public String getNickName() {
        return _nickName;
    }

/**
 *getter for the lastName
 * @return member's last name
 */
public String getLastName() {
        return _lastName;
    }



    /**
     *getter for the first name
     * @return member's first name
     */
    public String getFirstName() {
        return _firstName;
    }

    /**
     *getter for the email
     * @return member's email address
     */
    public String getEmail() {
        return _email;
    }

    /**
     *getter for the date of  birth
     * @return member's date of birth
     */
    public Date getDateOfBirth() {
        return _dateOfBirth;
    }

    /**
     *getter for the date the member registered the forum
     * @return member's registration date
     */
    public Date getDateJoined() {
        return _dateJoined;
    }
/**
 * the mothod is used when the member decides to log out of the forum
 * when the user logs out he becomes a guest and therefore can no longer write messages
 */
    public void logOut() {
        this.getForum().logout(this._userName);
    }
/**
 * this method is used when the member want to write a new message
 * @param subject - the subject of the message
 * @param body - the body of the message
 */
    public void writeMessage(String subject, String body) {
        this.getForum().addMessage(this._nickName,subject,body);
    }
/**
 * edit a message by changing the subject or the body of the message
 * @param messageId - the Id of the number that needs to be edited
 * @param subject - the new subject
 * @param body - the new body
 */
    public void editMessage(int messageId, String subject, String body) throws MessageNotFoundException,MessageOwnerException{
        this.getForum().editMessage(this._nickName,messageId,subject,body);
    }
    /**
     * this method is used to add a new reply to a message
     * @param parentId - the id of the parent message
     * @param subject - the subject of the new reply
     * @param body - the body of the message
     */
    public void addReply(int parentId,String subject,String body){
        this.getForum().addReply(parentId, this._nickName, subject, body);
    }

}
