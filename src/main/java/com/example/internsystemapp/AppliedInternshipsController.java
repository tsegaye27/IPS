package com.example.internsystemapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.ResultSet;
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

    ObservableList<AppliedInternshipsLists> internships = FXCollections.observableArrayList();
    String SQL;

    public void initialize() throws SQLException {
        tableViewInfo();
        appliedInternshipsBtn.setDisable(true);
    }

    void tableViewInfo() throws SQLException {
        SQL = "select internshipposts.title, internshipposts.duration, company.name, company.location, application.status from internshipposts join application on internshipposts.id = application.internshipId join company on internshipposts.company_id = company.id where application.internId ="+DBUtills.getCurrentInternId();
        ResultSet rst = DBUtills.getData(SQL);
        while(rst.next()){
            String title = rst.getString("title");
            String duration = rst.getString("duration");
            String companyName = rst.getString("name");
            String location = rst.getString("location");
            String status = rst.getString("status");

            internships.add(new AppliedInternshipsLists(title, companyName, location, duration, status));
        }


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
