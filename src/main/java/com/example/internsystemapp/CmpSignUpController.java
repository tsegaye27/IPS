package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class CmpSignUpController {

    @FXML
    private TextField companyEmailField;

    @FXML
    private Hyperlink companyLoginLink;

    @FXML
    private TextField companyNameField;

    @FXML
    private TextField contactPhoneField;

    @FXML
    private TextField locationField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signUpButton;

    @FXML
    void SignUpClicked(ActionEvent event) throws IOException {
        String companyName = companyNameField.getText();
        String companyEmail = companyEmailField.getText();
        String password = passwordField.getText();
        String contactPhone = contactPhoneField.getText();
        String location = locationField.getText();

        if(companyName.isEmpty()||companyEmail.isEmpty()||password.isEmpty()||location.isEmpty()||contactPhone.isEmpty()){
            showError("Please fill every field");
        }else{
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
    @FXML
    void loginLinkClicked(ActionEvent event) {

    }

}
