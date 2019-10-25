package main.java.services.Geolocation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Representation of an IP-address.
// Used by: Geolocation.
// Uses: Gathers the users public IP-address.

class IPAddress {

    //Gathers IP address from the webb.
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