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

/**
 *
 * @author najimmazidi
 */
public class ReturnCarCommand implements ICommandBehaviour {
    
    private Administrator admin = null;
    private Car carToReturn = null;
    private Loan loan = null;

    
    public ReturnCarCommand(Administrator admin, Car car, Loan loan) {
        this.admin = admin;
        this.carToReturn = car;
        this.loan = loan;
        
    }

    @Override
    public Boolean doCommand() {
        Boolean blnCompleted = false;
        if(this.isValid()){
            this.admin.returnCar(carToReturn, loan);
            blnCompleted = true;
        }
        return blnCompleted;
    }

    @Override
    public Boolean undoCommand() {
        Boolean blnCompleted = false;
        if(this.isValid()){
            try {
                DayLoan dayLoan = (DayLoan)loan;
                this.admin.assignDayLoan(carToReturn, admin);
            } catch (Exception ex) {}
            try {
                LongLoan longLoan = (LongLoan)loan;
                this.admin.assignLongLoan(carToReturn, admin);
            } catch (Exception ex) {}
            
            blnCompleted = true;
        }
        return blnCompleted;
    }
    public Boolean isValid(){
        Boolean blnValid = false;
        if(null != this.carToReturn){ 
            blnValid = true;
        }
        return blnValid;
    }
    
    
}
