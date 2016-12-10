/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package people;

import data.IObserver;
import data.Observed;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Person extends data.Observed implements java.io.Serializable {
    protected String title;
    protected String forename;
    protected String surname;
    protected Date dateOfBirth;
    protected String gender;
    protected String phoneNumber;
    protected String emailAddress;
   
    public Person() {
        this.title = "UKNOWN";
        this.forename = "UNKNOWN";
        this.surname = "UNKNOWN";
        this.dateOfBirth = null;
        this.gender = "UNKNOWN";
        this.phoneNumber = "UNKNOWN";
        this.emailAddress = "UNKNOWN";
    }
    
    public Person(String title, String forename, String surname, Date dateOfBirth, String gender, String phoneNumber, String emailAddress) {
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.notifyObservers();
    }
    
    public String getFullName() {
        return forename + " " + surname;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
        this.notifyObservers();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        this.notifyObservers();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.notifyObservers();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        this.notifyObservers();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.notifyObservers();
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        this.notifyObservers();
    }
}
