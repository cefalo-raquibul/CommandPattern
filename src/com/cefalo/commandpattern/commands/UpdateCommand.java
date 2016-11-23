package com.cefalo.commandpattern.commands;

import com.cefalo.commandpattern.receiver.CustomList;


/**
 * Created by Raquibul on 11/23/2016.
 */
public class UpdateCommand implements Command
{

    CustomList list;
    String updateParam;
    int index;
    String currentValue;


    public UpdateCommand(CustomList list, int index, String updateData)
    {
        this.list = list;
        this.updateParam = updateData;
        this.index = index;
    }


    @Override
    public void execute()
    {
        currentValue = list.read(index);
        list.update(index, updateParam);
    }


    @Override
    public void undo()
    {
        if (currentValue != null) {
            list.update(index, currentValue);
        }
    }
}
