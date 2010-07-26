package Forum.AcceptanceTest;

import Forum.DomainLayer.Forum;
import Forum.Exceptions.BadPasswordException;
import Forum.Exceptions.MessageNotFoundException;
import Forum.Exceptions.NicknameExistsException;
import Forum.Exceptions.NoSuchUserException;
import Forum.Exceptions.UserExistsException;
import Forum.Exceptions.UserLoggedException;
import Forum.Exceptions.WrongPasswordException;
import Forum.PersistentLayer.ForumHandler;
import Forum.PersistentLayer.SQLForumHandler;
import Forum.PersistentLayer.SQLMemberHandler;
import Forum.PersistentLayer.SQLMessageHandler;
import Forum.PersistentLayer.XMLFileHandler;
import Forum.PersistentLayer.XMLMemberHandler;
import Forum.PersistentLayer.XMLMessageHandler;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class Is simulating the case in which a real implementation exists ,
 * and if so , this real bridge connects the real implementation of the project to the
 * user acceptance tests.
 */
public class RealBridge implements ForumBridge {
    //     XMLFileHandler xf = new XMLFileHandler("useCase.xml");

    SQLMessageHandler msgH = new SQLMessageHandler();
    SQLForumHandler fH = new SQLForumHandler();
    SQLMemberHandler memH = new SQLMemberHandler();
    Forum instance = Forum.getInstance();
    /**
     *
     */
    public ForumBridge _bridge;

    /**
     * 
     */
    public RealBridge() {
        fH.initForum();
    }

    @SuppressWarnings({"static-access", "static-access"})
    public String register(String firstName, String lastName, String nickName, String userName, String password, String eMail) {
        fH.initForum();
        System.out.println("test register");
        Date tDate = new Date();
        try {
            Forum.getInstance().register(userName, password, nickName, firstName, lastName, eMail, tDate);
        } catch (UserExistsException ex) {
            Logger.getLogger(RealBridge.class.getName()).log(Level.SEVERE, null, ex);
            return "username already exists";
        } catch (NicknameExistsException ex) {
            Logger.getLogger(RealBridge.class.getName()).log(Level.SEVERE, null, ex);
            return "nickname already exists";
        } catch (BadPasswordException ex) {
            Logger.getLogger(RealBridge.class.getName()).log(Level.SEVERE, null, ex);
            return "password does not meet the policy";
        }
        if (Forum.getInstance().getMember(userName) != null) {
            return ("user was add and data was saved");
        } else {
            return ("user wasn't add");
        }
    }

    /**
     *  this is login procedure.
     * @param word - the user user name
     * @param password - the password
     */
    public void login(String word, String password) {
        try {
            instance.login(word, password);
        } catch (UserLoggedException ex) {
            Logger.getLogger(RealBridge.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchUserException ex) {
            Logger.getLogger(ProxyBridge.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WrongPasswordException ex) {
            Logger.getLogger(ProxyBridge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This is logoff procedure.
     * @param word - the name of the user
     */
    @SuppressWarnings("static-access")
    public void logout(String word) {
        Forum.getInstance().logout(word);
    }

    /**
     *  Add message function
     * @param subject - the subject of the message.
     * @param Body - the body of the message.
     * @return - message from the system.
     */
    public String addMessage(String subject, String Body) {
        if (instance.getOnlineMembers().size() > 0) {
            instance.addMessage("boby", subject, Body);
            return "the message is correctly saved";
        } else {
            return "User is not login";
        }
    }


    /**
     *  Reply to message function
     *      * @param subject - the subject of the message.
     * @param Body - the body of the message.
         * @param num - the num of the message we want to delete.
         * @return - message from the system
         */
    public String replyToMessage(int number,String subject, String Body) {
        if (instance.getOnlineMembers().size() > 0) {
            try {
                instance.addReply(number, "bobyRep", subject, Body);
                return "The reply as been saved.";
            } catch (MessageNotFoundException ex) {
                 return "Message not found";
            }
        } else {
            return "User is not login";
        }
    }

}
