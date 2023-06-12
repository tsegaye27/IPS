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
