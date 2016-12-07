/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package car;
import java.awt.Image;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Car implements java.io.Serializable{
    /**
     * RegNo should be unique. it is the method of identifying the car
     */
    private String regNo;
    private Transmission transmission;
    private Status status;
    private ServiceRecord serviceRecord;
    private Classification classification;
    private FuelType fuelType;
    private String location;
    private int milage;
    
    public Car(){
        
    }
    
    public Car(String regNo, Transmission transmission, FuelType fuelType, 
            String location, Classification classification) {
        this.regNo = regNo;
        this.classification = classification;
        this.transmission = transmission; 
        this.fuelType = fuelType;
        this.location = location;
        this.status = Status.AVAILABLE;
        this.serviceRecord = new ServiceRecord();
        
    }
    
    public String getRegNo() {
        return regNo;
    }
    
    public Status getStatus() {
        return status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
}
