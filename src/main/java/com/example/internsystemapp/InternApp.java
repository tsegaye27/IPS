package com.example.internsystemapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InternApp extends Application {
    private static Stage primaryStage;
    public static void showLoginPage() throws IOException {
        Parent root = FXMLLoader.load(InternApp.class.getResource("login.fxml"));
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showHomePage() throws IOException{
        Parent root = FXMLLoader.load(InternApp.class.getResource("HomePage.fxml"));
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        primaryStage.setTitle("Home");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showSignUpPage() throws IOException{
        Parent root = FXMLLoader.load(InternApp.class.getResource("SignUp.fxml"));
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        primaryStage.setTitle("Sign-up");
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
//public class InternshipSystemApp extends Application {
//    private static Stage primaryStage;
//    private static BorderPane mainLayout;
//
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//        InternshipSystemApp.primaryStage = primaryStage;
//        InternshipSystemApp.primaryStage.setTitle("Internship System");
//
//        showLoginPage();
//    }
//

//
//    public static void showSignUpPage() throws IOException {
//        FXMLLoader loader = new FXMLLoader(InternshipSystemApp.class.getResource("SignUp.fxml"));
//        BorderPane signUpLayout = loader.load();
//        Scene scene = new Scene(signUpLayout);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void showHomePage() throws IOException {
//        FXMLLoader loader = new FXMLLoader(InternshipSystemApp.class.getResource("Home.fxml"));
//        mainLayout = loader.load();
//        Scene scene = new Scene(mainLayout);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }


