/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forum.Client.ui.events;

import Forum.Client.ui.TreeView.ForumTree;
import Forum.Client.ui.TreeView.ForumTreeHandler;
import Forum.PersistentLayer.Interfaces.eMemberType;
import java.awt.Component;

/**
 *
 * @author Arseny
 */
public class LoginEvent implements ForumTreeEvent {

    private Component m_comp;
    private String user;
    private String nick;
    private eMemberType member;

    public LoginEvent(Component comp, String user, eMemberType member, String nick) {
        this.m_comp = comp;
        this.user = user;
        this.member = member;
        this.nick = nick;
    }

    public void respondToEvent(ForumTreeHandler handler) {
        ((ForumTree) (handler)).getMf().loginSuccess(user, member, nick);
    }
}
