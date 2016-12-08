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
import data.IObserver;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Administrator extends Staff implements IObserver{
    Loans loans = Loans.getInstance();
    StaffMembers staffMembers = StaffMembers.getInstance();
    Cars cars = Cars.getInstance();
    
    public Administrator() {
        this.position = Position.TRANSPORT_OFFICE_ADMIN;
    }
    
    public void createCar(Car car) {
        cars.registerObserver(this);
        cars.addCar(car);
    }
    
    public void createStaffMember(Staff staff) {
        staffMembers.registerObserver(this);
        staffMembers.addStaff(staff);
    }
    
    public void assignLongLoan(Car car, Staff staff) {
        Date returnDate = new Date();
        returnDate.setYear(returnDate.getYear() + 1);
        LongLoan loan = new LongLoan(staff, car, new Date(), returnDate);
        loans.registerObserver(this);
        loans.addLoan(loan);
    }
    
    public void assignDayLoan(Car car, Staff staff) {
        Date returnDate = new Date();
        returnDate.setHours(23);
        returnDate.setMinutes(59);
        DayLoan loan = new DayLoan(staff, car, returnDate);
        loans.registerObserver(this);
        loans.addLoan(loan);
    }
    
    public void sendForService(Car car){
        car.setStatus(Status.IN_FOR_SERVICE);
        
    }
    
    @Override 
    public void update() {
        System.out.println(loans.saveToDisk());
        System.out.println(cars.saveToDisk());
        System.out.println(staffMembers.saveToDisk());
    }
}
