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
import model.car.Car;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Cars implements ISerialisable{
    private ArrayList<Car> carsList;
    private static final Cars cars = new Cars();
    
    private Cars() { }
    
    public static Cars getInstance() {
        return cars;
    }
    
    public String loadFromDisk() {
        File objFile = new File("Cars.dat");
        if (objFile.exists() && objFile.canRead()) {
            try (ObjectInputStream objIn = new ObjectInputStream(
                  new BufferedInputStream(
                  new FileInputStream(objFile)))) {
                Object objData = objIn.readObject();
                ArrayList<Car> newCarsList = (ArrayList)objData;
                if (newCarsList != null) 
                    carsList = newCarsList;
                return("Successfully loaded " + getCars().size() + " Cars");
            } catch (Exception ex) {
                return("Data file could not be read " + ex.getMessage());
            }
        } else {
            return("Data file could not be found!");
        }
    }
    
    public String saveToDisk() {
        File objFile = new File("Cars.dat");
        try (ObjectOutputStream objOut = new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(objFile)))) {
            objOut.writeObject(carsList);
            return("Successfully saved " + getCars().size() + " Cars");
        } catch (IOException ex) {
           return("error: " + ex.getMessage());
        }
    }
    
    public void addCar(Car car) {
        if (carsList == null) {
            carsList = new ArrayList<Car>();
        }
        carsList.add(car);
    }
    
    public void removeCar(Car car) {
        if (carsList == null) return;
        carsList.remove(car);
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
