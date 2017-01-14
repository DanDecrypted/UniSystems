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
public interface ICommandBehaviour {
    
    /**
     * Executes this command behaviour
     * @return Boolean True if the command completed successfully, False otherwise
     */
    Boolean doCommand();
    
    /**
     * Reverses the command behaviour cancelling its effects
     * @return Boolean True if the commend was undone, False otherwise
     */
    Boolean undoCommand();
    
}
