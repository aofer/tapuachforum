package Forum.Client.ui.TreeView;

import Forum.Client.ui.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.ImageIcon;
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
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.Timer;
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
    private DefaultMutableTreeNode m_root;
    private Boolean m_needRefresh;
    private String m_nick;
    private boolean m_popupShown;
    private int m_viewFrom = 0;
    private int m_msgpp = 4; //number of messages per page
    private int m_viewNumberOfPages = 0; //how many paging are they

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

        TreeModel model = new DefaultTreeModel(m_root);
        m_tree.setModel(model);
        for (int i = 0; i < m_tree.getRowCount(); i++) {
            m_tree.expandRow(i);
        }

        //m_listen
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

        ActionListener taskPerformer = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                if (m_needRefresh) {
                    TreeModel model = new DefaultTreeModel(m_root);
                    m_tree.setModel(model);
                    for (int i = 0; i < m_tree.getRowCount(); i++) {
                        m_tree.expandRow(i);
                    }
                    m_needRefresh = false;
                }
            }
        };
        new Timer(1000, taskPerformer).start();
        m_needRefresh = true;
    }

    public void setPath(long msgID) {
        TreeNode[] nodePath = getPath((DefaultMutableTreeNode) m_tree.getModel().getRoot(), msgID);
        TreePath treePath = new TreePath(nodePath);
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
        m_root = rootNode;
        m_needRefresh = true;
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

    public void MoveDisplayFrom(boolean forword) {
        if (forword) {
            m_viewFrom += m_msgpp;
        } else {
            m_viewFrom -= m_msgpp;
        }
    }

    public int getNumbmerOfPages() {
        return m_viewNumberOfPages;
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
        for (int i = m_viewFrom; i < messages.size() & i < m_viewFrom + m_msgpp; i++) {
            root.add(new ForumCell(messages.get(i)));
        }
        m_viewNumberOfPages = messages.size() / m_msgpp;
        if (messages.size() % m_msgpp != 0) {
            m_viewNumberOfPages++;
        }
        _mf.getPagingPanel().UpdateView();
        if (_mf.getPagingPanel().isPassMax()) {
            return decodeView(encodedView);
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
                addNewMessagePopup(cell.getId());
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
    public void addNewMessagePopup() {
        addNewMessagePopup(0);
    }

    public void addNewMessagePopup(long id) {
        if (!m_popupShown) {
            ((ForumTreeCellRenderer) m_tree.getCellRenderer()).setAddButton(false);
            addNewMessage frm = new addNewMessage(this, m_nick, id);
            frm.setVisible(true);
            m_popupShown = true;
        } else {
            JOptionPane.showMessageDialog(this.getForumTreeUI(), "Only 1 popup is allowed");
        }
    }

    public void PopupDone() {
        ((ForumTreeCellRenderer) m_tree.getCellRenderer()).setAddButton(true);
        m_popupShown = false;
    }

    public void addNewMessage(final String subject, final String body, final long id) {

        m_pool.execute(new Runnable() {

            @Override
            public void run() {
                if (id == 0) {
                    getPipe().addNewMessage(subject, body, null);
                } else {
                    getPipe().addReplyToMessage(id, subject, body, null);
                }
            }
        });
    }

    public void setViewer(eMemberType memebr, String nick) {
        m_nick = nick;
        ((ForumTreeCellRenderer) m_tree.getCellRenderer()).setViwer(memebr, nick);
    }
}
