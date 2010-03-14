/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer.Interfaces;

import Forum.Exceptions.WrongPasswordException;
import Forum.DomainLayer.Member;
import Forum.DomainLayer.Message;
import Forum.Exceptions.*;

/**
 *
 * @author Amit Ofer
 */
public interface DomainForumInterface {
    public Message getMessage(int messageId)throws MessageNotFoundException;
    public void register(Member newMember) throws UserExistsException,NicknameExistsException,BadPasswordException;
    public void login(String username, String password) throws NoSuchUserException,WrongPasswordException ;
    public void logout(String username);
    public void addMessage(String nickname,String Subject,String body);
    public boolean checkPasswordPolicy(String password);
    public void addMember(Member member) ;
}
