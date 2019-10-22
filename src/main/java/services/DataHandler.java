package main.java.services;

import java.io.*;
import java.util.ArrayList;
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
    //This method will deserialize the serialized data in the .ser file to use it.
    //Generic methods to accept different types of objects.
    public <T> List <T> Deserialize(String fileName) throws IOException {

        List <T> deserializedList = new ArrayList();
        ObjectInputStream inputFile = new ObjectInputStream(new FileInputStream(fileName));
        try {
            while (inputFile.available() != -1) {
                //Read object from file
                T objectToDeserialize = (T) inputFile.readObject();
                deserializedList.add(objectToDeserialize);
            }
        } catch (EOFException ex) {
            //ex.printStackTrace();


        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return deserializedList;
    }

}
