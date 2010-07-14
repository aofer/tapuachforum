/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Main.java
 *
 * Created on 03/05/2010, 17:47:18
 */
package Forum.Client.ui;

import Forum.Client.ControllerLayer.ControllerHandler;
import Forum.Client.ui.TreeView.ForumTree;
import Forum.DomainLayer.SearchEngine.SearchHit;
import Forum.PersistentLayer.Interfaces.eMemberType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author lironkat
 */
public class Main extends javax.swing.JFrame {

    private ControllerHandler m_pipe;
    private ForumTree _tree;
    private boolean isAdmin;

    /** Creates new form Main */
    public Main(String title) {
        super(title);
        initComponents();
        _tree = new ForumTree(this);
        this.TreePanel.setViewportView(_tree.getForumTreeUI());
        this.m_pipe = _tree.getPipe();
        this.addMainToPanels();
        this.upgradeUsersPanel.setVisible(false);
        this.logoutPanel.setVisible(false);
        this.registrationPanel.setVisible(false);
        this.searchResultPanel1.setVisible(false);
        this.m_pipe.getOnlineMembers(this);
        int delay = 5000; //milliseconds
        ActionListener taskPerformer = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                m_pipe.getOnlineMembers(null);
            }
        };
        new Timer(delay, taskPerformer).start();

    }

    private void addMainToPanels() {
        this.loginPanel.addParent(this);
        this.statusPanel.addParent(this);
        this.searchPanel.addParent(this);
        this.logoutPanel.addParent(this);
        this.registrationPanel.addParent(this);
        this.upgradeUsersPanel.addParent(this);
        this.getSearchResultPanel1().addParent(this);
    }

    public void LogoutSuccess() {
        this.logoutPanel.setVisible(false);
        this.loginPanel.getTUsername().setText("");
        this.loginPanel.getTPassword().setText("");
        this.loginPanel.setVisible(true);
        isAdmin = false;
        _tree.setViewer(eMemberType.guest, "a");
        this.getM_pipe().refreshForum(this);
    }

    public boolean isAdminLogged() {
        return isAdmin;
    }

    public void RefreshUMembers(String _lm) {
        DefaultListModel dm = new DefaultListModel();
        String[] st = _lm.split(";");

        for (int i = 0; i < st.length; i++) {
            dm.addElement(st[i]);
        }
        this.upgradeUsersPanel.getMemberList().setModel(dm);
    }

    public void RegSuccess() {
        JOptionPane.showMessageDialog(this, "Registration Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.getRegistrationPanel().clearFields();
        this.getRegistrationPanel().setVisible(false);
        this.loginPanel.setVisible(true);
        this.TreePanel.setVisible(true);
        this.searchPanel.setVisible(true);
        this.statusPanel.setVisible(true);
        this.btnRefresh.setVisible(true);
    }

    public void loginSuccess(String user, eMemberType member, String nick) {
        this.loginPanel.setVisible(false);
        this.logoutPanel.setuser(user);
        logoutPanel.setVisible(true);
        _tree.setViewer(member, nick);
        if (member == eMemberType.Admin) {
            isAdmin = true;
            getUpgradeUsersPanel().setVisible(true);
            getM_pipe().getMembers(this);
        }
        this.getM_pipe().refreshForum(this);
    }

    public void setOnlineUsers(String onlineUsers) {
        this.getStatusPanel1().getJTextArea1().setText(onlineUsers);
    }

    public void upgradeSuccess() {
        JOptionPane.showMessageDialog(this, "Upgrade Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.m_pipe.getMembers(this);
    }

    public void showResults(String results) {
        this.TreePanel.setVisible(false);
        this.searchPanel.setVisible(false);
        this.statusPanel.setVisible(false);
        this.upgradeUsersPanel.setVisible(false);
        this.getSearchResultPanel1().resetResults();
        Vector<SearchHit> hits = Forum.TCPCommunicationLayer.MessagesParser.DecodeHits(results);
        Collections.sort(hits);
        for (Iterator<SearchHit> it = hits.iterator(); it.hasNext();) {
            this.getSearchResultPanel1().addMessageToTable(it.next());
        }
        this.getSearchResultPanel1().setVisible(true);
    }

    public void hideResults() {
        TreePanel.setVisible(true);
        searchPanel.setVisible(true);
        statusPanel.setVisible(true);
        searchResultPanel1.setVisible(false);
        if (isAdmin) {
            upgradeUsersPanel.setVisible(true);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registrationPanel = new Forum.Client.ui.RegistrationPanel();
        forumLabel = new javax.swing.JLabel();
        loginPanel = new Forum.Client.ui.LoginPanel();
        logoutPanel = new Forum.Client.ui.LogoutPanel();
        TreePanel = new javax.swing.JScrollPane();
        searchResultPanel1 = new Forum.Client.ui.SearchResultPanel();
        searchPanel = new Forum.Client.ui.SearchPanel();
        statusPanel = new Forum.Client.ui.StatusPanel();
        upgradeUsersPanel = new Forum.Client.ui.upgradeUsersPanel();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 825));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(registrationPanel);
        registrationPanel.setBounds(58, 180, 380, 399);

        forumLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36));
        forumLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forum/Client/ui/tapuachLogo4.gif"))); // NOI18N
        getContentPane().add(forumLabel);
        forumLabel.setBounds(10, 10, 400, 120);

        loginPanel.setMinimumSize(new java.awt.Dimension(580, 45));
        getContentPane().add(loginPanel);
        loginPanel.setBounds(430, 70, 560, 45);
        getContentPane().add(logoutPanel);
        logoutPanel.setBounds(544, 70, 230, 45);
        getContentPane().add(TreePanel);
        TreePanel.setBounds(20, 140, 790, 480);
        getContentPane().add(searchResultPanel1);
        searchResultPanel1.setBounds(71, 210, 480, 351);
        getContentPane().add(searchPanel);
        searchPanel.setBounds(20, 620, 624, 150);
        getContentPane().add(statusPanel);
        statusPanel.setBounds(640, 620, 344, 140);
        getContentPane().add(upgradeUsersPanel);
        upgradeUsersPanel.setBounds(800, 140, 200, 260);

        btnRefresh.setText("Refresh forum");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefresh);
        btnRefresh.setBounds(820, 580, 160, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        getM_pipe().logoff(this);
    }//GEN-LAST:event_formWindowClosing

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        this.getM_pipe().refreshForum(this);
    }//GEN-LAST:event_btnRefreshActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Main main = new Main("Tapuach Forum v1.0");
        main.setResizable(false);
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane TreePanel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel forumLabel;
    private Forum.Client.ui.LoginPanel loginPanel;
    private Forum.Client.ui.LogoutPanel logoutPanel;
    private Forum.Client.ui.RegistrationPanel registrationPanel;
    private Forum.Client.ui.SearchPanel searchPanel;
    private Forum.Client.ui.SearchResultPanel searchResultPanel1;
    private Forum.Client.ui.StatusPanel statusPanel;
    private Forum.Client.ui.upgradeUsersPanel upgradeUsersPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the m_pipe
     */
    public ControllerHandler getM_pipe() {
        return m_pipe;
    }

    /**
     * @return the loginPanel1
     */
    public Forum.Client.ui.LoginPanel getLoginPanel1() {
        return loginPanel;
    }

    /**
     * @return the searchPanel1
     */
    public Forum.Client.ui.SearchPanel getSearchPanel1() {
        return searchPanel;
    }

    /**
     * @return the statusPanel1
     */
    public Forum.Client.ui.StatusPanel getStatusPanel1() {
        return statusPanel;
    }

    /**
     * @return the registrationPanel
     */
    public Forum.Client.ui.RegistrationPanel getRegistrationPanel() {
        return registrationPanel;
    }

    /**
     * @return the TreePanel
     */
    public javax.swing.JScrollPane getTreePanel() {
        return TreePanel;
    }

    /**
     * @return the upgradeUsersPanel
     */
    public Forum.Client.ui.upgradeUsersPanel getUpgradeUsersPanel() {
        return upgradeUsersPanel;
    }

    /**
     * @return the searchResultPanel1
     */
    public Forum.Client.ui.SearchResultPanel getSearchResultPanel1() {
        return searchResultPanel1;
    }

    /**
     * @return the _tree
     */
    public ForumTree getForumTree() {
        return _tree;
    }

    public JButton getRefreshButton() {
        return this.btnRefresh;
    }
}
