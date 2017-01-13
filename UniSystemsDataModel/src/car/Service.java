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
 * Service structure.
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class Service extends data.Observed implements java.io.Serializable{
    private String mechanic;
    private ArrayList<String> repairs;
    private String summary;
    private Date dateOfService;
    
    /**
     * Constructor of a service
     * @param mechanic the mechanic that did the service
     * @param repairs the list of repairs of the service 
     * @param summary the summary of the service.
     */
    public Service(String mechanic, ArrayList<String> repairs, String summary, Date date) {
        this.mechanic = mechanic;
        this.repairs = repairs;
        this.dateOfService = date;
        this.summary = summary;
    }

    
    /**
     * Gets the summary of the service.
     * @return String
     */
    public String getSummary() {
        return summary;
    }
    
    /**
     * Gets the mechanic of the service.
     * @return String
     */
    public String getMechanic(){
        return mechanic;
    }
    
    /**
     * Gets the repairs of the service
     * @return Array list of strings.
     */
    public ArrayList<String> getRepairs(){
        return repairs;
    }
    
    /**
     * Adds a repair to the list of repairs.
     * @param repair 
     */
    public void addRepair(String repair) {
        if (repairs == null) repairs = new ArrayList<String>();
        repairs.add(repair);
        this.notifyObservers();
    }
    
    /**
     * Gets the date of the service.
     * @return 
     */
    public Date getDateOfService(){
        return dateOfService;
    }
}
