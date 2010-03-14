package Forum.PersistentLayer.Interfaces;

import Forum.Exceptions.NoSuchUserException;
import java.util.Date;
import java.util.List;

/**
*
* @author Liron Katav
*/

public interface MemberInterface {
	
	//--------------------Getters------------------------------
	/**
     * get the nickname
     * @param username */
	public String getNickName (String username) throws NoSuchUserException;
	
	/**
     * get the password
     * @param username */
	public String getPassword (String username) throws NoSuchUserException;
	
	/**
     * get the email
     * @param username */
	public String getEMail (String username) throws NoSuchUserException;
	
	/**
     * get the date when username joined the forum
     * @param username */
	public Date getDateJoined (String username) throws NoSuchUserException;
	
	/**
     * get the real first name of the username 
     * @param username */
	public String getFirstName (String username) throws NoSuchUserException;
	
	/**
     * get the real last name of the username 
     * @param username */
	public String getLastName (String username) throws NoSuchUserException;
	
	/**
     * get the date of birth of the username 
     * @param username */
	public Date getDateofBirth (String username) throws NoSuchUserException;
			
	/**
     * get the status of the username - online=true and offline= false 
     * @param username */
	public boolean getStatus (String username) throws NoSuchUserException;
	
	/**
     * get all the messages the user wrote 
     * @param username */
//	public List<MessageType> getMessages (String username);
	
	//--------------------Setters------------------------------
	
	/**
     * set the nickname
     * @param username, nickName */
	public void setNickName (String username, String nickName) throws NoSuchUserException;
	
	/**
     * set the password
     * @param username, password */
	public void setPassword (String username, String password) throws NoSuchUserException;
	
	/**
     * set the email
     * @param username, eMail */
	public void setEMail (String username, String eMail) throws NoSuchUserException;
	
	/**
     * set the date when username joined the forum
     * @param username,dateJoined */
	public void setDateJoined (String username, Date dateJoined) throws NoSuchUserException;
	
	/**
     * set the real first name of the username 
     * @param username,firstName */
	public void setFirstName (String username, String firstName) throws NoSuchUserException;
	
	/**
     * set the real last name of the username 
     * @param username,lastName*/
	public void setLastName (String username, String lastName) throws NoSuchUserException;
	
	/**
     * set the date of birth of the username 
     * @param username, dateOfBirth */
	public void setDateofBirth (String username, Date dateOfBirth) throws NoSuchUserException;
			
	/**
     * set the status of the username - online=true and offline= false 
     * @param username , status*/
	public void setStatus (String username, boolean status) throws NoSuchUserException;
	
	/**
     * get all the messages the user wrote 
     * @param username,newMessage*/
	//public void addMessage (String username, MessageType newMessage) ;

}
