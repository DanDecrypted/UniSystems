/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.util.ArrayList;
import java.util.Date;
import loaning.DayLoan;
import loaning.Loan;
import loaning.LongLoan;

/**
* Watch this space, gonna submit it to the shit people that developed
* the JDK.
* @param date
* @return a string in a format that actually makes sense.
*/
public class UtilityFunctions {
    
    public static String formatDate(Date date) {
        String returns = "";
        int month = date.getMonth() + 1;
        int year = date.getYear() + 1900;
        returns += " " + date.getDate()+ "/"
                + month + "/"
                + year + " ";
        returns += date.getHours() + ":"
                + date.getMinutes();
        return returns;
    }
    
    public ArrayList<DayLoan> getDayLoans(ArrayList<Loan> loans) {
        ArrayList<DayLoan> temp = new ArrayList<DayLoan>();
        for (Loan loan : loans) {
            try {
                temp.add((DayLoan)loan);
            } catch (Exception ex) { System.out.println("Cannot cast this loan to a day loan"); }
        }
        return temp;
    }
    
    public ArrayList<LongLoan> getLongLoans(ArrayList<Loan> loans) {
        ArrayList<LongLoan> temp = new ArrayList<LongLoan>();
        for (Loan loan : loans) {
            try {
                temp.add((LongLoan)loan);
            } catch (Exception ex) { System.out.println("Cannot cast this loan to a long loan"); } 
        }
        return temp;
    }
    
    public static String formatDateOfBirth(Date date) {
        String returns = "";
        int month = date.getMonth();
        int year = date.getYear();
        returns += " " + date.getDate()+ "/"
                + month + "/" 
                + year ;
        return returns;
    }
}
