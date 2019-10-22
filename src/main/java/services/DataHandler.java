package main.java.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class DataHandler {
    //The method below serialize n list of object into a .ser file. The method takes tow parameters:
    //first the path of output file, and second the list which to serialize. The class that we want to
    //serialize must implement Serializable

    public void Serialize(String fileName, List <Object> objectList) {

        try {

            ObjectOutputStream outputFile = new ObjectOutputStream(new FileOutputStream(fileName)); // create and save to the file.
            outputFile.writeObject(objectList);
            outputFile.flush(); // empty the buffer
            outputFile.close();  // closes the file to avoid leaking and corrupting.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
