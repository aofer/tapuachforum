/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.DomainLayer;

import Forum.DomainLayer.Interfaces.MemberInterface;
import Forum.DomainLayer.Logger.TapuachLogger;
import Forum.Exceptions.BadPasswordException;
import Forum.Exceptions.NicknameExistsException;
import Forum.Exceptions.NoSuchUserException;
import Forum.Exceptions.UserExistsException;
import Forum.Exceptions.UserNotExistException;
import Forum.Exceptions.WrongPasswordException;
import Forum.PersistentLayer.Data.MemberData;
import Forum.PersistentLayer.Interfaces.ForumHandlerInterface;
import Forum.PersistentLayer.Interfaces.XMLMemberInterface;
import Forum.PersistentLayer.Interfaces.eMemberType;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Kipi
 */
public class UserHandler {

    private ForumHandlerInterface _XmlForum;
    private XMLMemberInterface _XmlMember;
    private Vector<MemberInterface> _onlineMembers;

    public UserHandler(ForumHandlerInterface xmlForum, XMLMemberInterface xmlMember) {
        this._onlineMembers = new Vector<MemberInterface>();
        this._XmlForum = xmlForum;
        this._XmlMember = xmlMember;
    }

    public Member register(MemberData newMemberData) throws UserExistsException, NicknameExistsException, BadPasswordException {
        Member newMember = new Member(newMemberData);

        if (this._XmlForum.checkUsername(newMember.getUserName())) {
            throw new UserExistsException();
        } else if (this._XmlForum.checkNickname(newMember.getNickName())) {
            throw new NicknameExistsException();
        } else if (!checkPasswordPolicy(newMember.getPassword())) {
            throw new BadPasswordException();
        } else {
            String tUsername = newMember.getUserName();
            String tNickname = newMember.getNickName();
            String tPassword = newMember.getPassword();
            String encryptedPassword = this.encryptPassword(tPassword);
            String tFirstname = newMember.getFirstName();
            String tLastname = newMember.getLastName();
            String tEmail = newMember.getEmail();
            Date tDateOfBirth = newMember.getDateOfBirth();
            this._XmlForum.register(tUsername, tNickname, encryptedPassword, tEmail, tFirstname, tLastname, tDateOfBirth);
        }
        return newMember;
    }

    public void login(String username, String password) throws NoSuchUserException, WrongPasswordException {
        String encryptedPassword = this.encryptPassword(password);
        TapuachLogger.getInstance().info("user:  " + username + " logged in");
        String tPassword = this._XmlForum.userExists(username);
        if (tPassword == null) {
            throw new NoSuchUserException(username);
        } else if (!tPassword.equals(encryptedPassword)) {
            throw new WrongPasswordException();
        } else {
            MemberData data = this._XmlMember.getMember(username);
            MemberInterface tMember ;
            eMemberType type=  this._XmlMember.getMemberType(username);
            switch (type)
            {
                case Admin:
                    tMember=new Admin(data);
                    this.addMember(tMember);
                    break;
                case Moderator:
                    tMember=new Moderator(data);
                    this.addMember(tMember);
                    break;
                case member:
                    tMember=new Member(data);
                    this.addMember(tMember);
                    break;
            }
        }

    }

    public void logout(String username) {
        for (int i = 0; i < this._onlineMembers.size(); i++) {
            if (this._onlineMembers.elementAt(i).getUserName().equals(username)) {
                this._onlineMembers.removeElementAt(i);
                break;
            }
        }
    }

    public void upgradeUser(String username) throws UserNotExistException {
        this._XmlForum.upgradeUser(username);
        Forum.getInstance().logout(username);
        MemberData tData = this._XmlMember.getMember(username);
        Moderator tModerator = new Moderator(tData);
        addMember(tModerator);
    }

    public Vector<MemberInterface> getOnlineMembers() {
        return _onlineMembers;
    }

    /**
     *this method checks if the entered user meets our password policy
     * @param password
     * @return
     */
    private boolean checkPasswordPolicy(String password) {
        return password.length() >= 8;
    }

    /**
     *add an online  member to the forum
     * @param member
     */
    private void addMember(MemberInterface member) {
        this._onlineMembers.add(member);
    }

    /**
     * this method encrypts a password that will later be saved in the persistent layer
     * @param password - the original password that needs to be encrypted
     * @return - the encrypted password using the chosen algorithm
     * @throws NoSuchAlgorithmException - when the ecryption algorithm isn't known in this version of java
     */
    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            String encryptedPassword = "";
            byte[] b = password.getBytes();
            md.update(b);
            b = md.digest();
            for (int i = 0; i < b.length; i++) {
                encryptedPassword += String.format("%02x", 0xFF & b[i]);
            }
            return encryptedPassword;
        } catch (NoSuchAlgorithmException e) {
            return password;
        }

    }
}
