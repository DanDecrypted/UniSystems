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
import model.people.Staff;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class StaffMembers implements java.io.Serializable, ISerialisable {
    private ArrayList<Staff> staffList;
    private StaffMembers staffMembers;
    
    public StaffMembers() {
        
    }
    
    public StaffMembers getInstance() {
        if (staffMembers == null) {
            staffMembers = new StaffMembers();
        }
        return staffMembers;
    }
    
    @Override
    public String loadFromDisk() {
        File objFile = new File("Staff.dat");
        if (objFile.exists() && objFile.canRead()) {
            try (ObjectInputStream objIn = new ObjectInputStream(
                    new BufferedInputStream(
                    new FileInputStream(objFile)))) {
                Object objData = objIn.readObject();
                StaffMembers newObj = (StaffMembers)objData;
                staffMembers = newObj;
                return ("Successfully loaded " + getStaffMembers().size() + " Staff members");
            } catch (Exception ex) {
                return ("Data file could not be read " + ex.getMessage());
            }
        } else {
            return ("Data file could not be found.");
        }
    }
    
    @Override
    public String saveToDisk() {
        File objFile = new File("Staff.dat");
        try (ObjectOutputStream objOut = new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(objFile)))) {
            objOut.writeObject(staffMembers);
            return ("Successfully saved " + getStaffMembers().size() + " staff members");
        } catch (IOException ex) {
            return ("error: " + ex.getMessage());
        }
    }
    
    public void addStaff(Staff staff) {
        if (getInstance().staffList == null) {
            getInstance().staffList = new ArrayList<Staff>();
        }
        getInstance().staffList.add(staff);
    }
    
    public void removeStaff(Staff staff) {
        if (getInstance().staffList == null) return;
        getInstance().staffList.remove(staff);
    }
    
    public ArrayList<Staff> getStaffMembers() {
        if (getInstance().staffList == null) {
            getInstance().staffList = new ArrayList<Staff>();
        }
        
        ArrayList<Staff> temp = new ArrayList<Staff>();
        for(Staff staff : getInstance().staffList) {
            temp.add(staff);
        }
        return temp;
    }
    
}
