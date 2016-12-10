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
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class StaffMembers extends Observed implements ISerialisable {
    private ArrayList<Staff> staffList;
    private static final StaffMembers staffMembers = new StaffMembers();
    
    private StaffMembers() {}
    
    public static StaffMembers getInstance() {
        return staffMembers;
    }
    
    @Override
    public String loadFromDisk() {
        File objFile = new File("dist/StaffMembers.dat");
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
                }
                return ("Successfully loaded " + getStaffMembers().size() + " staff members");
            } catch (Exception ex) {
                return ("Data file could not be read " + ex.getMessage());
            }
        } else {
            return ("Data file could not be found");
        }
    }
    
    @Override
    public String saveToDisk() {
        File objFile = new File("dist/StaffMembers.dat");
        try (ObjectOutputStream objOut = new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(objFile)))) {
            objOut.writeObject(staffList);
            return ("Successfully saved " + getStaffMembers().size() + " staff members");
        } catch (IOException ex) {
            return ("error: " + ex.getMessage());
        }
    }
    
    public void addStaff(Staff staff) {
        if (staffList == null) {
            staffList = new ArrayList<Staff>();
        }
        staffList.add(staff);
        notifyObservers();
    }
    
    public void removeStaff(Staff staff) {
        if (staffList == null) return;
        if (staffList.contains(staff)) {
            staffList.remove(staff);
            notifyObservers();
        }
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
