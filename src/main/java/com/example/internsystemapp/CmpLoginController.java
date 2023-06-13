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

        if (companyName.trim().isEmpty()||companyEmail.trim().isEmpty()||password.trim().isEmpty()){
            showError("Please fill every field");
        }else{
            DBUtills.loginCmp(event, companyName, companyEmail, password);

        }
    }

    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void signUplinkClicked(ActionEvent event) throws IOException{
        InternApp.showCmpSignUpPage();
    }

}

