package Forum.AcceptanceTest;

import junit.framework.TestCase;

/**
 * The father class of each test class we will write, it contains
 * the main methods of the tested operations.
 */
public class TestProject extends TestCase{
	//the bridge to the real implementation , or the proxy bridge that will
	//simulate the run in a case that a real bridge doesn't exist.
	private static ForumBridge _bridge;
	
        /**
         *
         */
        public TestProject() {
		super();
	}

	/**
	 * this is bridge method
         * @param firstName the first name of the new memebr.
         * @param lastName  the last name of the new memebr.
         * @param nickName the nick name of the new memebr.
         * @param password the password  of the new memebr.
         * @param userName  the user name of the new memebr.
         * @param eMail the e-mail of the new memebr.
         * @return the message from the forum system.
	 */
	  public String register(String firstName, String lastName, String nickName, String userName, String password, String eMail) {
		return _bridge.register(firstName,lastName,nickName,userName,password,eMail);
	}
          
          /**
         *  Add message function
         * @param subject - the subject of the message.
           * @param body
         * @return - message from the system.
         */
          public String addMessage(String subject, String body){
            return _bridge.addMessage(subject, body);
        }

    /**
     *  this is login procedure.
     * @param word - the user user name
     * @param password - the password
     */
          public void login(String word, String password){
             _bridge.login(word, password);
        }
/**
 * This is logoff procedure.
 * @param word - the name of the user
 */
        public void logout(String word){
             _bridge.logout( word);
        }
	/**
	 * setter to the bridge
	 * @param bridge
	 */
	public static void setbridge(ForumBridge bridge) {
		_bridge = bridge;
	}


        /**
         *
         * @param number
         * @return
         */
        public String replyToMessage(int number,String subject, String body){
            return _bridge.replyToMessage(number, subject, body);
        }

}
