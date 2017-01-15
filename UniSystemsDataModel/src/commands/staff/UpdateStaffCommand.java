
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
    private Staff staffToRestore = null;
    private String staffID = null;
    
    public UpdateStaffCommand(Administrator admin, Staff staff, Staff oldStaff){
        this.admin = admin;
        this.staffToUpdate = staff;
        this.staffID = staff.getRefNumb();
        this.staffToRestore = oldStaff;
    }

    @Override
    public Boolean doCommand() {
        Boolean blnCompleted = false;
        if (this.isValid()){
            //this.staffToRestore = admin.getStaffForRefNumb(this.staffID);
            this.admin.removeStaffMember(admin.getStaffForRefNumb(this.staffToUpdate.getRefNumb()));
            this.admin.createStaffMember(staffToUpdate);
            blnCompleted = true;
        }
        return blnCompleted;
    }

    @Override
    public Boolean undoCommand() {
        Boolean blnCompleted = false;
        if (this.isValid()){
            this.admin.removeStaffMember(admin.getStaffForRefNumb(this.staffToUpdate.getRefNumb()));
            this.admin.createStaffMember(this.staffToRestore);
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
