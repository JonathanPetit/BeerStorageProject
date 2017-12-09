package com.company.Json;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.company.model.Beer;
import com.company.model.BrandBeer;
import com.company.model.Brewer;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class JsonRead {
  public List<Object> ReadFile(String fileType){
    List<Object> jsonRead = new ArrayList<>();
    String fileName = fileType+".json";

    //Initiation all variables for Beer, Brewer and BrandBeer
    String name = "";
    String type = "";
    String address = "";
    Double degree = 0.0;
    Double conditioning = 0.0;
    Double price = 0.0;
    Integer evaluation = 0;

    String number = "0";
    List<String> brandsList = new ArrayList<>();

    List<String> beersList = new ArrayList<>();

    Beer beer;
    Brewer brewer;
    BrandBeer brandBeer;


    JSONParser parser = new JSONParser();

    try {
      FileReader fileReader = new FileReader(fileName);
      try {
        Object obj = parser.parse(fileReader);
        JSONArray jsonArray = (JSONArray) obj;

        for (Object object:jsonArray){
          JSONObject jsonObject = (JSONObject) object;
          switch(fileType){
            case "Beer":
              name = (String) jsonObject.get("name");
              type = (String) jsonObject.get("type");
              degree = Double.parseDouble((String) jsonObject.get("degree"));
              conditioning = Double.parseDouble((String)jsonObject.get("conditioning"));
              price = Double.parseDouble((String) jsonObject.get("price"));
              evaluation = Integer.parseInt((String) jsonObject.get("evaluation"));
              beer = new Beer(name,type,degree,conditioning,price,evaluation);
              jsonRead.add(beer);
              break;
            case "Brewer":
              name = (String) jsonObject.get("name");
              address = (String) jsonObject.get("address");
              number = (String) jsonObject.get("number");
              JSONArray jsonObject1 = (JSONArray) jsonObject.get("brandsList");
              brandsList = (List<String>) jsonObject1;
              brewer = new Brewer(name,address,number);
              for (String brandBeerName:brandsList) {
                brandBeer = (BrandBeer) getByName("BrandBeer",(String) brandBeerName);
                brewer.addBrand(brandBeer);
              }
              jsonRead.add(brewer);
              break;
            case "BrandBeer":
              name = (String) jsonObject.get("name");
              address = (String) jsonObject.get("address");
              number = (String) jsonObject.get("number");
              beersList = (List<String>) jsonObject.get("beersList");
              brandBeer = new BrandBeer(name,address,number);
              for (String beerName:beersList){
                beer = (Beer) getByName("Beer",beerName);
                brandBeer.addBeer(beer);
              }
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

  public Object getByName(String type, String name){
    JsonRead jsonRead = new JsonRead();
    List<Object> objects = jsonRead.ReadFile(type);
    Object returnObject = null;
    switch (type){
      case "Beer":
        Beer beer;
        for (Object obj : objects) {
          beer = (Beer) obj;
          if (beer.getName().equals(name)) {
            returnObject = beer;
          }
        }
        if (returnObject == null){
          beer = new Beer("none","none",0.0,0.0,0.0,0);
          returnObject = beer;
        }
        break;
      case "Brewer":
        Brewer brewer;
        for (Object obj : objects) {
          brewer = (Brewer) obj;
          if (brewer.getName().equals(name)) {
            returnObject = brewer;
          }
        }
        if (returnObject == null){
          brewer = new Brewer("none","none","0");
          returnObject = brewer;
        }
        break;
      case "BrandBeer":
        BrandBeer brandBeer;
        for (Object obj : objects) {
          brandBeer = (BrandBeer) obj;
          if (brandBeer.getName().equals(name)) {
            returnObject = brandBeer;
          }
        }
        if (returnObject == null) {
          brandBeer = new BrandBeer("none", "none", "0");
          returnObject = brandBeer;
        }
        break;
      default:
        //
    }
    return returnObject;
  }

}
