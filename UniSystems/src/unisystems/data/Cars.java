/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package unisystems.data;
import java.util.ArrayList;
import java.io.*;
import unisystems.car.Car;

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
            return new Cars();
        }
        return cars;
    }
    
    public void loadFromDisk() {
        File objFile = new File("Cars.dat");
        if (objFile.exists() && objFile.canRead()) {
            try (ObjectInputStream objIn = new ObjectInputStream(
                  new BufferedInputStream(
                  new FileInputStream(objFile)))) {
                Object objData = objIn.readObject();
                ArrayList<Car> newList = (ArrayList)objData;
                if (newList != null) {
                    carsList = newList;
                    System.out.println("Successfully loaded " + carsList.size() + " Cars");
                }
            } catch (Exception ex) {
                System.out.println("Data file could not be read " + ex.getMessage());
            }
        } else {
            System.out.println("Data file could not be found!");
        }
    }
    
    public void saveToDisk() {
        File objFile = new File("Cars.dat");
        try (ObjectOutputStream objOut = new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(objFile)))) {
            objOut.writeObject(carsList);
            System.out.println("Successfully saved " + carsList.size() + " Cars");
        } catch (IOException ex) {
            System.out.println("error: " + ex.getMessage());
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
