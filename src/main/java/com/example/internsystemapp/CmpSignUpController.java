package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.w3c.dom.Text;

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
    private PasswordField confirmPasswordField;

    @FXML
    private TextField passwordViewField;

    @FXML
    private TextField confirmPasswordViewField;

    @FXML
    private Button hideConfirmPasswordBtn;

    @FXML
    private Button showConfirmPasswordBtn;

    @FXML
    private Button showPasswordBtn;

    @FXML
    private Button hidePasswordBtn;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signUpButton;

    private boolean validateEmail(){
        String email = companyEmailField.getText();

        if (email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validatePasswordLength(){
        String pd = passwordField.getText();
        if (pd.length()<6){
            return false;
        }
        return true;
    }
    private boolean validatePhoneNumber(){
        // Removing any non-digit characters from the phone number
        String phoneNumber = contactPhoneField.getText();
        phoneNumber.replaceAll("[^\\d]", "");

        // Check if the phone number has exactly 10 digits
        if (phoneNumber.length() != 10) {
            return false;
        }
        // Check if the phone number contains only digits
        if (!phoneNumber.matches("\\d+")) {
            return false;
        }

        return true;

    }

    private boolean validateConfirmPassword() {
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        return password.equals(confirmPassword);
    }

    @FXML
    void SignUpClicked(ActionEvent event) throws IOException {
        if(validateInputs()){
            if(validateEmail()){
                if(validatePasswordLength()){
                    if(validateConfirmPassword()){
                        if(validatePhoneNumber()){
                            DBUtills.signUpCmp(event, companyNameField.getText(), companyEmailField.getText(), passwordField.getText(),Integer.parseInt(contactPhoneField.getText()), locationField.getText());
                            showInfo("Successfully signed-up");
                            InternApp.showCmpLoginPage();
                        }else showWarning("Phone Number must be 10 digits long!");
                    }else showError("Passwords do not match!");
                }else showWarning("Password must be at least 6 characters long!");
            }else showError("Invalid Email!");
        }else showError("Please fill every field!");
    }

    @FXML
    void hideConfirmPasswordBtnClicked(ActionEvent event){
        hideConfirmPasswordBtn.setVisible(false);
        showConfirmPasswordBtn.setVisible(true);
        confirmPasswordViewField.setVisible(false);
        confirmPasswordField.setVisible(true);
        confirmPasswordField.setText(confirmPasswordViewField.getText());
    }

    @FXML
    void hidePasswordBtnClicked(ActionEvent event){
        hidePasswordBtn.setVisible(false);
        showPasswordBtn.setVisible(true);
        passwordViewField.setVisible(false);
        passwordField.setVisible(true);
        passwordField.setText(passwordViewField.getText());
    }

    @FXML
    void showConfirmPasswordBtnClicked(ActionEvent event){
        showConfirmPasswordBtn.setVisible(false);
        hideConfirmPasswordBtn.setVisible(true);
        confirmPasswordField.setVisible(false);
        confirmPasswordViewField.setVisible(true);
        confirmPasswordViewField.setText(confirmPasswordField.getText());
    }

    @FXML
    void showPasswordBtnClicked(ActionEvent event){
        showPasswordBtn.setVisible(false);
        hidePasswordBtn.setVisible(true);
        passwordField.setVisible(false);
        passwordViewField.setVisible(true);
        passwordViewField.setText(passwordField.getText());
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

    private void showWarning(String message){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void loginLinkClicked(ActionEvent event) throws IOException {
        InternApp.showCmpLoginPage();
    }

}
