/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.util.Date;

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
