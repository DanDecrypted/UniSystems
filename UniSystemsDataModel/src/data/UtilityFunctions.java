/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import loaning.DayLoan;
import loaning.Loan;
import loaning.LongLoan;

/**
 * Class to modify data/representations.
 * @author dansc
 */
public class UtilityFunctions {
    
    /**
     * Modifies the display of a date to be coherent. 
     * As far as I know the JDK does not offer such functionality.
     * @param date date to format
     * @return a string in a nice format
     */
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
    
    /**
     * From a list of loans, we get a list of day loans
     * @param loans loans to filter
     * @return a list of day loans
     */
    public static ArrayList<DayLoan> getDayLoans(ArrayList<Loan> loans) {
        ArrayList<DayLoan> temp = new ArrayList<DayLoan>();
        for (Loan loan : loans) {
            try {
                temp.add((DayLoan)loan);
            } catch (Exception ex) { System.out.println("Cannot cast this loan to a day loan"); }
        }
        return temp;
    }
    
    /**
     * From a list of loans, we get a list of long loans
     * @param loans loans to filter
     * @return a list of long loans
     */
    public static ArrayList<LongLoan> getLongLoans(ArrayList<Loan> loans) {
        ArrayList<LongLoan> temp = new ArrayList<LongLoan>();
        for (Loan loan : loans) {
            try {
                temp.add((LongLoan)loan);
            } catch (Exception ex) { System.out.println("Cannot cast this loan to a long loan"); } 
        }
        return temp;
    }
    
    /**
     * Modifies the display of a DOB to be coherent. 
     * As far as I know the JDK does not offer such functionality.
     * @param date date to format
     * @return a string in a nice format
     */
    public static String formatDateOfBirth(Date date) {
        String returns = "";
        int month = date.getMonth();
        int year = date.getYear();
        returns += " " + date.getDate()+ "/"
                + month + "/" 
                + year ;
        return returns;
    }
    
    /**
     * Formats an enumerator
     * @param str string to format
     * @return a string without all the underscores.
     */
    public static String formatEnum(String str) {
        char[] array = str.toCharArray();
        String formatted;
        for (int i = 1; i < array.length; i++) {
            
                array[i] = Character.toLowerCase(array[i]);
        }
        formatted = new String(array);
        formatted = formatted.replaceAll("_", " ");
        return formatted;
    }
}
