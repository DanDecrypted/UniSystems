/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package unisystems.gui;

/**
 *
 * @author Craig
 */
public class CheckInForm extends javax.swing.JFrame {

    /**
     * Creates new form CheckInForm
     */
    public CheckInForm() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        lblRegTitle = new javax.swing.JLabel();
        lblMileageTitle = new javax.swing.JLabel();
        lblFuelLevelTitle = new javax.swing.JLabel();
        cmbFuelLevel = new javax.swing.JComboBox<>();
        txtMileage = new javax.swing.JTextField();
        txtRegNumb = new javax.swing.JTextField();
        lblNotesTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextPane();
        lblStaffIdTitle = new javax.swing.JLabel();
        lblForenameTitle = new javax.swing.JLabel();
        lblSurnameTitle = new javax.swing.JLabel();
        lblFacultyTitle = new javax.swing.JLabel();
        txtStaffId = new javax.swing.JTextField();
        txtForename = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtFaculty = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Car Check In");

        lblRegTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblRegTitle.setText("Reg Number:");

        lblMileageTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblMileageTitle.setText("Mileage:");

        lblFuelLevelTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblFuelLevelTitle.setText("Fuel Level:");

        cmbFuelLevel.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        cmbFuelLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtMileage.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        txtRegNumb.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        lblNotesTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblNotesTitle.setText("Notes:");

        txtNotes.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        jScrollPane1.setViewportView(txtNotes);

        lblStaffIdTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblStaffIdTitle.setText("Staff ID:");

        lblForenameTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblForenameTitle.setText("Forename:");

        lblSurnameTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblSurnameTitle.setText("Surname:");

        lblFacultyTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblFacultyTitle.setText("Faculty:");

        txtStaffId.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        txtForename.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        txtSurname.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        txtFaculty.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFuelLevelTitle)
                            .addComponent(lblMileageTitle)
                            .addComponent(lblRegTitle)
                            .addComponent(lblNotesTitle))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMileage)
                            .addComponent(txtRegNumb)
                            .addComponent(cmbFuelLevel, 0, 150, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStaffIdTitle)
                            .addComponent(lblForenameTitle)
                            .addComponent(lblSurnameTitle)
                            .addComponent(lblFacultyTitle))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtForename, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegTitle)
                    .addComponent(txtRegNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStaffIdTitle)
                    .addComponent(txtStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMileageTitle)
                    .addComponent(txtMileage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblForenameTitle)
                    .addComponent(txtForename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuelLevelTitle)
                    .addComponent(cmbFuelLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSurnameTitle)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNotesTitle)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFacultyTitle)
                        .addComponent(txtFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(CheckInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckInForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbFuelLevel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFacultyTitle;
    private javax.swing.JLabel lblForenameTitle;
    private javax.swing.JLabel lblFuelLevelTitle;
    private javax.swing.JLabel lblMileageTitle;
    private javax.swing.JLabel lblNotesTitle;
    private javax.swing.JLabel lblRegTitle;
    private javax.swing.JLabel lblStaffIdTitle;
    private javax.swing.JLabel lblSurnameTitle;
    private javax.swing.JTextField txtFaculty;
    private javax.swing.JTextField txtForename;
    private javax.swing.JTextField txtMileage;
    private javax.swing.JTextPane txtNotes;
    private javax.swing.JTextField txtRegNumb;
    private javax.swing.JTextField txtStaffId;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables
}
