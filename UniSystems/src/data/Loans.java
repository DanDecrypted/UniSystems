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
public class Loans implements java.io.Serializable{
    private ArrayList<Loan> loanList;
    private static Loans loans;
    
    public Loans() {
        
    }
    
    public static Loans getInstance(){
        if (loans == null){
            loans = new Loans();
        }
        return loans;
    }   
    
    public static String loadFromDisk() {
        File objFile = new File("Loans.dat");
        if (objFile.exists() && objFile.canRead()) {
            try (ObjectInputStream objIn = new ObjectInputStream(
                  new BufferedInputStream(
                  new FileInputStream(objFile)))) {
                Object objData = objIn.readObject();
                Loans newObj = (Loans)objData;
                if (newObj != null) {
                    loans = newObj;
                }    
                return ("Successfully loaded " + Loans.getInstance().getLoans().size() + " Loans");
            } catch (Exception ex) {
                return("Data file could not be read " + ex.getMessage());
            }
        } else {
            return ("Data file could not be found!");
        }
    }
    
    public static String saveToDisk() {
        File objFile = new File("Cars.dat");
        try (ObjectOutputStream objOut = new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(objFile)))) {
            objOut.writeObject(loans);
            return ("Successfully saved " + Loans.getInstance().getLoans().size() + " Loans");
        } catch (IOException ex) {
            return ("error: " + ex.getMessage());
        }
    }
    
    public ArrayList<Loan> getLoans() {
        ArrayList<Loan> temp = new ArrayList<Loan>();
        for (Loan loan : loanList) {
            temp.add(loan);
        }
        return temp;
    }
    
    public void addLoan(Loan loan) {
        if (loanList == null) {
            loanList = new ArrayList<Loan>();
        }
        loanList.add(loan);
    }
    
    public void removeLoan(Loan loan) {
        if (loanList == null) return;
        loanList.remove(loan);
    }
}

