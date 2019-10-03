package main.java.services;

import main.java.model.Property.Location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//(3.1) Alex LV och Alex Ask
// Implementation of ILocationCreator that creates location objects based on input from an API.
public class LocationCreatorAPI implements ILocationCreator{


    //Creates a location from an API
    //TODO use a real API.
    @Override
    public Location createLocation() {
        MockLocationAPI api = new MockLocationAPI();
        Location l = new Location();

        l.setSolarHours(api.getSolarHours());

        Double x = api.getX();
        Double y = api.getY();
        l.setCoordinate(x,y);

        int solarPower = (int)Math.round(api.getSolarPower());
        l.setSolarPower(solarPower);

        return l;
    }

    public void getSolarData(){

        String jsonString = readStringFromUrl("https://power.larc.nasa.gov/cgi-bin/v1/DataAccess.py?request=execute&identifier=SinglePoint&parameters=ALLSKY_SFC_SW_DWN&startDate=20141002&endDate=20191002&lat=34.21&lon=56.78&userCommunity=SSE&tempAverage=DAILY&outputList=JSON&user=anonymous");
        System.out.println();
        JSONObject apiObject = createJSonObjectFromString(jsonString);
        //access the data values within the json data response
        JSONArray features = (JSONArray) apiObject.get("features");
        JSONObject properties = (JSONObject) features.get(0);
        properties = properties.getJSONObject("properties");
        JSONObject parameter = (JSONObject)properties.get("parameter");

        JSONObject allSkyInsolationIncident =   (JSONObject) parameter.get("ALLSKY_SFC_SW_DWN");



        /*for ( JSONObject p : parameter ) {
            int values = features.properties.parameter[p];
            for ( var v in values ){
                var powervalue = values[v];
            }*/

    }

    private String readStringFromUrl(String u){
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(u);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String s = "";
            while ((s = br.readLine()) != null) {
                sb.append(s + "\n");

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return sb.toString();
    }

    private JSONObject createJSonObjectFromString(String jsonText) {
        JSONObject json = null;
        try {
             json = new JSONObject(jsonText);
            return json;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return json;
    }
}
