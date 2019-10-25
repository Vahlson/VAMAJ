package main.java.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: An abstract class that gathers common code between ApiParsers.
// Used by: LocationCreatorAPI
// Implemented by: ApiJSONParser, [potential data parsers of different types].
// Info: T is the expected type of data object to be read from the API. (Ex. JSONOBJECT, XML)

public abstract class ApiParser<T> {

    //Template Method.
    abstract T parseData(String data);

    //Reading of the API takes place here.
    public T readAPI(String URL) {
        String dataString = getDataFromUrl(URL);

        //The concrete ApiParser implementation parses the string and returns a suitable object.
        return parseData(dataString);
    }

    // This method returns a string gathered from the API. Should not be different between APIs
    private String getDataFromUrl(String u) {
        StringBuilder sb = new StringBuilder();
        try {
            //Java syntax for reading a string from an URL. HTTP connection is hidden.
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

}
