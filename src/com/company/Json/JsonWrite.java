package com.company.Json;

import com.company.model.Beer;
import com.company.model.BrandBeer;
import com.company.model.Brewer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWrite {
  public void WriteFile(String name, Object object) {
    JsonRead jsonRead = new JsonRead();
    List<Object> objects = jsonRead.ReadFile(name);
    int objectsSize = objects.size();

    String filename = name + ".json";
    String stringToWrite = "[";
    try {
      FileWriter fileWriter = new FileWriter(filename);
      switch (name) {
        case "Beer":
          Beer beerObject = (Beer) object;
          objects.add(beerObject);
          for (Object beer : objects) {
            stringToWrite = stringToWrite.concat(beer.toString());
            if (beer != objects.get(objectsSize)) {
              stringToWrite += ",";
            }
          }
          break;
        case "BrandBeer":
          BrandBeer brandBeerObject = (BrandBeer) object;
          objects.add(brandBeerObject);
          for (Object brandBeer : objects) {
            stringToWrite = stringToWrite.concat(brandBeer.toString());
            if (brandBeer != objects.get(objectsSize)) {
              stringToWrite += ",";
            }
          }
          break;
        case "Brewer":
          Brewer brewerObject = (Brewer) object;
          objects.add(brewerObject);
          for (Object brewer : objects) {
            stringToWrite = stringToWrite.concat(brewer.toString());
            if (brewer != objects.get(objectsSize)) {
              stringToWrite += ",";
            }
          }
          break;
        default:
          //
      }
      stringToWrite += "]";
      fileWriter.write(stringToWrite);

      fileWriter.flush();

    } catch (IOException e) {
      System.out.println("File doesn't exist");
    }
  }
}
