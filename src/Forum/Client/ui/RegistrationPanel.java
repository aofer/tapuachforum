/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RegistrationPanel.java
 *
 * Created on 24/04/2010, 12:22:03
 */
package Forum.Client.ui;

import javax.swing.JOptionPane;

/**
 *
 * @author amit
 */
public class RegistrationPanel extends javax.swing.JPanel {

    private Main _parent;

    /** Creates new form RegistrationPanel */
    public RegistrationPanel() {
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

        RegButton = new javax.swing.JButton();
        rePass = new javax.swing.JPasswordField();
        CancelButton = new javax.swing.JButton();
        tUserName = new javax.swing.JTextField();
        tPassword = new javax.swing.JPasswordField();
        tEmail = new javax.swing.JTextField();
        tNickName = new javax.swing.JTextField();
        lLastNAme = new javax.swing.JLabel();
        lFirstName = new javax.swing.JLabel();
        tLastName = new javax.swing.JTextField();
        lPassword = new javax.swing.JLabel();
        lUserName = new javax.swing.JLabel();
        lNickName = new javax.swing.JLabel();
        lEmail = new javax.swing.JLabel();
        tFirstName = new javax.swing.JTextField();
        lRePassword = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        RegButton.setText("Register");
        RegButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegButtonActionPerformed(evt);
            }
        });

        rePass.setToolTipText("retype password");

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        tUserName.setToolTipText("username for login purposes");

        tPassword.setColumns(8);
        tPassword.setToolTipText("the password must be 8 characters");

        tEmail.setColumns(15);
        tEmail.setToolTipText("email");

        tNickName.setToolTipText("your nickname in the forum");

        lLastNAme.setText("Last Name:");

        lFirstName.setText("First Name:");

        tLastName.setColumns(10);
        tLastName.setToolTipText("your family name");

        lPassword.setText("Password:");

        lUserName.setText("Username:");

        lNickName.setText("Nickname:");

        lEmail.setText("Email:");

        tFirstName.setColumns(10);
        tFirstName.setToolTipText("your first name");

        lRePassword.setText("Re-enter Password:");

        jLabel1.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        jLabel1.setText("Registration");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(RegButton)
                        .addGap(29, 29, 29)
                        .addComponent(CancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lRePassword)
                            .addComponent(lFirstName)
                            .addComponent(lUserName)
                            .addComponent(lPassword)
                            .addComponent(lLastNAme)
                            .addComponent(jLabel1)
                            .addComponent(lNickName)
                            .addComponent(lEmail))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tLastName)
                            .addComponent(tEmail)
                            .addComponent(tNickName)
                            .addComponent(tUserName)
                            .addComponent(tPassword)
                            .addComponent(rePass, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(tFirstName, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lFirstName)
                    .addComponent(tFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lLastNAme))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lEmail)
                    .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNickName)
                    .addComponent(tNickName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lUserName)
                    .addComponent(tUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPassword)
                    .addComponent(tPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lRePassword)
                    .addComponent(rePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegButton)
                    .addComponent(CancelButton))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RegButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegButtonActionPerformed
        if (correctInput()) {
            String tFirstname = this.gettFirstName().getText();
            String tLastname = this.gettLastName().getText();
            String temail = this.gettEmail().getText();
            String tUsername = this.gettUserName().getText();
            String tNickname = this.gettNickName().getText();
            String tPass = new String(this.gettPassword().getPassword());
            this.getMain().getM_pipe().register(tFirstname, tLastname, tNickname, temail, tUsername, tPass, null);
        }
    }//GEN-LAST:event_RegButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed

        this.getMain().getSearchPanel1().setVisible(true);
        this.getMain().getStatusPanel1().setVisible(true);
        this.getMain().getTreePanel().setVisible(true);
        this.getMain().getLoginPanel1().setVisible(true);
        this.getMain().getRegistrationPanel().setVisible(false);
        this.getMain().getRefreshButton().setVisible(true);
        this.getMain().getPagingPanel().setVisible(true);
    }//GEN-LAST:event_CancelButtonActionPerformed

    /**
     * @return the _parent
     */
    public Main getMain() {
        return _parent;
    }

    private boolean correctInput() {
        if (this.gettFirstName().getText().length()==0){
            JOptionPane.showMessageDialog(this, "please enter a first name", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!this.gettFirstName().getText().matches("[a-zA-Z]{3,20}")) {
            JOptionPane.showMessageDialog(this, "first name should be only between 3 to 20 letters ", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (this.gettLastName().getText().length()==0){
            JOptionPane.showMessageDialog(this, "please enter a last name", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!this.gettLastName().getText().matches("[a-zA-Z]{3,20}")) {
            JOptionPane.showMessageDialog(this, "last name should be only between 3 to 20 letters ", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (this.gettEmail().getText().length()==0){
            JOptionPane.showMessageDialog(this, "please enter an email adress", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!this.gettEmail().getText().matches("[a-zA-Z0-9]+@([a-zA-Z0-9]+)[.]{1}([a-zA-Z.]+)")){
            JOptionPane.showMessageDialog(this, "invalid email ", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (this.gettUserName().getText().length()==0){
            JOptionPane.showMessageDialog(this, "please enter a user name", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!this.gettUserName().getText().matches("[a-zA-Z0-9]+")){
            JOptionPane.showMessageDialog(this, "invalid user name ", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (this.gettNickName().getText().length()==0){
            JOptionPane.showMessageDialog(this, "please enter a nickname", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!this.gettNickName().getText().matches("[a-zA-Z0-9]+")){
            JOptionPane.showMessageDialog(this, "invalid nickname  ", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        String p1 = new String(this.gettPassword().getPassword());
        String p2 = new String(this.getRePass().getPassword());
        if (p1.length()==0 | p2.length()==0){
            JOptionPane.showMessageDialog(this, "please enter a password", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (p1.compareTo(p2) != 0) {
            JOptionPane.showMessageDialog(this, "passwords don't match", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (p1.length()<8){
            JOptionPane.showMessageDialog(this, "password to short  ", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public void clearFields() {
        this.tFirstName.setText("");
        this.tLastName.setText("");
        this.tEmail.setText("");
        this.tNickName.setText("");
        this.tUserName.setText("");
        this.tPassword.setText("");
        this.rePass.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton RegButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lEmail;
    private javax.swing.JLabel lFirstName;
    private javax.swing.JLabel lLastNAme;
    private javax.swing.JLabel lNickName;
    private javax.swing.JLabel lPassword;
    private javax.swing.JLabel lRePassword;
    private javax.swing.JLabel lUserName;
    private javax.swing.JPasswordField rePass;
    private javax.swing.JTextField tEmail;
    private javax.swing.JTextField tFirstName;
    private javax.swing.JTextField tLastName;
    private javax.swing.JTextField tNickName;
    private javax.swing.JPasswordField tPassword;
    private javax.swing.JTextField tUserName;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the tEmail
     */
    public javax.swing.JTextField gettEmail() {
        return tEmail;
    }

    /**
     * @return the tFirstName
     */
    public javax.swing.JTextField gettFirstName() {
        return tFirstName;
    }

    /**
     * @return the tLastName
     */
    public javax.swing.JTextField gettLastName() {
        return tLastName;
    }

    /**
     * @return the tNickName
     */
    public javax.swing.JTextField gettNickName() {
        return tNickName;
    }

    /**
     * @return the tPassword
     */
    public javax.swing.JPasswordField gettPassword() {
        return tPassword;
    }

    /**
     * @return the tUserName
     */
    public javax.swing.JTextField gettUserName() {
        return tUserName;
    }

    /**
     * @return the rePass
     */
    public javax.swing.JPasswordField getRePass() {
        return rePass;
    }
}
