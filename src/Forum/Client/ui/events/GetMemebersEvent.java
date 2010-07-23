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
public class GetMemebersEvent implements ForumTreeEvent {

    private Component m_comp;
    private String _lm;

    public GetMemebersEvent(Component comp, String lm) {
        this.m_comp = comp;
        this._lm = lm;
    }

    public void respondToEvent(ForumTreeHandler handler) {
        ((ForumTree) (handler)).getMf().RefreshUMembers(_lm);
    }
}
