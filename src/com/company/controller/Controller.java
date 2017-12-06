package com.company.controller;
import java.util.Hashtable;
import java.util.Map;
import java.util.Arrays;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

//import Inventory
import com.company.views.View;
import com.company.model.Brouwer;


public class Controller {

    //private Database model;
    private View view;
    public Map<String, String[]> commandsList = new Hashtable<String, String[]>();
    public String[] options = {"--beer", "--brand", "--brewer"};

    public Controller(View view){
        //this.model = model;
        this.view = view;
        this.commandsList.put("add", options);
        this.commandsList.put("edit", options);
        this.commandsList.put("info", options);
    }


    public boolean parseCommand(String[] elements){

        if(elements.length < 1 ||
                elements.length > 3 ||
                !this.commandsList.containsKey(elements[0]) ){
            System.out.println("Commande invalide - Tapez 'help' pour plus d'aide");
            return false;
        }
        else{
            // Get the valid options of the command according to the collection 'commandList'
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
            else{

                switch (elements[0]){
                    case "add":
                        this.add(elements[1]);
                        break;
                    case "edit":
                        this.edit(elements[1]);
                        break;
                    case "help":
                        this.help();
                        break;
                    default:
                        break;
                }
                return true;
            }
        }
    }



    public boolean add(String option){
        switch (option){
            case "--beer":
                break;
            case "--brand":
                break;
            case "--brewer":
                Scanner scan = new Scanner(System.in);
                System.out.println("- Brasseur: ");
                Brouwer brew = new Brouwer(scan.nextLine());
                break;
        }
        return true;
    }


    public boolean edit(String option){
        return false;
    }


    public boolean help(){
        System.out.println("help method");
        return true;
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
