package com.company.Json;

import com.company.model.Beer;
import com.company.model.Brand;
import com.company.model.Brewer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWrite {
  /**
   * Writes an object to a file
   * @param name: Type of the Object, "Beer", "BrandBeer" or "Brewer"
   * @param object: Object that needs to be added to the file name".json"
   * @param update: tells if the object already existed (true) or if it is new (false)
   */
  public void writeFile(String name, Object object, Boolean update) {
    JsonRead jsonRead = new JsonRead();

    // Get all the objects from the file
    List<Object> objects = jsonRead.readFile(name);

    // If the object is not in the file yet: add it
    // open Json Array
    String stringToWrite = "[";
    try {
      FileWriter fileWriter = new FileWriter(name+".json");
      // get json string of each object (with switch case by type)
      // 1) convert the object to add to correct type
      // 2) add object to the list of objects
      // 3) write the json string
      switch (name) {
        case "Beer":
          // 1)
          Beer beerObject = (Beer) object;
          // 2)
          objects.add(beerObject);
          // 3)
          int i = 0;
          while (i < objects.size()) {
            Object beer = objects.get(i);
            if (!(beerObject.getName().equals(((Beer) beer).getName()) && i != objects.size()-1)){
              stringToWrite = stringToWrite.concat(beer.toString());
              if (i != objects.size() - 1) {
                stringToWrite += ",";
              }
            }
            i++;
          }
          break;
        case "BrandBeer":
          // 1)
          Brand brandBeerObject = (Brand) object;
          // 2)
          objects.add(brandBeerObject);
          // 3)
          i = 0;
          while (i < objects.size()) {
            Object brandBeer = objects.get(i);
            if (brandBeerObject.getName().equals(((Brand) brandBeer).getName()) && update){
              update = false;
            }
            else {
              stringToWrite = stringToWrite.concat(brandBeer.toString());
              if (i != objects.size() - 1) {
                stringToWrite += ",";
              }
            }
            i++;
          }
          break;
        case "Brewer":
          // 1)
          Brewer brewerObject = (Brewer) object;
          // 2)
          objects.add(brewerObject);
          // 3)
          i = 0;
          while (i < objects.size()) {
            Object brewer = objects.get(i);
            if (brewerObject.getName().equals(((Brewer) brewer).getName()) && update){
              update = false;
            }
            else {
              stringToWrite = stringToWrite.concat(brewer.toString());
              if (i != objects.size() - 1) {
                stringToWrite += ",";
              }
            }
            i++;
          }
          break;
        default:
          //
      }
      // close Json Array
      stringToWrite += "]";

      // write the entire string to the file
      fileWriter.write(stringToWrite);

      // finish writing
      fileWriter.flush();

    } catch (IOException e) {
      System.out.println("File doesn't exist");
    }

  }
}
