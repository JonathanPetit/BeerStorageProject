package com.company.views;

import java.util.*;

public class View {
    /*
     * Class for view console.
     */

    private Hashtable<String, ArrayList<String>> commands;

    // Function for display menu and control.
    private View() {
        this.commands = commands;
    }

    // Create and set unique instance of Parking class. (Singleton pattern)
    private static class ViewHolder {
        private static final View INSTANCE = new View();
    }

    // Method to get the unique instance of Parking.
    public static View getInstance() {
        return ViewHolder.INSTANCE;
    }

    public void setCommands(Hashtable<String, ArrayList<String>> commands) {
        this.commands = commands;
    }

    // Display main menu.
    public void display() {
        System.out.print("\n\n----- Main Menu -----\n\n");

        // Recover commands available by reflexion.
        System.out.print("Available commands:\n");
        Enumeration e = this.commands.keys();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            System.out.println("- " + key);
        }
        System.out.print("\n");

        System.out.print("Target:\n");
        System.out.print("- brewer\n");
        System.out.print("- brand\n");
        System.out.print("- beer\n");
        System.out.print("\n");

        System.out.print("\nExample commands: <command> <target> <option> (for 'all' info option is " +
                "blank" + " \n");
    }

    // Function to display add view.
    public ArrayList<String> addView(ArrayList<String> params) {
        ArrayList<String> values = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        // Display params one by one
        for (int i = 0; i < params.size(); i++) {
            System.out.println("\n" + params.get(i));
            String value = scanner.nextLine();
            values.add(value);
        }

        return values;
    }
}