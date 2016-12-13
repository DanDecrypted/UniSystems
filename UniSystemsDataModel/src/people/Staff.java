/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package people;

import java.util.Date;
import car.Car;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Staff extends Person {
    protected String staffRefNumb;
    protected Position position;
    protected Faculty faculty;
    protected String officeRoom;
    protected String workNumb;
    protected Address address;
    
    public Staff() {
        super();
        this.staffRefNumb = "UNKNOWN";
        this.position = null;
        this.faculty = null;
        this.officeRoom = "UNKNWON";
        this.workNumb = "UNKNOWN";
        this.address = null;
    }
    

    public Staff(String staffRefNumb, Position position, Faculty faculty, 
                 String officeRoom, String workNumb, Address address, 
                 String title, String forename, String surname, 
                 Date dateOfBirth, String gender, String phoneNumber, 
                 String emailAddress) {
        super(title, forename, surname, dateOfBirth, gender, phoneNumber, emailAddress);
        this.staffRefNumb = staffRefNumb;
        this.position = position;
        this.faculty = faculty;
        this.officeRoom = officeRoom;
        this.workNumb = workNumb;
        this.address = address;
    }

    public String getStaffRefNumb() {
        return staffRefNumb;
    }

    /* Staff reference number should never change once creared - Dan
    public void setStaffRefNumb(String staffRefNumb) {
        this.staffRefNumb = staffRefNumb;
    }*/

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        this.notifyObservers();
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
        this.notifyObservers();
    }

    public String getOfficeRoom() {
        return officeRoom;
    }

    public void setOfficeRoom(String officeRoom) {
        this.officeRoom = officeRoom;
        this.notifyObservers();
    }

    public String getWorkNumb() {
        return workNumb;
    }

    public void setWorkNumb(String workNumb) {
        this.workNumb = workNumb;
        this.notifyObservers();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        this.notifyObservers();
    }
}
