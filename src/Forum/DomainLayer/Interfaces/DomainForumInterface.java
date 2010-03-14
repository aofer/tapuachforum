/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer.Interfaces;

import Forum.DomainLayer.Member;
import Forum.DomainLayer.Message;
import Forum.Exceptions.*;

/**
 *
 * @author Amit Ofer
 */
public interface DomainForumInterface {
    public Message getMessage(int messageId);
    public void register(Member newMember) throws UserExistsException,NicknameExistsException,BadPasswordException;
    public void login(String username,String password);
    public void logout(String username);
    public void addMessage(String nickname,String Subject,String body);
    public boolean checkPasswordPolicy(String password);
}
