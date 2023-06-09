package com.example.internsystemapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class InternApp extends Application {
    private static Stage primaryStage;

    public static void showInternSignUpPage() throws IOException{
        Parent root = FXMLLoader.load(InternApp.class.getResource("SignUpIntern.fxml"));
        Scene scene = new Scene(root, 600, 440);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        Image image = new Image(InternApp.class.getResource("/img/logo1.png").toExternalForm());
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Sign-up");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showCmpSignUpPage() throws IOException{
        Parent root = FXMLLoader.load(InternApp.class.getResource("CmpSignUpPage.fxml"));
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        Image image = new Image(InternApp.class.getResource("/img/logo1.png").toExternalForm());
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Sign-up");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showReviewedApplicants() throws IOException{
        Parent root = FXMLLoader.load(InternApp.class.getResource("ReviewedApplicants.fxml"));
        Scene scene = new Scene(root, 820, 600);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        Image image = new Image(InternApp.class.getResource("/img/logo1.png").toExternalForm());
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Managed Applicants");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void showInternLoginPage() throws IOException {
        Parent root = FXMLLoader.load(InternApp.class.getResource("InternLogin.fxml"));
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        Image image = new Image(InternApp.class.getResource("/img/logo1.png").toExternalForm());
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showPostInternships() throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(InternApp.class.getResource("PostInternships.fxml")));
        Scene scene = new Scene(root, 820,600);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        primaryStage.setTitle("Post Internships");
        Image image = new Image(InternApp.class.getResource("/img/logo1.png").toExternalForm());
        primaryStage.getIcons().add(image);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showManageInternships() throws IOException{
        Parent root = FXMLLoader.load(InternApp.class.getResource("ManageInternships.fxml"));
        Scene scene = new Scene(root, 820, 600);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        Image image = new Image(InternApp.class.getResource("/img/logo1.png").toExternalForm());
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Manage Internships");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void showCmpLoginPage() throws IOException {
        Parent root = FXMLLoader.load(InternApp.class.getResource("CmpLogin.fxml"));
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        Image image = new Image(InternApp.class.getResource("/img/logo1.png").toExternalForm());
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showInternHomePage() throws IOException, SQLException {
        Parent root = FXMLLoader.load(InternApp.class.getResource("InternHomePage.fxml"));
        Scene scene = new Scene(root, 820, 600);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        StackPane sp = (StackPane) root;
        AnchorPane ap = (AnchorPane) sp.getChildren().get(0);
        InternHomePageController internHome = new InternHomePageController();
        internHome.loadFeaturedInternships(ap);
        Image image = new Image(InternApp.class.getResource("/img/logo1.png").toExternalForm());
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Home");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showSearchInternships() throws IOException{
        Parent root = FXMLLoader.load(InternApp.class.getResource("SearchInternships.fxml"));
        Scene scene = new Scene(root, 820, 600);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        Image image = new Image(InternApp.class.getResource("/img/logo1.png").toExternalForm());
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Search Internships");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showAppliedInternships() throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(InternApp.class.getResource("AppliedInternships.fxml")));
        Scene scene = new Scene(root, 820, 600);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        Image image = new Image(InternApp.class.getResource("/img/logo1.png").toExternalForm());
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Applied Internships");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showCmpHomePage() throws IOException{
        Parent root = FXMLLoader.load(InternApp.class.getResource("CmpHomePage.fxml"));
        Scene scene = new Scene(root, 820, 600);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        Image image = new Image(InternApp.class.getResource("/img/logo1.png").toExternalForm());
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Home Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showWelcomePage() throws IOException{
        Parent root = FXMLLoader.load(InternApp.class.getResource("Welcome.fxml"));
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(String.valueOf((InternApp.class.getResource("/style.css"))));
        Image image = new Image(InternApp.class.getResource("/img/logo1.png").toExternalForm());
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {
        InternApp.primaryStage = primaryStage;
        primaryStage.setTitle("Internship App");
        InternApp.showWelcomePage();
    }
    public static void main(String[] args) {
        launch(args);

    }
}


