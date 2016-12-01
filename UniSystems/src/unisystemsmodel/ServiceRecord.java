/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package unisystemsmodel;
import java.util.Date;

/**
 *
 * @author Craig Banyard, Daniel Scott & Najim Mazidi
 */
public class ServiceRecord {
    private Date dateOfService;
    private List<String> repairs;
    private String mechanic;
    
    public ServiceRecord(List<String> repairs, String mechanic) {
        
    }

    public ServiceRecord(Date dateOfService, List<String> repairs, String mechanic) {
        this.dateOfService = dateOfService;
        this.repairs = repairs;
        this.mechanic = mechanic;
    }

    public Date getDateOfService() {
        return this.dateOfService;
    }

    public List<String> getRepairs() {
        List<String> repairsList;
        for (String repair : repairs) {
            repairsList.add(repair);
        }
        return repairsList;
    }

    public void setMechanic(String mechanic){
        this.mechanic = mechanic;
    }

    public void addRepair(String repair) {
        this.repairs.add(repair);
    }
}
