/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package people;

import loaning.DayLoan;
import loaning.LongLoan;
import car.Car;
import car.LoanType;
import car.Service;
import car.Status;
import data.Loans;
import data.StaffMembers;
import data.Cars;
import java.util.Date;
import data.LoansObserver;
import data.CarsObserver;
import data.StaffObserver;
import data.AdministratorsObserver;
import data.Administrators;
import data.UtilityFunctions;
import java.util.ArrayList;
import loaning.Loan;

/**
 * The administrator class should be used as a factory for the other objects
 * which are contained within the system
 * @author Craig Banyard, Daniel Scott, Najim Mazidi
 */
public class Administrator extends Staff implements java.io.Serializable {
    // the following private properties are transient as we don't want them to 
    // be serialised to the disk.
    transient Loans loans = Loans.getInstance();
    transient StaffMembers staffMembers = StaffMembers.getInstance();
    transient Cars cars = Cars.getInstance();
    transient Administrators admins = Administrators.getInstance();
    transient LoansObserver loanObserver = new LoansObserver();
    transient StaffObserver staffObserver = new StaffObserver();
    transient CarsObserver carsObserver = new CarsObserver();
    transient AdministratorsObserver adminsObserver = new AdministratorsObserver();
    
    private String password;
    
    public Administrator() {
        this.position = Position.TRANSPORT_OFFICE_ADMIN;
    }
    
    /**
     * Constructor for the administrators object
     * @param staffRefNumb the reference of the staff member String
     * @param position the position of the staff member. Enum.
     * @param faculty the faculty of the staff member. Enum.
     * @param officeRoom the office location of the staff member. String.
     * @param workNumb the work number of the staff member. String.
     * @param address the address of the staff member. Address.
     * @param title the title of the staff member. String.
     * @param forename the staff members forename. String.
     * @param surname the staff members surname. String.
     * @param dateOfBirth the date of birth of the staff member. Date.
     * @param gender the gender of the staff member. String.
     * @param phoneNumber the private phone number of the staff member. String.
     * @param emailAddress the email address of the staff member. String.
     * @param password the password of the staff member. String.
     */
    public Administrator(String staffRefNumb, Position position, Faculty faculty, 
                 String officeRoom, String workNumb, Address address, 
                 String title, String forename, String surname, 
                 Date dateOfBirth, String gender, String phoneNumber, 
                 String emailAddress, String password) {
        super(staffRefNumb, Position.TRANSPORT_OFFICE_ADMIN, faculty, officeRoom, workNumb, address, 
                title, forename, surname, dateOfBirth, gender, phoneNumber, 
                emailAddress);
        this.password = password;
    }
    
    /**
     * This method is used to load all the data from disk into the memory of 
     * the application.
     */
    public void initialiseData() {
        cars = Cars.getInstance();
        loans = Loans.getInstance();
        admins = Administrators.getInstance();
        staffMembers = StaffMembers.getInstance();
        System.out.println(cars.loadFromDisk());
        System.out.println(loans.loadFromDisk());
        System.out.println(admins.loadFromDisk());
        System.out.println(staffMembers.loadFromDisk());
    }
    
    /**
     * Gets the password of the administrator
     * @return String. Unencrypted.
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Sets the password of the administrator, notifies all observers. 
     * @param password The new password of the admin
     */
    public void setPassword(String password) {
        this.password = password;
        this.notifyObservers();
    }
    
    /**
     * Adds a newly created car object to the list and assigns observers. Cars
     * are then saved to disk.
     * @param car car to be created
     */
    public void createCar(Car car) {
        if (cars == null) cars = Cars.getInstance();
        if (carsObserver == null) carsObserver = new CarsObserver();
        for (Car localCar : cars.getCars()) {
            if (localCar.getRegNo().equals(car.getRegNo())) {
                return;
            }
        }
        car.registerObserver(carsObserver);
        cars.registerObserver(carsObserver);
        cars.addCar(car);
    }
    
    /**
     * Gets all the loan details for a specific staff member which we obtain via 
     * their staff reference number
     * @param refNumb reference of the staff member
     * @return an array of loan objects relating to the staff member
     */
    public ArrayList<Loan> getLoansForRef(String refNumb) {
        ArrayList<Loan> temp = new ArrayList<Loan>();
        for (Loan loan : loans.getLoans()) {
            if (loan.getLoaner().getRefNumb().equals(refNumb)) {
                temp.add(loan);
            }
        }
        return temp;
    }
        
    /**
     * Gets the day loans relating to the staff member
     * @param refNumb reference of the staff member.
     * @return an array of day loans.
     */
    public ArrayList<DayLoan> getDayLoansForRef(String refNumb) {
        return UtilityFunctions.getDayLoans(getLoansForRef(refNumb));
    }
    
    /**
     * Gets the long loans relating to the staff member
     * @param refNumb reference of the staff member.
     * @return an array of long loans.
     */
    public ArrayList<LongLoan> getLongLoansForRef(String refNumb) {
        return UtilityFunctions.getLongLoans(getLoansForRef(refNumb));
    }
    
    /**
     * Gets a staff object which has a particular reference number.
     * @param refNumb reference of the staff member.
     * @return Staff object.
     */
    public Staff getStaffForRefNumb(String refNumb) {
        if (staffMembers == null) staffMembers = StaffMembers.getInstance();
        for (Staff staff : staffMembers.getStaffMembers()) {
            if (staff.getRefNumb().equals(refNumb)) {
                return staff;
            }
        }
        return null;
    }
    
    /**
     * Gets a car for a particular registration plate
     * @param carReg car registration.
     * @return Car object.
     */
    public Car getCarByReg(String carReg) {
        if (cars == null) cars = Cars.getInstance();
        cars.loadFromDisk();
        for (Car car : cars.getCars()) {
            if (car.getRegNo().equals(carReg)) { 
                return car;
            }
        }
        return null;
    }
    
    /**
     * Gets all loans (Previous and Current) for a car.
     * @param car car object.
     * @return an array of loans.
     */
    public ArrayList<Loan> getLoansForCar(Car car){
        ArrayList<Loan> temp = new ArrayList<Loan>();
        for (Loan loan : loans.getLoans()){
            if (loan.getCar().getRegNo().equals(car.getRegNo())){
                temp.add(loan);
            }
        }
        return temp;
    }
    
    /**
     * Gets all unfiltered loans. 
     * @return an array of loans.
     */
    public ArrayList<Loan> getLoans(){
        ArrayList<Loan> temp = new ArrayList<Loan>();
        for (Loan loan : loans.getLoans()){
            temp.add(loan);
        }
        return temp;
    }
    
    /**
     * Adds a staff member to the list of staff members and registers observers
     * @param staff staff object
     */
    public void createStaffMember(Staff staff) {
        if (staffObserver == null) staffObserver = new StaffObserver();
        if (staffMembers == null) staffMembers = StaffMembers.getInstance();
        for (Staff localStaff : staffMembers.getStaffMembers()) {
            if (staff.getRefNumb().equals(localStaff.getRefNumb())) {
                return;
            }
        }
        staff.registerObserver(staffObserver);
        staffMembers.registerObserver(staffObserver);
        staffMembers.addStaff(staff);
    }
    
    /**
     * Adds an administrator to the list of administrators and registers observers
     * @param admin admin object
     */
    public void createAdministrator(Administrator admin) {
        if (adminsObserver == null) adminsObserver = new AdministratorsObserver();
        if (admins == null) admins = Administrators.getInstance();
        for (Administrator localAdmin : admins.getAdministrators()) {
            if (admin.getRefNumb().equals(localAdmin.getRefNumb())) {
                return;
            }
        }
        admin.registerObserver(adminsObserver);
        admins.registerObserver(adminsObserver);
        admins.addAdministrator(admin);
    }
    
    
    /**
     * gets a list of administrators known to the system.
     * @return array list of administrator
     */
    public ArrayList<Administrator> getAdminstrators() {
        ArrayList<Administrator> temp = new ArrayList<Administrator>();
        for (Administrator admin : admins.getAdministrators()) {
            temp.add(admin);
        }
        return temp;
    }
    
    /**
     * gets a list of staff members known to the system.
     * @return array list of staff
     */
    public ArrayList<Staff> getStaffMembers() {
        ArrayList<Staff> temp = new ArrayList<Staff>();
        for (Staff staff : staffMembers.getStaffMembers()) {
            temp.add(staff);
        }
        return temp;
    }
    
    /**
     * Should you ever want to / need to, you can remove an administrator from 
     * the system.
     * @param admin administrator object.
     */
    public void removeAdministrator(Administrator admin) {
        if (admins == null) return;
        if (admins.getAdministrators().contains(admin)) {
            admin.removeObservers();
            admins.removeAdministrator(admin);
        }
    }
    
    /**
     * Removes a staff member from the system.
     * @param staff staff object.
     */
    public void removeStaffMember(Staff staff) {
        if (staffMembers == null) return;
        if (staffMembers.getStaffMembers().contains(staff)) {
            staff.removeObservers();
            staffMembers.removeStaff(staff);
        }
    }
    
    /**
     * Creates a long loan object and assigns observers.
     * @param car car object to be loaned.
     * @param staff staff object to loan.
     * @return assigned loan
     */
    public LongLoan assignLongLoan(Car car, Staff staff) {
        if (car.getLoanType() == LoanType.DAY_LOAN) {
            System.out.println("This car is not available as a long loan");
            return null;
        }
        if (loans == null) loans = Loans.getInstance();
        if (loanObserver == null) loanObserver = new LoansObserver(); 
        Date returnDate = new Date();
        returnDate.setYear(returnDate.getYear() + 1);
        LongLoan loan = new LongLoan(staff, car, new Date(), returnDate);
        car.setStatus(Status.OUT_ON_LOAN);
        loan.registerObserver(loanObserver);
        loans.registerObserver(loanObserver);
        loans.addLoan(loan);
        return loan;
    }
    
    /**
     * Creates a day loan object and assigns the observers.
     * @param car car object to be loaned.
     * @param staff staff member to carry out the loan.
     * @return assigned loan
     */
    public DayLoan assignDayLoan(Car car, Staff staff) {
        if (car.getLoanType() == LoanType.LONG_TERM_LOAN) {
            System.out.println("This car is not available as a day loan");
            return null;
        }
        if (loans == null) loans = Loans.getInstance();
        if (loanObserver == null) loanObserver = new LoansObserver();
        Date returnDate = new Date();
        returnDate.setHours(23);
        returnDate.setMinutes(59);
        DayLoan loan = new DayLoan(staff, car, returnDate);
        car.setStatus(Status.OUT_ON_LOAN);
        loan.registerObserver(loanObserver);
        loans.registerObserver(loanObserver);
        loans.addLoan(loan);
        return loan;
    }
    
    /**
     * Sets a cars status to awaiting prep and sets the return date of the loan.
     * @param car car object
     * @param loan loan object
     */
    public void returnCar(Car car, Loan loan) {
        car.setStatus(Status.AWAITING_PREP);
        loan.setReturnedDate(new Date());
    }

    /**
     * Overloaded method to accept a day loan as a parameter
     * @param car car object.
     * @param dayLoan day loan object.
     **/
    public void returnCar(Car car, DayLoan dayLoan) {
        this.returnCar(car, (Loan)dayLoan);
    }
    
    /**
     * Overloaded method to accept a long loan as a parameter
     * @param car car object.
     * @param longLoan long loan object.
     */
    public void returnCar(Car car, LongLoan longLoan) {
        this.returnCar(car, (Loan)longLoan);
    }
    /**
     * Used by undoing an erroneous loan assignment. Sets car status to available
     * @param car car object
     * @param loan loan object
     */
    public void cancelLoan(Car car, Loan loan) {
        car.setStatus(Status.AVAILABLE);
        loan.setReturnedDate(new Date());
        loan.setLoanNotes("Loan cancelled, ignore.");        
    }
    
    /**
     * Makes a note about the car.
     * @param car car object
     * @param note note to add against the car
     */
    public void makeNotes(Car car, String note) {
        car.addNote(note);
    }
    
    /**
     * Makes a note about the loan.
     * @param loan loan object.
     * @param note note to add.
     */
    public void makeNotes(Loan loan, String note) {
        loan.setLoanNotes(note);
    }
    
    /**
     * Function to check whether the car has been returned in a suitable state.
     * @param car car object.
     */
    public void checkCar(Car car) {
        // TODO: Make some kind of procedure to check the status of the car
        boolean isOk = true;
        if (isOk) {
            car.setStatus(Status.AVAILABLE);
        }
    }
    
    /**
     * Sends a car in for service and changes the status of the car.
     * @param car car object.
     */
    public void sendForService(Car car){
        car.setStatus(Status.IN_FOR_SERVICE);
    }
    
    /**
     * Gets an array of all the cars known to the system.
     * @return array of car.
     */
    public ArrayList<Car> getCars() {
        return cars.getCars();
    }
    /**
     * Removes car from list if car created in error. Can be accessed through undo/redo function
     * @param car 
     */
    public void removeCar(Car car) {
    if (cars == null) return;
        if (cars.getCars().contains(car)) {
            car.removeObservers();
            cars.removeCar(car);
        }
    }
}
