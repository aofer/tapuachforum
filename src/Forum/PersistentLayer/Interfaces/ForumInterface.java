package Forum.PersistentLayer.Interfaces;

import java.util.Date;

/**
*
* @author Liron Katav
*/

public interface ForumInterface {
	
	/**
     * set the status of the user to be online
     * @param username, password */
	public void login (String username);
	
	/**
     * set the status of the user to be offline
     * @param username a message id */
	public void logoff (String username);
	
	/**
     * check if the username already exist 
     * @param username 
     * @return username password if exists or NULL if not*/
	public String userExist (String username);
	
	/**
     * add a new member to the forum
     * @param username ,  nickName, password, eMail, firstName, lastName, dateOfBirth */
	public void register ( 	String userName , 
							String nickName,
							String password,
							String eMail,	
							String firstName,	
							String lastName,
							Date dateOfBirth);
	
	/**
     * add a new message to the forum
     * @param parentId, createdBy, subject,body */
	public void addMessage ( int parentId, String createdBy, String subject,String body, Date DateAdded);
}
