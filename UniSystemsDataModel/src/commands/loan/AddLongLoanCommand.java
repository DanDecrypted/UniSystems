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
import loaning.LongLoan;
import people.Administrator;
import people.Staff;

/**
 *
 * @author najimmazidi
 */
public class AddLongLoanCommand implements ICommandBehaviour {
    
    private Administrator admin = null;
    private Car carToLoan = null;
    private Staff staff = null;
    private LongLoan longLoan = null;
    
    public AddLongLoanCommand(Administrator admin, Car car, Staff staff) {
        this.admin = admin;
        this.carToLoan = car;
        this.staff = staff;
        
    }

    @Override
    public Boolean doCommand() {
        Boolean blnCompleted = false;
        if(this.isValid()){
            this.longLoan = this.admin.assignLongLoan(carToLoan, staff);
            blnCompleted = true;
        }
        return blnCompleted;
    }

    @Override
    public Boolean undoCommand() {
        Boolean blnCompleted = false;
        if(this.isValid()){
            this.admin.cancelLoan(carToLoan, (Loan)longLoan);
            blnCompleted = true;
        }
        return blnCompleted;
    }
    public Boolean isValid(){
        Boolean blnValid = false;
        if(null != this.carToLoan && null != this.staff){ 
            blnValid = true;
        }
        return blnValid;
    }
    
    
}
