package com.cefalo.commandpattern.commands;

import com.cefalo.commandpattern.receiver.CustomList;


/**
 * Created by Raquibul on 11/23/2016.
 */
public class ReadCommand implements Command
{

    CustomList list;
    int index;


    public ReadCommand(CustomList list, int index)
    {
        this.list = list;
        this.index = index;
    }


    @Override
    public void execute()
    {
        list.read(index);
    }


    @Override
    public void undo()
    {
        System.out.println("Not supported");
    }
}
