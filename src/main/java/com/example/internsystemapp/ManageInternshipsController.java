package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.util.Optional;

public class ManageInternshipsController {

    @FXML
    private Button homeBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button manageInternshipsBtn;

    @FXML
    private Button postInternshipsBtn;

    public void initialize(){
        manageInternshipsBtn.setDisable(true);
    }

    @FXML
    void homeBtnClicked(ActionEvent event) throws IOException {
        manageInternshipsBtn.setDisable(false);
        InternApp.showCmpHomePage();
    }

    @FXML
    void logoutBtnClicked(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to Logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            InternApp.showWelcomePage();
            DBUtills.setCurrentCmpId(0);
        }
    }

    @FXML
    void postInternshipsBtnClicked(ActionEvent event) throws IOException {
        manageInternshipsBtn.setDisable(false);
        InternApp.showPostInternships();
    }

}
