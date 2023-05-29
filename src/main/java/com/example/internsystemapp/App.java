package com.example.internsystemapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(String.valueOf((getClass().getResource("/style.css"))));
        primaryStage.setTitle("Home");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(App.class, args);
    }
}

