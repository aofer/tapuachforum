/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.MemberInterface;
import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.Exceptions.*;
import Forum.DomainLayer.Interfaces.ForumInterface;
import Forum.PersistentLayer.*;
import Forum.PersistentLayer.Data.MemberData;
import java.util.Vector;

/**
 *this class is the main logics of our forum
 * it communicates with the persistent layer through a pre defined interfaces
 * @author Amit Ofer
 */
public class Forum implements ForumInterface {

    private MessageHandler _messageHandler;
    private UserHandler _userHandler;
    private static Forum _forum;

    public static Forum getInstance() {
        if (_forum == null) {
            _forum = new Forum();

        }
        return _forum;
    }

    private Forum() {
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

    public MemberInterface register(MemberData newMember) throws UserExistsException, NicknameExistsException, BadPasswordException {
        return _userHandler.register(newMember);
    }

    public void login(String username, String password) throws NoSuchUserException, WrongPasswordException {
        this._userHandler.login(username, password);
    }

    public void logout(String username) {
        this._userHandler.logout(username);
    }

    public void addMessage(String nickname, String Subject, String body) throws MessageOwnerException {
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
        this._messageHandler.addReply(parentId, nickname, Subject, body);
    }

    public void editMessage(String nickname, int messageId, String newSubject, String newBody) throws MessageNotFoundException, MessageOwnerException {
        this._messageHandler.editMessage(nickname, messageId, newSubject, newBody);
    }

    public void deleteMessage(int messageId) throws MessageNotFoundException {
        this._messageHandler.deleteMessage(messageId);
    }

    public void upgradeUser(String username) throws UserNotExistException {
        this._userHandler.upgradeUser(username);
    }
}
