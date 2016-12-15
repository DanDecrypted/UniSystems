/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package gui;

import car.LoanType;
import static data.UtilityFunctions.formatEnum;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import loaning.DayLoan;
import loaning.LongLoan;
import people.Staff;
import people.Administrator;

/**
 *
 * @author Craig
 */
public class FormMain extends javax.swing.JFrame {
    private DefaultListModel listModel;
    private Administrator admin = new Administrator();
    
    public FormMain() { 
        initComponents();
        this.getContentPane().setBackground(new Color (238,238,238));
        
        listModel = new DefaultListModel();
    }
    
    public FormMain(Administrator admin) {
        this.admin = admin;
        //admin.initialiseData();
        listModel = new DefaultListModel();
                
        this.getContentPane().setBackground(new Color (238,238,238));
        this.rootPane.setDefaultButton(btnLookup);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStaffNumb = new javax.swing.JLabel();
        txtStaffNumb = new javax.swing.JTextField();
        lblFirstName = new javax.swing.JLabel();
        txtForename = new javax.swing.JTextField();
        lblSurname = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        lblPosition = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        lblFaculty = new javax.swing.JLabel();
        txtFaculty = new javax.swing.JTextField();
        lblOfficeRoom = new javax.swing.JLabel();
        txtOfficeRoom = new javax.swing.JTextField();
        lblOfficePhone = new javax.swing.JLabel();
        txtOfficePhone = new javax.swing.JTextField();
        btnLookup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlstRentalHistory = new javax.swing.JList<>();
        lblRentalHistory = new javax.swing.JLabel();
        btnRentDay = new javax.swing.JButton();
        btnRentLong = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(450, 300));

        lblStaffNumb.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblStaffNumb.setText("Staff Number:");

        lblFirstName.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblFirstName.setText("Forename:");

        txtForename.setEditable(false);
        txtForename.setEnabled(false);

        lblSurname.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblSurname.setText("Surname:");

        txtSurname.setEditable(false);
        txtSurname.setEnabled(false);

        lblPosition.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblPosition.setText("Position:");

        txtPosition.setEditable(false);
        txtPosition.setEnabled(false);

        lblFaculty.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblFaculty.setText("Faculty:");

        txtFaculty.setEditable(false);
        txtFaculty.setEnabled(false);

        lblOfficeRoom.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblOfficeRoom.setText("Office Room:");

        txtOfficeRoom.setEditable(false);
        txtOfficeRoom.setEnabled(false);

        lblOfficePhone.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblOfficePhone.setText("Office Phone:");

        txtOfficePhone.setEditable(false);
        txtOfficePhone.setEnabled(false);

        btnLookup.setFont(new java.awt.Font("Lato", 0, 11)); // NOI18N
        btnLookup.setText("Lookup");
        btnLookup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLookupActionPerformed(evt);
            }
        });

        jlstRentalHistory.setEnabled(false);
        jScrollPane1.setViewportView(jlstRentalHistory);

        lblRentalHistory.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        lblRentalHistory.setText("Rental History");

        btnRentDay.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnRentDay.setText("Day Loan");
        btnRentDay.setEnabled(false);
        btnRentDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentDayActionPerformed(evt);
            }
        });

        btnRentLong.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnRentLong.setText("Long Term");
        btnRentLong.setEnabled(false);
        btnRentLong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentLongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblStaffNumb)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblFirstName)
                                            .addComponent(lblPosition)
                                            .addComponent(lblOfficeRoom))
                                        .addGap(2, 2, 2)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtForename)
                                    .addComponent(txtStaffNumb)
                                    .addComponent(txtPosition)
                                    .addComponent(txtOfficeRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblFaculty)
                                            .addComponent(lblOfficePhone)
                                            .addComponent(lblSurname))
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtOfficePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnLookup, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblRentalHistory))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(btnRentLong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRentDay)
                .addGap(194, 194, 194))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStaffNumb)
                    .addComponent(txtStaffNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLookup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName)
                    .addComponent(txtForename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSurname)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosition)
                    .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFaculty)
                    .addComponent(txtFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOfficeRoom)
                    .addComponent(txtOfficeRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOfficePhone)
                    .addComponent(txtOfficePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(lblRentalHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRentDay)
                    .addComponent(btnRentLong))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLookupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLookupActionPerformed
        Staff staffObj = admin.getStaffForRefNumb(txtStaffNumb.getText());
        if (staffObj != null) {
            populateStaffDetails(staffObj);
            populateRentalList(staffObj);
            
            txtForename.setEnabled(true);
            txtSurname.setEnabled(true);
            txtPosition.setEnabled(true);
            txtFaculty.setEnabled(true);
            txtOfficePhone.setEnabled(true);
            txtOfficeRoom.setEnabled(true);
            jlstRentalHistory.setEnabled(true);
            txtForename.setEnabled(true);
            btnRentDay.setEnabled(true);
            btnRentLong.setEnabled(true);

        } else {
            JOptionPane.showMessageDialog(null,
                "The member of staff with the ID " + txtStaffNumb.getText() 
                + " was not found.",
                "Staff Lookup Error",
                JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnLookupActionPerformed

    private void btnRentDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentDayActionPerformed
        Staff objStaff = admin.getStaffForRefNumb(txtStaffNumb.getText());
        FormAvailableCars frm = new FormAvailableCars(admin, objStaff, LoanType.DAY_LOAN);
        frm.setVisible(true);
    }//GEN-LAST:event_btnRentDayActionPerformed

    private void btnRentLongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentLongActionPerformed
        Staff objStaff = admin.getStaffForRefNumb(txtStaffNumb.getText());
        FormAvailableCars frm = new FormAvailableCars(admin, objStaff, LoanType.LONG_TERM_LOAN);
        frm.setVisible(true);
    }//GEN-LAST:event_btnRentLongActionPerformed
    
    private void populateStaffDetails(Staff staff) {
        txtForename.setText(staff.getForename());
        txtSurname.setText(staff.getSurname());
        txtPosition.setText(formatEnum(staff.getPosition().toString()));
        txtFaculty.setText(formatEnum(staff.getFaculty().toString()));
        txtOfficeRoom.setText(staff.getOfficeRoom());
        txtOfficePhone.setText(staff.getWorkNumb());
    }
    
    private void populateRentalList(Staff staff) {
        listModel.clear();
        for (DayLoan dayLoan : admin.getDayLoansForRef(staff.getRefNumb())) {
            String listElement = dayLoan.getCar().getRegNo().toString()+ " - ";
            listElement += data.UtilityFunctions.formatDate(dayLoan.getRentalDate());
            listModel.addElement(listElement);
        }
        
        for (LongLoan longLoan : admin.getLongLoansForRef(staff.getRefNumb())) {
            String listElement = longLoan.getCar().getRegNo().toString()+ " - ";
            listElement += data.UtilityFunctions.formatDate(longLoan.getStartDate()) + " - "
                        + data.UtilityFunctions.formatDate(longLoan.getEndDate());
            listModel.addElement(listElement);
        }
        
        jlstRentalHistory.setModel(listModel);
    }
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
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLookup;
    private javax.swing.JButton btnRentDay;
    private javax.swing.JButton btnRentLong;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlstRentalHistory;
    private javax.swing.JLabel lblFaculty;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblOfficePhone;
    private javax.swing.JLabel lblOfficeRoom;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblRentalHistory;
    private javax.swing.JLabel lblStaffNumb;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JTextField txtFaculty;
    private javax.swing.JTextField txtForename;
    private javax.swing.JTextField txtOfficePhone;
    private javax.swing.JTextField txtOfficeRoom;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtStaffNumb;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables
}
