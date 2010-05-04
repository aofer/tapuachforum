/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forum.Client.ui.TreeView.Interfaces;

import Forum.PersistentLayer.Interfaces.eMemberType;

/**
 *
 * @author hadur
 */
public interface CellViewInterface {
    void setViewer(eMemberType member,String Nick);
    void Modified();
}
