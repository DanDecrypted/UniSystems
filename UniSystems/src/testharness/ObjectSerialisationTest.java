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
/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class ObjectSerialisationTest {
    private static Cars cars = Cars.getInstance();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        addCarAndSave();
        loadFromDisk();
    }
    
    public static void loadFromDisk() {
        cars.loadFromDisk();
    }
    
    public static void addCarAndSave() {
        Car car = new Car("ABCDEFG", Transmission.AUTOMATIC, FuelType.DIESEL, 
                            "Plymouth", Classification.COUPE);
        cars.addCar(car);
        cars.saveToDisk();
    }
    
}
