/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package data;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import car.Car;

/**
 * Cars list wrapper class
 * @author Craig Banyard, Daniel Scott, Najim Mazidi
 */
public class Cars extends Observed implements ISerialisable {
    private ArrayList<Car> carsList;
    private static final Cars cars = new Cars();
    
    private Cars() { }
    
    /**
     * Gets the singleton instance of the cars wrapper
     * @return cars wrapper object
     */
    public static Cars getInstance() {
        return cars;
    }
    
    /**
     * Loads all cars from disk.
     * @return string to say whether the operation passed or failed.
     */
    @Override
    public String loadFromDisk() {
        File objFile = new File("data//Cars.dat");
        if (objFile.exists() && objFile.canRead()) {
            try (ObjectInputStream objIn = new ObjectInputStream(
                  new BufferedInputStream(
                  new FileInputStream(objFile)))) {
                Object objData = objIn.readObject();
                ArrayList<Car> newCarsList = (ArrayList)objData;
                if (newCarsList != null) {
                    carsList = newCarsList;
                    CarsObserver carsObserver = new CarsObserver();
                    for (Car car : carsList) {
                        car.registerObserver(carsObserver);
                        System.out.println("Loaded car " + car.getRegNo() + " with status: " + car.getStatus());
                    }
                    this.registerObserver(carsObserver);
                }
                
                return("Successfully loaded " + getCars().size() + " cars");
            } catch (Exception ex) {
                return("Data file could not be read " + ex.getMessage());
            }
        } else {
            return("Data file could not be found");
        }
    }
    
    /**
     * Saves all cars to disk.
     * @return a string to say whether the operation passed or failed.
     */
    @Override
    public String saveToDisk() {
        File objFile = new File("data//Cars.dat");
        try {
            objFile.createNewFile();
        } catch (IOException ex) {
            return ("error: " + ex.getMessage().toString());
        }
        try (ObjectOutputStream objOut = new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(objFile)))) {
            objOut.writeObject(carsList);
            return("Successfully saved " + getCars().size() + " cars");
        } catch (IOException ex) {
           return("error: " + ex.getMessage());
        }
    }
    
    /**
     * adds a car to the list of cars
     * @param car car to add to the list
     * @return a string to say whether the operation passed or failed
     */
    public String addCar(Car car) {
        if (carsList == null) {
            carsList = new ArrayList<Car>();
        }
        for (Car carInList : carsList) {
            if (carInList.getRegNo().equals(car.getRegNo())) {
                return "car already exists in list";
            }
        }
        carsList.add(car);
        notifyObservers();
        return "Car with reg no " + car.getRegNo() + " added to the collection";
    }
    
    /**
     * Removes a car from the list of cars
     * @param car the car to be removed from the list
     */
    public void removeCar(Car car) {
        if (carsList == null) return;
        carsList.remove(car);
        notifyObservers();
    }
    
    /**
     * Gets a list of cars
     * @return a copy of the list of cars so that  
     */
    public ArrayList<Car> getCars(){
        if (carsList == null) {
            carsList = new ArrayList<Car>();
        }
        
        ArrayList<Car> temp = new ArrayList<Car>();
        for(Car car : carsList){
            temp.add(car);
        }
        return temp;
    }
}
