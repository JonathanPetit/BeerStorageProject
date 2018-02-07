package com.company.Json;

<<<<<<< HEAD
import com.company.model.Beer;
<<<<<<< HEAD
import com.company.model.BrandBeer;
=======
import com.company.model.Brand;
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
import com.company.model.Brewer;

=======
>>>>>>> 404ff1be70dbcc0279071ef4f017b73e2b69c41c
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.json.simple.JSONObject;

public class JsonWrite {
<<<<<<< HEAD
  /**
   * Writes an object to a file
   * @param name: Type of the Object, "Beer", "BrandBeer" or "Brewer"
   * @param object: Object that needs to be added to the file name".json"
<<<<<<< HEAD
=======
   * @param update: tells if the object already existed (true) or if it is new (false)
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
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
<<<<<<< HEAD
          BrandBeer brandBeerObject = (BrandBeer) object;
=======
          Brand brandBeerObject = (Brand) object;
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
          // 2)
          objects.add(brandBeerObject);
          // 3)
          i = 0;
          while (i < objects.size()) {
            Object brandBeer = objects.get(i);
<<<<<<< HEAD
            if (brandBeerObject.getName().equals(((BrandBeer) brandBeer).getName()) && update){
=======
            if (brandBeerObject.getName().equals(((Brand) brandBeer).getName()) && update){
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
              update = false;
=======
    /**
     * Writes an object to a file
     * @param target: String Object, "Beer", "BrandBeer" or "Brewer".
     * @param objectList: List of parameters values.
     * @param params: List of Class parameters.
    */
    public void writeFile(String target, ArrayList<Object> objectList, ArrayList<String> params) {
        // Initialize some variable
        ArrayList<String> objects = new ArrayList<String>();
        FileWriter fileWriter;

        try {
            // Target the good file and the good class
            fileWriter = new FileWriter(formatTarget(target)+".json");
            Class c = Class.forName("com.company.model." + target);

            //Create the Json Object with reflexion
            for (int i = 0; i < objectList.size(); i++) {
                JSONObject json = new JSONObject();
                for (int j = 0; j < params.size(); j++) {
                    Method m = c.getDeclaredMethod("get" + formatTarget(params.get(j)));
                    Object obj = objectList.get(i);
                    Object resp = m.invoke(obj);
                    json.put(params.get(j), resp);
                }
                objects.add(json.toJSONString());
>>>>>>> 404ff1be70dbcc0279071ef4f017b73e2b69c41c
            }

            // Write the entire string to the file.
            fileWriter.write(objects.toString());

            // Finish writing.
            fileWriter.flush();
            fileWriter.close();

        } catch (Exception e) {
            System.out.print("Record file problem: " + e);
        }
    }

<<<<<<< HEAD
  }
<<<<<<< HEAD

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
=======
>>>>>>> 3c4e5e47ba5be159e6083da673b42e00df123250
=======
    // Methods to up the first letter for reflexion.
    private String formatTarget(String rawTarget) {
        String target = rawTarget.substring(0,1).toUpperCase() + rawTarget.substring(1);
        return target;
    }
>>>>>>> 404ff1be70dbcc0279071ef4f017b73e2b69c41c
}
