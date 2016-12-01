/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package unisystemsmodel;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Loan {
    private Staff loaner;
    private Car car;
    private String carNotes;
    
    public Loan(Staff loaner, Car car){
        this.loaner = loaner;
        this.car = car;
    }
    
    public Staff getLoaner() {
        return loaner;
    }
    
    public Car getCar() {
        return car;
    }
}
