package Forum.PersistentLayer.Interfaces;

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
	public String getNickName (String username);
	
	/**
     * get the password
     * @param username */
	public String getPassword (String username);
	
	/**
     * get the email
     * @param username */
	public String getEMail (String username);
	
	/**
     * get the date when username joined the forum
     * @param username */
	public Date getDateJoined (String username);
	
	/**
     * get the real first name of the username 
     * @param username */
	public String getFirstName (String username);
	
	/**
     * get the real last name of the username 
     * @param username */
	public String getLastName (String username);
	
	/**
     * get the date of birth of the username 
     * @param username */
	public Date getDateofBirth (String username);
			
	/**
     * get the status of the username - online=true and offline= false 
     * @param username */
	public boolean getStatus (String username);
	
	/**
     * get all the messages the user wrote 
     * @param username */
//	public List<MessageType> getMessages (String username);
	
	//--------------------Setters------------------------------
	
	/**
     * set the nickname
     * @param username, nickName */
	public void setNickName (String username, String nickName);
	
	/**
     * set the password
     * @param username, password */
	public void setPassword (String username, String password);
	
	/**
     * set the email
     * @param username, eMail */
	public void setEMail (String username, String eMail);
	
	/**
     * set the date when username joined the forum
     * @param username,dateJoined */
	public void setDateJoined (String username, Date dateJoined);
	
	/**
     * set the real first name of the username 
     * @param username,firstName */
	public void setFirstName (String username, String firstName);
	
	/**
     * set the real last name of the username 
     * @param username,lastName*/
	public void setLastName (String username, String lastName);
	
	/**
     * set the date of birth of the username 
     * @param username, dateOfBirth */
	public void setDateofBirth (String username, Date dateOfBirth);
			
	/**
     * set the status of the username - online=true and offline= false 
     * @param username , status*/
	public void setStatus (String username, boolean status);
	
	/**
     * get all the messages the user wrote 
     * @param username,newMessage*/
	//public void addMessage (String username, MessageType newMessage);

}
