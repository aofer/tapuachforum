/*
 * this class implements all of the forum fascade interface method by calling the forum singleton
 * it also holds the information of the user that the server communicates with
 */

package Forum.DomainLayer;


import Forum.DomainLayer.Interfaces.MemberInterface;
import Forum.DomainLayer.Interfaces.MessageInterface;
import Forum.Exceptions.*;
import Forum.PersistentLayer.ForumHandler;
import Forum.PersistentLayer.Interfaces.eMemberType;
import Forum.PersistentLayer.XMLMemberHandler;
import Forum.PersistentLayer.XMLMessageHandler;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author amit ofer
 */
public class ForumFascade {

    private User _user;

    public ForumFascade(){
        this._user = new Guest();

    }



    public String readMessage(int messageId) throws MessageNotFoundException {
        return this._user.readMessage(messageId);
    }

    public Vector<MessageInterface> viewForum() {
        return Forum.getInstance().viewForum();
    }

    public void register(String username, String password, String nickname, String email, String firstName, String lastName, Date dateOfBirth) throws UserExistsException, NicknameExistsException, BadPasswordException,UserPrivilegeException {
        if (this._user.getType() == eMemberType.guest){
            ((Guest)this._user).register(username, password, nickname, email, firstName, lastName, dateOfBirth);
        }
        else{
            throw new UserPrivilegeException("Only Guests can register.");
        }
    }

    public void login(String username, String password) throws NoSuchUserException, WrongPasswordException,UserPrivilegeException {
        if (this._user.getType() == eMemberType.guest){
            ((Guest)this._user).logIn(username, password);
        }
        else{
            throw new UserPrivilegeException("You are already logged in.");
        }
    }

    public void logout() throws UserPrivilegeException {
        if (this._user.getType() == eMemberType.guest){
            throw new UserPrivilegeException(("you are not logged in"));
        }
        else{
            ((Member)this._user).logOut();
        }
    }

    public void addMessage(String Subject, String body) throws UserPrivilegeException  {
        if (this._user.getType() == eMemberType.guest){
            throw new UserPrivilegeException("Guests can't write messages, please login or register first.");
        }
        else{
            ((Member)this._user).writeMessage(Subject, body);
        }
    }

    public void addReply(int replyId, String nickname, String Subject, String body) throws MessageNotFoundException, MessageOwnerException, UserPrivilegeException {
        if (this._user.getType() == eMemberType.guest){
            throw new UserPrivilegeException("Guests can't write replies, please login or register first.");
        }
        else{
            ((Member)this._user).writeReply(replyId, Subject, body);
        }
    }

    public void editMessage(String nickname, int messageId, String newSubject, String newBody) throws MessageNotFoundException, MessageOwnerException, UserPrivilegeException {
        if (this._user.getType() == eMemberType.guest){
            throw new UserPrivilegeException("Guests can't edit messages, please login or register first.");
        }
        else{
            ((Member)this._user).editMessage(messageId, newSubject, newBody);
        }
    }

    public void deleteMessage(int messageId) throws MessageNotFoundException, UserPrivilegeException {
        if (this._user.getType() == eMemberType.Moderator || this._user.getType() == eMemberType.Admin){
            ((Moderator)this._user).deleteMessage(messageId);
        }
        else {
            throw new UserPrivilegeException("Only Moderators/Admins can delete messages.");
        }
    }


    public void upgradeUser(String username) throws UserNotExistException, UserPrivilegeException {
        if (this._user.getType() == eMemberType.Admin){
            ((Admin)this._user).upgradeUser(username);
        }
        else{
            throw new UserPrivilegeException("Only Admins can upgrade users.");
        }
    }

}
