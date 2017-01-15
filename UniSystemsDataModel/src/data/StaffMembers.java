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
import people.Staff;

/**
 * Staff members data wrapper class
 * @author Craig Banyard, Daniel Scott, Najim Mazidi
 */
public class StaffMembers extends Observed implements ISerialisable {
    private ArrayList<Staff> staffList;
    private static final StaffMembers staffMembers = new StaffMembers();
    
    private StaffMembers() {}
    
    /**
     * Gets the staff members that are stored in the singleton object
     * @return a StaffMembers object
     */
    public static StaffMembers getInstance() {
        return staffMembers;
    }
    
    /**
     * Loads staff members from disk
     * @return a string with information on whether the operation passed or failed
     */
    @Override
    public String loadFromDisk() {
        File objFile = new File("data//StaffMembers.dat");
        if (objFile.exists() && objFile.canRead()) {
            try (ObjectInputStream objIn = new ObjectInputStream(
                    new BufferedInputStream(
                    new FileInputStream(objFile)))) {
                Object objData = objIn.readObject();
                ArrayList<Staff> newStaffList = (ArrayList)objData;
                if (newStaffList != null) {
                    staffList = newStaffList;
                    StaffObserver staffObserver = new StaffObserver();
                    for (Staff staff : staffList) {
                        staff.registerObserver(staffObserver);
                    }
                    this.registerObserver(staffObserver);
                }
                return ("Successfully loaded " + getStaffMembers().size() + " staff members");
            } catch (Exception ex) {
                return ("Data file could not be read " + ex.getMessage());
            }
        } else {
            return ("Data file could not be found");
        }
    }
    
    /**
     * Saves staff members to the disk
     * @return a string to say whether it's passed or failed
     */
    @Override
    public String saveToDisk() {
        File objFile = new File("data//StaffMembers.dat");
        try {
            objFile.createNewFile();
        } catch (IOException ex) {
            return ("error: " + ex.getMessage().toString());
        }
        
        try (ObjectOutputStream objOut = new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(objFile)))) {
            objOut.writeObject(staffList);
            return ("Successfully saved " + getStaffMembers().size() + " staff members");
        } catch (IOException ex) {
            return ("error: " + ex.getMessage());
        }
    }
    
    /**
     * adds a staff member to the list
     * @param staff staff to add
     */
    public void addStaff(Staff staff) {
        if (staffList == null) {
            staffList = new ArrayList<Staff>();
        }
        staffList.add(staff);
        notifyObservers();
    }
    
    /**
     * Removes a staff member from the list
     * @param staff staff to remove
     */
    public void removeStaff(Staff staff) {
        if (staffList == null) return;
        if (staffList.contains(staff)) {
            staffList.remove(staff);
            notifyObservers();
        }
    }
    
    /**
     * Gets the staff members list
     * @return Array of all the staff members of the system.
     */
    public ArrayList<Staff> getStaffMembers() {
        if (staffList == null) {
            staffList = new ArrayList<Staff>();
        }
        
        ArrayList<Staff> temp = new ArrayList<Staff>();
        for(Staff staff : staffList) {
            temp.add(staff);
        }
        return temp;
    }
    
}
