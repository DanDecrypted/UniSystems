
package commands.staff;

import command.interfaces.ICommandBehaviour;
import data.StaffMembers;
import people.Administrator;
import people.Staff;

/**
 *
 * @author najimmazidi
 */
public class UpdateStaffCommand implements ICommandBehaviour {
    private Administrator admin = null;
    private Staff staffToUpdate = null;
    
    public UpdateStaffCommand(Administrator admin, Staff staff){
        this.admin = admin;
        this.staffToUpdate = staff;
    }

    @Override
    public Boolean doCommand() {
        Boolean blnCompleted = false;
        if (this.isValid()){
            this.admin.removeStaffMember(admin.getStaffForRefNumb(this.staffToUpdate.getRefNumb()));
            this.admin.createStaffMember(staffToUpdate);
            blnCompleted = true;
        }
        return blnCompleted;
    }

    @Override
    public Boolean undoCommand() {
        Boolean blnCompleted = false;
        Staff tempStaff;
        if (this.isValid()){
            this.admin.removeStaffMember(this.staffToUpdate);
            this.admin.createStaffMember(staffToUpdate);
            blnCompleted = true;
        }
        return blnCompleted;
    }
    
    private Boolean isValid(){
        Boolean blnValid = false;
        if (null != this.staffToUpdate) {
            blnValid = true;
        }
        return blnValid;
    }
    
}
