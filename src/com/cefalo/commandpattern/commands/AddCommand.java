package com.cefalo.commandpattern.commands;

import com.cefalo.commandpattern.receiver.CustomList;


/**
 * Created by Raquibul on 11/23/2016.
 */
public class AddCommand implements Command
{

    CustomList list;
    String param;


    public AddCommand(CustomList list, String param)
    {
        this.list = list;
        this.param = param;
    }


    @Override
    public void execute()
    {
        list.add(param);
    }


    @Override
    public void undo()
    {
        list.remove();
    }
}
