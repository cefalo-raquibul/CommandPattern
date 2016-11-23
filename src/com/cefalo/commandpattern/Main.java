package com.cefalo.commandpattern;

import com.cefalo.commandpattern.commands.AddCommand;
import com.cefalo.commandpattern.commands.Command;
import com.cefalo.commandpattern.commands.DeleteCommand;
import com.cefalo.commandpattern.commands.ReadCommand;
import com.cefalo.commandpattern.commands.UpdateCommand;
import com.cefalo.commandpattern.invoker.CommandInvoker;
import com.cefalo.commandpattern.receiver.CustomList;

import java.util.Scanner;


public class Main
{

    public static void main(String[] args)
    {
        // write your code here
        CustomList customList = new CustomList();
        CommandInvoker commandInvoker = new CommandInvoker();


        printHelp();

        Scanner s = new Scanner(System.in);
        while (true) {
            String command = s.nextLine();
            String[] splitted = command.split(" ");
            if (splitted.length > 0) {
                if (splitted[0].equalsIgnoreCase("undo")) {
                    commandInvoker.undo();
                }
                else if (splitted[0].equalsIgnoreCase("help")) {
                    printHelp();
                }
                else if (splitted[0].equalsIgnoreCase("redo")) {
                    commandInvoker.redo();
                }
                else if (splitted[0].equalsIgnoreCase("exit")) {
                    break;
                }
                else if (splitted[0].equalsIgnoreCase("add")) {
                    if (splitted.length >= 2) {
                        Command add = new AddCommand(customList, splitted[1]);
                        commandInvoker.execute(add);
                    }
                }
                else if (splitted[0].equalsIgnoreCase("del")) {
                    Command delete = new DeleteCommand(customList);
                    commandInvoker.execute(delete);

                }
                else if (splitted[0].equalsIgnoreCase("up")) {
                    if (splitted.length >= 3) {
                        try {
                            int index = Integer.parseInt(splitted[1]);
                            Command update = new UpdateCommand(customList, index, splitted[2]);
                            commandInvoker.execute(update);
                        }
                        catch (Exception ex) {

                        }
                    }
                }
                else if (splitted[0].equalsIgnoreCase("read")) {
                    if (splitted.length >= 2) {
                        try {
                            int index = Integer.parseInt(splitted[1]);
                            Command readCommand = new ReadCommand(customList, index);
                            commandInvoker.execute(readCommand);
                        }
                        catch (Exception ex) {

                        }
                    }
                }
                System.out.println(customList.toString());

            }
        }

    }


    static void printHelp()
    {
        System.out.println("");
        System.out.println("available commands : add, del, up, undo, redo, read, exit, help");
        System.out.println("To undo: undo");
        System.out.println("To Redo: redo");
        System.out.println("add command example: add str1");
        System.out.println("update command example(up {index} newupdatevalue):  up 1 str2");
        System.out.println("Delete command example:  del");
        System.out.println("Read command example(read {index}):  read 1");
        System.out.println("");
    }
}
