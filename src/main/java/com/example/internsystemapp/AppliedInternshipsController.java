package com.example.internsystemapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<AppliedInternshipsLists,String> titleColumn;

    @FXML
    private TableColumn<AppliedInternshipsLists,String> companyColumn;

    @FXML
    private TableColumn<AppliedInternshipsLists,String> locationColumn;

    @FXML
    private TableColumn<AppliedInternshipsLists,String> durationColumn;

    @FXML
    private TableColumn<AppliedInternshipsLists,String> statusColumn;

    @FXML
    private TableView<AppliedInternshipsLists> tableView;
    public void initialize(){
        tableViewInfo();
        appliedInternshipsBtn.setDisable(true);
    }

    void tableViewInfo(){
        ObservableList<AppliedInternshipsLists> internships = FXCollections.observableArrayList(
                //adding dummy data to the list
                new AppliedInternshipsLists("Title 1", "Company 1", "Location 1", "Duration 1", "Status 1"),
                new AppliedInternshipsLists("Title 2", "Company 2", "Location 2", "Duration 2", "Status 2")
        );

        //binding the table view to the observable list
        tableView.setItems(internships);

        //setting the values of the table columns
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        companyColumn.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

//    void createHBox() {
//        AnchorPane anchorPane = new AnchorPane();
//
//        anchorPane.getStyleClass().add("featured-card");
//
//        anchorPane.setPrefWidth(400);
//        anchorPane.setPrefHeight(220);
//
//        Label titleLabel = new Label("Title");
//        Label companyLabel = new Label("Company");
//        Label locationLabel = new Label("Location");
//        Label durationLabel = new Label("Duration");
//        Label statusLabel = new Label("Status");
//
//        Button actionButton;
//        if (statusLabel.getText().equals("Pending")) {
//            actionButton = new Button("Cancel Application");
//            actionButton.getStyleClass().add("cancelAppBtn");
//            actionButton.setOnAction(event -> {
//
//            });
//        } else {
//            actionButton = new Button("View Details");
//            actionButton.getStyleClass().add("applyBtn");
//            actionButton.setOnAction(event -> {
//
//            });
//        }
//
//        AnchorPane.setTopAnchor(titleLabel, 20.0);
//        AnchorPane.setLeftAnchor(titleLabel, 50.0);
//
//        AnchorPane.setTopAnchor(companyLabel, 50.0);
//        AnchorPane.setLeftAnchor(companyLabel, 50.0);
//
//        AnchorPane.setTopAnchor(locationLabel, 80.0);
//        AnchorPane.setLeftAnchor(locationLabel, 50.0);
//
//        AnchorPane.setTopAnchor(durationLabel, 110.0);
//        AnchorPane.setLeftAnchor(durationLabel, 50.0);
//
//        AnchorPane.setTopAnchor(statusLabel, 140.0);
//        AnchorPane.setLeftAnchor(statusLabel, 50.0);
//
//        AnchorPane.setTopAnchor(actionButton, 170.0);
//        AnchorPane.setLeftAnchor(actionButton, 160.0);
//
//        anchorPane.getChildren().addAll(titleLabel, companyLabel, locationLabel, durationLabel, statusLabel, actionButton);
//
//        titleLabel.getStyleClass().add("internship-title");
//        companyLabel.getStyleClass().add("internship-details");
//        locationLabel.getStyleClass().add("internship-details");
//        durationLabel.getStyleClass().add("internship-details");
//        statusLabel.getStyleClass().add("internship-details");
//        HBox hBox = new HBox(anchorPane);
//        hBox.setSpacing(10);
//        appliedInternshipsContainer.getChildren().add(hBox);
//    }

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
