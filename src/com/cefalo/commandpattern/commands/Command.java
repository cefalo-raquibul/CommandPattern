package com.cefalo.commandpattern.commands;

/**
 * Created by Raquibul on 11/23/2016.
 */
public interface Command
{
    void execute();

    void undo();
}
