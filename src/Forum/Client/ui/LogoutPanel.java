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
public class LogoutPanel extends javax.swing.JPanel {

    private Main _parent ;
    

    /** Creates new form LoginPanel */
    public LogoutPanel() {
        initComponents();
    }

    void addParent(Main main) {
          this._parent = main;
    }


    void setuser(String user) {
        this.lWellcom.setText("welcome  " + user);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bLogOut = new javax.swing.JButton();
        lWellcom = new javax.swing.JLabel();

        bLogOut.setText("Log out");
        bLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogOutActionPerformed(evt);
            }
        });

        lWellcom.setText("Welcome ********");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lWellcom)
                .addGap(27, 27, 27)
                .addComponent(bLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lWellcom)
                    .addComponent(bLogOut))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLogOutActionPerformed
        this.getMain().getUpgradeUsersPanel().setVisible(false);
        this.getMain().getM_pipe().logoff(this);
}//GEN-LAST:event_bLogOutActionPerformed


        /**
     * @return the _parent
     */
    public Main getMain() {
        return _parent;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLogOut;
    private javax.swing.JLabel lWellcom;
    // End of variables declaration//GEN-END:variables

}
