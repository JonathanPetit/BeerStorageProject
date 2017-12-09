package com.company.Json;

import com.company.model.Beer;
import com.company.model.BrandBeer;
import com.company.model.Brewer;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWrite {
  public void WriteFile(String name, Object object){
    String filename = name+".json";
    try {
      FileWriter fileWriter = new FileWriter(filename);
      switch(name){
        case "Beer":
          Beer beerObject = (Beer) object;
          fileWriter.write("["+beerObject.toString()+"]");
          break;
        case "BrandBeer":
          BrandBeer brandBeerObject = (BrandBeer) object;
          fileWriter.write("["+brandBeerObject.toString()+"]");
          break;
        case "Brewer":
          Brewer brewerObject = (Brewer) object;
          fileWriter.write("["+brewerObject.toString()+"]");
          break;
        default:
          //
      }
      fileWriter.flush();

    }
    catch (IOException e){
      System.out.println("File doesn't exist");
    }
  }
}
