package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class CmpHomePageController {

    @FXML
    private Button homeBtn;

    @FXML
    private Label companyNameLabel;

    @FXML
    private Button returnToPostedBtn;
    @FXML
    private Button returnToPostedBtnV;
    @FXML
    private Label locationLabel;
    @FXML
    private Label locationLabelV;
    @FXML
    private Label durationLabel;
    @FXML
    private Label durationLabelV;

    @FXML
    private Label contactLabel;
    @FXML
    private Label contactLabelV;
    @FXML
    private Label paidUnpaidLabel;
    @FXML
    private Label paidUnpaidLabelV;
    @FXML
    private Label requirementsLabel;
    @FXML
    private Label requirementsLabelV;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label descriptionLabelV;
    @FXML
    private Button editPostBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Label internshipTitle;
    @FXML
    private Label internshipTitleV;
    @FXML
    private AnchorPane postDetailsPane;
    @FXML
    private Button logoutBtn;

    @FXML
    private Button manageInternshipsBtn;

    @FXML
    private Button postInternshipsBtn;

    @FXML
    private Label totalInternshipsLabel;

    @FXML
    private Label totalApplicationsLabel;

    @FXML
    private Label acceptedLabel;

    @FXML
    private Label pendingLabel;

    @FXML
    private Label rejectedLabel;

    @FXML
    private AnchorPane postDetailsViewPane;
    @FXML
    private VBox postedInternshipsContainer;

    public void initialize(){
        homeBtn.setDisable(true);
        postedInternshipsContainer.setSpacing(10);
        displayPostedInternships();
    }

    void displayPostedInternships(){
        //if the company have posted an internship
        createHBox();
    }

    void createHBox(){
            AnchorPane anchorPane = new AnchorPane();

            anchorPane.getStyleClass().add("featured-card");

            anchorPane.setPrefWidth(380);
            anchorPane.setPrefHeight(220);

            Label titleLabel = new Label("Title");
            Label companyLabel = new Label("Company");
            Label locationLabel = new Label("Location");
            Label durationLabel = new Label("Duration");
            Label statusLabel = new Label("Status");

            Button manageButton = new Button("Manage Internship");
            manageButton.getStyleClass().add("cancelBtn");
            manageButton.setOnAction(event -> {
                InternshipEditor();
            });

            Button viewDetails = new Button("View Details");
            viewDetails.getStyleClass().add("submitBtn");
            viewDetails.setOnAction(event -> {
                showDetails();
            });

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

            AnchorPane.setTopAnchor(manageButton, 180.0);
            AnchorPane.setLeftAnchor(manageButton, 70.0);

            AnchorPane.setTopAnchor(viewDetails, 180.0);
            AnchorPane.setLeftAnchor(viewDetails, 220.0);

            anchorPane.getChildren().addAll(titleLabel, companyLabel, locationLabel, durationLabel, statusLabel, manageButton, viewDetails);

            titleLabel.getStyleClass().add("internship-title");
            companyLabel.getStyleClass().add("internship-details");
            locationLabel.getStyleClass().add("internship-details");
            durationLabel.getStyleClass().add("internship-details");
            statusLabel.getStyleClass().add("internship-details");
            HBox hBox = new HBox(anchorPane);
            hBox.setSpacing(10);
            postedInternshipsContainer.getChildren().add(hBox);
    }

    void InternshipEditor(){
        postedInternshipsContainer.setVisible(false);
        postDetailsPane.setVisible(true);
    }

    void showDetails(){
        postedInternshipsContainer.setVisible(false);
        postDetailsViewPane.setVisible(true);
    }

    @FXML
    void returnToPostedBtnClicked(ActionEvent event){
        postDetailsViewPane.setVisible(false);
        postDetailsPane.setVisible(false);
        postedInternshipsContainer.setVisible(true);
    }
    @FXML
    void manageInternshipsBtnClicked(ActionEvent event) throws IOException {
        homeBtn.setDisable(false);
        InternApp.showManageInternships();
    }

    @FXML
    void postInternshipsBtnClicked(ActionEvent event) throws IOException {
        homeBtn.setDisable(false);
        InternApp.showPostInternships();
    }
    @FXML
    void logoutBtnClicked(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to Logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) logoutBtn.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            DBUtills.setCurrentCmpId(0);
        }
    }

}
