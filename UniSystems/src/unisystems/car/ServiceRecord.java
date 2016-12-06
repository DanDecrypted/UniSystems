/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package unisystems.car;
import java.util.ArrayList;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class ServiceRecord implements java.io.Serializable{
    private ArrayList<Service> record;
    public ServiceRecord() {
        this.record = new ArrayList<Service>();
    }

    public void addService(String repair) {
        
    }
    
    /**
     * Get a copy of the service history array so that it cannot be modified.
     * @return a copy of the array.
     */
    public ArrayList<Service> getServiceRecord() {
        ArrayList<Service> temp = new ArrayList<Service>(); 
        for (Service service : record) {
            temp.add(service);
        }
        return temp;
    }
}
