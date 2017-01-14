/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandtracker;

import command.interfaces.ICommand;
import command.interfaces.ICommandBehaviour;

/**
 *
 * @author najimmazidi
 */
public class Command implements ICommand {

    private ICommandBehaviour delegate;
    private Boolean blnExecuted = false;
    
    /**
     * Constructor to wrap ICOmmandBehaviour object
     * @param objCommand - A Command behaviour to wrap 
     */
    public Command(ICommandBehaviour objCommand) {
        this.delegate = objCommand;
    }
    
    @Override
    public Boolean isExecuted() {
        return this.blnExecuted;
    }
    
    @Override
    public Boolean setExecuted(Boolean flag) {
        Boolean blnResult = false;
        if(null != flag) {
            this.blnExecuted = flag;
            blnResult = flag;
        }
        return blnResult;
    } 
    @Override
    public Boolean isUndone() {
        return !this.blnExecuted;
    }
    
    @Override
    public Boolean doCommand() {
        Boolean done = false;
        done = this.delegate.doCommand();
        this.blnExecuted = done;
        return done;
    }
    
    @Override 
    public Boolean undoCommand() {
        Boolean undone = false;
        undone = this.delegate.undoCommand();
        this.blnExecuted = !undone;
        return undone;
    }
    
}
