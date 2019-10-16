package main.java;

import javafx.application.Application;
import main.java.model.ModelFacade;
import main.java.services.ServiceFacade;
import main.java.viewcontroller.PrimaryController;
import main.java.viewcontroller.Window;

public class Main {
    public static void main(String[] args) {

        // Creating the model facade
        ModelFacade modelFacade = new ModelFacade();

        // Creating the primary controller
        PrimaryController primaryController = new PrimaryController();
        primaryController.setModelFacade(modelFacade);

        System.out.println("Launching...");
        Application.launch(Window.class, args);
    }
}
