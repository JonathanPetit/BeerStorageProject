package com.company.controller;

<<<<<<< HEAD
//import Inventory
import com.company.views.*;
import com.company.model.*;
=======
import com.company.model.*;

import java.util.*;
import java.sql.Connection;
import java.lang.reflect.*;
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250


public class Controller {
    private Hashtable<String, ArrayList<String>> commandsList;

    public Controller(){
        this.commandsList = new Hashtable<String, ArrayList<String>>();
    }

    public void addCommands(String key, ArrayList<String> options) {
        this.commandsList.put(key, options);
    }

    private void help(){
        System.out.println("Help method");
    }

    private void exit() {
        System.exit(0);
    }

<<<<<<< HEAD
    public ArrayList<String> parseCommand(String elements) {
        ArrayList<String> parserReturn = new ArrayList<>();
=======
    private ArrayList<String> parseCommand(String elements) {
        String options = "";
        ArrayList<String> parserReturn = new ArrayList<String>();
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
        elements = elements.trim();
        String[] parseElement = elements.split("\\s+'");

        if (parseElement.length < 1) {
            System.out.println("Please enter a command");
            return parserReturn;
        }

        String command = parseElement[0];
        if (!this.commandsList.containsKey(command)) {
            System.out.println("Command invalid");
            parserReturn.add("help");
            return parserReturn;
        } else {
            ArrayList validOption = this.commandsList.get(command);
            parserReturn.add(command);

            if (validOption.size() == 0) {
                return parserReturn;
            }

            try {
                options = parseElement[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please enter a option");
                return parserReturn;
            }

            if (!validOption.contains(options)) {
                System.out.println("Option invalid");
                return parserReturn;
            }

            parserReturn.add(options);

            if (parseElement[2] != null) {
                parserReturn.add(parseElement[2]);
            }

            return parserReturn;
        }
    }

    private boolean reflexionElement(ArrayList<String> parseCommand) {
        try {
            Class c = this.getClass();
            Method m = c.getDeclaredMethod(parseCommand.get(0));
            System.out.print(m);
        } catch (NoSuchMethodException e) {
            this.exit();
        }
        return true;
    }

    private boolean add(ArrayList<String> parseCommand) {
        return false;
    }

    private boolean edit(ArrayList<String> parseCommand) {
        return false;
    }

    private boolean remove(ArrayList<String> parsedCommand) {
        return false;
    }

    private boolean info(ArrayList parsedCommand) {
        return false;
    }

    public void run(){
        Inventory inventory = new Inventory();

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(">> ");
            String command = scanner.nextLine();
            ArrayList<String> parseCommand = this.parseCommand(command);
            for (int i = 0; i < parseCommand.size(); i++) {
                System.out.println(parseCommand.get(i));
            }

            this.reflexionElement(parseCommand);
        }
    }
    

     /* Tentative d'invocation de méthode par réflexion .... pour lancer la méthode à partir de son nom */
    /*public boolean test(String[] elements){
        String[] validOptions = this.commandsList.get(elements[0]);
        boolean valid = false;

        try{
            valid = Arrays.asList(validOptions).contains(elements[1]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Option invalide");
            return false;
        }

        if(!valid) {
            System.out.println("Option invalide");
            return false;
        }
        else {
            //Class[] typeParameters = new Class[];
            try{
                Method m = this.getClass().getDeclaredMethod("edit", null);
                if (Modifier.isStatic(m.getModifiers())) {
                    m.invoke(new Controller(this.view), null);
                    System.out.println(this.getClass().getMethod("edit", null));
                    return true;
                }
            }
            catch(NoSuchMethodException e){
                    System.out.println("No such method");
                }
        }
    }*/

}
