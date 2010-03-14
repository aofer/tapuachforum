/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.DomainLayer.Interfaces;

import Forum.DomainLayer.Member;
import Forum.DomainLayer.Message;

/**
 *
 * @author Amit Ofer
 */
public interface ForumInterface {
    public Message getMessage(int messageId);
    public void register(Member newMember);
    public void login(String username,String password);
    public void logout(String username);
    public void addMessage(String nickname,String Subject,String body);
}
