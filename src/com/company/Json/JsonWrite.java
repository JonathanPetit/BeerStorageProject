package com.company.Json;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.json.simple.JSONObject;

public class JsonWrite {
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

    // Methods to up the first letter for reflexion.
    private String formatTarget(String rawTarget) {
        String target = rawTarget.substring(0,1).toUpperCase() + rawTarget.substring(1);
        return target;
    }
}
