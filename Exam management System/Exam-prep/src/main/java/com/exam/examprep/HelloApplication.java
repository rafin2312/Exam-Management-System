package com.exam.examprep;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        try{
            HelloApplication.stage = stage;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("Welcome");
            stage.setScene(scene);
            stage.show();
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Failed to load initial project");
        }

    }

    public static void main(String[] args) {
        launch();
    }

    public static void sceneChange(String fxmlFilename){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFilename+".fxml"));
            Scene scene = new Scene(fxmlLoader.load(),800,600);
            stage.setScene(scene);
            stage.show();

        }catch(IOException ex){
            ex.printStackTrace();
            System.out.println("Failed to load Scene");
        }
    }
}