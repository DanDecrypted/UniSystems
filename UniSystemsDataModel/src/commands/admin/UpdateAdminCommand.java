
package commands.admin;

import commands.staff.*;
import command.interfaces.ICommandBehaviour;
import people.Administrator;
import people.Staff;

/**
 *
 * @author najimmazidi
 */
public class UpdateAdminCommand implements ICommandBehaviour {
    private Administrator admin = null;
    private Administrator adminToUpdate = null;
    private Administrator adminToRestore = null;
    
    public UpdateAdminCommand(Administrator admin, Administrator adminToUpdate, Administrator oldAdminToUpdate){
        this.admin = admin;
        this.adminToUpdate = adminToUpdate;
        this.adminToRestore = oldAdminToUpdate;
    }
    /**
     * Do command called when action is done or redone
     * @return boolean to check if action was carried out
     */
    @Override
    public Boolean doCommand() {
        Boolean blnCompleted = false;
        if (this.isValid()){
            this.admin.removeAdministrator(admin.getAdminForRefNumb(this.adminToUpdate.getRefNumb()));
            this.admin.createAdministrator(this.adminToUpdate);
            blnCompleted = true;
        }
        return blnCompleted;
    }
    /**
     * Undo command called when action is being undone
     * @return boolean to check if action was carried out
     */
    @Override
    public Boolean undoCommand() {
        Boolean blnCompleted = false;
        if (this.isValid()){
            this.admin.removeAdministrator(admin.getAdminForRefNumb(this.adminToUpdate.getRefNumb()));
            this.admin.createAdministrator(this.adminToRestore);
            blnCompleted = true;
        }
        return blnCompleted;
    }
    /**
     * Checks if operation is allowed to be done 
     * @return Boolean to check if is valid 
     */
    private Boolean isValid(){
        Boolean blnValid = false;
        if (null != this.adminToUpdate) {
            blnValid = true;
        }
        return blnValid;
    }
    
}
