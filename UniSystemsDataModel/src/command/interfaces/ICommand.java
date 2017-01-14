/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.interfaces;

/**
 *
 * @author najimmazidi
 */
public interface ICommand extends ICommandBehaviour {
    /**
     * Accessor to test if this command has been executed
     * @return Boolean True if this command has been executed and not undone,
     * False otherwise
     */
    Boolean isExecuted();
    /**
     * Accessor to set the boolean flag which indicates if this command has been executed
     * @param flag - Boolean being the new value for the flag
     * @return Boolean True if the flag was set to the value given, False otherwise
     */
    Boolean setExecuted(Boolean flag);
    /**
     * Accessor to test if this command has been undone
     * @return Boolean True if this command has NOT been executed or if it
     * was undone after execution, False otherwise.
     */
    Boolean isUndone();
    
}
