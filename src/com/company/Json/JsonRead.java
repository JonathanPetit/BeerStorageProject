package com.company.Json;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.company.model.Beer;
<<<<<<< HEAD
import com.company.model.BrandBeer;
=======
import com.company.model.Brand;
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
import com.company.model.Brewer;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class JsonRead {
  /*
   * Get all the objects from a json file
   * @param fileType: "Beer", "Brewer" or "BrandBeer", type of the Objects returned in the List
   * @return : List of Objects from the file fileType".json"
   */

  public ArrayList<Object> readFile(String fileType){
    ArrayList<Object> jsonRead = new ArrayList<>();
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
<<<<<<< HEAD
    BrandBeer brandBeer;
=======
    Brand brandBeer;
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250


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
              degree = (double) jsonObject.get("degree");
              conditioning = (double) jsonObject.get("conditioning");
              price = (double) jsonObject.get("price");
              evaluation = (double) jsonObject.get("evaluation");
              // Create Object
              beer = new Beer(name, type, degree, conditioning, price, evaluation);
              // Add to list
              jsonRead.add(beer);
              break;
            case "Brewer":
              // Get Attributes
              name = (String) jsonObject.get("name");
              address = (String) jsonObject.get("address");
              JSONArray jsonObject1 = (JSONArray) jsonObject.get("brandsList");
              brandsList = (List<Object>) jsonObject1;
              // Create Object
              brewer = new Brewer(name, address);

              for (Object brandBeerName:brandsList) {
<<<<<<< HEAD
<<<<<<< HEAD
                brandBeer = (BrandBeer) getByName("BrandBeer",(String) brandBeerName);
=======
                brandBeer = (Brand) getByName("BrandBeer",(String) brandBeerName);
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
=======
                brandBeer = (Brand) getByName("Brand",(String) brandBeerName);
>>>>>>> 404ff1be70dbcc0279071ef4f017b73e2b69c41c
                brewer.addBrand(brandBeer);
              }
              // Add to list
              jsonRead.add(brewer);
              break;
            case "Brand":
              // Get Attributes
              name = (String) jsonObject.get("name");
              address = (String) jsonObject.get("address");

              JSONArray jsonArray1 = (JSONArray) jsonObject.get("beersList");
              beersList = (List<Object>) jsonArray1;
              // Create Object
<<<<<<< HEAD
<<<<<<< HEAD
              brandBeer = new BrandBeer(name,address,number);
=======
              brandBeer = new Brand(name,address,number);
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
=======
              brandBeer = new Brand(name, address);
>>>>>>> 404ff1be70dbcc0279071ef4f017b73e2b69c41c
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
<<<<<<< HEAD
        System.out.println(e.toString());
=======
        System.out.println("lol");
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
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
   * @param fileType: "Beer", "Brewer" or "Brand", json file where we need to search
   * @param name: name of the Object we're looking for
   * @return returns an Object with the correct attributes OR an Object with null/0.0/0 everywhere
   */

  public Object getByName(String fileType, String name){
<<<<<<< HEAD
    JsonRead jsonRead = new JsonRead();
    List<Object> objects = jsonRead.readFile(fileType);
    Object returnObject = null;
    switch (fileType){
      case "Beer":
        Beer beer;
        for (Object obj : objects) {
          beer = (Beer) obj;
          if (beer.getName().equals(name)) {
            returnObject = beer;
            break;
          }
        }
        if (returnObject == null){
          beer = new Beer(null,null,0.0,0.0,0.0,0);
          returnObject = beer;
        }
        break;
      case "Brewer":
        Brewer brewer;
        for (Object obj : objects) {
          brewer = (Brewer) obj;
          if (brewer.getName().equals(name)) {
            returnObject = brewer;
            break;
          }
        }
        if (returnObject == null){
          brewer = new Brewer(null,null,null);
          returnObject = brewer;
        }
        break;
      case "BrandBeer":
        BrandBeer brandBeer;
        for (Object obj : objects) {
          brandBeer = (BrandBeer) obj;
          if (brandBeer.getName().equals(name)) {
            returnObject = brandBeer;
            break;
          }
        }
        if (returnObject == null) {
          brandBeer = new BrandBeer(null, null, null);
          returnObject = brandBeer;
        }
        break;
      default:
        //
    }
    return returnObject;
=======
    List<Object> objects = getByArg(fileType, "name",name);
    if (objects.size()==1){
      return objects.get(0);
    }
    else {
      return new Object();
    }
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
  }

  /**
   * Get an Object by type, argument en value
   * @param fileType: "Beer", "Brewer" or "Brand", json file where we need to search
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
          break;
        case "Brewer":
          Brewer brewer = (Brewer) object;
          if (arg.equals("name") && brewer.getName().equals(value)){
            objectList.add(brewer);
          }
          else if (arg.equals("address") && brewer.getAddress().equals(value)){
            objectList.add(brewer);
          }
          else if (arg.equals("brandsList")){
<<<<<<< HEAD
            List<BrandBeer> brandsList = brewer.getBrandList();
            for (BrandBeer brandBeer:brandsList){
=======
            List<Brand> brandsList = brewer.getBrandList();
            for (Brand brandBeer:brandsList){
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
              if (brandBeer.getName().equals(value)){
                objectList.add(brewer);
                break;
              }
            }
            break;
          }
          break;
<<<<<<< HEAD
        case "BrandBeer":
<<<<<<< HEAD
          BrandBeer brandBeer = (BrandBeer) object;
=======
          Brand brandBeer = (Brand) object;
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
          System.out.println(brandBeer);
=======
        case "Brand":
          Brand brandBeer = (Brand) object;

>>>>>>> 404ff1be70dbcc0279071ef4f017b73e2b69c41c
          if (arg.equals("name") && brandBeer.getName().equals(value)){
            objectList.add(brandBeer);
          }
          else if (arg.equals("address") && brandBeer.getAddress().equals(value)){
            objectList.add(brandBeer);
          }
          else if (arg.equals("beersList")){
            List<Beer> beerList = brandBeer.getBeersListObject();
            for (Beer beer1:beerList){
              if (beer1.getName().equals(value)){
                objectList.add(brandBeer);
                break;
              }
            }
            break;
          }
          break;
        default:
          //
      }
    }
    return objectList;
  }

}
