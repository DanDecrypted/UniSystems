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
/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class ObjectSerialisationTest {
    private static Cars cars;
    private static StaffMembers staffMembers;
    private static Loans loans;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        staffMembers.getInstance();
        addCarAndSave();
        loadFromDisk();
    }
    
    public static void loadFromDisk() {
        Cars.loadFromDisk();
        cars = Cars.getInstance();
        System.out.println("Cars[0] has the regNo: " + cars.getCars().get(0).getRegNo() + 
                           " and availability of " + cars.getCars().get(0).getStatus());
        staffMembers.loadFromDisk();
        System.out.println("StaffMembers[0] has the name: " + staffMembers.getStaffMembers().get(0).getFirstName() + 
                           " and availability of " + cars.getCars().get(0).getStatus());
        Loans.loadFromDisk();
    }
    
    public static void addCarAndSave() {
        Car car = new Car("ABCDEFG", Transmission.AUTOMATIC, FuelType.DIESEL, 
                            "Plymouth", Classification.COUPE);
        cars.addCar(car);
        Cars.saveToDisk();
    }
    
}
