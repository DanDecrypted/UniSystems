/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package gui;

import car.Car;
import car.LoanType;
import command.interfaces.ICommand;
import command.interfaces.ICommandBehaviour;
import commands.loan.ReturnCarCommand;
import commandtracker.Command;
import commandtracker.CommandTracker;
import java.awt.Color;
import java.util.concurrent.TimeUnit;
import loaning.DayLoan;
import loaning.Loan;
import loaning.LongLoan;
import people.Administrator;
import people.Staff;

/**
 *
 * @author najimmazidi
 */
public class FormViewRental extends javax.swing.JFrame {
    Administrator admin;
    Staff staff;
    Car car;
    Loan loan;
    CommandTracker commandTracker = new CommandTracker();
    
    /**
     * Creates new form FormViewRental
     */
    
    public FormViewRental() {
        initComponents();
        this.getContentPane().setBackground(new Color (238,238,238));
        this.jPanel1.setBackground(new Color (238, 238, 238));
        this.jPanel2.setBackground(new Color (238, 238, 238));
        this.jPanel3.setBackground(new Color (238, 238, 238));
    }
    public FormViewRental(Administrator admin, DayLoan loan) {
        initComponents();
        this.getContentPane().setBackground(new Color (238,238,238));
        this.jPanel1.setBackground(new Color (238, 238, 238));
        this.jPanel2.setBackground(new Color (238, 238, 238));
        this.jPanel3.setBackground(new Color (238, 238, 238));
        
        this.admin = admin;
        this.staff = loan.getLoaner();
        this.car = loan.getCar();
        this.loan = loan;
        
        this.txtStaffNumb.setText(staff.getRefNumb());
        this.txtForename.setText(staff.getForename());
        this.txtSurname.setText(staff.getSurname());
        this.txtRoom.setText(staff.getOfficeRoom());
        this.txtPhone.setText(staff.getWorkNumb());
        
        this.txtNumberPlate.setText(car.getRegNo());
        this.txtMake.setText(car.getMake());
        this.txtModel.setText(car.getModel());
        this.txtClass.setText(car.getClassification().toString());
        
        this.txtLoanType.setText(data.UtilityFunctions.formatEnum(LoanType.DAY_LOAN.toString()));
        this.txtLoanDate.setText(data.UtilityFunctions.formatDate(loan.getRentalDate()));
        
        this.lblStartDate.setVisible(false);
        this.lblEndDate.setVisible(false);
        this.lblDuration.setVisible(false);
        this.txtStartDate.setVisible(false);
        this.txtEndDate.setVisible(false);
        this.txtDuration.setVisible(false);
        
    }
    
    public FormViewRental(Administrator admin, LongLoan loan) {
        initComponents();
        this.getContentPane().setBackground(new Color (238,238,238));
        this.jPanel1.setBackground(new Color (238, 238, 238));
        this.jPanel2.setBackground(new Color (238, 238, 238));
        this.jPanel3.setBackground(new Color (238, 238, 238));
        
        this.admin = admin;
        this.staff = loan.getLoaner();
        this.car = loan.getCar();
        this.loan = loan;
        
        this.txtStaffNumb.setText(staff.getRefNumb());
        this.txtForename.setText(staff.getForename());
        this.txtSurname.setText(staff.getSurname());
        this.txtRoom.setText(staff.getOfficeRoom());
        this.txtPhone.setText(staff.getWorkNumb());
        
        this.txtNumberPlate.setText(car.getRegNo());
        this.txtMake.setText(car.getMake());
        this.txtModel.setText(car.getModel());
        this.txtClass.setText(car.getClassification().toString());
        
        this.txtLoanType.setText(data.UtilityFunctions.formatEnum(LoanType.LONG_TERM_LOAN.toString()));
        this.txtStartDate.setText(data.UtilityFunctions.formatDate(loan.getStartDate()));
        this.txtEndDate.setText(data.UtilityFunctions.formatDate(loan.getEndDate()));
        this.txtDuration.setText(Long.toString(loan.getDuration(TimeUnit.DAYS)));
        
        this.lblLoanDate.setVisible(false);
        this.txtLoanDate.setVisible(false);
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
        jPanel1 = new javax.swing.JPanel();
        lblStaffDetails = new javax.swing.JLabel();
        lblStaffNumber = new javax.swing.JLabel();
        txtStaffNumb = new javax.swing.JTextField();
        lblForename = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        txtForename = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        lblOfficeRoom = new javax.swing.JLabel();
        txtRoom = new javax.swing.JTextField();
        lblOfficePhone = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblCarDetails = new javax.swing.JLabel();
        lblNumbPlate = new javax.swing.JLabel();
        lblMake = new javax.swing.JLabel();
        lblModel = new javax.swing.JLabel();
        lblClass = new javax.swing.JLabel();
        txtNumberPlate = new javax.swing.JTextField();
        txtMake = new javax.swing.JTextField();
        txtClass = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblRentalDetails = new javax.swing.JLabel();
        lblLoanType = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
        lblDuration = new javax.swing.JLabel();
        lblEndDate = new javax.swing.JLabel();
        txtLoanType = new javax.swing.JTextField();
        txtStartDate = new javax.swing.JTextField();
        txtEndDate = new javax.swing.JTextField();
        txtDuration = new javax.swing.JTextField();
        lblLoanDate = new javax.swing.JLabel();
        txtLoanDate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("View Loan");
        lblTitle.setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblStaffDetails.setFont(new java.awt.Font("Lato", 1, 13)); // NOI18N
        lblStaffDetails.setText("Staff Details");

        lblStaffNumber.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblStaffNumber.setText("Staff Number:");

        txtStaffNumb.setEditable(false);

        lblForename.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblForename.setText("Forename:");

        lblSurname.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblSurname.setText("Surname:");

        txtForename.setEditable(false);

        txtPhone.setEditable(false);

        lblOfficeRoom.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblOfficeRoom.setText("Office Room:");

        txtRoom.setEditable(false);

        lblOfficePhone.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblOfficePhone.setText("Office Phone:");

        txtSurname.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStaffDetails)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblOfficeRoom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblForename)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtForename, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblStaffNumber)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStaffNumb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSurname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblOfficePhone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStaffDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStaffNumber)
                    .addComponent(txtStaffNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblForename)
                    .addComponent(lblSurname)
                    .addComponent(txtForename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOfficeRoom)
                    .addComponent(lblOfficePhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCarDetails.setFont(new java.awt.Font("Lato", 1, 13)); // NOI18N
        lblCarDetails.setText("Car Details");

        lblNumbPlate.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblNumbPlate.setText("Number Plate:");

        lblMake.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblMake.setText("Make:");

        lblModel.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblModel.setText("Model:");

        lblClass.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblClass.setText("Class:");

        txtNumberPlate.setEditable(false);

        txtMake.setEditable(false);

        txtClass.setEditable(false);

        txtModel.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCarDetails)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNumbPlate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumberPlate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblClass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtClass, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblMake)
                                .addGap(57, 57, 57)
                                .addComponent(txtMake, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addComponent(lblModel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCarDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumbPlate)
                    .addComponent(txtNumberPlate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMake)
                    .addComponent(lblModel)
                    .addComponent(txtMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClass)
                    .addComponent(txtClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnCancel.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnReturn.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnReturn.setText("Return Car");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblRentalDetails.setFont(new java.awt.Font("Lato", 1, 13)); // NOI18N
        lblRentalDetails.setText("Loan Details");

        lblLoanType.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblLoanType.setText("Loan Type:");

        lblStartDate.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblStartDate.setText("Start Date:");

        lblDuration.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblDuration.setText("Duration:");

        lblEndDate.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblEndDate.setText("End Date:");

        txtLoanType.setEditable(false);

        txtStartDate.setEditable(false);

        txtEndDate.setEditable(false);

        txtDuration.setEditable(false);

        lblLoanDate.setText("Loan Date:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblEndDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStartDate)
                            .addComponent(lblRentalDetails)
                            .addComponent(lblLoanType))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoanDate)
                    .addComponent(lblDuration))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDuration, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(txtLoanDate))
                .addGap(45, 45, 45))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblRentalDetails)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLoanType)
                            .addComponent(txtLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLoanDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblLoanDate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStartDate)
                    .addComponent(lblDuration)
                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndDate)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReturn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnReturn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        
        FormConfirmReturn frm = new FormConfirmReturn(admin, loan, commandTracker);
        frm.setVisible(true);

    }//GEN-LAST:event_btnReturnActionPerformed

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
            java.util.logging.Logger.getLogger(FormViewRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormViewRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormViewRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormViewRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormViewRental().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReturn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCarDetails;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblDuration;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblForename;
    private javax.swing.JLabel lblLoanDate;
    private javax.swing.JLabel lblLoanType;
    private javax.swing.JLabel lblMake;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblNumbPlate;
    private javax.swing.JLabel lblOfficePhone;
    private javax.swing.JLabel lblOfficeRoom;
    private javax.swing.JLabel lblRentalDetails;
    private javax.swing.JLabel lblStaffDetails;
    private javax.swing.JLabel lblStaffNumber;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtClass;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtEndDate;
    private javax.swing.JTextField txtForename;
    private javax.swing.JTextField txtLoanDate;
    private javax.swing.JTextField txtLoanType;
    private javax.swing.JTextField txtMake;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtNumberPlate;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtRoom;
    private javax.swing.JTextField txtStaffNumb;
    private javax.swing.JTextField txtStartDate;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables
}
