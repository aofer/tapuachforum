/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.Client.ui.events;

import Forum.Client.ui.ForumTree;
import Forum.Client.ui.ForumTreeHandler;
import java.awt.Component;

/**
 *
 * @author Arseny
 */
public class UpgradeEvent  implements  ForumTreeEvent {
 private Component m_comp;
   private String  _user;

    public UpgradeEvent(Component comp,  String user) {
        this.m_comp = comp;
        this._user = user;
    }
    public void respondToEvent(ForumTreeHandler handler) {
         ((ForumTree)(handler)).getMf().upgradeSuccess();
    }


}
