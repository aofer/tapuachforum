/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.Client.ui.events;

import Forum.Client.ui.TreeView.ForumTree;
import Forum.Client.ui.TreeView.ForumTreeHandler;
import java.awt.Component;

/**
 *
 * @author Arseny
 */
public class LoginEvent implements ForumTreeEvent {
  private Component m_comp;
  private String user;

    public LoginEvent(Component comp, String user) {
        this.m_comp = comp;
        this.user = user;
    }



    public void respondToEvent(ForumTreeHandler handler) {
           ((ForumTree)(handler)).getMf().loginSuccess(user);
    }

}
