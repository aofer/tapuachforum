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
 * @author amit
 */
public class  OnlineMembersEvent implements ForumTreeEvent {

    private Component m_comp;
   private String onlineUsers;

    public OnlineMembersEvent(Component comp, String response) {
        this.m_comp = comp;
        this.onlineUsers = response;
    }

     public void respondToEvent(ForumTreeHandler handler) {
           ((ForumTree)(handler)).getMf().setOnlineUsers(this.onlineUsers);
    }




}
