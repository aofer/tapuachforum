package Forum.Client.ui.TreeView;

import Forum.PersistentLayer.Interfaces.eMemberType;
import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

/**
 * This class represents a forum cell (overriding the default TreeCellRenderer).
 * 
 * @author Tomer Heber
 */
public class ForumTreeCellRenderer implements TreeCellRenderer {

    private NonSelectedForumTreeCellPanel m_nonselectedPanel;
    private ForumCellView m_selectedPanel;
    private ForumTreeRootPanel m_rootPanel;

    public ForumTreeCellRenderer(ForumTree forumTree) {
        m_nonselectedPanel = new NonSelectedForumTreeCellPanel();
        m_selectedPanel = new ForumCellView(forumTree);
        m_rootPanel = new ForumTreeRootPanel(forumTree);
       setViwer(eMemberType.Admin, "a");
    }

    /* (non-Javadoc)
     * @see javax.swing.tree.TreeCellRenderer#getTreeCellRendererComponent(javax.swing.JTree, java.lang.Object, boolean, boolean, boolean, int, boolean)
     */
    @Override
    public Component getTreeCellRendererComponent(
            JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        if (row == 0) {
            return m_rootPanel;
        }

        if (selected) {
            m_selectedPanel.updateView((ForumCell) node.getUserObject());
            return m_selectedPanel;
        } else {
            m_nonselectedPanel.updatePanel((ForumCell) node.getUserObject());
            return m_nonselectedPanel;
        }
    }

    public void setViwer(eMemberType member, String nick) {
        m_rootPanel.getAddButton().setEnabled(member != eMemberType.guest); //set the add new message button if the user is not a guest
        m_selectedPanel.setViewer(member, nick);
    }
}
