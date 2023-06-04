package com.example.internsystemapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InternApp extends Application {
    private static Stage primaryStage;

    public static void showSignUpPage() throws IOException{
        Parent root = FXMLLoader.load(InternApp.class.getResource("SignUpIntern.fxml"));
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        primaryStage.setTitle("Sign-up");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void showLoginPage() throws IOException {
        Parent root = FXMLLoader.load(InternApp.class.getResource("LoginIntern.fxml"));
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showHomePage() throws IOException{
        Parent root = FXMLLoader.load(InternApp.class.getResource("HomePageIntern.fxml"));
        Scene scene = new Scene(root, 820, 600);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        primaryStage.setTitle("Home");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showSearchInternships() throws IOException{
        Parent root = FXMLLoader.load(InternApp.class.getResource("SearchInternships.fxml"));
        Scene scene = new Scene(root, 820, 600);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        primaryStage.setTitle("Search Internships");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showAppliedInternships() throws IOException{
        Parent root = FXMLLoader.load(InternApp.class.getResource("AppliedInternships.fxml"));
        Scene scene = new Scene(root, 820, 600);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        primaryStage.setTitle("Applied Internships");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) throws IOException{
        InternApp.primaryStage = primaryStage;
        InternApp.primaryStage.setTitle("Internship App");
        InternApp.showSignUpPage();
    }
    public static void main(String[] args) {
        launch(args);
    }
}


