package main.java.services;

import org.json.JSONException;
import org.json.JSONObject;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Implementation of the ApiParser.
// Used by: LocationCreatorAPI
// Uses: Reads JSON objects from a string.

public class ApiJSONParser extends ApiParser<JSONObject> {

    // Converts strings to JSON objects provided that they can.
    public JSONObject parseData(String jsonText) {
        try {
            return new JSONObject(jsonText);
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }

    }
}
