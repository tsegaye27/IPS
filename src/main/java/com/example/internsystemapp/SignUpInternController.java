package com.example.internsystemapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class SignUpInternController{
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy");
    DateTimeFormatter dOBFormater = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    @FXML
    private TextField emailField;

    @FXML
    private TextField fieldOfStudyField;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private DatePicker dateOfBirthField;

    @FXML
    private DatePicker graduationYearField;

    @FXML
    private Hyperlink loginLink;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signUpButton;
    @FXML
    private TextField locationField;

    @FXML
    void signUpClicked(ActionEvent event) throws IOException {
        LocalDate graduationYearDate = graduationYearField.getValue();
        String graduationYear = graduationYearDate.format(formatDate);
        LocalDate dateOfBirthDate = dateOfBirthField.getValue();
        String dateOfBirth = dateOfBirthDate.format(dOBFormater);
        if(validateInputs()){
            DBUtills.signUpIntern(event, fullNameField.getText(), emailField.getText(), passwordField.getText(), Integer.parseInt(phoneNumberField.getText()), fieldOfStudyField.getText(), dateOfBirth, graduationYear, locationField.getText());
            InternApp.showInternHomePage();
        }else {
            showError("Please fill in every field");
        }
    }

    private boolean validateInputs(){
        String fullName = fullNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String fieldOfStudy = fieldOfStudyField.getText();
        String phoneNumber = phoneNumberField.getText();
        LocalDate graduationYear = graduationYearField.getValue();
        LocalDate dateOfBirth = dateOfBirthField.getValue();
        String location = locationField.getText();

        if((fullName.trim().isEmpty())||(email.trim().isEmpty())||(password.trim().isEmpty())||(phoneNumber.trim().isEmpty())||(graduationYear==null)||(fieldOfStudy.trim().isEmpty())||(location.trim().isEmpty())||dateOfBirth==null){
            return false;
        }
            return true;
    }
    @FXML
    void loginLinkClicked(ActionEvent event) throws IOException {
        InternApp.showInternLoginPage();
    }

    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
