package com.company.Json;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.company.model.Beer;
import com.company.model.Brand;
import com.company.model.Brewer;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class JsonRead {
  /**
   * Get all the objects from a json file
   * @param fileType: "Beer", "Brewer" or "BrandBeer", type of the Objects returned in the List
   * @return : List of Objects from the file fileType".json"
   */

  public List<Object> readFile(String fileType){
    List<Object> jsonRead = new ArrayList<>();
    String fileName = fileType+".json";

    //Initiating all variables for Beer, Brewer and BrandBeer
    String name;
    String type;
    String address;
    Double degree;
    Double conditioning;
    Double price;
    Double evaluation;

    String number;
    List<Object> brandsList;

    List<Object> beersList;

    Beer beer;
    Brewer brewer;
    Brand brandBeer;


    JSONParser parser = new JSONParser();

    try {
      FileReader fileReader = new FileReader(fileName);
      try {
        Object obj = parser.parse(fileReader);
        JSONArray jsonArray = (JSONArray) obj;

        for (Object object:jsonArray){
          JSONObject jsonObject = (JSONObject) object;
          switch(fileType){
            /* for each case: get attributes from json file
            *  then: create new object with these attributes
            *  finally: add to the list of objects jsonRead
            */
            case "Beer":
              // Get Attributes
              name = (String) jsonObject.get("name");
              type = (String) jsonObject.get("type");
              degree = Double.parseDouble((String) jsonObject.get("degree"));
              conditioning = Double.parseDouble((String)jsonObject.get("conditioning"));
              price = Double.parseDouble((String) jsonObject.get("price"));
              evaluation = Double.parseDouble((String) jsonObject.get("evaluation"));
              // Create Object
              beer = new Beer(name,type,degree,conditioning,price,evaluation);
              // Add to list
              jsonRead.add(beer);
              break;
            case "Brewer":
              // Get Attributes
              name = (String) jsonObject.get("name");
              address = (String) jsonObject.get("address");
              number = (String) jsonObject.get("number");
              JSONArray jsonObject1 = (JSONArray) jsonObject.get("brandsList");
              brandsList = (List<Object>) jsonObject1;
              // Create Object
              brewer = new Brewer(name,address,number);
              for (Object brandBeerName:brandsList) {
                brandBeer = (Brand) getByName("BrandBeer",(String) brandBeerName);
                brewer.addBrand(brandBeer);
              }
              // Add to list
              jsonRead.add(brewer);
              break;
            case "BrandBeer":
              // Get Attributes
              name = (String) jsonObject.get("name");
              address = (String) jsonObject.get("address");
              number = (String) jsonObject.get("number");
              JSONArray jsonArray1 = (JSONArray) jsonObject.get("beersList");
              beersList = (List<Object>) jsonArray1;
              // Create Object
              brandBeer = new Brand(name,address,number);
              for (Object beerName:beersList){
                beer = (Beer) getByName("Beer",(String) beerName);
                brandBeer.addBeer(beer);
              }
              // Add to list
              jsonRead.add(brandBeer);
              break;
            default:
              //
          }
        }
      }
      catch(Exception e){
        System.out.println(e.toString());
      }
      fileReader.close();
    }
    catch (IOException e){
      System.out.println("File does not exist");
    }

    return jsonRead;
  }

  /**
   * Get an Object by type and name
   * @param fileType: "Beer", "Brewer" or "BrandBeer", json file where we need to search
   * @param name: name of the Object we're looking for
   * @return returns an Object with the correct attributes OR an Object with null/0.0/0 everywhere
   */

  public Object getByName(String fileType, String name){
    List<Object> objects = getByArg(fileType, "name",name);
    if (objects.size()==1){
      return objects.get(0);
    }
    else {
      return new Object();
    }
  }

  /**
   * Get an Object by type, argument en value
   * @param fileType: "Beer", "Brewer" or "BrandBeer", json file where we need to search
   * @param arg: name of the argument we want to scan
   * @param value: value of the argument we are searching for
   * @return returns a List of Objects with the correct attribute
   */
  public List<Object> getByArg(String fileType, String arg, String value){
    List<Object> objectList = new ArrayList<>();
    JsonRead jsonRead = new JsonRead();
    List<Object> objects = jsonRead.readFile(fileType);

    for (Object object:objects) {
      switch (fileType) {
        case "Beer":
          Beer beer = (Beer) object;
          if (arg.equals("name") && beer.getName().equals(value)){
            objectList.add(beer);
          }
          else if (arg.equals("type") && beer.getType().equals(value)) {
            objectList.add(beer);
          }
          else if (arg.equals("degree") && beer.getDegree() == Double.parseDouble(value)){
            objectList.add(beer);
          }
          else if (arg.equals("conditioning") && beer.getConditioning()==Double.parseDouble(value)){
            objectList.add(beer);
          }
          else if (arg.equals("price") && beer.getPrice() == Double.parseDouble(value)){
            objectList.add(beer);
          }
          else if (arg.equals("evaluation") && beer.getEvaluation() == Double.parseDouble(value)){
            objectList.add(beer);
          }
          else {
            System.out.println("Error");
          }
          break;
        case "Brewer":
          Brewer brewer = (Brewer) object;
          if (arg.equals("name") && brewer.getName().equals(value)){
            objectList.add(brewer);
          }
          else if (arg.equals("address") && brewer.getAddress().equals(value)){
            objectList.add(brewer);
          }
          else if (arg.equals("number") && brewer.getNumber().equals(value)){
            objectList.add(brewer);
          }
          else if (arg.equals("brandsList")){
            List<Brand> brandsList = brewer.getBrandList();
            for (Brand brandBeer:brandsList){
              if (brandBeer.getName().equals(value)){
                objectList.add(brewer);
                break;
              }
            }
            break;
          }
          else {
            System.out.println("Error");
          }
          break;
        case "BrandBeer":
          Brand brandBeer = (Brand) object;
          System.out.println(brandBeer);
          if (arg.equals("name") && brandBeer.getName().equals(value)){
            objectList.add(brandBeer);
          }
          else if (arg.equals("address") && brandBeer.getAddress().equals(value)){
            objectList.add(brandBeer);
          }
          else if (arg.equals("number") && brandBeer.getNumber().equals(value)){
            objectList.add(brandBeer);
          }
          else if (arg.equals("beersList")){
            List<Beer> beerList = brandBeer.getBeersList();
            System.out.println(beerList);
            for (Beer beer1:beerList){
              if (beer1.getName().equals(value)){
                objectList.add(brandBeer);
                break;
              }
            }
            break;
          }
          else {
            System.out.println("Error");
          }
          break;
        default:
          //
      }
    }
    return objectList;
  }

}
