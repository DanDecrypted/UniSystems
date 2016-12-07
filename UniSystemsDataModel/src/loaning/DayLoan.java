/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package loaning;
import java.util.Date;
import car.Car;
import people.Staff;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class DayLoan extends Loan {
    private Date rentalDate;
    
    public DayLoan(Staff loaner, Car car, Date rentalDate) {
        super(loaner, car);
        this.rentalDate = rentalDate;
    }
    
    public Date getRentalDate() {
        return rentalDate;
    }
}
