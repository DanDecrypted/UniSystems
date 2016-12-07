/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package model.people;

import model.car.Car;
import model.car.Status;
import model.loaning.*;
import data.Loans;
import java.util.Date;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Administrator extends Staff{
    Loans loans = Loans.getInstance();
    
    public Administrator() {
        
    }
    
    public void assignLongLoan(Car car, Staff staff) {
        Date returnDate = new Date();
        returnDate.setYear(returnDate.getYear() + 1);
        LongLoan loan = new LongLoan(staff, car, new Date(), returnDate);
        loans.addLoan(loan);
    }
    
    public void assignDayLoan(Car car, Staff staff) {
        Date returnDate = new Date();
        returnDate.setHours(23);
        returnDate.setMinutes(59);
        DayLoan loan = new DayLoan(staff, car, returnDate);
        loans.addLoan(loan);
    }
    
    public void sendForService(Car car){
        car.setStatus(Status.IN_FOR_SERVICE);
    }
}
