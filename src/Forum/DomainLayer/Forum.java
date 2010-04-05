/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.MemberInterface;
import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.Exceptions.*;
import Forum.DomainLayer.Interfaces.ForumInterface;
import Forum.DomainLayer.SearchEngine.SearchEngineHandler;
import Forum.DomainLayer.SearchEngine.SearchHit;
import Forum.PersistentLayer.*;
import Forum.PersistentLayer.Interfaces.ForumHandlerInterface;
import Forum.PersistentLayer.Interfaces.XMLMemberInterface;
import Forum.PersistentLayer.Interfaces.XMLMessageInterface;
import java.util.Date;
import java.util.Vector;
import Forum.DomainLayer.Logger.*;

/**
 *this class is the main logics of our forum
 * it communicates with the persistent layer through a pre defined interfaces
 * @author Amit Ofer
 */
public class Forum implements ForumInterface {

    private MessageHandler _messageHandler;
    private UserHandler _userHandler;
    private SearchEngineHandler _searchHandler;
    private static Forum _forum;

    public static Forum getInstance() {
        if (_forum == null) {
            _forum = new Forum();

        }
        return _forum;
    }

    private Forum() {   //added stuff to the constructor in order to make it work
        XMLFileHandler xf = new XMLFileHandler("testforum.xml"); //currently using the testforum xml file
        ForumHandlerInterface xmlForumHandler = new ForumHandler(xf);
        XMLMessageInterface xmlMessageHandler = new XMLMessageHandler(xf);
        XMLMemberInterface xmlMemberHandler = new XMLMemberHandler(xf);
        this._messageHandler = new MessageHandler(xmlForumHandler,xmlMessageHandler);
        this._userHandler = new UserHandler(xmlForumHandler, xmlMemberHandler);
        this._searchHandler = new SearchEngineHandler();
        Date tDate = new Date();
        addAdmin("admin", "admin", "adminy", "thebestadmin@gmail.com", "ad", "min", tDate);

    }

    /**
     *constructor
     * @param messageHandler
     * @param forumHandler
     * @param memberHandler
     */
    public void setDBHandlers(XMLMessageHandler messageHandler, ForumHandler forumHandler, XMLMemberHandler memberHandler) {
        this._messageHandler = new MessageHandler(forumHandler, messageHandler);
        this._userHandler = new UserHandler(forumHandler, memberHandler);
    }

    /**
     * this is the getter for the vector of online members
     * @return a vector containing all online members
     */
    public Vector<MemberInterface> getOnlineMembers() {
        return _userHandler.getOnlineMembers();
    }

    public MessageInterface getMessage(int messageId) throws MessageNotFoundException {
        return this._messageHandler.getMessage(messageId);
    }

// omri's version
/*    public MemberInterface register(MemberData newMember) throws UserExistsException, NicknameExistsException, BadPasswordException {
        return _userHandler.register(newMember);
    }*/
// amit's version
    public void register(String username,String password,String nickname,
            String email,String firstName,String lastName,Date dateOfBirth) throws UserExistsException, NicknameExistsException, BadPasswordException {
    	TapuachLogger.getInstance().info("user:  " + username + " registered to the forum");
        this._userHandler.register(username,password,nickname,email,firstName,lastName,dateOfBirth);
    }

    public void login(String username, String password) throws NoSuchUserException, WrongPasswordException {
    	TapuachLogger.getInstance().info("user:  " + username + " logged in");
    	this._userHandler.login(username, password);
    }

    public void logout(String username) {
    	TapuachLogger.getInstance().info("user:  " + username + " logged out");
        this._userHandler.logout(username);
    }

    public void addMessage(String nickname, String Subject, String body)  { //might needs to throw NoSuchUserException in case there is no user with that nickname
    	TapuachLogger.getInstance().info( "nickname: "+nickname + " added new message");
        this._messageHandler.addMessage(nickname, Subject, body);
    }
    /**
     * this method adds a new reply to the forum
     * @param parentId - the id of the message that we want to add the reply to
     * @param nickname
     * @param Subject
     * @param body
     * @throws MessageNotFoundException
     */
    public void addReply(int parentId, String nickname, String Subject, String body) throws MessageNotFoundException {
    	TapuachLogger.getInstance().info( "nickname: "+nickname + " add reply to message number:" + parentId);
        this._messageHandler.addReply(parentId, nickname, Subject, body);
    }

    public void editMessage(String nickname, int messageId, String newSubject, String newBody) throws MessageNotFoundException, MessageOwnerException {
    	TapuachLogger.getInstance().info( "nickname: "+nickname + " edit message number:" + messageId);
        this._messageHandler.editMessage(nickname, messageId, newSubject, newBody);
    }

    public void deleteMessage(int messageId) throws MessageNotFoundException {
    	TapuachLogger.getInstance().info( "message number:" + messageId+" deleted");
        this._messageHandler.deleteMessage(messageId);
    }

    public void upgradeUser(String username) throws UserNotExistException {
    	TapuachLogger.getInstance().info("user:  " + username + " has been upgraded");
        this._userHandler.upgradeUser(username);
    }

    public Vector<MessageInterface> viewForum() {
        return this._messageHandler.viewForum();
    }

    public void addMessageToIndex(MessageInterface m){
        this._searchHandler.addData(m);
    }

    public  SearchHit[] searchByContent(String phrase, int from, int to){
        return _searchHandler.searchByContent(phrase, from, to);
    }

    public SearchHit[] searchByAuthor(String username, int from, int to){
        return _searchHandler.searchByAuthor(username, from, to);
    }

   public void removeMessageFromIndex(MessageInterface m){
       _searchHandler.RemoveMessage(m);
   }
   public MemberInterface getMember(String username){
       return _userHandler.getMember(username);
   }
   private void addAdmin(String username,String password,String nickname,
		   				 String email,String firstName,String lastName,Date dateOfBirth) {
	   TapuachLogger.getInstance().info(username + " registered to the forum as Admin");
       this._userHandler.addAdmin(username, password, nickname, email, firstName, lastName, dateOfBirth);
   }
}
