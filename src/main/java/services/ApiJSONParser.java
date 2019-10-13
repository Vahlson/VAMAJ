package services;

import org.json.JSONException;
import org.json.JSONObject;

//Implementation of the ApiParser that reads JSON objects.
public class ApiJSONParser extends ApiParser {

    // Converts strings to JSON objects provided that they can.
    public JSONObject parseData(String jsonText) {
        try {
            JSONObject json = new JSONObject(jsonText);
            return json;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }
}
