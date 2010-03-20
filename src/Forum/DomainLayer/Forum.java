/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer;
import Forum.Exceptions.*;
import Forum.DomainLayer.Interfaces.ForumInterface;
import  Forum.PersistentLayer.*;
import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.Data.MessageData;
import Forum.PersistentLayer.Interfaces.ForumHandlerInterface;
import Forum.PersistentLayer.Interfaces.MemberInterface;
import Forum.PersistentLayer.Interfaces.MessageInterface;
import java.util.Date;
import java.util.Vector;


/**
 *this class is the main logics of our forum
 * it communicates with the persistent layer through a pre defined interfaces
 * @author Amit Ofer
 */
public class Forum implements ForumInterface{

    private  ForumHandlerInterface _XmlForum;
    private MemberInterface _XmlMember;
    private MessageInterface _XmlMessage;
    private Vector<Member> _onlineMembers;

    private static Forum _forum;

    public  static Forum getInstance()
    {
        if (_forum==null)
            _forum=new Forum();
        return _forum;
    }
    private Forum()
    {
        
    }
    /**
     *constructor
     * @param messageHandler
     * @param forumHandler
     * @param memberHandler
     */
    public void setXML(XMLMessageHandler messageHandler,ForumHandler forumHandler,XMLMemberHandler memberHandler){
        this._XmlForum = forumHandler;
        this._XmlMember = memberHandler;
        this._XmlMessage = messageHandler;
        this._onlineMembers = new Vector<Member>();
    }
/**
 * this is the getter for the vector of online members
 * @return a vector containing all online members
 */
    public Vector<Member> getOnlineMembers() {
        return _onlineMembers;
    }

    
    /**
     *registers a new member to the forum
     * @param newMember - the new member to be added
     * @throws UserExistsException - is thrown when the username already exists in the forum
     * @throws NicknameExistsException - is thrown when the nickname already exists in the forum
     * @throws BadPasswordException -  is thrown when the password the user supplied does not meet the password policy
     */
    public Member register(MemberData newMemberData)  throws UserExistsException,NicknameExistsException,BadPasswordException{
        Member newMember = new Member(newMemberData);
        
        if (this._XmlForum.checkUsername(newMember.getUserName()))
            throw new UserExistsException();
        else if (this._XmlForum.checkNickname(newMember.getNickName()))
            throw new NicknameExistsException();
        else if (!checkPasswordPolicy(newMember.getPassword()))
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
        return newMember;
    }

    /**
     *this method is used for getting a certain message from the bottom layer
     * @param messageId - the id of the required message
     * @return - returns the message needed
     * @throws MessageNotFoundException - is thrown when the message was not found
     */
    public Message getMessage(int messageId)  throws MessageNotFoundException{
        MessageData data= this._XmlMessage.getMessage(messageId);
        Message msg=new Message(data);
        
        Vector<Message> tReplies = new Vector<Message>();
        
        //get children to be implemented later on!!

        return msg;
    }

    /**
     *this method is used for logging into the forum
     * @param username
     * @param password
     * @throws NoSuchUserException
     * @throws WrongPasswordException
     */
    public void login(String username, String password) throws NoSuchUserException,WrongPasswordException {
        String tPassword = this._XmlForum.userExists(username);
        if (tPassword == null)
            throw new NoSuchUserException(username);
        else if (!tPassword.equals(password))
            throw new WrongPasswordException();
        else{
            MemberData data=this._XmlMember.getMember(username);

            Member tMember = new Member(data);
            this.addMember(tMember);
        }

    }

    /**
     *this metho is used for writing a new message
     * @param _nickName
     * @param subject
     * @param body
     */
    public void addMessage(String _nickName, String subject, String body) {
        Date tDate = new Date();
        this._XmlForum.addMessage(0, _nickName, subject, body, tDate, tDate);
    }

    /**
     *this method is used for logging out of the forum
     * @param username
     */
    public void logout(String username) {
        for (int i=0;i < this._onlineMembers.size();i++){
            if (this._onlineMembers.elementAt(i).getUserName().equals(username)){
                this._onlineMembers.removeElementAt(i);
                break;
            }
        }
    }

    /**
     *this method checks if the entered user meets our password policy
     * @param password
     * @return
     */
    public boolean checkPasswordPolicy(String password) {
        return password.length() >= 8;
    }

    /**
     *add an online  member to the forum
     * @param member
     */
    public void addMember(Member member) {
        this._onlineMembers.add(member);
    }

    /**
     * this is used for editing a message
     * @param messageId
     * @param subject
     * @param body
     */
    public void editMessage(String nickname,int messageId, String subject, String body) throws MessageNotFoundException, MessageOwnerException{
            Date tDate = new Date();
            String tNickname = this._XmlMessage.getMessage(messageId).getNickname();
            if (nickname.equals(tNickname)) {
                this._XmlForum.editMessage(messageId, subject, body, tDate);
            }
            else {
                throw new MessageOwnerException();
            }
        } 
    

    /**
     *this method is used for adding a new reply
     * @param parentId
     * @param nickname
     * @param subject
     * @param body
     */
    public void addReply(int parentId, String nickname, String subject, String body) {
        Date tDate = new Date();
        this._XmlForum.addMessage(parentId, body, subject, body, tDate, tDate);
    }




}
