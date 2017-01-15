/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.loan;

import car.Car;
import command.interfaces.ICommandBehaviour;
import loaning.DayLoan;
import loaning.Loan;
import people.Administrator;
import people.Staff;

/**
 *
 * @author najimmazidi
 */
public class AddDayLoanCommand implements ICommandBehaviour {
    
    private Administrator admin = null;
    private Car carToLoan = null;
    private Staff staff = null;
    private DayLoan dayLoan = null;
    
    public AddDayLoanCommand(Administrator admin, Car car, Staff staff) {
        this.admin = admin;
        this.carToLoan = car;
        this.staff = staff; 
    }
    /**
     * Do command called when action is done or redone
     * @return boolean to check if action was carried out
     */
    @Override
    public Boolean doCommand() {
        Boolean blnCompleted = false;
        if(this.isValid()){
            this.dayLoan = this.admin.assignDayLoan(carToLoan, staff);
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
            this.admin.cancelLoan(carToLoan, (Loan)dayLoan);
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
        if(null != this.carToLoan && null != this.staff){ 
            blnValid = true;
        }
        return blnValid;
    }
    
    
}
