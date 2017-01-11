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
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Cars extends Observed implements ISerialisable {
    private ArrayList<Car> carsList;
    private static final Cars cars = new Cars();
    
    private Cars() { }
    
    public static Cars getInstance() {
        return cars;
    }
    
    @Override
    public String loadFromDisk() {
        File objFile = new File("dist/Cars.dat");
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
                }
                
                return("Successfully loaded " + getCars().size() + " cars");
            } catch (Exception ex) {
                return("Data file could not be read " + ex.getMessage());
            }
        } else {
            return("Data file could not be found");
        }
    }
    
    @Override
    public String saveToDisk() {
        File objFile = new File("dist/Cars.dat");
        try (ObjectOutputStream objOut = new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(objFile)))) {
            objOut.writeObject(carsList);
            return("Successfully saved " + getCars().size() + " cars");
        } catch (IOException ex) {
           return("error: " + ex.getMessage());
        }
    }
    
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
