/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import data.Cars;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class CarsObserver implements IObserver{
    private Cars cars = Cars.getInstance();
    public CarsObserver() {
        
    }
    
    @Override
    public void update() {
        System.out.println(cars.saveToDisk());
    }
}
