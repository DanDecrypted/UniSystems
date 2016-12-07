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
import loaning.Loan;

/**
 *
 * @author Craig
 */
public class Loans implements ISerialisable{
    private ArrayList<Loan> loanList;
    private static final Loans loans = new Loans();
    
    private Loans() { }
    
    public static Loans getInstance(){
        return loans;
    }   
    
    public String loadFromDisk() {
        File objFile = new File("Loans.dat");
        if (objFile.exists() && objFile.canRead()) {
            try (ObjectInputStream objIn = new ObjectInputStream(
                  new BufferedInputStream(
                  new FileInputStream(objFile)))) {
                Object objData = objIn.readObject();
                ArrayList<Loan> newLoanList = (ArrayList)objData;
                if (newLoanList != null) {
                    loanList = newLoanList;
                }    
                return ("Successfully loaded " + getLoans().size() + " Loans");
            } catch (Exception ex) {
                return("Data file could not be read " + ex.getMessage());
            }
        } else {
            return ("Data file could not be found!");
        }
    }
    
    public String saveToDisk() {
        File objFile = new File("Loans.dat");
        try (ObjectOutputStream objOut = new ObjectOutputStream(
                new BufferedOutputStream(
                new FileOutputStream(objFile)))) {
            
            objOut.writeObject(loanList);
            
            return ("Successfully saved " + getLoans().size() + " Loans");
        } catch (IOException ex) {
            return ("error: " + ex.getMessage());
        }
    }
    
    public ArrayList<Loan> getLoans() {
        if (loanList == null) return new ArrayList<Loan>();
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

