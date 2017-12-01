package com.company;

import java.util.List;
import java.util.stream.Collectors;


public class Main {
  public static void main(String[] args) {
    Brouwer Artois = new Brouwer("Artois");
    BrandBeer Leffe = new BrandBeer("Leffe");
    BrandBeer VieuxTemps = new BrandBeer("Vieux-temps");

    Artois.AddBrand(Leffe);
    Artois.AddBrand(VieuxTemps);

    ModelBeer LeffeBrune33 = new ModelBeer("Leffe brune", "Brune", 6.5, 33.0, 2.5, 2);

    Leffe.AddBeer(LeffeBrune33);

    System.out.println(Artois.BrandBeerList2String(","));

  }

  public void AddBeer(){

  }
}
