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
public class DeleteStaffCommand implements ICommandBehaviour {
        private Administrator admin = null;
    private Staff staffToRemove = null;
    
    public DeleteStaffCommand(Administrator admin, Staff staff) {
        this.admin = admin;
        this.staffToRemove = staff;
    }
    /**
     * Do command called when action is done or redone
     * @return boolean to check if action was carried out
     */
    @Override
    public Boolean doCommand() {
        Boolean blnCompleted = false;
        if(this.isValid()){
            this.admin.removeStaffMember(staffToRemove);
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
            this.admin.createStaffMember(staffToRemove);
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
        if(null != this.staffToRemove){
            blnValid = true;
        }
        return blnValid;
    }
}
