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
public class SearchByAutherResultsEvent implements ForumTreeEvent {
  private Component _comp;
  private String _results;

    public SearchByAutherResultsEvent(Component comp, String results) {
        this._comp = comp;
        this._results = results;
    }



    public void respondToEvent(ForumTreeHandler handler) {
           ((ForumTree)(handler)).getMf().showResults(this._results);
    }

}
