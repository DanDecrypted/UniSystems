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

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Administrator extends Staff {
    Loans loans = Loans.getInstance();
    StaffMembers staffMembers = StaffMembers.getInstance();
    Cars cars = Cars.getInstance();
    LoansObserver loanObserver = new LoansObserver();
    StaffObserver staffObserver = new StaffObserver();
    CarsObserver carsObserver = new CarsObserver();
    
    
    public Administrator() {
        this.position = Position.TRANSPORT_OFFICE_ADMIN;
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
