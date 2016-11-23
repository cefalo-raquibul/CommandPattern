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
        String value = list.read(index);
        System.out.println("Value in index "+index+" is "+value);
    }


    @Override
    public void undo()
    {
        System.out.println("Nothing to redo");
    }
}
