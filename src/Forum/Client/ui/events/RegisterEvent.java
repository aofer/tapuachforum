/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.Client.ui.events;

import Forum.Client.ui.TreeView.ForumTree;

;
import Forum.Client.ui.TreeView.ForumTreeHandler;
import java.awt.Component;

/**
 *
 * @author Arseny
 */
public class RegisterEvent implements ForumTreeEvent {

    private Component m_comp;

    public RegisterEvent(Component comp) {
        this.m_comp = comp;
    }



    public void respondToEvent(ForumTreeHandler handler) {
        ((ForumTree)(handler)).getMf().RegSuccess();
    }

}
