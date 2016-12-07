/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package car;
import java.util.ArrayList;

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
    private ArrayList<Service> serviceRecord;
    private Classification classification;
    private FuelType fuelType;
    private String location;
    private int milage;
    private int seats;
    private int doors;
    
    public Car(){
        
    }
    
    public Car(String regNo, Transmission transmission, FuelType fuelType, 
            String location, Classification classification, int seats, int doors) {
        this.regNo = regNo;
        this.classification = classification;
        this.transmission = transmission; 
        this.fuelType = fuelType;
        this.location = location;
        this.status = Status.AVAILABLE;
        this.serviceRecord = new ArrayList<Service>();
        this.seats = seats;
        this.doors = doors;
        
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
    
    public Classification getClassification() {
        return classification;
    }
    
    public String getLocation() {
        return location;
    }
    
    public int getMilage() {
        return milage;
    }
    
    public Transmission getTransmission() {
        return transmission;
    }
    
    public FuelType getFuelType() {
        return fuelType;
    }
    
    public int getSeats(){
        return seats;
    }
    
    public int getDoors(){
        return doors;
    }
    
    public ArrayList<Service> getServiceRecord() {
        ArrayList<Service> temp = new ArrayList<Service>();
        for (Service service : serviceRecord) {
            temp.add(service);
        }
        return temp;
    }
    
    public void addService(Service service) {
        if (serviceRecord == null) serviceRecord = new ArrayList<Service>();
        serviceRecord.add(service);
    }
}
