package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class AppliedInternshipsController {
    @FXML
    private Button appliedInternshipsBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Label noAppliedInternships;

    @FXML
    private Button searchInternshipsBtn;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox appliedInternshipsContainer;

    public void initialize(){

        appliedInternshipsBtn.setDisable(true);
        appliedInternshipsContainer.setSpacing(10);
        displayAppliedInternships();
    }

    void displayAppliedInternships(){
        //if the current user have applied to internships
        createHBox();
        //else{
        //scrollPane.setVisible(false);
       // noAppliedInternships.setVisible(true);}
    }

    void createHBox() {
        AnchorPane anchorPane = new AnchorPane();

        anchorPane.getStyleClass().add("featured-card");

        anchorPane.setPrefWidth(400);
        anchorPane.setPrefHeight(220);

        Label titleLabel = new Label("Title");
        Label companyLabel = new Label("Company");
        Label locationLabel = new Label("Location");
        Label durationLabel = new Label("Duration");
        Label statusLabel = new Label("Status");

        Button actionButton;
        if (statusLabel.getText().equals("Pending")) {
            actionButton = new Button("Cancel Application");
            actionButton.getStyleClass().add("cancelAppBtn");
            actionButton.setOnAction(event -> {

            });
        } else {
            actionButton = new Button("View Details");
            actionButton.getStyleClass().add("applyBtn");
            actionButton.setOnAction(event -> {

            });
        }

        AnchorPane.setTopAnchor(titleLabel, 20.0);
        AnchorPane.setLeftAnchor(titleLabel, 50.0);

        AnchorPane.setTopAnchor(companyLabel, 50.0);
        AnchorPane.setLeftAnchor(companyLabel, 50.0);

        AnchorPane.setTopAnchor(locationLabel, 80.0);
        AnchorPane.setLeftAnchor(locationLabel, 50.0);

        AnchorPane.setTopAnchor(durationLabel, 110.0);
        AnchorPane.setLeftAnchor(durationLabel, 50.0);

        AnchorPane.setTopAnchor(statusLabel, 140.0);
        AnchorPane.setLeftAnchor(statusLabel, 50.0);

        AnchorPane.setTopAnchor(actionButton, 170.0);
        AnchorPane.setLeftAnchor(actionButton, 160.0);

        anchorPane.getChildren().addAll(titleLabel, companyLabel, locationLabel, durationLabel, statusLabel, actionButton);

        titleLabel.getStyleClass().add("internship-title");
        companyLabel.getStyleClass().add("internship-details");
        locationLabel.getStyleClass().add("internship-details");
        durationLabel.getStyleClass().add("internship-details");
        statusLabel.getStyleClass().add("internship-details");
        HBox hBox = new HBox(anchorPane);
        hBox.setSpacing(10);
        appliedInternshipsContainer.getChildren().add(hBox);
    }

    @FXML
    void homeBtnClicked(ActionEvent event) throws IOException, SQLException {
        appliedInternshipsBtn.setDisable(false);
        InternApp.showInternHomePage();
    }

    @FXML
    void logoutBtnClicked(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to Logout?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            InternApp.showWelcomePage();
        }
    }

    @FXML
    void searchInternshipsBtnClicked(ActionEvent event) throws IOException {
        appliedInternshipsBtn.setDisable(false);
        InternApp.showSearchInternships();
    }
}
