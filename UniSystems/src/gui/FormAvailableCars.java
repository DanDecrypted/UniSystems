/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package gui;

import car.Car;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import car.Classification;
import car.LoanType;
import car.Status;
import static data.UtilityFunctions.formatEnum;
import javax.swing.DefaultListModel;
import people.Administrator;
import people.Staff;

/**
 *
 * @author Craig
 */
public class FormAvailableCars extends javax.swing.JFrame {
    private DefaultListModel listModel;
    private Administrator admin = new Administrator();
    private LoanType loanType;
    private Staff staff = new Staff();
    
    /**
     * Creates new form FormAvailableCars
     */
    public FormAvailableCars() {
        initComponents();
        
        this.getContentPane().setBackground(new Color (238,238,238));
        
    }
    public FormAvailableCars(Administrator admin, Staff staff, LoanType loanType) {
        initComponents();
        this.getContentPane().setBackground(new Color (238,238,238));
        
        listModel = new DefaultListModel();
        
        this.admin = admin;
        this.staff = staff;
        this.loanType = loanType;
        this.lblStaff.setText("Cars for: " + staff.getFullName());
        this.lblCarLoanType.setText("Showing cars available for a " + formatEnum(loanType.toString()));
        populateAvailableCars();
    }
    
    private void populateAvailableCars() {
        listModel.clear();
        
        for (Car car : admin.getCars()) {
                if (car.getLoanType().equals(this.loanType)) {
                    if (car.getStatus() == Status.AVAILABLE){
                    String listElement = car.getRegNo().toString() + " - "
                            + formatEnum(car.getTransmission().toString()) + " "
                            + formatEnum(car.getClassification().toString()) + " in "
                            + formatEnum(car.getLocation().toString());
                    
                    listModel.addElement(listElement);
                    }
                }
            }
        lstAvailableCars.setModel(listModel);
    }
    
    private void updateAvailableCars() {
        listModel.clear();
        lstAvailableCars.setModel(listModel);
        
       if (cboClass.getSelectedItem() == "ALL" && cboLocation.getSelectedItem() == "ALL"){
           populateAvailableCars();
       } else {
           if (cboClass.getSelectedItem() == "ALL") {
               for (Car car : admin.getCars()) {
                   if (car.getLoanType().equals(this.loanType)) {
                       if (car.getStatus() == Status.AVAILABLE){
                       if (car.getLocation().toString().equals(this.cboLocation.getSelectedItem().toString())) {
                           String listElement = car.getRegNo().toString() + " - "
                                + formatEnum(car.getTransmission().toString()) + " "
                                + formatEnum(car.getClassification().toString()) + " in "
                                + formatEnum(car.getLocation().toString());
                           listModel.addElement(listElement);
                       }
                       }
                   }
               }
           } else if (cboLocation.getSelectedItem() == "ALL") {
               for (Car car : admin.getCars()) {
                   if (car.getLoanType().equals(this.loanType)) {
                       if (car.getStatus() == Status.AVAILABLE){
                       if (car.getClassification().toString().equals(this.cboClass.getSelectedItem().toString())) {
                           String listElement = car.getRegNo().toString() + " - "
                                + formatEnum(car.getTransmission().toString()) + " "
                                + formatEnum(car.getClassification().toString()) + " in "
                                + formatEnum(car.getLocation().toString());
                           listModel.addElement(listElement);
                       }
                       }
                   }
               }
           } else {
               for (Car car : admin.getCars()) {
                   if (car.getLoanType().equals(this.loanType)) {
                       if (car.getStatus() == Status.AVAILABLE){
                       if ((car.getClassification().toString().equals(this.cboClass.getSelectedItem().toString())) &&
                               car.getLocation().toString().equals(this.cboLocation.getSelectedItem().toString())) {
                           String listElement = car.getRegNo().toString() + " - "
                                + formatEnum(car.getTransmission().toString()) + " "
                                + formatEnum(car.getClassification().toString()) + " in "
                                + formatEnum(car.getLocation().toString());
                           listModel.addElement(listElement);
                       }
                   }
                   }
               }
           }
           
        }
        
        lstAvailableCars.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        cboClass = new javax.swing.JComboBox<>();
        lblCarClass = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        cboLocation = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAvailableCars = new javax.swing.JList<>();
        lblCarLoanType = new javax.swing.JLabel();
        lblStaff = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        btnRentCar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Available Cars");

        cboClass.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        cboClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "COMPACT", "COUPE", "ESTATE", "LORRY", "VAN" }));
        cboClass.setToolTipText("");

        lblCarClass.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblCarClass.setText("Car Class:");

        lblLocation.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblLocation.setText("Location:");

        cboLocation.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        cboLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "PLYMOUTH", "DEVONPORT", "EXETER", "DERRIFORD", "FALMOUTH" }));

        btnUpdate.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lstAvailableCars.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(lstAvailableCars);

        lblCarLoanType.setText("PLACEHOLDER");

        lblStaff.setText("PLACEHOLDER");

        lblInfo.setText("Please select desired car from the list below:");

        btnRentCar.setText("Rent Car");
        btnRentCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentCarActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCarLoanType)
                            .addComponent(lblStaff))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblInfo)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblCarClass)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboClass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblLocation)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUpdate)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRentCar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStaff)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCarLoanType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCarClass)
                    .addComponent(lblLocation)
                    .addComponent(cboLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRentCar)
                            .addComponent(btnCancel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateAvailableCars();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRentCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentCarActionPerformed
        String[] carString = this.lstAvailableCars.getSelectedValue().toString().split(" ");
        Car carToRent = admin.getCarByReg(carString[0]);
        
        FormRentalConfirm frm = new FormRentalConfirm(admin, staff, carToRent);
        frm.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnRentCarActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(FormAvailableCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAvailableCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAvailableCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAvailableCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAvailableCars().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRentCar;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboClass;
    private javax.swing.JComboBox<String> cboLocation;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCarClass;
    private javax.swing.JLabel lblCarLoanType;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblStaff;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JList<String> lstAvailableCars;
    // End of variables declaration//GEN-END:variables
}
