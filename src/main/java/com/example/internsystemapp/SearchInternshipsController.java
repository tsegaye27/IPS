package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Optional;

public class SearchInternshipsController {
    @FXML
    private Button appliedInternshipsBtn;

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
                   createHBox();
        }
    }

    void createHBox(){
        HBox hBox = new HBox();
        hBox.setSpacing(10);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefWidth(540);
        anchorPane.setPrefHeight(120);
        anchorPane.getStyleClass().add("featured-card");

        Label internshipTitleLabel = new Label("Internship Title");
        Label locationLabel = new Label("Location");
        Label durationLabel = new Label("Duration");

        Hyperlink readMoreLink = new Hyperlink("Read More");
        readMoreLink.setOnAction(event -> {
            AnchorPane clickedAnchorPane = (AnchorPane) event.getSource();
            String internshipId = (String) clickedAnchorPane.getUserData();
            showDetails(internshipId);
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

    void showDetails(String internshipId){

    }

    void createHBoxPaid(){

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
    void homeBtnClicked(ActionEvent event) throws IOException{
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
