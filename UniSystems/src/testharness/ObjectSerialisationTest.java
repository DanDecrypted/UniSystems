/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package testharness;
import data.Cars;
import model.car.Car;
import model.car.Classification;
import model.car.FuelType;
import model.car.Transmission;
import data.Loans;
import data.StaffMembers;
import model.people.Staff;
/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class ObjectSerialisationTest {
    private static Cars cars;
    private static StaffMembers staffMembers = new StaffMembers().getInstance();
    private static Loans loans;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        loadFromDisk();
        addStaffAndSave();
        //System.out.println(staffMembers.loadFromDisk());
        loadFromDisk();
    }
    
    public static void loadFromDisk() {
        staffMembers.loadFromDisk();
        System.out.println("StaffMembers[0] has the name: " + staffMembers.getStaffMembers().get(0).getFirstName() + " array size: " + staffMembers.getStaffMembers().size());
    }
    
    public static void addCarAndSave() {
        Car car = new Car("ABCDEFG", Transmission.AUTOMATIC, FuelType.DIESEL, 
                            "Plymouth", Classification.COUPE);
        cars.addCar(car);
        Cars.saveToDisk();
    }
    public static void addStaffAndSave() {
        Staff staff = new Staff("Dan");
        staffMembers.addStaff(staff);
        System.out.println(staffMembers.saveToDisk());
    }
    
}
