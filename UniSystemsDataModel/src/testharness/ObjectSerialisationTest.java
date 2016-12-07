/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package testharness;
import data.Cars;
import car.Car;
import car.Classification;
import car.FuelType;
import car.Transmission;
import data.Loans;
import data.StaffMembers;
import java.util.Date;
import people.Address;
import people.Faculty;
import people.Position;
import people.Staff;
import people.Administrator;
import loaning.Loan;
import loaning.DayLoan;
import loaning.LongLoan;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class ObjectSerialisationTest{
    private static Cars cars = Cars.getInstance();
    private static StaffMembers staffMembers = StaffMembers.getInstance();
    private static Loans loans = Loans.getInstance();
    private static Administrator admin = new Administrator();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Car car = new Car("ABCDEFG", Transmission.AUTOMATIC, FuelType.DIESEL, 
                            "Plymouth", Classification.COUPE);
        admin.createCar(car);*/
        addTestDataAndSave();
        //loadFromDisk();
        
    }

    public static void addTestDataAndSave() {
        Car car = new Car("ABCDEFG", Transmission.AUTOMATIC, FuelType.DIESEL, 
                            "Plymouth", Classification.COUPE);
        Staff staff = new Staff("10438524", Position.LECTURER, Faculty.SCIENCE_AND_ENGINEERING, "BGB106", "07474306999", new Address("1", "Tothill Avenue", "Plymouth", "Devon", "PL4 8PH"),
                "Mr", "Najim", "Mazidi", new Date(1995,07,26), "Male", "07474306999", "nmazidi95@gmail.com");
        admin.assignDayLoan(car, staff);
        admin.createCar(car);
        admin.createStaffMember(staff);
    }
    
    public static void loadFromDisk() {
        System.out.println(staffMembers.loadFromDisk());
        for (Staff staff : staffMembers.getStaffMembers()) {
            System.out.println(staff.getStaffRefNumb() + " " + staff.getForename() + " " + staff.getSurname());
        }
        System.out.println(cars.loadFromDisk());
        for (Car car : cars.getCars()) {
            System.out.println(car.getRegNo() + " " + car.getStatus());
        }
        System.out.println(loans.loadFromDisk());
        for (Loan loan : loans.getLoans()) {
            System.out.println(loan.getLoaner().getForename() + " " + loan.getCar().getRegNo());
        }
    }
    
    public static void addCarAndSave() {
        Car car = new Car("ABCDEFG", Transmission.AUTOMATIC, FuelType.DIESEL, 
                            "Plymouth", Classification.COUPE);
        cars.addCar(car);
    }
    
    public static void addStaffAndSave() {
        Staff staff = new Staff("10438524", Position.LECTURER, Faculty.SCIENCE_AND_ENGINEERING, "BGB106", "07474306999", new Address("1", "Tothill Avenue", "Plymouth", "Devon", "PL4 8PH"),
                "Mr", "Najim", "Mazidi", new Date(1995,07,26), "Male", "07474306999", "nmazidi95@gmail.com");
        staffMembers.addStaff(staff);
        System.out.println(staffMembers.saveToDisk());
    }
    
}
