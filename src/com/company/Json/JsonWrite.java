package com.company.Json;

import com.company.model.Beer;
import com.company.model.BrandBeer;
import com.company.model.Brewer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWrite {
  /**
   * Writes an object to a file
   * @param name: Type of the Object, "Beer", "BrandBeer" or "Brewer"
   * @param object: Object that needs to be added to the file name".json"
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
          BrandBeer brandBeerObject = (BrandBeer) object;
          // 2)
          objects.add(brandBeerObject);
          // 3)
          i = 0;
          while (i < objects.size()) {
            Object brandBeer = objects.get(i);
            if (brandBeerObject.getName().equals(((BrandBeer) brandBeer).getName()) && update){
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

  /**
   * Updates a file based on some criteria
   * @param name: type of the data in the file (Beer, Brewer, BrandBeer)
   * @param objectName: name of the Object that needs to be changed
   * @param KeyToUpdate: key of the Object from which the value needs to change
   * @param ValueToUpdate: New Value for the key of the Object
   */
  public void updateFile(String name, String objectName, String KeyToUpdate, Object
          ValueToUpdate){
    JsonRead jsonRead = new JsonRead();
    JsonWrite jsonWrite = new JsonWrite();

    List<Object> objects = jsonRead.readFile(name);
    String checkName = "";

    int index = 0;
    while (index < objects.size()) {
      Object object = objects.get(index);
      switch(name){
        case "Beer":
          Beer beer = (Beer) object;
          checkName = beer.getName();
          if (checkName.equals(objectName)) {
            switch (KeyToUpdate) {
              case "price":
                beer.setPrice(Double.parseDouble((String) ValueToUpdate));
                break;
              case "evaluation":
                beer.setEvaluation(Double.parseDouble((String) ValueToUpdate));
              default:
                //
            }
            objects.set(index,beer);
            for (Object beer1:objects){
              jsonWrite.writeFile(name,beer1, true);
            }
          }
          break;
        case "Brewer":
          Brewer brewer = (Brewer) object;
          checkName = brewer.getName();
          if (checkName.equals(objectName)) {
            switch (KeyToUpdate) {
              case "addBrand":
                brewer.addBrand((BrandBeer) ValueToUpdate);
                break;
              case "removeBrand":
                brewer.RemoveBrand((BrandBeer) ValueToUpdate);
              case "number":
                brewer.setNumber((String) ValueToUpdate);
                break;
              case "address":
                brewer.setAddress((String) ValueToUpdate);
                break;
              default:
                //
            }
            objects.set(index,brewer);
            jsonWrite.writeFile(name,brewer, true);
          }
          break;
        case "BrandBeer":
          BrandBeer brandBeer = (BrandBeer) object;
          checkName = brandBeer.getName();
          if (checkName.equals(objectName)){
            switch (KeyToUpdate) {
              case "addBeer":
                brandBeer.addBeer((Beer) ValueToUpdate);
                break;
              case "removeBeer":
                brandBeer.removeBeer((Beer) ValueToUpdate);
                break;
              case "address":
                brandBeer.setAddress((String) ValueToUpdate);
                break;
              case "number":
                brandBeer.setNumber((String) ValueToUpdate);
              default:
                //
            }
            objects.set(index,brandBeer);
            jsonWrite.writeFile(name,brandBeer, true);
          }
          break;
        default:
          //
      }
      index ++;
    }

  }
}
