package com.company;
//import com.company.views.*;
import com.company.model.*;
import com.company.controller.Controller;

import java.util.*;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller();

        ArrayList options = new ArrayList();
        options.add("beer");
        options.add("brand");
        options.add("brewer");

        controller.addCommands("exit", new ArrayList<>());
        controller.addCommands("help", new ArrayList<>());
        controller.addCommands("add", options);
        controller.addCommands("edit", options);
        controller.addCommands("remove", options);

        options.add("all");
        controller.addCommands("info", options);

        controller.run();
    }



/*
    public static List<Brewer>GetData(){
        Brewer Artois = new Brewer("Artois");
        BrandBeer Leffe = new BrandBeer("Leffe");
        Beer LeffeBrune33 = new Beer("Leffe brune", "Brune", 6.5, 33.0, 2.5, 2);
        Beer LeffeBlonde33 = new Beer("Leffe Blonde", "Blonde", 6.5, 33.0, 2.5, 2);
        Leffe.AddBeer(LeffeBlonde33);
        Leffe.AddBeer(LeffeBrune33);
        BrandBeer Stella = new BrandBeer("Stella");
        Beer Pils = new Beer("Pils", "Blonde", 6.5, 33.0, 2.5, 2);
        Stella.AddBeer(Pils);
        Artois.AddBrand(Leffe);
        Artois.AddBrand(Stella);

        Brewer Dubuisson = new Brewer("Dubuisson");
        BrandBeer Bush = new BrandBeer("Bush");
        Beer Bush12 = new Beer("Bush12", "Blonde", 12.0, 33.0, 2.5, 2);
        Bush.AddBeer(Bush12);
        Dubuisson.AddBrand(Bush);

        Brewer Abinbev = new Brewer("ABinbev");
        BrandBeer Jupiler = new BrandBeer("Jupiler");
        Beer Force = new Beer("Force", "Blonde", 0.0, 33.0, 2.5, 2);
        Jupiler.AddBeer(Force);
        Abinbev.AddBrand(Jupiler);

        List<Brewer> list = new ArrayList();
        list.add(Artois);
        list.add(Abinbev);
        list.add(Dubuisson);

        return list;

    }*/
}

