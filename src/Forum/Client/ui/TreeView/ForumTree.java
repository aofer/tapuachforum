package Forum.Client.ui.TreeView;

import Forum.Client.ui.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import Forum.Client.ControllerLayer.ControllerHandler;
import Forum.Client.ControllerLayer.ControllerHandlerFactory;
import Forum.Client.ui.TreeView.Interfaces.CellViewInterface;
import Forum.DomainLayer.Message;
import Forum.PersistentLayer.Interfaces.eMemberType;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 * @author Tomer Heber
 *
 */
public class ForumTree implements ForumTreeHandler {

    TreePath _path = null;
    /**
     * The JTree GUI component.
     */
    private JTree m_tree;
    /**
     * The JPanel GUI component.
     */
    private JPanel m_panel;
    /**
     * A pipe interface to communicate with the controller layer.
     */
    private ControllerHandler m_pipe;
    private Main _mf;

    public Main getMf() {
        return _mf;
    }

    public ControllerHandler getPipe() {
        return m_pipe;
    }
    /**
     * A thread pool that is used to initiate operations in the controller layer.
     */
    private ExecutorService m_pool = Executors.newCachedThreadPool();

    public ForumTree(Main mf) {
        UIManager.put("Tree.collapsedIcon", new ImageIcon("./images/plus-8.png"));
        UIManager.put("Tree.expandedIcon", new ImageIcon("./images/minus-8.png"));
        this._mf = mf;
        m_pipe = ControllerHandlerFactory.getPipe();
        /* Add an observer to the controller (The observable). */
        m_pipe.addObserver(new ForumTreeObserver(this));

        m_tree = new JTree();
        m_tree.putClientProperty("JTree.lineStyle", "None");

        refreshForum(m_pipe.getForumView());

        ForumTreeCellRenderer renderer = new ForumTreeCellRenderer(this);
        m_tree.setCellRenderer(renderer);
        m_tree.setCellEditor(new ForumTreeCellEditor(renderer));
        m_tree.setEditable(true);

        m_tree.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                BasicTreeUI ui = (BasicTreeUI) m_tree.getUI();
                ui.setLeftChildIndent(ui.getLeftChildIndent());
                ui.setRightChildIndent(ui.getRightChildIndent());
            }
        });

        m_panel = new JPanel();
        m_panel.setBackground(Color.WHITE);
        JScrollPane pane = new JScrollPane(m_tree);
        pane.setPreferredSize(new Dimension(770, 450));
        m_panel.add(pane);
        m_panel.setPreferredSize(new Dimension(780, 475));
    }

    public void setPath(long msgID) {
        TreeNode[] nodePath= getPath((DefaultMutableTreeNode)m_tree.getModel().getRoot(),msgID);
        TreePath treePath= new TreePath(nodePath);
        m_tree.setSelectionPath(treePath);
    }

    private TreeNode[] getPath(DefaultMutableTreeNode parent, long msgID) {
        DefaultMutableTreeNode child;
        TreeNode[] childPath = null;

        if (((ForumCell) parent.getUserObject()).getId() == msgID) {
            childPath = parent.getPath();
        } else {
            for (int i = 0; i < parent.getChildCount() & childPath == null; i++) {
                child = (DefaultMutableTreeNode) parent.getChildAt(i);
                childPath = getPath(child, msgID);
            }
        }
        return childPath;
    }

    /**
     *
     * @return The forum tree GUI component.
     */
    public Component getForumTreeUI() {
        return m_panel;
    }

    @Override
    public void refreshForum(String encodedView) {
        ForumCell rootCell = decodeView(encodedView);
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(rootCell);

        Stack<DefaultMutableTreeNode> stack = new Stack<DefaultMutableTreeNode>();
        stack.add(rootNode);
        while (!stack.isEmpty()) {
            DefaultMutableTreeNode node = stack.pop();
            ForumCell cell = (ForumCell) (node.getUserObject());
            for (ForumCell sonCell : cell.getSons()) {
                DefaultMutableTreeNode sonNode = new DefaultMutableTreeNode(sonCell);
                node.add(sonNode);
                stack.add(sonNode);
            }
        }

        DefaultTreeModel model = new DefaultTreeModel(rootNode);
        m_tree.setModel(model);
        for (int i = 0; i < m_tree.getRowCount(); i++) {
            m_tree.expandRow(i);
        }

    }

    @Override
    public void NotifyError(final String errorMessage) {
        m_pool.execute(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,
                        errorMessage,
                        "Operation failed.",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    /**
     * Receives an encoding describing the forum tree.<br>
     * It decodes the description and returns the tree representation in a ForumCell instance.
     *
     * @return The tree representing the forum.
     */
    private ForumCell decodeView(String encodedView) {
        ForumCell root = new ForumCell(0, "", "", "");
        Vector<Message> messages = Forum.TCPCommunicationLayer.MessagesParser.Decode(encodedView);
        for (Message m : messages) {
            root.add(new ForumCell(m));
        }
        return root;
    }

    public void modifyMessage(final CellViewInterface cellView) {
        m_pool.execute(new Runnable() {

            @Override
            public void run() {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) m_tree.getSelectionPath().getLastPathComponent();
                ForumCell cell = (ForumCell) node.getUserObject();
                m_pipe.modifyMessage(cell.getId(), cell.getSubject(), cell.getBody(), null);
                cellView.Modified();
            }
        });
    }

    /**
     * Replies to the selected message.
     */
    public void replyToMessage() {
        m_pool.execute(new Runnable() {

            @Override
            public void run() {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) m_tree.getSelectionPath().getLastPathComponent();
                ForumCell cell = (ForumCell) node.getUserObject();
                m_pipe.addReplyToMessage(cell.getId(), "", "", m_panel);
            }
        });
    }

    /**
     * Deletes the selected message.
     */
    public void deleteMessage() {
        m_pool.execute(new Runnable() {

            @Override
            public void run() {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) m_tree.getSelectionPath().getLastPathComponent();
                ForumCell cell = (ForumCell) node.getUserObject();

                m_pipe.deleteMessage(cell.getId(), null);
            }
        });
    }

    /**
     * Adds a new message.
     */
    public void addNewMessage(final JButton button) {
        m_pool.execute(new Runnable() {

            @Override
            public void run() {
                getPipe().addNewMessage("", "", button);
            }
        });
    }

    public void setViewer(eMemberType memebr, String user) {
        ((ForumTreeCellRenderer) m_tree.getCellRenderer()).setViwer(memebr, user);
    }
}
