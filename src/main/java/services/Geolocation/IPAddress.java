package services.Geolocation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

class IPAddress {

    static String getIp() throws Exception {

        // Using web service to fetch public IP address (for geolocation database)
        URL myIp = new URL("http://checkip.amazonaws.com");

        // Trying to read data from the connection
        BufferedReader in = null;
        try {

            // If connection is successful, return ip
            in = new BufferedReader(new InputStreamReader(
                    myIp.openStream()));
            return in.readLine();

        } finally {

            // Close the input stream
            if (in != null) {
                try {
                    in.close();

                    // If something went wrong
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}