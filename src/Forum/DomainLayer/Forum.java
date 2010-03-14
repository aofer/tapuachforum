/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;
import Forum.Exceptions.*;
import Forum.DomainLayer.Interfaces.DomainForumInterface;
import Forum.PersistentLayer.ForumHandler;
import  Forum.PersistentLayer.Interfaces.*;
import Forum.PersistentLayer.MemberHandler;
import Forum.PersistentLayer.XMLMessageHandler;
import java.util.Date;
import java.util.Vector;
/**
 *
 * @author amit
 */
public class Forum implements DomainForumInterface{

    private  ForumInterface _XmlForum;
    private MemberInterface _XmlMember;
    private MessageInterface _XmlMessage;
    private Vector<Member> _onlineMembers;

    public Forum(XMLMessageHandler messageHandler){
        this._XmlForum = new ForumHandler();
        this._XmlMember = new MemberHandler();
        this._XmlMessage = messageHandler;
        this._onlineMembers = new Vector<Member>();
    }

    public void register(Member newMember)  throws UserExistsException,NicknameExistsException,BadPasswordException{
        if (this._XmlForum.checkUsername(newMember.getUserName()))
            throw new UserExistsException();
        else if (this._XmlForum.checkNickname(newMember.getNickName()))
            throw new NicknameExistsException();
        else if (checkPasswordPolicy(newMember.getPassword()))
            throw new BadPasswordException();
        else {
           String tUsername = newMember.getUserName();
           String tNickname = newMember.getNickName();
           String tPassword = newMember.getPassword();
           String tFirstname = newMember.getFirstName();
           String tLastname = newMember.getLastName();
           String tEmail = newMember.getEmail();
           Date tDateOfBirth = newMember.getDateOfBirth();
            this._XmlForum.register(tUsername,tNickname,tPassword,tEmail,tFirstname, tLastname,tDateOfBirth);
        }
    }

    public Message getMessage(int messageId)  throws MessageNotFoundException{
        String tNickname = this._XmlMessage.getNickname(messageId);
        String tSubject = this._XmlMessage.getSubject(messageId);
        String tBody = this._XmlMessage.getContent(messageId);
        Date tDateAdded = this._XmlMessage.getDateAdded(messageId);
        Date tDateModified = this._XmlMessage.getModifiedDate(messageId);
        Vector<Message> tReplies = new Vector<Message>();
        //get children

        return new Message(tNickname, tSubject, tBody, tReplies, tDateAdded, tDateModified);

    }

    public void login(String username, String password) throws NoSuchUserException,WrongPasswordException {
        String tPassword = this._XmlForum.userExists(username);
        if (tPassword == null)
            throw new NoSuchUserException(username);
        else if (!tPassword.equals(password))
            throw new WrongPasswordException();
        else{
            String tNickname = this._XmlMember.getNickName(username);
            String tFirstName = this._XmlMember.getFirstName(username);
            String tLastName = this._XmlMember.getLastName(username);
            String tEmail = this._XmlMember.getEMail(username);
            Date tDateOfBirth = this._XmlMember.getDateofBirth(username);
            Date tDateJoined = this._XmlMember.getDateJoined(username);
            Member tMember = new Member(this, username, tNickname, password, tFirstName, tLastName, tEmail, tDateOfBirth);
            this.addMember(tMember);
        }

    }

    public void addMessage(String _nickName, String subject, String body) {
        Date tDate = new Date();
        this._XmlForum.addMessage(0, body, subject, body, tDate, tDate);
    }

    public void logout(String username) {
        for (int i=0;i < this._onlineMembers.size();i++){
            if (this._onlineMembers.elementAt(i).getUserName().equals(username)){
                this._onlineMembers.removeElementAt(i);
                break;
            }
        }
    }

    public boolean checkPasswordPolicy(String password) {
        return password.length() >= 8;
    }

    public void addMember(Member member) {
        this._onlineMembers.add(member);
    }




}
