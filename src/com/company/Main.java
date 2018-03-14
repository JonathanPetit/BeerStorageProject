package com.company;

import com.company.controller.Controller;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        Controller controller = Controller.getInstance();

        ArrayList options = new ArrayList();
        options.add("beer");
        options.add("brand");
        options.add("brewer");


        controller.addCommands("add", options);
        controller.addCommands("remove", options);
        controller.addCommands("info", options);
        controller.run();
    }
}

