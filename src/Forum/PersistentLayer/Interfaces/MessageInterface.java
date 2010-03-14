package Forum.PersistentLayer.Interfaces;
import Forum.Exceptions.MessageNotFoundException;
import java.util.Date;

/**
*
* @author Liron Katav
*/
public interface MessageInterface {
	    
	//--------------------Getters------------------------------
		/**
	     * get the parent id number of the message 
	     * @param messageID a message id
	     * @returns the parent id  */
		public int getParentId(int messageID) throws MessageNotFoundException;
				
		/**
	     * get the subject of the message 
	     * @param messageID a message id
	     * @returns the subject of the message given    */
		public String getSubject(int messageID) throws MessageNotFoundException ;
				
		/**
	     * get the content of the message 
	     * @param messageID a message id
	     * @returns the content of the message given    */
		public String getContent(int messageID) throws MessageNotFoundException ;
				
		/**
	     * get the username the wrote the messgae 
	     * @param messageID a message id
	     * @returns the username the wrote the messgae   */
		public String getUsername(int messageID) throws MessageNotFoundException ;
		
		/**
	     * get the date and time of the message 
	     * @param messageID a message id
	     * @returns the  date and time of the messgae   */
		public Date getDateAdded(int messageID) throws MessageNotFoundException ;

                	/**
	     * get the nickname that wrote the message
	     * @param messageID a message id
	     * @returns the username that wrote the message   */
		public String getNickname(int messageID) throws MessageNotFoundException ;

	//--------------------Setters------------------------------
		/**
	     * set the subject of the message to be the new subject 
	     * @param messageID,newSubject*/
		public void setSubject(int messageID, String newSubject) throws MessageNotFoundException ;
		
		/**
	     * set the content of the message to be the new content 
	     * @param messageID, newContent
	     * @returns the content of the message given    */
		public void setContent(int messageID, String newContent) throws MessageNotFoundException ;



	}
