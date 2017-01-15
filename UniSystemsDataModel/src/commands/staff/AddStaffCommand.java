/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.staff;

import command.interfaces.ICommandBehaviour;
import people.Administrator;
import people.Staff;

/**
 *
 * @author najimmazidi
 */
public class AddStaffCommand implements ICommandBehaviour {
    
    private Administrator admin = null;
    private Staff staffToAdd = null;
    
    public AddStaffCommand(Administrator admin, Staff staff) {
        this.admin = admin;
        this.staffToAdd = staff;
    }
    /**
     * Do command called when action is done or redone
     * @return boolean to check if action was carried out
     */
    @Override
    public Boolean doCommand() {
        Boolean blnCompleted = false;
        if(this.isValid()){
            this.admin.createStaffMember(this.staffToAdd);
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
        if(this.isValid()){
            this.admin.removeStaffMember(staffToAdd);
            blnCompleted = true;
        }
        return blnCompleted;
    }
    /**
     * Checks if operation is allowed to be done 
     * @return Boolean to check if is valid 
     */
    public Boolean isValid(){
        Boolean blnValid = false;
        if(admin.getStaffForRefNumb(staffToAdd.getRefNumb()) == null){ //staff doesn't exist
            blnValid = true; 
        }
        return blnValid;
    }
    
    
}
