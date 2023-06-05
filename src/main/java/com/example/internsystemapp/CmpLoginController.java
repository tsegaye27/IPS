package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class CmpLoginController {

    @FXML
    private TextField companyNameField;

    @FXML
    private TextField companyEmailField;
    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Hyperlink signUplink;

    @FXML
    void loginBtnClicked(ActionEvent event) throws IOException {
        String companyName = companyNameField.getText();
        String companyEmail = companyEmailField.getText();
        String password = passwordField.getText();

        if (companyName.isEmpty()||companyEmail.isEmpty()||password.isEmpty()){
            showError("Please fill every field");
        }else{
            showInfo("Successfully Logged-in");
            InternApp.showCmpHomePage();
        }
    }

    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfo(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    @FXML
    void signUplinkClicked(ActionEvent event) throws IOException{
        InternApp.showCmpSignUpPage();
    }

}

