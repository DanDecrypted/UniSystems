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
    /**
     * Boolean class to check if a command has been executed
     * @return boolean returns true if command executed
     */
    @Override
    public Boolean isExecuted() {
        return this.blnExecuted;
    }
    /**
     * Sets boolean to true if command is executed
     * @param flag passes true when a command executes
     * @return boolean true if command is executed 
     */
    @Override
    public Boolean setExecuted(Boolean flag) {
        Boolean blnResult = false;
        if(null != flag) {
            this.blnExecuted = flag;
            blnResult = flag;
        }
        return blnResult;
    } 
    /**
     * Class to check if command has been undone
     * @return boolean true if undo command is completed 
     */
    @Override
    public Boolean isUndone() {
        return !this.blnExecuted;
    }
    /**
     * Class to carry out a do command
     * @return returns true of command executed successfully 
     */
    @Override
    public Boolean doCommand() {
        Boolean done = false;
        done = this.delegate.doCommand();
        this.blnExecuted = done;
        return done;
    }
    /**
     * Class to carry out an undo command
     * @return returns true if command undone successfully 
     */
    @Override 
    public Boolean undoCommand() {
        Boolean undone = false;
        undone = this.delegate.undoCommand();
        this.blnExecuted = !undone;
        return undone;
    }
    
}
