/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package gui;

import data.Loans;
import java.awt.Color;
import people.Administrator;

/**
 *
 * @author Craig
 */
public class FormNavigation extends javax.swing.JFrame {
    private Administrator admin;
    /**
     * Creates new form FormNavigation
     */
    public FormNavigation() {
        initComponents();
    }
    
    public FormNavigation(Administrator admin) {
        initComponents();
        this.admin = admin;
        this.getContentPane().setBackground(new Color (238,238,238));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCarSearch = new javax.swing.JButton();
        btnStaffSearch = new javax.swing.JButton();
        btnRentals = new javax.swing.JButton();
        btnManageCars = new javax.swing.JButton();
        btnManageMembers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(450, 300));

        jLabel1.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Management Navigation");

        btnCarSearch.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnCarSearch.setText("Manage Cars");
        btnCarSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarSearchActionPerformed(evt);
            }
        });

        btnStaffSearch.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnStaffSearch.setText("Rental");
        btnStaffSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffSearchActionPerformed(evt);
            }
        });

        btnRentals.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnRentals.setText("Loan Lookup");
        btnRentals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentalsActionPerformed(evt);
            }
        });

        btnManageCars.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnManageCars.setText("Car Lookup");
        btnManageCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCarsActionPerformed(evt);
            }
        });

        btnManageMembers.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnManageMembers.setText("Manage Members");
        btnManageMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageMembersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnManageMembers, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRentals, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCarSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(btnManageCars, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(btnStaffSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addComponent(btnStaffSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCarSearch)
                    .addComponent(btnManageMembers))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnManageCars)
                    .addComponent(btnRentals))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarSearchActionPerformed
        FormCarLookup frmCarLookup = new FormCarLookup(admin);
        frmCarLookup.setVisible(true);
    }//GEN-LAST:event_btnCarSearchActionPerformed

    private void btnStaffSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffSearchActionPerformed
        FormMain frmMain = new FormMain(admin);
        frmMain.setVisible(true);
        Loans.getInstance().registerObserver(frmMain);
    }//GEN-LAST:event_btnStaffSearchActionPerformed

    private void btnRentalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentalsActionPerformed
        FormManageLoans frmRental = new FormManageLoans(admin);
        frmRental.setVisible(true);
    }//GEN-LAST:event_btnRentalsActionPerformed

    private void btnManageMembersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageMembersActionPerformed
        FormStaffLookup frmStaffLookup = new FormStaffLookup(admin);
        frmStaffLookup.setVisible(true);
    }//GEN-LAST:event_btnManageMembersActionPerformed

    private void btnManageCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCarsActionPerformed
        FormCarStatusLookup frmCarStatusLookup = new FormCarStatusLookup(admin);
        frmCarStatusLookup.setVisible(true);
    }//GEN-LAST:event_btnManageCarsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormNavigation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNavigation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNavigation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNavigation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormNavigation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarSearch;
    private javax.swing.JButton btnManageCars;
    private javax.swing.JButton btnManageMembers;
    private javax.swing.JButton btnRentals;
    private javax.swing.JButton btnStaffSearch;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
