/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package model.people;

import java.util.Date;
import model.car.Car;

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
    

    public Staff(String staffRefNumb, Position position, Faculty faculty, String officeRoom, String workNumb, Address address, String title, String forename, String surname, Date dateOfBirth, String gender, String phoneNumber, String emailAddress) {
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
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getOfficeRoom() {
        return officeRoom;
    }

    public void setOfficeRoom(String officeRoom) {
        this.officeRoom = officeRoom;
    }

    public String getWorkNumb() {
        return workNumb;
    }

    public void setWorkNumb(String workNumb) {
        this.workNumb = workNumb;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
