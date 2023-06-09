package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class SearchInternshipsController {
    @FXML
    private Button appliedInternshipsBtn;

    @FXML
    private AnchorPane applicationForm;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField degreeField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField locationField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField skillsField;

    @FXML
    private Button submitBtn;

    @FXML
    private TextField universityNameField;

    @FXML
    private TextField yearOfStudyField;

    @FXML
    private ToggleButton durationFilterBtn;

    @FXML
    private ToggleButton fieldsFilterBtn;

    @FXML
    private ToggleButton locationFilterBtn;

    @FXML
    private TextField searchField;

    @FXML
    private ComboBox<String> paymentStatusFilterBtn;

    @FXML
    private Button searchBtn;

    @FXML
    private VBox searchResultContainer;
    @FXML
    private Button homeBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button searchInternshipsBtn;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button applyNowBtn;

    @FXML
    private Label companyNameLabel;

    @FXML
    private Label contactLabel;

    @FXML
    private Label description;

    @FXML
    private Label durationLabel;

    @FXML
    private AnchorPane internshipDetailsPane;

    @FXML
    private Label locationLabel;

    @FXML
    private Label paidUnpaidLabel;

    @FXML
    private Label requirementsLabel;

    @FXML
    private Button returnToFeaturedBtn;



    public void initialize(){
        searchInternshipsBtn.setDisable(true);
        paymentStatusFilterBtn.getItems().add("Paid");
        paymentStatusFilterBtn.getItems().add("Unpaid");
        searchResultContainer.setSpacing(10);
    }

    @FXML
    void searchBtnClicked(ActionEvent event){
        String searchedText = searchField.getText();
        boolean filterByLocation = locationFilterBtn.isSelected();
        boolean filterByDuration = durationFilterBtn.isSelected();
        boolean filterByField = fieldsFilterBtn.isSelected();
        String selectedValue = paymentStatusFilterBtn.getSelectionModel().getSelectedItem();

               if(filterByLocation){
                   //compare searchedText with location values in DB
                   //if found
                   createHBox();
        } else if (filterByDuration) {

                   createHBox();
        } else if (filterByField) {

                   createHBox();
        } else if(selectedValue.equals("Paid")){
                   createHBoxPaid();
        } else{
                //brute force search
                   //if found
//                   createHBox();
                   //if not found
                   noResultFound();
        }
    }

    void createHBox(){
        HBox hBox = new HBox();
        hBox.setSpacing(10);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefWidth(540);
        anchorPane.setPrefHeight(120);
        anchorPane.getStyleClass().add("featured-card");

        Label internshipTitleLabel = new Label("Internship Title");//fetch from DB
        Label locationLabel = new Label("Location");
        Label durationLabel = new Label("Duration");

        Hyperlink readMoreLink = new Hyperlink("Read More");
        readMoreLink.setOnAction(event -> {
//            AnchorPane clickedAnchorPane = (AnchorPane) event.getSource();
//            String internshipId = (String) clickedAnchorPane.getUserData();

            showDetails();
        });

        anchorPane.getChildren().addAll(internshipTitleLabel, locationLabel, durationLabel, readMoreLink);

        AnchorPane.setTopAnchor(internshipTitleLabel, 10.0);
        AnchorPane.setTopAnchor(locationLabel, 40.0);
        AnchorPane.setTopAnchor(durationLabel, 60.0);
        AnchorPane.setTopAnchor(readMoreLink,80.0);

        AnchorPane.setLeftAnchor(internshipTitleLabel, 230.0);
        AnchorPane.setLeftAnchor(locationLabel, 250.0);
        AnchorPane.setLeftAnchor(durationLabel, 250.0);
        AnchorPane.setLeftAnchor(readMoreLink, 240.0);

        internshipTitleLabel.getStyleClass().add("internship-title");
        locationLabel.getStyleClass().add("internship-details");
        durationLabel.getStyleClass().add("internship-details");
        readMoreLink.getStyleClass().add("login-link");


        hBox.getChildren().add(anchorPane);

        searchResultContainer.getChildren().add(hBox);
    }

    void showDetails(){
        scrollPane.setVisible(false);
        internshipDetailsPane.setVisible(true);
    }

    void createHBoxPaid(){
        HBox hBox = new HBox();
        hBox.setSpacing(10);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefWidth(540);
        anchorPane.setPrefHeight(140);
        anchorPane.getStyleClass().add("featured-card");

        Label internshipTitleLabel = new Label("Internship Title");//fetch from database
        Label locationLabel = new Label("Location");
        Label durationLabel = new Label("Duration");
        Label paidLabel = new Label("Paid");

        Hyperlink readMoreLink = new Hyperlink("Read More");
        readMoreLink.setOnAction(event -> {
//            AnchorPane clickedAnchorPane = (AnchorPane) event.getSource();
//            String internshipId = (String) clickedAnchorPane.getUserData();

            showDetails();
        });

        anchorPane.getChildren().addAll(internshipTitleLabel, locationLabel, durationLabel, paidLabel, readMoreLink);

        AnchorPane.setTopAnchor(internshipTitleLabel, 10.0);
        AnchorPane.setTopAnchor(locationLabel, 40.0);
        AnchorPane.setTopAnchor(durationLabel, 60.0);
        AnchorPane.setTopAnchor(paidLabel, 80.0);
        AnchorPane.setTopAnchor(readMoreLink,100.0);

        AnchorPane.setLeftAnchor(internshipTitleLabel, 230.0);
        AnchorPane.setLeftAnchor(locationLabel, 250.0);
        AnchorPane.setLeftAnchor(durationLabel, 250.0);
        AnchorPane.setLeftAnchor(paidLabel, 250.0);
        AnchorPane.setLeftAnchor(readMoreLink, 240.0);

        internshipTitleLabel.getStyleClass().add("internship-title");
        locationLabel.getStyleClass().add("internship-details");
        durationLabel.getStyleClass().add("internship-details");
        paidLabel.getStyleClass().add("internship-details");
        readMoreLink.getStyleClass().add("login-link");


        hBox.getChildren().add(anchorPane);

        searchResultContainer.getChildren().add(hBox);
    }

    void noResultFound(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("No result found!");
        alert.setHeaderText(null);
        alert.setTitle(null);
        alert.showAndWait();
    }

    @FXML
    void applyNowBtnClicked(ActionEvent event){
        internshipDetailsPane.setVisible(false);
        applicationForm.setVisible(true);
    }

    @FXML
    void submitBtnClicked(ActionEvent event){
        if(validateInputs()){
            //save into database
        }else{
            showError("Please fill every field");
        }
    }

    private boolean validateInputs(){
        String fullName = fullNameField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        String location = locationField.getText();
        String universityName = universityNameField.getText();
        String degree = degreeField.getText();
        String yearOfStudy = yearOfStudyField.getText();
        String skills = skillsField.getText();

        if(fullName.isEmpty()||email.isEmpty()||phoneNumber.isEmpty()||location.isEmpty()||universityName.isEmpty()||degree.isEmpty()||yearOfStudy.isEmpty()||skills.isEmpty()){
            return false;
        }
        return true;
    }

    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void cancelBtnClicked(ActionEvent event){
        applicationForm.setVisible(false);
        internshipDetailsPane.setVisible(true);
    }

    @FXML
    void returnToFeaturedBtnClicked(ActionEvent event){
        internshipDetailsPane.setVisible(false);
        scrollPane.setVisible(true);
    }
    @FXML
    void appliedInternshipsBtnClicked(ActionEvent event) throws IOException {
        searchInternshipsBtn.setDisable(false);
        InternApp.showAppliedInternships();
    }

    @FXML

    void locationFilterBtnClicked(ActionEvent event){
        if(locationFilterBtn.isSelected()){
            durationFilterBtn.getStyleClass().remove("filterBtn-focused");
            fieldsFilterBtn.getStyleClass().remove("filterBtn-focused");
            locationFilterBtn.getStyleClass().add("filterBtn-focused");
        }else{
            locationFilterBtn.getStyleClass().remove("filterBtn-focused");
        }
    }

    @FXML
    void comboBoxFilterClicked(ActionEvent event){
        String selectedValue = paymentStatusFilterBtn.getSelectionModel().getSelectedItem();

        if(!selectedValue.isEmpty()){
            durationFilterBtn.getStyleClass().remove("filterBtn-focused");
            durationFilterBtn.setSelected(false);
            fieldsFilterBtn.getStyleClass().remove("filterBtn-focused");
            fieldsFilterBtn.setSelected(false);
            locationFilterBtn.getStyleClass().remove("filterBtn-focused");
            locationFilterBtn.setSelected(false);
        }
    }

    @FXML
    void durationFilterBtnClicked(ActionEvent event){
        if(durationFilterBtn.isSelected()){
            durationFilterBtn.getStyleClass().add("filterBtn-focused");
            fieldsFilterBtn.getStyleClass().remove("filterBtn-focused");
            fieldsFilterBtn.setSelected(false);
            locationFilterBtn.getStyleClass().remove("filterBtn-focused");
            locationFilterBtn.setSelected(false);
        }else{
            durationFilterBtn.getStyleClass().remove("filterBtn-focused");
            durationFilterBtn.setSelected(false);
        }
    }

    @FXML
    void fieldsFilterBtnClicked(ActionEvent event){
        if(fieldsFilterBtn.isSelected()){
            durationFilterBtn.getStyleClass().remove("filterBtn-focused");
            durationFilterBtn.setSelected(false);
            fieldsFilterBtn.getStyleClass().add("filterBtn-focused");
            locationFilterBtn.getStyleClass().remove("filterBtn-focused");
            locationFilterBtn.setSelected(false);
        }else{
            fieldsFilterBtn.getStyleClass().remove("filterBtn-focused");
            fieldsFilterBtn.setSelected(false);
        }
    }
    @FXML
    void homeBtnClicked(ActionEvent event) throws IOException, SQLException {
        searchInternshipsBtn.setDisable(false);
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
}
