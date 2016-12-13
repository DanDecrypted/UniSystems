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
import people.Administrator;

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
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword() {
        this.password = password;
        this.notifyObservers();
    }
    
    public void createCar(Car car) {
        car.registerObserver(carsObserver);
        cars.registerObserver(carsObserver);
        cars.addCar(car);
    }
    
    public void createStaffMember(Staff staff) {
        staff.registerObserver(staffObserver);
        staffMembers.registerObserver(staffObserver);
        staffMembers.addStaff(staff);
    }
    
    public void createAdministrator(Administrator admin) {
        admin.registerObserver(adminsObserver);
        admins.registerObserver(adminsObserver);
        admins.addAdministrator(admin);
    }
    
    public void removeAdministrator(Administrator admin) {
        if (admins.getAdministrators().contains(admin)) {
            admin.removeObserver(adminsObserver);
            admins.removeObserver(adminsObserver);
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
        Date returnDate = new Date();
        returnDate.setYear(returnDate.getYear() + 1);
        LongLoan loan = new LongLoan(staff, car, new Date(), returnDate);
        loan.registerObserver(loanObserver);
        loans.registerObserver(loanObserver);
        loans.addLoan(loan);
    }
    
    public void assignDayLoan(Car car, Staff staff) {
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
