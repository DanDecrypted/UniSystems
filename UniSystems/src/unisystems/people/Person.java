/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package unisystems.people;

import java.util.Date;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Person {
    private String title;
    private String firstName;
    private String surname;
    private Date dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String emailAddress;
    
   
    public Person() {
        
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    
    public String getGender() {
        return gender;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
}
