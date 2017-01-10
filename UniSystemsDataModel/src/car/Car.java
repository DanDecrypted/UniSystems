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
    private int milage;
    private int seats;
    private int doors;
    private LoanType loanType;
    private ArrayList<String> notes;
    
    public Car(){
        
    }
    
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
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    public String getRegNo() {
        return regNo;
    }
    
    public Status getStatus() {
        return status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
        this.notifyObservers();
    }
    
    public Classification getClassification() {
        return classification;
    }
    
    public Location getLocation() {
        return location;
    }

    public String getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(String parkingSpace) {
        this.parkingSpace = parkingSpace;
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

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
        this.notifyObservers();
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
        this.notifyObservers();
    }
    
    public void addNote(String note) {
        if (notes == null) notes = new ArrayList<String>();
        notes.add(note);
        this.notifyObservers();
    }
    
    public void addNotes(ArrayList<String> notes) {
        if (notes == null) return;
        if (this.notes == null) this.notes = new ArrayList<String>();
        for (String note : notes) {
            this.notes.add(note);
        }
        this.notifyObservers();
    }
    
    public ArrayList<String> getNotes() {
        ArrayList<String> temp = new ArrayList<String>();
        for (String note : notes) {
            temp.add(note);
        }
        return temp;
    }
}
