/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package unisystems.people;

import unisystems.car.Car;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Staff extends Person {
    private String staffRefNumb;
    private Position position;
    private Faculty faculty;
    private String officeRoom;
    private String workNumb;
    private Address address;
    
    public Staff() {
        
    }
    
    public void dayLoan(Car car) {
        //Code for creating day loan
    }
    
    public String getStaffRefNumb() {
        return staffRefNumb;
    }
    
    public Position getPosition() {
        return position;
    }
    
    public Faculty getFaculty() {
        return faculty;
    }
    
    public String getOfficeRoom() {
        return officeRoom;
    }
    
    public String getWorkNumb() {
        return workNumb;
    }
    
    
}
