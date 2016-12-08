/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package car;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Service implements java.io.Serializable{
    private String mechanic;
    private ArrayList<String> repairs;
    private String summary;
    private Date dateOfService;
    
    public Service(String mechanic, ArrayList<String> repairs, String summary) {
        this.mechanic = mechanic;
        this.repairs = repairs;
        this.dateOfService = new Date();
        this.summary = summary;
    }
    
    public String getSummary() {
        return summary;
    }
    
    public String getMechanic(){
        return mechanic;
    }
    
    public ArrayList<String> getRepairs(){
        return repairs;
    }
    
    public Date getDateOfService(){
        return dateOfService;
    }
}
