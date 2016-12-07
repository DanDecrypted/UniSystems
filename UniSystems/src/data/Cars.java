/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package data;
import java.util.ArrayList;
import java.io.*;
import model.car.Car;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Cars implements java.io.Serializable{
    private ArrayList<Car> carsList;
    private static Cars cars;
    public Cars() {
        
    }
    
    public static Cars getInstance() {
        if (cars == null) { 
            cars = new Cars();
        }
        return cars;
    }
    
    public String loadFromDisk() {
        File objFile = new File("Cars.dat");
        if (objFile.exists() && objFile.canRead()) {
            try (ObjectInputStream objIn = new ObjectInputStream(
                  new BufferedInputStream(
                  new FileInputStream(objFile)))) {
                Object objData = objIn.readObject();
                Cars newObj = (Cars)objData;
                if (newObj != null) {
                    cars = newObj;
                }
                return("Successfully loaded " + carsList.size() + " Cars");
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
            objOut.writeObject(cars);
            return("Successfully saved " + carsList.size() + " Cars");
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
