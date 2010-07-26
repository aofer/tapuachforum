package Forum.AcceptanceTest;

/**
 * The interface of the tested operations
 */
public interface ForumBridge {

    /**
     * this is interface for the register use case.
     * @param firstName the first name of the new memebr.
     * @param lastName  the last name of the new memebr.
     * @param nickName the nick name of the new memebr.
     * @param password the password  of the new memebr.
     * @param userName  the user name of the new memebr.
     * @param eMail the e-mail of the new memebr.
     * @return true if the login succeeded, false otherwise
     */
    public String register(String firstName, String lastName, String nickName, String userName, String password, String eMail);

    /**
     *
     * @param username
     * @param password
     */
    public void login(String username, String password);

    /**
     *
     * @param username
     */
    public void logout(String username);

    /**
     *
     * @param subject
     * @param Body
     * @return
     */
    public String addMessage(String subject, String Body);

    /**
     * @param subject
     * @param Body
     * @param num
     * @return
     */
    public String replyToMessage(int number,String subject, String Body);
}
