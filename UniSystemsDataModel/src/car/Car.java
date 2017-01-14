/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package car;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Craig Banyard, Daniel Scott, Najim Mazidi
 */
public class Car extends data.Observed implements java.io.Serializable{
    /**
     * RegNo should be unique. it is the method of identifying the car
     */
    private String regNo;
    private String make;
    private String model;
    private Transmission transmission;
    private Status status;
    private ArrayList<Service> serviceRecord;
    private Classification classification;
    private FuelType fuelType;
    private Location location;
    private String parkingSpace;
    private int seats;
    private int doors;
    private LoanType loanType;
    private ArrayList<String> notes;
    private int milageAtLastService;
    private int milage;
    private Date lastService;
    
    /**
     * Default constructor for a car
     */
    public Car(){
        
    }
    
    /**
     * Constructor for a car object
     * @param regNo registration number of the car
     * @param make make of the car 
     * @param model model of the car 
     * @param transmission Transmission type of the car 
     * @param fuelType fuel type of the car 
     * @param location geographical location of the car 
     * @param parkingSpace parking space of the car 
     * @param classification classification of the car
     * @param seats seats of the car
     * @param doors doors of the car 
     * @param mileage mileage of the car 
     * @param loanType loan type of the car, day or long.
     */
    public Car(String regNo, String make, String model, Transmission transmission, FuelType fuelType, 
            Location location, String parkingSpace, Classification classification, int seats, int doors,
            int mileage, LoanType loanType) {
        this.regNo = regNo.toUpperCase();
        this.make = make;
        this.model = model;
        this.classification = classification;
        this.transmission = transmission; 
        this.fuelType = fuelType;
        this.location = location;
        this.parkingSpace = parkingSpace;
        this.status = Status.AVAILABLE;
        this.serviceRecord = new ArrayList<Service>();
        this.seats = seats;
        this.doors = doors;
        this.milage = mileage;
        this.loanType = loanType;
        this.notes = new ArrayList<String>();
        this.notifyObservers();
    }
    
    /**
     * Checks if the car needs a service based on the rules of 
     * if it's been a year or if the car has driven more than 10k miles.
     * @return true or false
     */
    public boolean needsService() {
        Date today = new Date();
        long diff = lastService.getTime() - today.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        if (diffDays >= 365 || (milage - milageAtLastService >= 10000)){
            return true;
        }
        return false;
    }

    /** 
     * Gets the make of the car
     * @return String
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the make of the car
     * @param make make of the car. String.
     */
    public void setMake(String make) {
        this.make = make;
        this.notifyObservers();
    }

    /**
     * Gets the model of the car
     * @return String
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the car 
     * @param model model of the car. String.
     */
    public void setModel(String model) {
        this.model = model;
        this.notifyObservers();
    }

    /**
     * Sets the mileage of the car
     * @param milage Milage of the car. Integer.
     */
    public void setMilage(int milage) {
        this.milage = milage;
    }
    
    /**
     * Gets the registration number of the car 
     * @return String
     */
    public String getRegNo() {
        return regNo;
    }
    
    /** 
     * Gets the status of the car
     * @return Status enumerator 
     */
    public Status getStatus() {
        return status;
    }
    
    /**
     * Sets the status of the car
     * @param status Status enumerator.
     */
    public void setStatus(Status status) {
        this.status = status;
        if (status == Status.IN_FOR_SERVICE) {
            this.lastService = new Date();
            this.milageAtLastService = this.milage;
        }
        
        this.notifyObservers();
    }
    
    /**
     * Gets the Classification of the car
     * @return Classification Enumerator
     */
    public Classification getClassification() {
        return classification;
    }
    
    /**
     * Gets the geographical location of the car
     * @return String
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Gets the parking space of the car 
     * @return String
     */
    public String getParkingSpace() {
        return parkingSpace;
    }

    /**
     * Sets the parking space of the car
     * @param parkingSpace String
     */
    public void setParkingSpace(String parkingSpace) {
        this.parkingSpace = parkingSpace;
        this.notifyObservers();
    }
    
    /**
     * Gets the milage of the car 
     * @return integer
     */
    public int getMilage() {
        return milage;
    }
    
    /**
     * Gets the transmission of the car
     * @return Transmission enum
     */
    public Transmission getTransmission() {
        return transmission;
    }
    
    /**
     * Gets the Fuel Type of the car 
     * @return Fuel Type enum
     */
    public FuelType getFuelType() {
        return fuelType;
    }
    
    /**
     * Gets the seats of the car
     * @return integer
     */
    public int getSeats(){
        return seats;
    }
    
    /**
     * Gets the door count of the car
     * @return integer
     */
    public int getDoors(){
        return doors;
    }

    /**
     * Gets the loan type of the car
     * @return LoanType enum
     */
    public LoanType getLoanType() {
        return loanType;
    }

    /**
     * Sets the loan type of the car
     * @param loanType LoanType of the car.
     */
    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
        this.notifyObservers();
    }
   
    /**
     * Gets the service record of the car
     * @return an array of service
     */
    public ArrayList<Service> getServiceRecord() {
        ArrayList<Service> temp = new ArrayList<Service>();
        for (Service service : serviceRecord) {
            temp.add(service);
        }
        return temp;
    }
    
    /**
     * Adds a service to the record of the car
     * @param service Service to be added to the car.
     */
    public void addService(Service service) {
        if (serviceRecord == null) serviceRecord = new ArrayList<Service>();
        serviceRecord.add(service);
        this.notifyObservers();
    }
    
    /**
     * Adds a note to the cars list of notes.
     * @param note note to be added to the car
     */
    public void addNote(String note) {
        if (notes == null) notes = new ArrayList<String>();
        notes.add(note);
        this.notifyObservers();
    }
    
    /**
     * Adds an array of strings to the notes.
     * @param notes notes to be added to the car. ArrayList of string.
     */
    public void addNotes(ArrayList<String> notes) {
        if (notes == null) return;
        if (this.notes == null) this.notes = new ArrayList<String>();
        for (String note : notes) {
            this.notes.add(note);
        }
        this.notifyObservers();
    }
    
    /**
     * Gets the array list of notes.
     * @return Array list of strings.
     */
    public ArrayList<String> getNotes() {
        ArrayList<String> temp = new ArrayList<String>();
        for (String note : notes) {
            temp.add(note);
        }
        return temp;
    }
}
