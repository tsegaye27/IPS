package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class InternLoginController {

        @FXML
        private TextField emailField;

        @FXML
        private TextField fullNameField;

        @FXML
        private Button loginBtn;

        @FXML
        private PasswordField passwordField;

        @FXML
        private Hyperlink signUplink;

        @FXML
        void loginBtnClicked(ActionEvent event) throws IOException{
        String fullName = fullNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        if(fullName.trim().isEmpty()||email.trim().isEmpty()||password.trim().isEmpty()){
                showError("Please fill every field");
        } else{
                DBUtills.loginIntern(event, fullName,email, password);
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
        void signUplinkClicked(ActionEvent event) throws IOException {
                InternApp.showInternSignUpPage();
        }

}
