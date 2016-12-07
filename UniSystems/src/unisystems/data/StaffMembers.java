/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package unisystems.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import unisystems.people.Staff;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class StaffMembers implements java.io.Serializable {
    private ArrayList<Staff> staffList;
    private static StaffMembers staffMembers;
    
    public StaffMembers() {
        
    }
    
    public static StaffMembers getInstance() {
        if (staffMembers == null) {
            staffMembers = new StaffMembers();
        }
        return staffMembers;
    }
    
    public void loadFromDisk() {
        File objFile = new File("Staff.dat");
        if (objFile.exists() && objFile.canRead()) {
            try (ObjectInputStream objIn = new ObjectInputStream(
                    new BufferedInputStream(
                    new FileInputStream(objFile)))) {
                Object objData = objIn.readObject();
                ArrayList<Staff> newList = (ArrayList)objData;
                if (newList != null) {
                    staffList = newList;
                    System.out.println("Successfully loaded " + staffList.size() + " Staff members");
                }
            } catch (Exception ex) {
                System.out.println("Data file could not be read " + ex.getMessage());
            }
        } else {
            System.out.println("Data file could not be found.");
        }
    }
    
    public void saveToDisk() {
        File objFile = new File("Staff.dat");
        try (ObjectOutputStream objOut = new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(objFile)))) {
            objOut.writeObject(staffList);
            System.out.println("Successfully saved " + staffList.size() + " staff members");
        } catch (IOException ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
    
    public void addStaff(Staff staff) {
        if (staffList == null) {
            staffList = new ArrayList<Staff>();
        }
        staffList.add(staff);
    }
    
    public void removeStaff(Staff staff) {
        if (staffList == null) return;
        staffList.remove(staff);
    }
    
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
