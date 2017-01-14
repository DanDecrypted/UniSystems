/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package gui;
import command.interfaces.ICommand;
import command.interfaces.ICommandBehaviour;
import command.interfaces.ICommandTracker;
import commands.AddAdminCommand;
import commands.AddStaffCommand;
import commands.DeleteStaffCommand;
import commandtracker.Command;
import commandtracker.CommandTracker;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import loaning.DayLoan;
import loaning.LongLoan;
import people.Address;
import people.Administrator;
import people.Faculty;
import people.Position;
import people.Staff;

/**
 *
 * @author Craig
 */
public class FormStaffDetails extends javax.swing.JFrame {
    //private StaffMembers staff = StaffMembers.getInstance();
    //private Loans loans = Loans.getInstance();
    private Administrator admin;
    private DefaultListModel listModel;
    private ICommandTracker commandTracker = new CommandTracker();
    /**
     * Creates new form FormStaffDetails
     */
    public FormStaffDetails() {
        this.getContentPane().setBackground(new Color (238,238,238));
        initComponents();
    }
    
    public FormStaffDetails(Administrator admin){
        this.getContentPane().setBackground(new Color (238,238,238));
        initComponents();
        this.btnUpdate.setVisible(false);
        this.lstLoanHistory.setVisible(false);
        this.lblLoanHistory.setVisible(false);
        this.jScrollPane2.setVisible(false);
        this.lblPassword.setVisible(false);
        this.txtPassword.setVisible(false);
        this.setSize(this.getSize().width,
                jSeparator2.getLocation().y + jSeparator2.getSize().height 
                        + btnCreate.getSize().height + 100);
        this.admin = admin;
    }
    
    public FormStaffDetails(Administrator admin, String staffNumb){
        this.getContentPane().setBackground(new Color (238,238,238));
        
        initComponents();
        
        listModel = new DefaultListModel();
        Staff staff = admin.getStaffForRefNumb(staffNumb);
        if (staff != null) {
            this.txtStaffNumb.setText(staffNumb);
            this.jxDOB.setDate(staff.getDateOfBirth());
            this.txtEmail.setText(staff.getEmailAddress());
            this.cboFaculty.setSelectedItem(staff.getFaculty().toString());
            this.txtForename.setText(staff.getForename());
            this.txtGender.setText(staff.getGender());
            this.txtOffice.setText(staff.getOfficeRoom());
            this.txtPhoneNumb.setText(staff.getPhoneNumber());
            this.cboPosition.setSelectedItem(staff.getPosition());
            this.txtSurname.setText(staff.getSurname());
            this.txtTitle.setText(staff.getTitle());
            this.txtWorkNumb.setText(staff.getWorkNumb());
            this.txtAddressOne.setText(staff.getAddress().getAddressLineOne());
            this.txtAddressTwo.setText(staff.getAddress().getAddressLineTwo());
            this.txtCity.setText(staff.getAddress().getAddressCity());
            this.txtCounty.setText(staff.getAddress().getAddressCounty());
            this.txtPostCode.setText(staff.getAddress().getAddressPostCode());
            for (Administrator administrator : admin.getAdminstrators()){
                if (administrator.getRefNumb().equals(staffNumb)){
                    txtPassword.setText(administrator.getPassword());
                    this.cbAdmin.setSelected(true);
                }
            }
        }
        this.admin = admin;
        populateLoanList(staffNumb);
    }
    
    private void populateLoanList(String ref) {
        listModel.clear();
        ArrayList<LongLoan> longLoans = admin.getLongLoansForRef(ref);
        ArrayList<DayLoan> dayLoans = admin.getDayLoansForRef(ref);
        for (LongLoan longLoan : longLoans) {
            String listElement = longLoan.getCar().getRegNo() + " - ";
            // TODO: Use functions in the JDK that aren't a heaping pile of shit
                //Deprecated but I'm too lazy to fix it right now 
            listElement += data.UtilityFunctions.formatDate(longLoan.getStartDate()) + " - "
                        + data.UtilityFunctions.formatDate(longLoan.getEndDate());
            listModel.addElement(listElement);
        }
        
        for (DayLoan dayLoan : dayLoans) {
            String listElement = dayLoan.getCar().getRegNo() + " - ";
            // TODO: Use functions in the JDK that aren't a heaping pile of shit
                //Deprecated but I'm too lazy to fix it right now 
            listElement += data.UtilityFunctions.formatDate(dayLoan.getRentalDate());
            listModel.addElement(listElement);
        }
        lstLoanHistory.setModel(listModel);
        this.btnCreate.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtStaffNumb = new javax.swing.JTextField();
        lblStaffNumb = new javax.swing.JLabel();
        lblMainTitle = new javax.swing.JLabel();
        lblPosition = new javax.swing.JLabel();
        lblFaculty = new javax.swing.JLabel();
        lblOffice = new javax.swing.JLabel();
        txtOffice = new javax.swing.JTextField();
        lblWorkNumb = new javax.swing.JLabel();
        txtWorkNumb = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        lblForename = new javax.swing.JLabel();
        txtForename = new javax.swing.JTextField();
        lblSurname = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        lblDob = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhoneNumb = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblGender1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblLoanHistory = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstLoanHistory = new javax.swing.JList<>();
        btnCreate = new javax.swing.JButton();
        cboFaculty = new javax.swing.JComboBox<>();
        cboPosition = new javax.swing.JComboBox<>();
        jxDOB = new org.jdesktop.swingx.JXDatePicker();
        cbAdmin = new javax.swing.JCheckBox();
        txtPassword = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtAddressOne = new javax.swing.JTextField();
        txtAddressTwo = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtCounty = new javax.swing.JTextField();
        txtPostCode = new javax.swing.JTextField();
        lblGender2 = new javax.swing.JLabel();
        lblGender3 = new javax.swing.JLabel();
        lblGender4 = new javax.swing.JLabel();
        lblGender5 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        mnuUndo = new javax.swing.JMenuItem();
        mnuRedo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(450, 250, 0, 0));
        setLocation(new java.awt.Point(450, 300));

        txtStaffNumb.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        lblStaffNumb.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblStaffNumb.setText("Staff Numb:");

        lblMainTitle.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        lblMainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMainTitle.setText("Staff Details");

        lblPosition.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblPosition.setText("Position:");

        lblFaculty.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblFaculty.setText("Faculty:");

        lblOffice.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblOffice.setText("Office Room:");

        txtOffice.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        lblWorkNumb.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblWorkNumb.setText("Work No:");

        txtWorkNumb.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        lblTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblTitle.setText("Title:");

        txtTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        lblForename.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblForename.setText("Forename:");

        txtForename.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        lblSurname.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblSurname.setText("Surname:");

        txtSurname.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        lblDob.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblDob.setText("DOB:");

        lblGender.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblGender.setText("Gender:");

        txtGender.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        lblPhone.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblPhone.setText("Phone No:");

        txtPhoneNumb.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        lblEmail.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblEmail.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        lblGender1.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblGender1.setText("Address Line 1:");

        btnUpdate.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblLoanHistory.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        lblLoanHistory.setText("Loan History:");

        lstLoanHistory.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        lstLoanHistory.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstLoanHistory);

        btnCreate.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        cboFaculty.setModel(new DefaultComboBoxModel(Faculty.values()));

        cboPosition.setModel(new DefaultComboBoxModel(Position.values()));

        cbAdmin.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        cbAdmin.setText("Admin");
        cbAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAdminActionPerformed(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblPassword.setText("Password: ");

        txtAddressOne.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        txtAddressTwo.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        txtCity.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        txtCounty.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        txtPostCode.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        lblGender2.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblGender2.setText("Address Line 2:");

        lblGender3.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblGender3.setText("City:");

        lblGender4.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblGender4.setText("County:");

        lblGender5.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblGender5.setText("Post Code:");

        btnDelete.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        mnuUndo.setText("Undo");
        mnuUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUndoActionPerformed(evt);
            }
        });
        jMenu2.add(mnuUndo);

        mnuRedo.setText("Redo");
        mnuRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRedoActionPerformed(evt);
            }
        });
        jMenu2.add(mnuRedo);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMainTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitle)
                                    .addComponent(lblForename)
                                    .addComponent(lblSurname)
                                    .addComponent(lblDob)
                                    .addComponent(lblGender)
                                    .addComponent(lblGender1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblStaffNumb))
                                .addComponent(lblGender2)
                                .addComponent(lblGender3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(lblGender4)
                            .addComponent(lblGender5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtForename, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtStaffNumb, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTitle, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSurname, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGender, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jxDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAddressTwo)
                            .addComponent(txtAddressOne)
                            .addComponent(txtCity, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCounty)
                            .addComponent(txtPostCode, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFaculty)
                                    .addComponent(lblPosition)
                                    .addComponent(lblWorkNumb)
                                    .addComponent(lblPhone)
                                    .addComponent(lblEmail)
                                    .addComponent(cbAdmin)
                                    .addComponent(lblPassword))
                                .addGap(5, 5, 5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblOffice)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtWorkNumb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOffice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboFaculty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboPosition, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtEmail)
                                        .addComponent(txtPhoneNumb, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreate)
                        .addGap(42, 42, 42)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addGap(100, 100, 100))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLoanHistory)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMainTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStaffNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStaffNumb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtForename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblForename))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSurname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDob)
                            .addComponent(jxDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGender)
                            .addComponent(lblEmail)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPosition)
                            .addComponent(cboPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFaculty)
                            .addComponent(cboFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOffice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOffice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtWorkNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWorkNumb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhoneNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddressOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGender1)
                    .addComponent(cbAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddressTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGender2)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGender3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCounty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGender4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPostCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGender5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnCancel)
                            .addComponent(btnDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoanHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        FormStaffLookup frm = new FormStaffLookup();
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
        try {
            if (cbAdmin.isSelected()){
            Administrator newAdmin = new Administrator(txtStaffNumb.getText(), (Position)cboPosition.getSelectedItem(),
                    (Faculty)cboFaculty.getSelectedItem(),txtOffice.getText(), txtWorkNumb.getText(),
                    new Address(txtAddressOne.getText(),txtAddressTwo.getText(),txtCity.getText(),txtCounty.getText(),txtPostCode.getText()),
                    txtTitle.getText(), txtForename.getText(), txtSurname.getText(), jxDOB.getDate(), txtGender.getText()
                    , txtPhoneNumb.getText(), txtEmail.getText(), txtPassword.getText()); 
            ICommandBehaviour objAdd = new AddAdminCommand(admin, newAdmin);
            ICommand objCommand = new Command(objAdd);
            this.commandTracker.executeCommand(objCommand);
            }
            else{
            Staff newStaff = new Staff(txtStaffNumb.getText(), (Position)cboPosition.getSelectedItem(), 
                (Faculty)cboFaculty.getSelectedItem(), txtOffice.getText(), txtWorkNumb.getText(), 
                new Address(txtAddressOne.getText(),txtAddressTwo.getText(),txtCity.getText(),txtCounty.getText(),txtPostCode.getText()), 
                    txtTitle.getText(), txtForename.getText(), txtSurname.getText(), jxDOB.getDate(),
                txtGender.getText(), txtPhoneNumb.getText(), txtEmail.getText() );
            System.out.println("new staff member created " + newStaff.getForename());
            if (admin == null) admin = new Administrator(); 
            ICommandBehaviour objAdd = new AddStaffCommand(admin, newStaff);
            ICommand objCommand = new Command(objAdd);
            this.commandTracker.executeCommand(objCommand);
            }
        } catch (Exception e) {
        }  //formatter.parse throws an uncaught exception if not properly used.
    }//GEN-LAST:event_btnCreateActionPerformed

    private void cbAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAdminActionPerformed
        if (this.cbAdmin.isSelected()){
            this.lblPassword.setVisible(true);
            this.txtPassword.setVisible(true);
        }
        else{
            this.lblPassword.setVisible(false);
            this.txtPassword.setVisible(false);
        }
    }//GEN-LAST:event_cbAdminActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Administrator tempAdmin = null;
        for (Administrator administrator : admin.getAdminstrators()) {
            if (administrator.getRefNumb().equals(this.txtStaffNumb.getText())) {
                tempAdmin = administrator;
            }
        }

        Address address = new Address(txtAddressOne.getText(),txtAddressTwo.getText(),txtCity.getText(),
                txtCounty.getText(),this.txtPostCode.getText());
        if (txtPassword.isVisible()) {
            tempAdmin.setAddress(address);
            tempAdmin.setDateOfBirth(jxDOB.getDate());
            tempAdmin.setEmailAddress(txtEmail.getText());
            tempAdmin.setFaculty((Faculty)cboFaculty.getSelectedItem());
            tempAdmin.setForename(txtForename.getText());
            tempAdmin.setGender(txtGender.getText());
            tempAdmin.setOfficeRoom(txtOffice.getText());
            tempAdmin.setPhoneNumber(txtPhoneNumb.getText());
            tempAdmin.setPosition((Position)cboPosition.getSelectedItem());
            tempAdmin.setSurname(txtSurname.getText());
            tempAdmin.setTitle(txtTitle.getText());
            tempAdmin.setWorkNumb(txtWorkNumb.getText());
            tempAdmin.setPassword(txtPassword.getText());
        }
        Staff staff = admin.getStaffForRefNumb(this.txtStaffNumb.getText());
        staff.setAddress(address);
        staff.setDateOfBirth(jxDOB.getDate());
        staff.setEmailAddress(txtEmail.getText());
        staff.setFaculty((Faculty)cboFaculty.getSelectedItem());
        staff.setForename(txtForename.getText());
        staff.setGender(txtGender.getText());
        staff.setOfficeRoom(txtOffice.getText());
        staff.setPhoneNumber(txtPhoneNumb.getText());
        staff.setPosition((Position)cboPosition.getSelectedItem());
        staff.setSurname(txtSurname.getText());
        staff.setTitle(txtTitle.getText());
        staff.setWorkNumb(txtWorkNumb.getText());
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

            Staff staff = admin.getStaffForRefNumb(this.txtStaffNumb.getText());
            ICommandBehaviour objDelete = new DeleteStaffCommand(admin, staff);
            ICommand objCommand = new Command(objDelete);
            this.commandTracker.executeCommand(objCommand);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void mnuUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUndoActionPerformed
        this.commandTracker.undoLastCommand();
    }//GEN-LAST:event_mnuUndoActionPerformed

    private void mnuRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRedoActionPerformed
        this.commandTracker.redoLastCommand();
    }//GEN-LAST:event_mnuRedoActionPerformed

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
            java.util.logging.Logger.getLogger(FormStaffDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormStaffDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormStaffDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormStaffDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormStaffDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox cbAdmin;
    private javax.swing.JComboBox<String> cboFaculty;
    private javax.swing.JComboBox<String> cboPosition;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private org.jdesktop.swingx.JXDatePicker jxDOB;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFaculty;
    private javax.swing.JLabel lblForename;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGender1;
    private javax.swing.JLabel lblGender2;
    private javax.swing.JLabel lblGender3;
    private javax.swing.JLabel lblGender4;
    private javax.swing.JLabel lblGender5;
    private javax.swing.JLabel lblLoanHistory;
    private javax.swing.JLabel lblMainTitle;
    private javax.swing.JLabel lblOffice;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblStaffNumb;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWorkNumb;
    private javax.swing.JList<String> lstLoanHistory;
    private javax.swing.JMenuItem mnuRedo;
    private javax.swing.JMenuItem mnuUndo;
    private javax.swing.JTextField txtAddressOne;
    private javax.swing.JTextField txtAddressTwo;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCounty;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtForename;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtOffice;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhoneNumb;
    private javax.swing.JTextField txtPostCode;
    private javax.swing.JTextField txtStaffNumb;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtWorkNumb;
    // End of variables declaration//GEN-END:variables
}
