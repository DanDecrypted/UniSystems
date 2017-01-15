/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.car;

import car.Car;
import commands.staff.*;
import command.interfaces.ICommandBehaviour;
import people.Administrator;
import people.Staff;

/**
 *
 * @author najimmazidi
 */
public class DeleteCarCommand implements ICommandBehaviour {
    private Administrator admin = null;
    private Car carToRemove = null;
    
    public DeleteCarCommand(Administrator admin, Car car) {
        this.admin = admin;
        this.carToRemove = car;
    }

    @Override
    public Boolean doCommand() {
        Boolean blnCompleted = false;
        if(this.isValid()){
            this.admin.removeCar(carToRemove);
            blnCompleted = true;
        }
        return blnCompleted;
    }

    @Override
    public Boolean undoCommand() {
        Boolean blnCompleted = false;
        if(this.isValid()){
            this.admin.createCar(carToRemove);
            blnCompleted = true;
        }
        return blnCompleted;
    }
    public Boolean isValid(){
        Boolean blnValid = false;
        if(null != this.carToRemove){
            blnValid = true;
        }
        return blnValid;
    }
}
