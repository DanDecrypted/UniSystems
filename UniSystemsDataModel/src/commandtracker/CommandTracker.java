/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandtracker;

import command.interfaces.ICommand;
import command.interfaces.ICommandTracker;
import java.util.Stack;

/**
 *
 * @author najimmazidi
 */
public class CommandTracker implements ICommandTracker {
    private Stack<ICommand> stkDone = new Stack<>();
    private Stack<ICommand> stkUndone = new Stack<>();
    
    @Override
    public Boolean executeCommand(ICommand objCommand){
        Boolean blnExecuted = false;
        if (null != objCommand){
            if (objCommand.doCommand()) {
                this.stkDone.push(objCommand);
                blnExecuted = true;
            }
        }
        return blnExecuted;
    }

    @Override
    public Boolean undoLastCommand() {
        Boolean blnUndone = false;
        if (this.isUndoable()) {
            ICommand lastCommand = this.stkDone.pop();
            if (lastCommand.undoCommand()){
                this.stkUndone.push(lastCommand);
                blnUndone = false;
            }
        }
        return blnUndone;
    }

    @Override
    public Boolean redoLastCommand() {
        Boolean blnDone = false;
        if (this.isRedoable()) {
            ICommand lastCommand = this.stkUndone.pop();
            if (lastCommand.undoCommand()){
                this.stkDone.push(lastCommand);
                blnDone = false;
            }
        }
        return blnDone;
    }

    @Override
    public Boolean isUndoable() {
        Boolean blnCanUndo = false;
        if (!this.stkDone.empty()){
            blnCanUndo = true;
        }
        return blnCanUndo;
    }

    @Override
    public Boolean isRedoable() {
        Boolean blnCanRedo = false;
        if (!this.stkUndone.empty()){
            blnCanRedo = true;
        }
        return blnCanRedo;
    }
    
}
