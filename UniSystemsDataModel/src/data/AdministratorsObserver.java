/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import data.Administrators;

/**
 * Administrators observer
 * @author Craig Banyard, Daniel Scott, Najim Mazidi
 */
public class AdministratorsObserver implements IObserver {
    Administrators admins = Administrators.getInstance();
    
    public AdministratorsObserver() { }
    
    /**
     * Saves the administrators to disk
     */
    @Override
    public void update() {
        System.out.println(admins.saveToDisk());
    }
}
