/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

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

    @Override
    public Boolean doCommand() {
        Boolean blnCompleted = false;
        if(this.isValid()){
            this.admin.removeStaffMember(staffToRemove);
            blnCompleted = true;
        }
        return blnCompleted;
    }

    @Override
    public Boolean undoCommand() {
        Boolean blnCompleted = false;
        if(this.isValid()){
            this.admin.createStaffMember(staffToRemove);
            blnCompleted = true;
        }
        return blnCompleted;
    }
    public Boolean isValid(){
        Boolean blnValid = false;
        if(null != this.staffToRemove){
            blnValid = true;
        }
        return blnValid;
    }
}
