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
    private Button searchInternshipsBtn;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox appliedInternshipsContainer;

    public void initialize(){

        appliedInternshipsBtn.setDisable(true);
        appliedInternshipsContainer.setSpacing(10);
        createHBox();
    }

    void createHBox() {
        // Create the anchor pane
        AnchorPane anchorPane = new AnchorPane();

        anchorPane.getStyleClass().add("featured-card");

        // Set width and height of the anchor pane
        anchorPane.setPrefWidth(400);
        anchorPane.setPrefHeight(200);

        // Create labels
        Label titleLabel = new Label("Title");
        Label companyLabel = new Label("Company");
        Label locationLabel = new Label("Location");
        Label durationLabel = new Label("Duration");
        Label statusLabel = new Label("Status");

        Button actionButton;
        if (statusLabel.equals("Pending")) {
            actionButton = new Button("Cancel Application");
        } else {
            actionButton = new Button("View Details");
        }

        actionButton.setOnAction(event -> {
            //handle the actionButton
        });

        AnchorPane.setTopAnchor(titleLabel, 10.0);
        AnchorPane.setLeftAnchor(titleLabel, 10.0);

        AnchorPane.setTopAnchor(companyLabel, 40.0);
        AnchorPane.setLeftAnchor(companyLabel, 10.0);

        AnchorPane.setTopAnchor(locationLabel, 70.0);
        AnchorPane.setLeftAnchor(locationLabel, 10.0);

        AnchorPane.setTopAnchor(durationLabel, 100.0);
        AnchorPane.setLeftAnchor(durationLabel, 10.0);

        AnchorPane.setTopAnchor(statusLabel, 130.0);
        AnchorPane.setLeftAnchor(statusLabel, 10.0);

        AnchorPane.setTopAnchor(actionButton, 160.0);
        AnchorPane.setLeftAnchor(actionButton, 160.0);

        anchorPane.getChildren().addAll(titleLabel, companyLabel, locationLabel, durationLabel, statusLabel, actionButton);

        titleLabel.getStyleClass().add("internship-title");
        companyLabel.getStyleClass().add("internship-details");
        locationLabel.getStyleClass().add("internship-details");
        durationLabel.getStyleClass().add("internship-details");
        statusLabel.getStyleClass().add("internship-details");
        actionButton.getStyleClass().add("applyBtn");

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
            InternApp.showInternLoginPage();
        }
    }

    @FXML
    void searchInternshipsBtnClicked(ActionEvent event) throws IOException {
        appliedInternshipsBtn.setDisable(false);
        InternApp.showSearchInternships();
    }
}
