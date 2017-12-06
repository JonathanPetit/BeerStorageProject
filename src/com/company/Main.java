package com.company;
import com.company.views.*;
import com.company.model.*;
import com.company.controller.Controller;

import java.util.*;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        View inventory = new View(GetData());
        /*inventory.atoz();
        inventory.ztoa();
        inventory.search("Pils");*/
        Scanner scn = new Scanner(System.in);
        Controller controller = new Controller(inventory);
        //Inventory inventory = new Inventory();
        //View view = new View();

        System.out.println("Entrez une commande");

        String com ="start";

        while(!Objects.equals(com, "exit")) {
            System.out.print(">> \t");
            String command = scn.nextLine();
            // A command should be formatted as: command [-option] [value]
            String elements[] = command.split(" ");

            controller.parseCommand(elements);

            /*for(int i = 0; i<elements.length; i++){
                System.out.println(i + " " + elements[0]);
            }*/

            com = elements[0];
        }

    }




    public static List<Brouwer>GetData(){
        Brouwer Artois = new Brouwer("Artois");
        BrandBeer Leffe = new BrandBeer("Leffe");
        ModelBeer LeffeBrune33 = new ModelBeer("Leffe brune", "Brune", 6.5, 33.0, 2.5, 2);
        ModelBeer LeffeBlonde33 = new ModelBeer("Leffe Blonde", "Blonde", 6.5, 33.0, 2.5, 2);
        Leffe.AddBeer(LeffeBlonde33);
        Leffe.AddBeer(LeffeBrune33);
        BrandBeer Stella = new BrandBeer("Stella");
        ModelBeer Pils = new ModelBeer("Pils", "Blonde", 6.5, 33.0, 2.5, 2);
        Stella.AddBeer(Pils);
        Artois.AddBrand(Leffe);
        Artois.AddBrand(Stella);

        Brouwer Dubuisson = new Brouwer("Dubuisson");
        BrandBeer Bush = new BrandBeer("Bush");
        ModelBeer Bush12 = new ModelBeer("Bush12", "Blonde", 12.0, 33.0, 2.5, 2);
        Bush.AddBeer(Bush12);
        Dubuisson.AddBrand(Bush);

        Brouwer Abinbev = new Brouwer("ABinbev");
        BrandBeer Jupiler = new BrandBeer("Jupiler");
        ModelBeer Force = new ModelBeer("Force", "Blonde", 0.0, 33.0, 2.5, 2);
        Jupiler.AddBeer(Force);
        Abinbev.AddBrand(Jupiler);

        List<Brouwer> list = new ArrayList();
        list.add(Artois);
        list.add(Abinbev);
        list.add(Dubuisson);

        return list;

    }
}

