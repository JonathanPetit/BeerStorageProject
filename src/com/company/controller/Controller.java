package com.company.controller;
import java.util.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

//import Inventory
import com.company.views.View;
import com.company.model.Brewer;


public class Controller {
    public Hashtable<String, ArrayList<String>> commandsList;

    public Controller(){
        this.commandsList = new Hashtable<String, ArrayList<String>>();
    }

    public void addCommands(String key, ArrayList<String> options) {
        this.commandsList.put(key, options);
    }

    public boolean help(){
        System.out.println("Help method");
        return true;
    }

    public void exit() {
        System.exit(0);
    }

    public ArrayList<String> parseCommand(String elements) {
        ArrayList<String> parserReturn = new ArrayList<String>();
        elements = elements.trim();
        String[] parseElement = elements.split("\\s+'");

        if (parseElement.length > 3) {
            System.out.println("Invalid input");
            this.exit();
        }

        String command = parseElement[1];
        String options = parseElement[2];
        if (!this.commandsList.containsKey(command)) {
            System.out.println("Command invalid");
            this.exit();
        } else {
            ArrayList validOption = this.commandsList.get(command);
            if (!validOption.contains(options)) {
                System.out.println("Option invalid");
                this.exit();
            }
        }

        parserReturn.add(command);
        parserReturn.add(options);
        parserReturn.add(parseElement[3]);
        return parserReturn;
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
