package es.crttn.Calculadora;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;


public class CalulatorApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        ViewController.primaryStage = primaryStage;

        ViewController controller = new ViewController();



        primaryStage.setTitle("Calculadora");
        primaryStage.setScene(new Scene(controller.getRoot(), 500, 400));
        primaryStage.show();

    }
}
