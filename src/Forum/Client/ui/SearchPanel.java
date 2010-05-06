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

    private Main _parent;

    /** Creates new form SearchPanel */
    public SearchPanel() {
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

        pSearchByAuthor = new javax.swing.JPanel();
        tSearchAuther = new javax.swing.JTextField();
        bSearchAuthor = new javax.swing.JButton();
        lAuther = new javax.swing.JLabel();
        tFromAuther = new javax.swing.JTextField();
        lFrom1 = new javax.swing.JLabel();
        lTo1 = new javax.swing.JLabel();
        tToAuther = new javax.swing.JTextField();
        pSearchByPharse = new javax.swing.JPanel();
        tSearchPharse = new javax.swing.JTextField();
        bSearchPharse = new javax.swing.JButton();
        lPharse = new javax.swing.JLabel();
        lFrom2 = new javax.swing.JLabel();
        lTo2 = new javax.swing.JLabel();
        tToPharse = new javax.swing.JTextField();
        tFromPharse = new javax.swing.JTextField();

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

        lFrom1.setText("From:");

        lTo1.setText("To:");

        javax.swing.GroupLayout pSearchByAuthorLayout = new javax.swing.GroupLayout(pSearchByAuthor);
        pSearchByAuthor.setLayout(pSearchByAuthorLayout);
        pSearchByAuthorLayout.setHorizontalGroup(
            pSearchByAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSearchByAuthorLayout.createSequentialGroup()
                .addComponent(lAuther)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tSearchAuther, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lFrom1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tFromAuther, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lTo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tToAuther, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(lFrom1)
                    .addComponent(tFromAuther, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTo1)
                    .addComponent(tToAuther, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        lFrom2.setText("From:");

        lTo2.setText("To:");

        javax.swing.GroupLayout pSearchByPharseLayout = new javax.swing.GroupLayout(pSearchByPharse);
        pSearchByPharse.setLayout(pSearchByPharseLayout);
        pSearchByPharseLayout.setHorizontalGroup(
            pSearchByPharseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSearchByPharseLayout.createSequentialGroup()
                .addComponent(lPharse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tSearchPharse, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lFrom2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tFromPharse, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lTo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tToPharse, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(bSearchPharse)
                .addContainerGap())
        );
        pSearchByPharseLayout.setVerticalGroup(
            pSearchByPharseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSearchByPharseLayout.createSequentialGroup()
                .addGroup(pSearchByPharseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lFrom2)
                    .addComponent(tFromPharse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTo2)
                    .addComponent(tToPharse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        pSearchByAuthor.getAccessibleContext().setAccessibleDescription("Search by Author");
    }// </editor-fold>//GEN-END:initComponents

    private void bSearchAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchAuthorActionPerformed
        String autherText = this.tSearchAuther.getText();
        int from, to;
        if (this.tFromAuther.getText().compareTo("") == 0) {
            from = 0;
        } else {
            from = Integer.parseInt(this.tFromAuther.getText());
        }
        if (this.tToAuther.getText().compareTo("") == 0) {
            to = 0;
        } else {
            to = Integer.parseInt(this.tToAuther.getText());
        }
        this.getMain().getM_pipe().searchByAuthor(autherText, from, to, this);
    }//GEN-LAST:event_bSearchAuthorActionPerformed

    private void bSearchPharseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchPharseActionPerformed
        String pharseText = tSearchPharse.getText();
        tSearchPharse.selectAll();
    }//GEN-LAST:event_bSearchPharseActionPerformed

    private void tSearchAutherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSearchAutherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tSearchAutherActionPerformed

    /**
     * @return the _parent
     */
    public Main getMain() {
        return _parent;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSearchAuthor;
    private javax.swing.JButton bSearchPharse;
    private javax.swing.JLabel lAuther;
    private javax.swing.JLabel lFrom1;
    private javax.swing.JLabel lFrom2;
    private javax.swing.JLabel lPharse;
    private javax.swing.JLabel lTo1;
    private javax.swing.JLabel lTo2;
    private javax.swing.JPanel pSearchByAuthor;
    private javax.swing.JPanel pSearchByPharse;
    private javax.swing.JTextField tFromAuther;
    private javax.swing.JTextField tFromPharse;
    private javax.swing.JTextField tSearchAuther;
    private javax.swing.JTextField tSearchPharse;
    private javax.swing.JTextField tToAuther;
    private javax.swing.JTextField tToPharse;
    // End of variables declaration//GEN-END:variables
}
