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
 * Super class which gives Staff and Administrator their base properties.
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
   
    /**
     * Default constructor of a person
     */
    public Person() {
        this.title = "UKNOWN";
        this.forename = "UNKNOWN";
        this.surname = "UNKNOWN";
        this.dateOfBirth = null;
        this.gender = "UNKNOWN";
        this.phoneNumber = "UNKNOWN";
        this.emailAddress = "UNKNOWN";
    }
    
    /**
     * Constructor for a person not that we will ever really need to.
     * @param title the title of the person.
     * @param forename the forename of the person.
     * @param surname the surname of the person.
     * @param dateOfBirth the date of birth of the person.
     * @param gender gender of the person  
     * @param phoneNumber phone number of the person 
     * @param emailAddress email address of the person.
     */
    public Person(String title, String forename, String surname, 
            Date dateOfBirth, String gender, String phoneNumber, 
            String emailAddress) {
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    /**
     * gets the title of the person
     * @return a string 
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the person
     * @param title the title of the person
     */
    public void setTitle(String title) {
        this.title = title;
        this.notifyObservers();
    }
    
    /**
     * Gets the full name of the person separated by a space.
     * @return String
     */
    public String getFullName() {
        return forename + " " + surname;
    }
    
    /**
     * Gets the forename of the person.
     * @return String 
     */
    public String getForename() {
        return forename;
    }
    
    /**
     * Sets the forename of the person.
     * @param forename 
     */
    public void setForename(String forename) {
        this.forename = forename;
        this.notifyObservers();
    }

    /**
     * Gets the surname of the person.
     * @return String
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of the person
     * @param surname 
     */
    public void setSurname(String surname) {
        this.surname = surname;
        this.notifyObservers();
    }

    /**
     * gets the date of birth of the person
     * @return Date
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the person.
     * @param dateOfBirth 
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.notifyObservers();
    }

    /** 
     * Gets the gender of the person.
     * @return String
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the person.
     * @param gender 
     */
    public void setGender(String gender) {
        this.gender = gender;
        this.notifyObservers();
    }

    /**
     * Gets the phone number of the person.
     * @return 
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the person.
     * @param phoneNumber 
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.notifyObservers();
    }
    
    /**
     * Gets the email address of the person.
     * @return String 
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    
    /**
     * Sets the email address of the person.
     * @param emailAddress 
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        this.notifyObservers();
    }
}
