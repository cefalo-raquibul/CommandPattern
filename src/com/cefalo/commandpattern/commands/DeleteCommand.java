package com.cefalo.commandpattern.commands;

import com.cefalo.commandpattern.receiver.CustomList;


/**
 * Created by Raquibul on 11/23/2016.
 */
public class DeleteCommand implements Command
{

    CustomList list;
    String removedItem;


    public DeleteCommand(CustomList list)
    {
        this.list = list;

    }


    @Override
    public void execute()
    {
        this.removedItem = list.remove();
    }


    @Override
    public void undo()
    {
        if (removedItem != null) {
            list.add(removedItem);
        }
    }
}
