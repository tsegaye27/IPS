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
            DBUtills.signUpCmp(event, companyNameField.getText(), companyEmailField.getText(), passwordField.getText(),Integer.parseInt(contactPhoneField.getText()), locationField.getText());
            showInfo("Successfully signed-up");
            InternApp.showCmpLoginPage();
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

        if(companyName.trim().isEmpty()||companyEmail.trim().isEmpty()||password.trim().isEmpty()||location.trim().isEmpty()||contactPhone.trim().isEmpty()){
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
        InternApp.showCmpLoginPage();
    }

}
