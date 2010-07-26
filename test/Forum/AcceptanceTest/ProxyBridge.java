package Forum.AcceptanceTest;

import Forum.DomainLayer.Forum;
import Forum.DomainLayer.Interfaces.ForumInterface;
import Forum.DomainLayer.Member;
import Forum.Exceptions.BadPasswordException;
import Forum.Exceptions.MessageNotFoundException;
import Forum.Exceptions.NicknameExistsException;
import Forum.Exceptions.NoSuchUserException;
import Forum.Exceptions.UserExistsException;
import Forum.Exceptions.UserLoggedException;
import Forum.Exceptions.WrongPasswordException;
import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.ForumHandler;
import Forum.PersistentLayer.Interfaces.ForumHandlerInterface;
import Forum.PersistentLayer.Interfaces.XMLMemberInterface;
import Forum.PersistentLayer.Interfaces.XMLMessageInterface;
import Forum.PersistentLayer.SQLForumHandler;
import Forum.PersistentLayer.SQLMemberHandler;
import Forum.PersistentLayer.SQLMessageHandler;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * **********************************************************
 *      This is not the proxy bridge. IT IS THE REAL BRIDGE!!!
 * **********************************************************
 */
/**
 *
 * @author Nir
 */
public class ProxyBridge implements ForumBridge {

    //             XMLFileHandler xf = new SQLFileHandler("useCase.xml");
    XMLMessageInterface msgH = new SQLMessageHandler();
    ForumHandlerInterface fH = new SQLForumHandler();
    XMLMemberInterface memH = new SQLMemberHandler();
    Forum instance = Forum.getInstance();
    Date tDate = new Date();
    /**
     *
     */
    public ForumBridge _bridge;

    /**
     *
     * @param bridge
     */
    public ProxyBridge(ForumBridge bridge) {
        fH.initForum();
        this._bridge = bridge;

    }

    @SuppressWarnings({"static-access", "static-access"})
    public String register(String firstName, String lastName, String nickName, String userName, String password, String eMail) {
        System.out.println("test register");
        MemberData memberDetails = new MemberData("amitUserName", "amitNickName", "amiiPass", "amitFirstName", "amitLastName", "amit@iteration.1", tDate);
        Member newMember = new Member(memberDetails);
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
            Logger.getLogger(ProxyBridge.class.getName()).log(Level.SEVERE, null, ex);
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
     *
     * @param subject - the subject of the message.
     * @param Body - the body of the message.
     * @return - message from the system.
     */
    public String addMessage(String subject, String Body) {
        if (instance.getOnlineMembers().size() > 0) {
            instance.addMessage("bobyRep", subject, Body);
            return "the message is correctly saved";
        } else {
            return "User is not login";
        }
    }

    /**
     *  Reply to message function
     * @param number - the num of the message we want to delete.
     * @return - message from the system
     */
    public String replyToMessage(int number,String subject, String Body) {
        if (instance.getOnlineMembers().size() > 0) {
            try {
                instance.addReply(number, "bobyRep", subject, Body);
            } catch (MessageNotFoundException ex) {
                return "Message not found";
            }
            return "The reply as been saved.";
        } else {
            return "User is not login";
        }
    }
}
