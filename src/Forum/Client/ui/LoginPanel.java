/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginPanel.java
 *
 * Created on 23/04/2010, 17:49:32
 */
package Forum.Client.ui;

/**
 *
 * @author Eden
 */
public class LoginPanel extends javax.swing.JPanel {

    private Main _parent;

    /** Creates new form LoginPanel */
    public LoginPanel() {
        initComponents();
    }

    void addParent(Main main) {
        this._parent = main;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lUsername = new javax.swing.JLabel();
        tUsername = new javax.swing.JTextField();
        lPassword = new javax.swing.JLabel();
        tPassword = new javax.swing.JPasswordField();
        bLogin = new javax.swing.JButton();
        bRegister = new javax.swing.JButton();

        lUsername.setText("Username:");

        lPassword.setText("Password:");

        tPassword.setColumns(8);
        tPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tPasswordKeyTyped(evt);
            }
        });

        bLogin.setText("Log in");
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });

        bRegister.setText("Register");
        bRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lUsername)
                    .addComponent(tUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lPassword)
                    .addComponent(tPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bRegister)
                    .addComponent(bLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
        Login();
    }//GEN-LAST:event_bLoginActionPerformed
    private void Login() {
        String userNameText = getTUsername().getText();
        getTUsername().selectAll();
        String passwordText = new String(getTPassword().getPassword());
        getTPassword().selectAll();
        this.getMain().getM_pipe().login(userNameText, passwordText, this);
    }
    private void bRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegisterActionPerformed
        this.getMain().getTreePanel().setVisible(false);
        this.getMain().getSearchPanel1().setVisible(false);
        this.getMain().getStatusPanel1().setVisible(false);
        this.getMain().getLoginPanel1().setVisible(false);
        this.getMain().getRegistrationPanel().setVisible(true);
        this.getMain().getRefreshButton().setVisible(false);
        this.getMain().getPagingPanel().setVisible(false);
    }//GEN-LAST:event_bRegisterActionPerformed

    private void tPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tPasswordKeyTyped
        if (evt.getKeyChar() == '\n') {
            Login();
        }
    }//GEN-LAST:event_tPasswordKeyTyped

    /**
     * @return the tPassword
     */
    public javax.swing.JPasswordField getTPassword() {
        return tPassword;
    }

    /**
     * @param tPassword the tPassword to set
     */
    public void setTPassword(javax.swing.JPasswordField tPassword) {
        this.tPassword = tPassword;
    }

    /**
     * @return the tUsername
     */
    public javax.swing.JTextField getTUsername() {
        return tUsername;
    }

    /**
     * @param tUsername the tUsername to set
     */
    public void setTUsername(javax.swing.JTextField tUsername) {
        this.tUsername = tUsername;
    }

    /**
     * @return the _parent
     */
    public Main getMain() {
        return _parent;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLogin;
    private javax.swing.JButton bRegister;
    private javax.swing.JLabel lPassword;
    private javax.swing.JLabel lUsername;
    private javax.swing.JPasswordField tPassword;
    private javax.swing.JTextField tUsername;
    // End of variables declaration//GEN-END:variables
}
