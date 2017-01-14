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
public interface ICommandTracker {
    /**
     * Executes the provided command and if it completes adds it to the collection
     * of executed commands being tracked
     * @param objACommand - Interface to the command object to execute
     * @return Boolean True if command completed and was added to the 
     * collection of executed commands, False otherwise.
     */
    Boolean executeCommand(ICommand objACommand);
    /**
     * This method reverses the last command added to the collection of executed commands.
     * Repeated calls to this method will provide an in order reversal of executed commands.
     * Undone commands will be added to their own collection
     * @return Boolean True if a command was reversed, False otherwise.
     */
    Boolean undoLastCommand();
    /**
     * This method executes the last command added to the collection of undone commands.
     * @return Boolean True if a previously undone command was re-executed, False otherwise
     */
    Boolean redoLastCommand();
    /**
     * This method tests if a call to undoLastCommand will find a command that can be undone.
     * @return Boolean True if a executed command exists that can be undone, False otherwise.
     */
    Boolean isUndoable();
    /**
     * This method tests if a call to redoLastCommand will find a command that can be executed.
     * @return Boolean True if a undone command exists that can be executed, False otherwise.
     */
    Boolean isRedoable();
}
