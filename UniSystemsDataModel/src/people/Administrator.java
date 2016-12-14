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
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Administrator extends Staff implements java.io.Serializable {
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
    
    public Administrator(String staffRefNumb, Position position, Faculty faculty, 
                 String officeRoom, String workNumb, Address address, 
                 String title, String forename, String surname, 
                 Date dateOfBirth, String gender, String phoneNumber, 
                 String emailAddress, String password) {
        super(staffRefNumb, position, faculty, officeRoom, workNumb, address, 
                title, forename, surname, dateOfBirth, gender, phoneNumber, 
                emailAddress);
        this.position = Position.TRANSPORT_OFFICE_ADMIN;
        this.password = password;
    }
    
    public void initialiseData() {
        System.out.println(cars.loadFromDisk());
        System.out.println(loans.loadFromDisk());
        System.out.println(admins.loadFromDisk());
        System.out.println(staffMembers.loadFromDisk());
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword() {
        this.password = password;
        this.notifyObservers();
    }
    
    public void createCar(Car car) {
        if (cars == null) cars = Cars.getInstance();
        if (carsObserver == null) carsObserver = new CarsObserver();
        car.registerObserver(carsObserver);
        cars.registerObserver(carsObserver);
        cars.addCar(car);
    }
    
    public ArrayList<Loan> getLoansForRef(String refNumb) {
        ArrayList<Loan> temp = new ArrayList<Loan>();
        for (Loan loan : loans.getLoans()) {
            if (loan.getLoaner().getRefNumb().equals(refNumb)) {
                temp.add(loan);
            }
        }
        return temp;
    }
    
    public ArrayList<DayLoan> getDayLoansForRef(String refNumb) {
        return UtilityFunctions.getDayLoans(getLoansForRef(refNumb));
    }
    
    public ArrayList<LongLoan> getLongLoansForRef(String refNumb) {
        return UtilityFunctions.getLongLoans(getLoansForRef(refNumb));
    }
    
    public Staff getStaffForRefNumb(String refNumb) {
        if (staffMembers == null) staffMembers = StaffMembers.getInstance();
        for (Staff staff : staffMembers.getStaffMembers()) {
            if (staff.getRefNumb().equals(refNumb)) {
                return staff;
            }
        }
        return null;
    }
    
    public ArrayList<Loan> getLoansForCar(String carReg){
        ArrayList<Loan> temp = new ArrayList<Loan>();
        for (Loan loan : loans.getLoans()){
            if (loan.getCar().getRegNo().equals(carReg)){
                temp.add(loan);
            }
        }
        return temp;
    }
    
    
    public void createStaffMember(Staff staff) {
        if (staffObserver == null) staffObserver = new StaffObserver();
        if (staffMembers == null) staffMembers = StaffMembers.getInstance();
        staff.registerObserver(staffObserver);
        staffMembers.registerObserver(staffObserver);
        staffMembers.addStaff(staff);
    }
    
    public void createAdministrator(Administrator admin) {
        if (adminsObserver == null) adminsObserver = new AdministratorsObserver();
        if (admins == null) admins = Administrators.getInstance();
        admin.registerObserver(adminsObserver);
        admins.registerObserver(adminsObserver);
        admins.addAdministrator(admin);
    }
    
    public void removeAdministrator(Administrator admin) {
        if (admins == null) return;
        if (admins.getAdministrators().contains(admin)) {
            if (adminsObserver != null) {
                admin.removeObserver(adminsObserver);
                admins.removeObserver(adminsObserver);
            }
            admins.removeAdministrator(admin);
        }
    }
    
    public void removeStaffMember(Staff staff) {
        if (staffMembers.getStaffMembers().contains(staff)) {
            staff.removeObserver(staffObserver);
            staffMembers.removeObserver(staffObserver);
            staffMembers.removeStaff(staff);
        }
    }
    
    public void assignLongLoan(Car car, Staff staff) {
        if (loans == null) loans = Loans.getInstance();
        if (loanObserver == null) loanObserver = new LoansObserver(); 
        Date returnDate = new Date();
        returnDate.setYear(returnDate.getYear() + 1);
        LongLoan loan = new LongLoan(staff, car, new Date(), returnDate);
        loan.registerObserver(loanObserver);
        loans.registerObserver(loanObserver);
        loans.addLoan(loan);
    }
    
    public void assignDayLoan(Car car, Staff staff) {
        if (loans == null) loans = Loans.getInstance();
        if (loanObserver == null) loanObserver = new LoansObserver();
        Date returnDate = new Date();
        returnDate.setHours(23);
        returnDate.setMinutes(59);
        DayLoan loan = new DayLoan(staff, car, returnDate);
        loan.registerObserver(loanObserver);
        loans.registerObserver(loanObserver);
        loans.addLoan(loan);
    }
    
    public void sendForService(Car car){
        car.setStatus(Status.IN_FOR_SERVICE);
    }
}
