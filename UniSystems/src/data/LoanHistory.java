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
import model.loaning.Loan;

/**
 *
 * @author Craig
 */
public class LoanHistory {
    private ArrayList<Loan> loanList;
    private static LoanHistory loanHistory;
    
    public static LoanHistory getInstance(){
        if (loanHistory == null){
            loanHistory = new LoanHistory();
        }
        return loanHistory;
    }   
    
    public void loadFromDisk() {
        File objFile = new File("Cars.dat");
        if (objFile.exists() && objFile.canRead()) {
            try (ObjectInputStream objIn = new ObjectInputStream(
                  new BufferedInputStream(
                  new FileInputStream(objFile)))) {
                Object objData = objIn.readObject();
                ArrayList<Loan> newList = (ArrayList)objData;
                if (newList != null) {
                    loanList = newList;
                    System.out.println("Successfully loaded " + loanList.size() + " Loans");
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
            objOut.writeObject(loanList);
            System.out.println("Successfully saved " + loanList.size() + " Loans");
        } catch (IOException ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
    
    public void addCar(Loan loan) {
        if (loanList == null) {
            loanList = new ArrayList<Loan>();
        }
        loanList.add(loan);
    }
    
    public void removeCar(Loan loan) {
        if (loanList == null) return;
        loanList.remove(loan);
    }
}

