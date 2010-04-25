/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SearchPanel.java
 *
 * Created on 24/04/2010, 10:54:43
 */

package Forum.Client.ui;

/**
 *
 * @author Liron
 */
public class SearchPanel extends javax.swing.JPanel {

    /** Creates new form SearchPanel */
    public SearchPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pSearchByAuthor = new javax.swing.JPanel();
        tSearchAuther = new javax.swing.JTextField();
        bSearchAuthor = new javax.swing.JButton();
        lAuther = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        pSearchByPharse = new javax.swing.JPanel();
        tSearchPharse = new javax.swing.JTextField();
        bSearchPharse = new javax.swing.JButton();
        lPharse = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        pSearchByAuthor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Search by Author"));

        tSearchAuther.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSearchAutherActionPerformed(evt);
            }
        });

        bSearchAuthor.setText("Search");
        bSearchAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSearchAuthorActionPerformed(evt);
            }
        });

        lAuther.setText("Author:");

        jLabel5.setText("From:");

        jLabel6.setText("To:");

        javax.swing.GroupLayout pSearchByAuthorLayout = new javax.swing.GroupLayout(pSearchByAuthor);
        pSearchByAuthor.setLayout(pSearchByAuthorLayout);
        pSearchByAuthorLayout.setHorizontalGroup(
            pSearchByAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSearchByAuthorLayout.createSequentialGroup()
                .addComponent(lAuther)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tSearchAuther, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bSearchAuthor)
                .addContainerGap())
        );
        pSearchByAuthorLayout.setVerticalGroup(
            pSearchByAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSearchByAuthorLayout.createSequentialGroup()
                .addGroup(pSearchByAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lAuther)
                    .addComponent(tSearchAuther, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSearchAuthor))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pSearchByPharse.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Search by Pharse"));

        bSearchPharse.setText("Search");
        bSearchPharse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSearchPharseActionPerformed(evt);
            }
        });

        lPharse.setText("Pharse:");

        jLabel3.setText("From:");

        jLabel4.setText("To:");

        javax.swing.GroupLayout pSearchByPharseLayout = new javax.swing.GroupLayout(pSearchByPharse);
        pSearchByPharse.setLayout(pSearchByPharseLayout);
        pSearchByPharseLayout.setHorizontalGroup(
            pSearchByPharseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSearchByPharseLayout.createSequentialGroup()
                .addComponent(lPharse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tSearchPharse, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(bSearchPharse)
                .addContainerGap())
        );
        pSearchByPharseLayout.setVerticalGroup(
            pSearchByPharseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSearchByPharseLayout.createSequentialGroup()
                .addGroup(pSearchByPharseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSearchPharse)
                    .addComponent(tSearchPharse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lPharse))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pSearchByAuthor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pSearchByPharse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pSearchByAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pSearchByPharse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pSearchByAuthor.getAccessibleContext().setAccessibleName("Search by Author");
        pSearchByAuthor.getAccessibleContext().setAccessibleDescription("Search by Author");
    }// </editor-fold>//GEN-END:initComponents

    private void bSearchAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchAuthorActionPerformed
        String autherText = tSearchAuther.getText();
        tSearchAuther.selectAll();
      
    }//GEN-LAST:event_bSearchAuthorActionPerformed

    private void bSearchPharseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchPharseActionPerformed
        String pharseText = tSearchPharse.getText();
        tSearchPharse.selectAll();
    }//GEN-LAST:event_bSearchPharseActionPerformed

    private void tSearchAutherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSearchAutherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tSearchAutherActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSearchAuthor;
    private javax.swing.JButton bSearchPharse;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lAuther;
    private javax.swing.JLabel lPharse;
    private javax.swing.JPanel pSearchByAuthor;
    private javax.swing.JPanel pSearchByPharse;
    private javax.swing.JTextField tSearchAuther;
    private javax.swing.JTextField tSearchPharse;
    // End of variables declaration//GEN-END:variables

}
