/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package model.loaning;

import model.car.Car;
import model.people.Staff;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Loan implements java.io.Serializable{
    private Staff loaner;
    private Car car;
    private String carNotes;
    private int fuelLevel;
    
    public Loan(Staff loaner, Car car){
        this.loaner = loaner;
        this.car = car;
    }
    
    public int getFuelLevel() {
        return this.fuelLevel;
    }
    
    public Staff getLoaner() {
        return loaner;
    }
    
    public Car getCar() {
        return car;
    }
}
