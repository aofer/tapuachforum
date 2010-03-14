/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;
import Forum.Exceptions.BadPasswordException;
import Forum.Exceptions.*;
import Forum.DomainLayer.Interfaces.DomainForumInterface;
import Forum.PersistentLayer.ForumHandler;
import  Forum.PersistentLayer.Interfaces.*;
import Forum.PersistentLayer.MemberHandler;
import Forum.PersistentLayer.XMLMessageHandler;
import java.util.Date;
import java.util.Vector;
import org.omg.CORBA.UserException;
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
        String tNickname = this._XmlMessage.
    }

    public void login(String username, String password) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void addMessage(String _nickName, String subject, String body) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void logout(String _userName) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean checkPasswordPolicy(String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
