/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package people;

import java.util.Date;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Person implements java.io.Serializable {
    protected String title;
    protected String forename;
    protected String surname;
    protected Date dateOfBirth;
    protected String gender;
    protected String phoneNumber;
    protected String emailAddress;
   
    public Person() {
        
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
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    
    
}
