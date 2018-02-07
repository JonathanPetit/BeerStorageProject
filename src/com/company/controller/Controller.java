package com.company.controller;

import com.company.Json.JsonRead;
import com.company.Json.JsonWrite;
import com.company.model.*;
import com.company.views.View;

import java.util.*;
import java.lang.reflect.*;
import java.lang.reflect.Constructor;

public class Controller {
    /*
     * Controller class, the manage of the app
     */

    private Hashtable<String, ArrayList<String>> commandsList;
    private JsonRead jsonR = new JsonRead();
    private JsonWrite jsonW = new JsonWrite();
    View view = View.getInstance();


    private Controller(){
        this.commandsList = new Hashtable<String, ArrayList<String>>();
    }

    // Create and set unique instance of Controller class. (Singleton pattern)
    private static class ControllerHolder {
        private static final Controller INSTANCE = new Controller();
    }

    // Method to get the unique instance of Controller.
    public static Controller getInstance() {
        return Controller.ControllerHolder.INSTANCE;
    }

    // Add commands to class.
    public void addCommands(String key, ArrayList<String> options) {
        this.commandsList.put(key, options);
    }

    // Help and exit methods.
    private void help(){
        System.out.println("Help method");
    }

    private void exit() {
        System.exit(0);
    }

    // Add method, add a object to json "database".
    private void add(ArrayList<String> parsedCommand) {
        // Init.
        Constructor cons;
        Object o;
        Beer beer;

        try {
            // Format target class and file.
            String target = formatTarget((String) parsedCommand.get(1));

            // Get method by reflexion.
            Class c = this.getClass();
            Method method = c.getDeclaredMethod("getParams" + target);
            // Run method.
            ArrayList<String> paramsName = (ArrayList)method.invoke(this);

            // Display add view and recover user entries.
            ArrayList<String> params = view.addView(paramsName);

            // Read data into the json file.
            ArrayList<Object> obj = jsonR.readFile(target);

            // Target the good class.
            Class clsTarget = Class.forName("com.company.model." + formatTarget(target));

            switch (target) {
                case "Beer":
                    // Recover constructor of the good class.
                    cons = clsTarget.getConstructor(new Class[]{String.class, String.class, double
                            .class, double.class, double.class, double.class});
                    // Create a new instance class.
                    o = cons.newInstance(params.get(0), params.get(1),
                            Double.parseDouble(params.get(2)), Double.parseDouble(params.get(3)),
                            Double.parseDouble(params.get(4)), Double.parseDouble(params.get(5)));
                    break;
                default:
                    cons = clsTarget.getConstructor(new Class[]{String.class, String.class});
                    o = cons.newInstance(params.get(0), params.get(1));
                    break;
            }

            // Add and write to the good json file
            obj.add(o);
            jsonW.writeFile(target, obj, paramsName);

        } catch (Exception e) {
            System.out.print("Add to json error: " + e);
        }
    }

    // Function to remove a entry into a json file.
    private void remove(ArrayList<String> parsedCommand) {
        // Init.
        String name = null;
        Object objRemove;
        String target = formatTarget((String) parsedCommand.get(1));
        ArrayList<Object> objs = jsonR.readFile(target);

        // Test to get options.
        try {
            name = parsedCommand.get(2);
        } catch (Exception e) {
            System.out.print("Name of the target doesn't exist (try an other)");
        }

        try {
            // Target the good class and goot method to reflexion.
            Class c = Class.forName("com.company.model." + target);
            Method m = c.getDeclaredMethod("getName");

            // Search object to remove.
            for (int i = 0; i < objs.size(); i++) {
                if (m.invoke(objs.get(i)) == name) {
                    objs.remove(i);
                }
            }
        } catch (Exception e) {
            System.out.print("Remove Error: " + e);
        }

        // Write to json file.
        try {
            // Target the methods to recover params for the write.
            Class cls = this.getClass();
            Method method = cls.getDeclaredMethod("getParams" + target);
            ArrayList<String> paramsName = (ArrayList)method.invoke(this);

            // Call write function
            jsonW.writeFile(target, objs, paramsName);
        } catch (Exception e) {
            System.out.print("Write to json File Error: " + e);
        }
    }

    // Function to get info of an object or a complet file.
    private void info(ArrayList parsedCommand) {
        // Format target files
        String target = formatTarget((String)parsedCommand.get(1));

        // Check all entries or only one. (Test if an option)
        if(parsedCommand.size() > 2) {
            Object o = jsonR.getByName(target, (String)parsedCommand.get(2));
            System.out.println(o.toString());
        }
        else {
            List<Object> data = jsonR.readFile(target);
            for (int i = 0; i < data.size(); i++) {
                System.out.println(data.get(i).toString());
            }
        }
    }

    // Method to parse command entry.
    private ArrayList<String> parseCommand(String elements) {
        // Init.
        String options = null;
        ArrayList<String> parserReturn = new ArrayList<String>();
        elements = elements.trim();
        String[] parseElement = elements.split("\\s+");

        // Check if commands is entry.
        if (parseElement.length < 1) {
            System.out.println("Please enter a command");
            return parserReturn;
        }

        // Parse and check if exist.
        String command = parseElement[0];
        if (!this.commandsList.containsKey(command)) {
            System.out.println("Command invalid");

            // Return help function if invalid command.
            parserReturn.add("help");
            return parserReturn;
        } else {
            // Build the list with the parse.
            ArrayList validOption = this.commandsList.get(command);
            parserReturn.add(command);

            if (validOption.size() == 0) {
                return parserReturn;
            }

            // if an options is neccesary.
            try {
                options = parseElement[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please enter a option");
                return parserReturn;
            }

            // If invalid option
            if (!validOption.contains(options)) {
                System.out.println("Option invalid");
                return parserReturn;
            }

            parserReturn.add(options);

            if (parseElement.length > 2) {
                parserReturn.add(parseElement[2]);
            }

            return parserReturn;
        }
    }

    // Methods to call the good function for reflexion.
    private boolean reflexionCommand(ArrayList<String> parsedCommand) {
        //Init
        Method m;

        try {
            // Target the good class with the parsed command.
            Class c = this.getClass();
            // Recove method.
            m = c.getDeclaredMethod(parsedCommand.get(0), ArrayList.class);
            try {
                // Invoke method and if catch exit.
                m.invoke(this, parsedCommand);
            } catch (Exception e) {
                System.out.print(e);
                this.exit();
            }

        } catch (NoSuchMethodException e) {
            System.out.print(e);
            this.exit();
        }
        return true;
    }

    // Method to format target (up first letter).
    private String formatTarget(String rawTarget) {
        String target = rawTarget.substring(0,1).toUpperCase() + rawTarget.substring(1);
        return target;
    }

    // List of param's Brewer for reflexion.
    private ArrayList<String> getParamsBrewer() {
        ArrayList<String> params = new ArrayList<String>();
        params.add("name");
        params.add("address");
        params.add("brandsList");
        return params;
    }

    // List of param's Brand for reflexion.
    private ArrayList<String> getParamsBrand() {
        ArrayList<String> params = new ArrayList<String>();
        params.add("name");
        params.add("address");
        params.add("beersList");
        return params;
    }

    // List of param's Beer for reflexion.
    private ArrayList<String> getParamsBeer() {
        ArrayList<String> params = new ArrayList<String>();
        params.add("name");
        params.add("type");
        params.add("degree");
        params.add("conditioning");
        params.add("price");
        params.add("evaluation");
        return params;
    }

    // Run function, to manage app.
    public void run(){
        while(true) {
            Scanner scanner = new Scanner(System.in);
            // Set view commands to display.
            view.setCommands(this.commandsList);
            view.display();
            System.out.print(">> ");
            // Scan entry.
            String command = scanner.nextLine();
            // Parse entry.
            ArrayList<String> parseCommand = this.parseCommand(command);
            // Call function.
            this.reflexionCommand(parseCommand);
        }
    }
}
