package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.io.IOException;
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

    public void initialize(){
        appliedInternshipsBtn.setDisable(true);
    }

    @FXML
    void homeBtnClicked(ActionEvent event) throws IOException {
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
