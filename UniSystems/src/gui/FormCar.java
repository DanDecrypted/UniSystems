/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package gui;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import car.*;
import command.interfaces.ICommand;
import command.interfaces.ICommandBehaviour;
import commands.car.AddCarCommand;
import commands.car.DeleteCarCommand;
import commandtracker.Command;
import commandtracker.CommandTracker;
import loaning.*;
import javax.swing.DefaultListModel;
import people.Administrator;

/**
 *
 * @author Craig
 */
public class FormCar extends javax.swing.JFrame {

    private Administrator admin;
    private Car car;
    private DefaultListModel serviceListModel;
    private DefaultListModel loanListModel;
    private CommandTracker commandTracker = new CommandTracker();

    /**
     * Creates new form FormCar
     */
    public FormCar() {
        initComponents();

        this.getContentPane().setBackground(new Color (238,238,238));
        this.btnUpdate.setVisible(false);


    }

    public FormCar(Administrator admin){
        initComponents();

        this.getContentPane().setBackground(new Color (238,238,238));
        this.btnUpdate.setVisible(false);
        this.scrlLoanHistory.setVisible(false);
        this.lblLoanHistory.setVisible(false);
        this.scrlServiceHistory.setVisible(false);
        this.lblServiceHistory.setVisible(false);
        this.lblStatus.setVisible(false);
        this.lblStatusTitle.setVisible(false);
        this.btnService.setVisible(false);
        this.cboStatus.setVisible(false);
        this.btnEdit.setVisible(false);
        this.cboStatus.setVisible(false);
        this.btnViewService.setVisible(false);
        enableTextBoxes();
        hideHoldLabels();
        this.setSize(this.getSize().width,
                jSeparator2.getLocation().y + jSeparator2.getSize().height
                        + btnCreate.getSize().height);
        this.admin = admin;
    }

    /**
     * This constructor will auto-populate the fields given that the
     * List of cars contains a car with the regNo that you pass as a param.
     * @param regNo
     */
    public FormCar(String regNo, Administrator admin) {

        initComponents();

        serviceListModel = new DefaultListModel();
        loanListModel = new DefaultListModel();



        this.getContentPane().setBackground(new Color (238,238,238));
        this.btnCreate.setVisible(false);
        Car car = admin.getCarByReg(regNo);
        this.admin = admin;
        this.car = car;
        if (car != null) {
            this.txtRegNo.setText(regNo);
            this.txtMake.setText(car.getMake());
            this.txtModel.setText(car.getModel());
            this.cboClassification.setVisible(false);
            this.txtMileage.setText(Integer.toString(car.getMilage()));
            this.cboFuelType.setVisible(false);
            this.cboTransmission.setVisible(false);
            this.txtDoors.setText(Integer.toString(car.getDoors()));
            this.txtSeats.setText(Integer.toString(car.getSeats()));
            this.cboLocation.setVisible(false);
            this.txtSpace.setText(car.getParkingSpace());
            this.lblStatus.setText(data.UtilityFunctions.formatEnum(car.getStatus().toString()));
            this.lblClassHold.setText(data.UtilityFunctions.formatEnum(car.getClassification().toString()));
            this.lblFuelHold.setText(data.UtilityFunctions.formatEnum(car.getFuelType().toString()));
            this.lblTransmissionHold.setText(data.UtilityFunctions.formatEnum(car.getTransmission().toString()));
            this.lblLocationHold.setText(data.UtilityFunctions.formatEnum(car.getLocation().toString()));
            this.lblLoanTypeHold.setText(data.UtilityFunctions.formatEnum(car.getLoanType().toString()));
            this.cboLoanType.setVisible(false);
            this.cboStatus.setVisible(false);
            this.btnUpdate.setVisible(false);
            populateServiceHistoryList(car);
            populateLoanHistory(car);
        }
    }
    /**
     * populate car service history list
     * @param reg car registration number
     */
    private void populateServiceHistoryList(Car objCar) {
        serviceListModel.clear();

        for (int i=0; i < objCar.getServiceRecord().size(); i++){
            String listElement = objCar.getServiceRecord().get(i).getMechanic() + " - ";
            listElement += objCar.getServiceRecord().get(i).getSummary() + " - ";
            listElement += data.UtilityFunctions.formatDate(
            objCar.getServiceRecord().get(i).getDateOfService()) + " ";
            serviceListModel.addElement(listElement);
        }

        this.lstServiceHistory.setModel(serviceListModel);

    }

    private void populateLoanHistory(Car objCar){
        loanListModel.clear();

        for (Loan loan : admin.getLoansForCar(objCar)) {
            String listElement = loan.getLoaner().getFullName() + " - ";
            try {
                DayLoan dayLoan = (DayLoan)loan;
                listElement += data.UtilityFunctions.formatDate(dayLoan.getRentalDate());
            } catch (Exception e) {}
            try {
                LongLoan longLoan = (LongLoan)loan;
                listElement += data.UtilityFunctions.formatDate(longLoan.getStartDate()) + " - ";
                if (longLoan.getReturnedDate() == null) {
                    listElement += data.UtilityFunctions.formatDate(longLoan.getEndDate());
                } else {
                    listElement += data.UtilityFunctions.formatDate(longLoan.getReturnedDate());
                }

            } catch (Exception e) {}

            loanListModel.addElement(listElement);
        }

        for (LongLoan longLoan : admin.getLongLoansForRef(objCar.getRegNo())) {
            String listElement = longLoan.getLoaner().getFullName() + " - ";
            listElement += data.UtilityFunctions.formatDate(longLoan.getStartDate())+" - "+
                           data.UtilityFunctions.formatDate(longLoan.getEndDate());
            loanListModel.addElement(listElement);
        }

        this.lstLoanHistory.setModel(loanListModel);
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
        lblTitle = new javax.swing.JLabel();
        lblRegTitle = new javax.swing.JLabel();
        lblTransmissionTitle = new javax.swing.JLabel();
        lblMileageTitle = new javax.swing.JLabel();
        lblFuelTitle = new javax.swing.JLabel();
        lblClassTitle = new javax.swing.JLabel();
        lblLocationTitle = new javax.swing.JLabel();
        lblSeatsTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblStatusTitle = new javax.swing.JLabel();
        scrlLoanHistory = new javax.swing.JScrollPane();
        lstLoanHistory = new javax.swing.JList<>();
        lblLoanHistory = new javax.swing.JLabel();
        scrlServiceHistory = new javax.swing.JScrollPane();
        lstServiceHistory = new javax.swing.JList<>();
        lblServiceHistory = new javax.swing.JLabel();
        txtRegNo = new javax.swing.JTextField();
        txtMileage = new javax.swing.JTextField();
        txtDoors = new javax.swing.JTextField();
        txtSeats = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        cboTransmission = new javax.swing.JComboBox<>();
        cboFuelType = new javax.swing.JComboBox<>();
        lblDoorsTitle = new javax.swing.JLabel();
        cboClassification = new javax.swing.JComboBox<>();
        btnCancel = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblLoanType = new javax.swing.JLabel();
        cboLoanType = new javax.swing.JComboBox<>();
        cboLocation = new javax.swing.JComboBox<>();
        lblSpace = new javax.swing.JLabel();
        txtSpace = new javax.swing.JTextField();
        lblMake = new javax.swing.JLabel();
        txtMake = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        lblModel = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        btnViewService = new javax.swing.JButton();
        btnService = new javax.swing.JButton();
        lblLoanTypeHold = new javax.swing.JLabel();
        lblLocationHold = new javax.swing.JLabel();
        lblClassHold = new javax.swing.JLabel();
        lblTransmissionHold = new javax.swing.JLabel();
        lblFuelHold = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        lblUpdate = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        mnuUndo = new javax.swing.JMenuItem();
        mnuRedo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(450, 300));

        lblTitle.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Car Details");
        lblTitle.setToolTipText("");

        lblRegTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblRegTitle.setText("Registration No:");

        lblTransmissionTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblTransmissionTitle.setText("Transmission:");

        lblMileageTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblMileageTitle.setText("Mileage:");

        lblFuelTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblFuelTitle.setText("Fuel Type:");

        lblClassTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblClassTitle.setText("Class:");

        lblLocationTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblLocationTitle.setText("Location:");

        lblSeatsTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblSeatsTitle.setText("Seats:");

        lblStatusTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblStatusTitle.setText("Status:");

        lstLoanHistory.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        scrlLoanHistory.setViewportView(lstLoanHistory);

        lblLoanHistory.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        lblLoanHistory.setText("Loan History");

        lstServiceHistory.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        scrlServiceHistory.setViewportView(lstServiceHistory);

        lblServiceHistory.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        lblServiceHistory.setText("Service History");

        txtRegNo.setEditable(false);
        txtRegNo.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        txtMileage.setEditable(false);
        txtMileage.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        txtDoors.setEditable(false);
        txtDoors.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        txtSeats.setEditable(false);
        txtSeats.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        lblStatus.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        lblStatus.setText("A");

        cboTransmission.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        cboTransmission.setModel(new DefaultComboBoxModel(Transmission.values()));

        cboFuelType.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        cboFuelType.setModel(new DefaultComboBoxModel(FuelType.values()));

        lblDoorsTitle.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblDoorsTitle.setText("Doors:");

        cboClassification.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        cboClassification.setModel(new DefaultComboBoxModel(Classification.values()));

        btnCancel.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setAlignmentX(0.5F);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnCreate.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnCreate.setText("Create");
        btnCreate.setAlignmentX(0.5F);
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setAlignmentX(0.5F);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblLoanType.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblLoanType.setText("Loan Type:");

        cboLoanType.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        cboLoanType.setModel(new DefaultComboBoxModel(LoanType.values()));

        cboLocation.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        cboLocation.setModel(new DefaultComboBoxModel(Location.values()));

        lblSpace.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblSpace.setText("Space:");

        txtSpace.setEditable(false);
        txtSpace.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        lblMake.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblMake.setText("Make:");

        txtMake.setEditable(false);
        txtMake.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        txtModel.setEditable(false);
        txtModel.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N

        lblModel.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblModel.setText("Model:");

        cboStatus.setModel(new DefaultComboBoxModel(Status.values()));

        btnViewService.setText("View Service");
        btnViewService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewServiceActionPerformed(evt);
            }
        });

        btnService.setText("Add Service");
        btnService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiceActionPerformed(evt);
            }
        });

        lblLoanTypeHold.setText("A");

        lblLocationHold.setText("A");

        lblClassHold.setText("A");

        lblTransmissionHold.setText("A");

        lblFuelHold.setText("A");

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        lblUpdate.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblUpdate.setForeground(new java.awt.Color(255, 0, 0));
        lblUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnViewService))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrlServiceHistory, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrlLoanHistory, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblServiceHistory)
                                    .addComponent(lblLoanHistory))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRegTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSeatsTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDoorsTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDoors, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblSpace)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSpace, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMake)
                                .addGap(18, 69, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMake, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(txtRegNo, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblModel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLoanType)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTransmissionTitle)
                                    .addComponent(lblClassTitle)
                                    .addComponent(lblLocationTitle)
                                    .addComponent(lblFuelTitle)
                                    .addComponent(lblMileageTitle))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMileage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFuelHold)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboFuelType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblClassHold)
                                            .addComponent(lblTransmissionHold)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblLoanTypeHold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblLocationHold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboClassification, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboTransmission, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatusTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus)
                .addGap(6, 6, 6)
                .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(btnCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnService)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegTitle)
                    .addComponent(txtRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMileageTitle)
                    .addComponent(txtMileage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoanType)
                    .addComponent(txtMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMake)
                    .addComponent(lblLoanTypeHold)
                    .addComponent(cboLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModel)
                    .addComponent(lblLocationTitle)
                    .addComponent(cboLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLocationHold))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSpace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSpace)
                    .addComponent(lblClassTitle)
                    .addComponent(cboClassification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClassHold))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDoors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDoorsTitle)
                    .addComponent(lblTransmissionTitle)
                    .addComponent(cboTransmission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTransmissionHold))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSeatsTitle)
                    .addComponent(lblFuelTitle)
                    .addComponent(cboFuelType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFuelHold))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(lblStatusTitle)
                    .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdate)
                    .addComponent(btnService)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(scrlLoanHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblLoanHistory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblServiceHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrlServiceHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewService)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        Car newCar = new Car(txtRegNo.getText(),txtMake.getText(), txtModel.getText(), (Transmission)cboTransmission.getSelectedItem()
            , (FuelType)cboFuelType.getSelectedItem(), (Location)cboLocation.getSelectedItem(), txtSpace.getText(),
            (Classification)cboClassification.getSelectedItem(),
            Integer.parseInt(txtSeats.getText()),Integer.parseInt(txtDoors.getText()),
            Integer.parseInt(txtMileage.getText()), (LoanType)cboLoanType.getSelectedItem() );
        
        ICommandBehaviour objCreate = new AddCarCommand(this.admin, newCar);
        ICommand command = new Command(objCreate);
        this.commandTracker.executeCommand(command);
        this.lblUpdate.setText("The user has been Created");
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Car car = admin.getCarByReg(this.txtRegNo.getText());
        car.setMake(this.txtMake.getText());
        car.setModel(this.txtModel.getText());
        car.setLoanType((LoanType)cboLoanType.getSelectedItem());
        car.setParkingSpace(this.txtSpace.getText());
        car.setStatus((Status)cboStatus.getSelectedItem());
        this.lblUpdate.setText("Details have been updated");


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiceActionPerformed
        FormAddService frm = new FormAddService(admin, car);
        frm.setVisible(true);
    }//GEN-LAST:event_btnServiceActionPerformed

    private void btnViewServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewServiceActionPerformed

        for (int i = 0; i <= car.getServiceRecord().size(); i++) {
                Service service = car.getServiceRecord().get(i);
                FormViewService frm = new FormViewService(admin, service);
                frm.setVisible(true);
        }

    }//GEN-LAST:event_btnViewServiceActionPerformed

    private void mnuRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRedoActionPerformed
        commandTracker.redoLastCommand();
    }//GEN-LAST:event_mnuRedoActionPerformed

    private void mnuUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUndoActionPerformed
        commandTracker.undoLastCommand();
    }//GEN-LAST:event_mnuUndoActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        this.lblStatus.setVisible(false);
        this.cboClassification.setVisible(true);
        this.cboFuelType.setVisible(true);
        this.cboLoanType.setVisible(true);
        this.cboLocation.setVisible(true);
        this.cboTransmission.setVisible(true);
        this.cboStatus.setVisible(true);
        this.btnUpdate.setVisible(true);
        this.btnEdit.setVisible(false);
        enableTextBoxes();
        hideHoldLabels();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Car car = admin.getCarByReg(this.txtRegNo.getText());
        
        ICommandBehaviour objRemove = new DeleteCarCommand(admin, car);
        ICommand command = new Command(objRemove);
        commandTracker.executeCommand(command);
        
        this.lblUpdate.setText("Car has been deleted");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void enableTextBoxes(){
        this.txtDoors.setEditable(true);
        this.txtMake.setEditable(true);
        this.txtMileage.setEditable(true);
        this.txtModel.setEditable(true);
        this.txtRegNo.setEditable(true);
        this.txtSeats.setEditable(true);
        this.txtSpace.setEditable(true);
    }
    
    private void hideHoldLabels(){
        this.lblLoanTypeHold.setVisible(false);
        this.lblLocationHold.setVisible(false);
        this.lblClassHold.setVisible(false);
        this.lblTransmissionHold.setVisible(false);
        this.lblFuelHold.setVisible(false);
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
            java.util.logging.Logger.getLogger(FormCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCar().setVisible(true);
            }
        });


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnService;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnViewService;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboClassification;
    private javax.swing.JComboBox<String> cboFuelType;
    private javax.swing.JComboBox<String> cboLoanType;
    private javax.swing.JComboBox<String> cboLocation;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JComboBox<String> cboTransmission;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblClassHold;
    private javax.swing.JLabel lblClassTitle;
    private javax.swing.JLabel lblDoorsTitle;
    private javax.swing.JLabel lblFuelHold;
    private javax.swing.JLabel lblFuelTitle;
    private javax.swing.JLabel lblLoanHistory;
    private javax.swing.JLabel lblLoanType;
    private javax.swing.JLabel lblLoanTypeHold;
    private javax.swing.JLabel lblLocationHold;
    private javax.swing.JLabel lblLocationTitle;
    private javax.swing.JLabel lblMake;
    private javax.swing.JLabel lblMileageTitle;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblRegTitle;
    private javax.swing.JLabel lblSeatsTitle;
    private javax.swing.JLabel lblServiceHistory;
    private javax.swing.JLabel lblSpace;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatusTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTransmissionHold;
    private javax.swing.JLabel lblTransmissionTitle;
    private javax.swing.JLabel lblUpdate;
    private javax.swing.JList<String> lstLoanHistory;
    private javax.swing.JList<String> lstServiceHistory;
    private javax.swing.JMenuItem mnuRedo;
    private javax.swing.JMenuItem mnuUndo;
    private javax.swing.JScrollPane scrlLoanHistory;
    private javax.swing.JScrollPane scrlServiceHistory;
    private javax.swing.JTextField txtDoors;
    private javax.swing.JTextField txtMake;
    private javax.swing.JTextField txtMileage;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtRegNo;
    private javax.swing.JTextField txtSeats;
    private javax.swing.JTextField txtSpace;
    // End of variables declaration//GEN-END:variables
}
