package com.cefalo.commandpattern.invoker;

import com.cefalo.commandpattern.commands.Command;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Raquibul on 11/23/2016.
 */
public class CommandInvoker
{
    List<Command> commandHistory;
    List<Command> undoHistory;


    public CommandInvoker()
    {
        this.commandHistory = new ArrayList<Command>();
        this.undoHistory = new ArrayList<Command>();
    }


    public void execute(Command command)
    {
        if (redoing == true) {
            undoHistory.clear();
            redoing = false;
        }
        commandHistory.add(command);
        command.execute();

    }


    public void undo()
    {
        if (commandHistory.size() > 0) {
            Command command = commandHistory.remove(commandHistory.size() - 1);
            undoHistory.add(command);
            command.undo();
        }
        else {
            System.out.println("Nothing to undo");
        }

    }


    boolean redoing = false;


    public void redo()
    {

        if (undoHistory.size() > 0) {
            redoing = true;
            Command command = undoHistory.remove(undoHistory.size() - 1);
            commandHistory.add(command);
            command.execute();
        }
        else {
            System.out.println("Nothing to redo");
        }
    }


}
