package com.cefalo.commandpattern.receiver;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Raquibul on 11/23/2016.
 */
public class CustomList
{
    List<String> list;
    public CustomList()
    {
        list = new ArrayList<String>();
    }

    public void add(String itemToAdd){
        list.add(itemToAdd);
    }

    public String read(int index){
        if(list.size() > index)
            return list.get(index);
        return null;
    }

    public String remove(){
        if(list.size() > 0) {
            return list.remove(list.size()-1);
        }
        return null;
    }



    public void update(int index, String updateData){
        if(list.size() > index) {            
            list.set(index, updateData);
        }
    }


    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("CustomList{");
        sb.append("list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
