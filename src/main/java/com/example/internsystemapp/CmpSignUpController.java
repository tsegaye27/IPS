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
        if(validateInputs()){
            showInfo("Successfully signed-up");
            InternApp.showCmpHomePage();
        }else{
            showError("Please fill every field");
        }
    }

    private boolean validateInputs(){
        String companyName = companyNameField.getText();
        String companyEmail = companyEmailField.getText();
        String password = passwordField.getText();
        String contactPhone = contactPhoneField.getText();
        String location = locationField.getText();

        if(companyName.isEmpty()||companyEmail.isEmpty()||password.isEmpty()||location.isEmpty()||contactPhone.isEmpty()){
            return false;
        }
        
        return true;
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
    void loginLinkClicked(ActionEvent event) throws IOException {
        InternApp.showInternLoginPage();
    }

}
