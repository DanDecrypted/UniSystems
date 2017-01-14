/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.*;
import java.util.ArrayList;
import people.Administrator;

/**
 * Singleton class for the administrators container.
 * @author Craig Banyard, Daniel Scott, Najim Mazidi
 */
public class Administrators extends Observed implements ISerialisable {
    private ArrayList<Administrator> adminList = new ArrayList<Administrator>();
    private static final Administrators admins = new Administrators();
    private Administrators() { }
    
    /**
     * Gets the instance of the administrators container.
     * @return Administrators object.
     */
    public static Administrators getInstance() {
        return admins;
    }
    
    /**
     * Loads the administrators data from disk.
     * @return String containing error messages or success.
     */
    public String loadFromDisk() {
        File objFile = new File("dist/Administrators.dat");
        if (objFile.exists() && objFile.canRead()) {
            try (ObjectInputStream objIn = new ObjectInputStream(
                new BufferedInputStream( 
                new FileInputStream(objFile)))) {
                Object objData = objIn.readObject();
                ArrayList<Administrator> newAdminList = (ArrayList)objData;
                if (newAdminList != null) {
                    adminList = newAdminList;
                    AdministratorsObserver adminObserver = new AdministratorsObserver();
                    for (Administrator admin : adminList) {
                        admin.registerObserver(adminObserver);
                    }
                    this.registerObserver(adminObserver);
                }
                return ("Successfully loaded " + getAdministrators().size() + " Administrators");
                
            } catch (Exception ex) {
                return ("Data file could not be read!");
            }
        } else {
            return ("Data file could not be found!");
        }
    }
    
    /**
     * Saves the administrators to disk.
     * @return a string containing any errors / successes.
     */
    public String saveToDisk() {
        File objFile = new File("dist/Administrators.dat");
        try (ObjectOutputStream objOut = new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(objFile)))) {
            
            objOut.writeObject(adminList);
            
            return ("Successfully saved " + getAdministrators().size() + " administrators");
        } catch (IOException ex) {
            ex.printStackTrace();
            return ("error: " + ex.getMessage().toString());
        }
    }
    
    public ArrayList<Administrator> getAdministrators() {
        if (adminList == null) return new ArrayList<Administrator>();
        ArrayList<Administrator> temp = new ArrayList<Administrator>();
        
        for (Administrator admin : adminList) {
            temp.add(admin);
        }
        return temp;
    }
    
    public void addAdministrator(Administrator admin) {
        if (adminList == null) {
            adminList = new ArrayList<Administrator>();
        }
        adminList.add(admin);
        notifyObservers();
    }
    
    public void removeAdministrator(Administrator admin) {
        if (adminList == null) return;
        adminList.remove(admin);
        notifyObservers();
    }
}
