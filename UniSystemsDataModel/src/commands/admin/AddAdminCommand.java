/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.admin;

import command.interfaces.ICommandBehaviour;
import people.Administrator;
import people.Staff;

/**
 *
 * @author najimmazidi
 */
public class AddAdminCommand implements ICommandBehaviour {
    
    private Administrator admin = null;
    private Staff adminToAdd = null;
    
    public AddAdminCommand(Administrator admin, Staff staff) {
        this.admin = admin;
        this.adminToAdd = staff;
    }

    @Override
    public Boolean doCommand() {
        Boolean blnCompleted = false;
        if(this.isValid()){
            this.admin.createAdministrator(admin);
            blnCompleted = true;
        }
        return blnCompleted;
    }

    @Override
    public Boolean undoCommand() {
        Boolean blnCompleted = false;
        if(this.isValid()){
            this.admin.removeAdministrator(admin);
            blnCompleted = true;
        }
        return blnCompleted;
    }
    public Boolean isValid(){
        Boolean blnValid = false;
        if(null != this.adminToAdd){
            blnValid = true;
        }
        return blnValid;
    }
    
    
}
