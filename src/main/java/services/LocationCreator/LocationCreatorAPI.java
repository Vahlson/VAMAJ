package main.java.services.LocationCreator;

import main.java.model.Property.Location;

import java.util.*;


import main.java.services.ApiJSONParser;
import main.java.services.ApiParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//(3.1) Alex LV och Alex Ask
// Implementation of ILocationCreator that creates location objects based on input from an API.
public class LocationCreatorAPI implements ILocationCreator{

    //Current year and month
    private int currentYear = Calendar.getInstance().get(Calendar.YEAR);

    //Variables needed for dataCollection
    private double latitude = 63.825848;
    private double longitude = 20.263035;
    private int dataAccuracyInYears = 5;


    //Creates a location from an API
    @Override
    public Location createLocation() {

        Location l = new Location();
        l.setSolarInsolation(getSolarInsolation());
        l.setCoordinate(latitude,longitude);

        return l;
    }

    private double getSolarInsolation(){
        //adjusting
        dataAccuracyInYears -= 1;

        ApiParser<JSONObject> parser = new ApiJSONParser();

        //Getting the jsonObject from the API.
        try {
            JSONObject root = parser.readAPI("https://power.larc.nasa.gov/cgi-bin/v1/DataAccess.py?request=execute&identifier=SinglePoint&parameters=ALLSKY_SFC_SW_DWN&startDate=" + (currentYear - dataAccuracyInYears - 1) + "&endDate=" + (currentYear - 1) + "&lat=" + latitude + "&lon=" + longitude + "&userCommunity=SSE&tempAverage=INTERANNUAL&outputList=JSON&user=anonymous\n");

            //access the data values within the json data response
            // Very specific to the API.
            JSONArray features = (JSONArray) root.get("features");
            JSONObject properties = (JSONObject) features.get(0);
            properties = properties.getJSONObject("properties");
            JSONObject parameter = (JSONObject) properties.get("parameter");
            JSONObject allSkyInsolationIncident = (JSONObject) parameter.getJSONObject("ALLSKY_SFC_SW_DWN");

            return getAverageInsolation(allSkyInsolationIncident,dataAccuracyInYears);

        }catch (NullPointerException e){
            return -1;
        }


    }

    //returns the average kW-hr/m^2/day taking into account specified amount of years.
    //"years" must not exceed the amount of years from which data was gathered.
    private double getAverageInsolation(JSONObject dataSource, int yearsBack){
        double average = 0;
        double sum = 0;
        int months = 0;
        //sum up data averages from the previous years.
        for(int i = 0 ; i <= yearsBack; i ++) {
            for (String s : dataSource.keySet()) {
                //The datasource is unsorted so we need to match it.
                if (s.startsWith(Integer.toString(currentYear - i -1))) {
                    months++;
                    sum += dataSource.getDouble(s);
                }
            }
        }

        if(months != 0) {
            //Calculate average
            average = sum / months;
        }


        return average;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
