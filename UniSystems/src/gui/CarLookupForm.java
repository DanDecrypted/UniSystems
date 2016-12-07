/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package gui;
import data.Cars;
import car.Car;
import java.awt.Color;
import javax.swing.JOptionPane;
/**
 *
 * @author Craig
 */
public class CarLookupForm extends javax.swing.JFrame {
    private Cars cars = Cars.getInstance();
    /**
     * Creates new form CarLookupForm
     */
    public CarLookupForm() {
        this.getContentPane().setBackground(new Color (238,238,238));

        initComponents();
        System.out.println(cars.loadFromDisk());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRegTitle = new javax.swing.JLabel();
        txtRegNumb = new javax.swing.JTextField();
        btnEdtDlt = new javax.swing.JButton();
        btnAddCar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRegTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblRegTitle.setText("Reg Number:");

        btnEdtDlt.setText("Edit/Delete");
        btnEdtDlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdtDltActionPerformed(evt);
            }
        });

        btnAddCar.setText("Add Car");
        btnAddCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Car Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblRegTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRegNumb, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdtDlt))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(btnAddCar)))
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegTitle)
                    .addComponent(txtRegNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdtDlt))
                .addGap(18, 18, 18)
                .addComponent(btnAddCar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEdtDltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdtDltActionPerformed
        // TODO add your handling code here:
        for (Car car : cars.getCars()) {
            // foreach (Car car in cars.getCars()) { } 
            if (car.getRegNo().equals(txtRegNumb.getText().toUpperCase())) {
                FormCar frm = new FormCar(car.getRegNo());
                frm.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "The Registration entered was not found.",
                        "Car Lookup Error",
                        JOptionPane.WARNING_MESSAGE);
            
            }
        }
    }//GEN-LAST:event_btnEdtDltActionPerformed

    private void btnAddCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCarActionPerformed
        FormCar frm = new FormCar();
        frm.setVisible(true);
    }//GEN-LAST:event_btnAddCarActionPerformed

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
            java.util.logging.Logger.getLogger(CarLookupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarLookupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarLookupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarLookupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarLookupForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCar;
    private javax.swing.JButton btnEdtDlt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblRegTitle;
    private javax.swing.JTextField txtRegNumb;
    // End of variables declaration//GEN-END:variables
}
