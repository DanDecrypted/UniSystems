/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package gui;

import car.Car;
import car.LoanType;
import car.Status;
import java.awt.Color;
import javax.swing.DefaultListModel;
import loaning.DayLoan;
import loaning.Loan;
import loaning.LongLoan;
import people.Administrator;
import people.Staff;

/**
 *
 * @author Craig
 */
public class FormManageLoans extends javax.swing.JFrame {

    private DefaultListModel listModel;
     private Administrator admin = new Administrator();
    private Staff staff = new Staff();
    
    /**
     * Creates new form FormDayLoan
     */
    public FormManageLoans() {
        initComponents();
        
        this.getContentPane().setBackground(new Color (238,238,238));
        
    }
    public FormManageLoans(Administrator admin) {
        initComponents();
        
        this.getContentPane().setBackground(new Color (238,238,238));
        this.jPanel2.setBackground(new Color (238,238,238));
        listModel = new DefaultListModel();
        
        if (this.rbtnCurrent.isSelected()) {
            populateActiveLoans();
        } else {
            populatePastLoans();
        }
        
    }
    
    private void populateActiveLoans() {
        listModel.clear();
        
        for (Loan loan : admin.getLoans()) {
            Car car = admin.getCarByReg(loan.getCar().getRegNo());
            if (car.getStatus().equals(Status.OUT_ON_LOAN)){
                try {
                    DayLoan dayLoan = (DayLoan)loan; //day loan boiz 
                        String listElement = loan.getCar().getRegNo()+ " rented by ";
                            listElement += loan.getLoaner().getFullName();
                            listElement += data.UtilityFunctions.formatDate(dayLoan.getRentalDate());
                            listModel.addElement(listElement);
                }
                catch (Exception e) { } 
                try {
                    LongLoan longLoan = (LongLoan)loan; // long loan boiz 
                        String listElement = loan.getCar().getRegNo()+ " rented by ";
                            listElement += loan.getLoaner().getFullName();
                            listElement += data.UtilityFunctions.formatDate(longLoan.getStartDate()) + " - "
                            + data.UtilityFunctions.formatDate(longLoan.getEndDate());
                            listModel.addElement(listElement);
                } catch (Exception e) { } 
            }
        }
        lstRentalList.setModel(listModel);
    }
    
    private void populatePastLoans() {
        listModel.clear();
        for (Loan loan : admin.getLoans()) {
            if (null != loan.getReturnedDate()){
                try {
                    DayLoan dayLoan = (DayLoan)loan; //day loan boiz 
                        String listElement = loan.getCar().getRegNo()+ " rented by ";
                            listElement += loan.getLoaner().getFullName();
                            listElement += data.UtilityFunctions.formatDate(dayLoan.getRentalDate()) + " returned on ";
                            listElement += data.UtilityFunctions.formatDate(dayLoan.getReturnedDate());
                            listModel.addElement(listElement);
                }
                catch (Exception e) { } 
                try {
                    LongLoan longLoan = (LongLoan)loan; // long loan boiz 
                        String listElement = loan.getCar().getRegNo()+ " rented by ";
                            listElement += loan.getLoaner().getFullName();
                            listElement += data.UtilityFunctions.formatDate(longLoan.getStartDate()) + " returned on  "
                            + data.UtilityFunctions.formatDate(longLoan.getReturnedDate());
                            listModel.addElement(listElement);
                } catch (Exception e) { } 
            }
        }
        lstRentalList.setModel(listModel);
    }
    
    private void filterActiveLoans() {
        listModel.clear();
        lstRentalList.setModel(listModel);
        if (txtRegNumb.getText().equals("") && txtStaffID.getText().equals("")) {
            populateActiveLoans();
        } else {
                if (txtStaffID.getText().equals("")) {
                    for (Loan loan : admin.getLoans()) {
                        Car car = admin.getCarByReg(loan.getCar().getRegNo());
                        if (car.getStatus().equals(Status.OUT_ON_LOAN)){
                            if (car.getRegNo().toLowerCase().equals(this.txtRegNumb.getText().toLowerCase())) {
                                String listElement = loan.getCar().getRegNo() + " rented by ";
                                    listElement += loan.getLoaner().getFullName();
                                    try {
                                        DayLoan dayLoan = (DayLoan)loan;
                                        listElement += data.UtilityFunctions.formatDate(dayLoan.getRentalDate());
                                    } catch (Exception e) {}
                                    try {
                                        LongLoan longLoan = (LongLoan)loan;
                                        listElement += data.UtilityFunctions.formatDate(longLoan.getStartDate()) + " - "
                                                + data.UtilityFunctions.formatDate(longLoan.getEndDate());
                                    } catch (Exception e) {}
                                    listModel.addElement(listElement);
                            }
                        }
                    }
                } else if (txtRegNumb.getText().equals("")) {
                    for (Loan loan : admin.getLoans()) {
                        Car car = admin.getCarByReg(loan.getCar().getRegNo());
                        if (car.getStatus().equals(Status.OUT_ON_LOAN)){
                            if (loan.getLoaner().getRefNumb().equals(this.txtStaffID.getText())) {
                                String listElement = car.getRegNo() + " rented by ";
                                listElement += loan.getLoaner().getFullName();
                                try {
                                    DayLoan dayLoan = (DayLoan)loan;
                                    listElement += data.UtilityFunctions.formatDate(dayLoan.getRentalDate());
                                } catch (Exception e) {}
                                try {
                                    LongLoan longLoan = (LongLoan)loan;
                                    listElement += data.UtilityFunctions.formatDate(longLoan.getStartDate()) + " - "
                                        + data.UtilityFunctions.formatDate(longLoan.getEndDate());
                                } catch (Exception e) {}
                                listModel.addElement(listElement);
                            }
                        }
                    }
                } else {
                    for (Loan loan : admin.getLoans()) {
                        Car car = admin.getCarByReg(loan.getCar().getRegNo());
                        if (car.getStatus().equals(Status.OUT_ON_LOAN)){
                            if (car.getRegNo().toLowerCase().equals(this.txtRegNumb.getText().toLowerCase()) && 
                                    loan.getLoaner().getRefNumb().equals(this.txtStaffID.getText())) {
                                String listElement = car.getRegNo() + " rented by ";
                                    listElement += loan.getLoaner().getFullName();
                                    try {
                                        DayLoan dayLoan = (DayLoan)loan;
                                        listElement += data.UtilityFunctions.formatDate(dayLoan.getRentalDate());
                                    } catch (Exception e) {}
                                    try {
                                        LongLoan longLoan = (LongLoan)loan;
                                        listElement += data.UtilityFunctions.formatDate(longLoan.getStartDate()) + " - "
                                                + data.UtilityFunctions.formatDate(longLoan.getEndDate());
                                    } catch (Exception e) {}
                                    listModel.addElement(listElement);
                            }
                        }
                    }
                }
                lstRentalList.setModel(listModel);
            }
    }
        private void filterPastLoans() {
        listModel.clear();
        lstRentalList.setModel(listModel);
        if (txtRegNumb.getText().equals("") && txtStaffID.getText().equals("")) {
            populatePastLoans();
        } else {
                if (txtStaffID.getText().equals("")) {
                    for (Loan loan : admin.getLoans()) {
                        Car car = admin.getCarByReg(loan.getCar().getRegNo());
                        if (null != loan.getReturnedDate()){
                            if (car.getRegNo().toLowerCase().equals(this.txtRegNumb.getText().toLowerCase())) {
                                String listElement = loan.getCar().getRegNo() + " rented by ";
                                    listElement += loan.getLoaner().getFullName();
                                    try {
                                        DayLoan dayLoan = (DayLoan)loan;
                                        listElement += data.UtilityFunctions.formatDate(dayLoan.getRentalDate());
                                    } catch (Exception e) {}
                                    try {
                                        LongLoan longLoan = (LongLoan)loan;
                                        listElement += data.UtilityFunctions.formatDate(longLoan.getStartDate());
                                    } catch (Exception e) {}
                                    listElement += " returned on " + loan.getReturnedDate();
                                    listModel.addElement(listElement);
                            }
                        }
                    }
                } else if (txtRegNumb.getText().equals("")) {
                    for (Loan loan : admin.getLoans()) {
                        Car car = admin.getCarByReg(loan.getCar().getRegNo());
                        if (null != loan.getReturnedDate()){
                            if (loan.getLoaner().getRefNumb().equals(this.txtStaffID.getText())) {
                                String listElement = car.getRegNo() + " rented by ";
                                listElement += loan.getLoaner().getFullName();
                                try {
                                    DayLoan dayLoan = (DayLoan)loan;
                                    listElement += data.UtilityFunctions.formatDate(dayLoan.getRentalDate());
                                } catch (Exception e) {}
                                try {
                                    LongLoan longLoan = (LongLoan)loan;
                                    listElement += data.UtilityFunctions.formatDate(longLoan.getStartDate()) + " - "
                                        + data.UtilityFunctions.formatDate(longLoan.getEndDate());
                                } catch (Exception e) {}
                                listElement += " returned on " + loan.getReturnedDate();
                                listModel.addElement(listElement);
                            }
                        }
                    }
                } else {
                    for (Loan loan : admin.getLoans()) {
                        Car car = admin.getCarByReg(loan.getCar().getRegNo());
                        if (null != loan.getReturnedDate()){
                            if (car.getRegNo().toLowerCase().equals(this.txtRegNumb.getText().toLowerCase()) && 
                                    loan.getLoaner().getRefNumb().equals(this.txtStaffID.getText())) {
                                String listElement = car.getRegNo() + " rented by ";
                                    listElement += loan.getLoaner().getFullName();
                                    try {
                                        DayLoan dayLoan = (DayLoan)loan;
                                        listElement += data.UtilityFunctions.formatDate(dayLoan.getRentalDate());
                                    } catch (Exception e) {}
                                    try {
                                        LongLoan longLoan = (LongLoan)loan;
                                        listElement += data.UtilityFunctions.formatDate(longLoan.getStartDate()) + " - "
                                                + data.UtilityFunctions.formatDate(longLoan.getEndDate());
                                    } catch (Exception e) {}
                                    listElement += " returned on " + loan.getReturnedDate();
                                    listModel.addElement(listElement);
                            }
                        }
                    }
                }
                lstRentalList.setModel(listModel);
            }
    }
    private Loan getLoan(String str) {
        String[] strArray = str.split(" ");
        Car car = admin.getCarByReg(strArray[0]);
        Loan temp = null;

        for (Loan loan : admin.getLoans()) {
            if (loan.getCar().getRegNo().equals(car.getRegNo())) { 
                temp = loan;
            }
        }
        return temp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstRentalList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtRegNumb = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnFilter = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtStaffID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        rbtnPast = new javax.swing.JRadioButton();
        rbtnCurrent = new javax.swing.JRadioButton();
        btnViewRental = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setViewportView(lstRentalList);

        jLabel1.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Loans");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtRegNumb.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        btnFilter.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        jLabel4.setText("Reg Number:");

        jLabel5.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        jLabel5.setText("Staff ID:");

        txtStaffID.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel2.setText("Please use one or both of the boxes below to find active loans.");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        buttonGroup.add(rbtnPast);
        rbtnPast.setText("Past Loans");
        rbtnPast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPastActionPerformed(evt);
            }
        });

        buttonGroup.add(rbtnCurrent);
        rbtnCurrent.setSelected(true);
        rbtnCurrent.setText("Active Loans");
        rbtnCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCurrentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtRegNumb, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbtnCurrent))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnFilter)
                                            .addComponent(txtStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbtnPast))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRegNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(rbtnCurrent))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnPast))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFilter)
                            .addComponent(btnCancel)))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnViewRental.setText("View Rental");
        btnViewRental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRentalActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnViewRental)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnViewRental)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnViewRentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRentalActionPerformed

        Loan loan = getLoan(this.lstRentalList.getSelectedValue());
        try {
            DayLoan dayLoan = (DayLoan)loan;
            FormViewLoan frm = new FormViewLoan(admin, dayLoan);
            frm.setVisible(true);
        } catch (Exception e) {}
        try {
            LongLoan longLoan = (LongLoan)loan;
            FormViewLoan frm = new FormViewLoan(admin, longLoan);
            frm.setVisible(true);
        } catch (Exception e) {}
             
        dispose();
    }//GEN-LAST:event_btnViewRentalActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        if (this.rbtnCurrent.isSelected()){
            filterActiveLoans();
        } else {
            filterPastLoans();
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void rbtnCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCurrentActionPerformed
        populateActiveLoans();
    }//GEN-LAST:event_rbtnCurrentActionPerformed

    private void rbtnPastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPastActionPerformed
        populatePastLoans();
    }//GEN-LAST:event_rbtnPastActionPerformed

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
            java.util.logging.Logger.getLogger(FormManageLoans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormManageLoans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormManageLoans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormManageLoans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormManageLoans().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnViewRental;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstRentalList;
    private javax.swing.JRadioButton rbtnCurrent;
    private javax.swing.JRadioButton rbtnPast;
    private javax.swing.JTextField txtRegNumb;
    private javax.swing.JTextField txtStaffID;
    // End of variables declaration//GEN-END:variables
}
