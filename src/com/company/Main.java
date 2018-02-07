package com.company;
<<<<<<< HEAD
import com.company.Json.JsonRead;
import com.company.Json.JsonWrite;
import com.company.views.*;
=======
//import com.company.views.*;
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
import com.company.model.*;
import com.company.controller.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {

<<<<<<< HEAD
    Brewer testBrewer = new Brewer("BrewerName","BrewerAddress", "0");
    BrandBeer brandBeer = new BrandBeer("OtherBrandBeer","BrandAddress","15");
    Beer beer = new Beer("OtherBeer", "BullShit", 0.2, 15.0,0.3, 0);

    //brandBeer.addBeer(beer);

    testBrewer.addBrand(brandBeer);

    JsonWrite jsonWrite = new JsonWrite();
    jsonWrite.writeFile("Beer", beer, false);
    jsonWrite.updateFile("Beer","OtherBeer","price","3.3");
    //jsonWrite.writeFile("Brewer",testBrewer, false);
    //jsonWrite.writeFile("BrandBeer",brandBeer, false);
    JsonRead jsonRead = new JsonRead();

    List<Object> searchBeer = jsonRead.getByArg("BrandBeer","beersList","OtherBeer");
    System.out.println(searchBeer.size());
    for (Object search:searchBeer){
      System.out.println("result: ");
      System.out.println(search);
    }
    //Beer beer = (Beer) jsonRead.getByName("Beer","TK");

    //brandBeer.addBeer(beer);

    //writeJson.WriteFile("BrandBeer",brandBeer);

    /*List<Object> read = jsonRead.ReadFile("BrandBeer");
    for (Object obj:read){
      System.out.println(obj.toString());
    }*/

    /*Brewer brewerObject = (Brewer) jsonRead.getByName("Brewer","BrewerName");
    System.out.println("Brewer: "+brewerObject);

    System.out.println("BrandBeers: ");
    for (BrandBeer brandBeer:brewerObject.getBrandList()){
      BrandBeer brandBeerObject = (BrandBeer) jsonRead.getByName("BrandBeer",brandBeer.getName
              ());
      System.out.println(brandBeerObject);
      System.out.println("Beers: ");
      for (Beer beer:brandBeerObject.getBeersList()){
        Beer beerObject = (Beer) jsonRead.getByName("Beer",beer.getName());
        System.out.println(beerObject);
      }
    }*/

      //    View inventory = new View(GetData());
      /*inventory.atoz();
      inventory.ztoa();
      inventory.search("Pils");*/
      Scanner scn = new Scanner(System.in);
      //    Controller controller = new Controller(inventory);
      //Inventory inventory = new Inventory();
      //View view = new View();

      System.out.println("Entrez une commande");

      String com ="start";

      while(!Objects.equals(com, "exit")) {
          System.out.print(">> \t");
          String command = scn.nextLine();
          // A command should be formatted as: command [-option] [value]
          String elements[] = command.split(" ");

          //    controller.parseCommand(elements);

          /*for(int i = 0; i<elements.length; i++){
              System.out.println(i + " " + elements[0]);
          }*/

          com = elements[0];
      }

  }




    /*
=======
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
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
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

<<<<<<< HEAD
    }
    */
=======
    }*/
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
}

