package main.java.services;

import org.json.JSONException;
import org.json.JSONObject;

//Implementation of the ApiParser that reads JSON objects.
public class ApiJSONParser extends ApiParser<JSONObject> {

    // Converts strings to JSON objects provided that they can.
    public JSONObject parseData(String jsonText) {
        try {
            return new JSONObject(jsonText);
        }catch (JSONException e){
            e.printStackTrace();
            return new JSONObject();
        }

    }
}
