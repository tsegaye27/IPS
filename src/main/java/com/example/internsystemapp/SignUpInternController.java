package com.example.internsystemapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class SignUpInternController {

    @FXML
    private TextField emailField;

    @FXML
    private TextField fieldOfStudyField;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField graduationYearField;

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
        String fullName = fullNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String fieldOfStudy = fieldOfStudyField.getText();
        String graduationYear = graduationYearField.getText();
        String location = locationField.getText();

        if((fullName.isEmpty())||(email.isEmpty())||(password.isEmpty())||(fieldOfStudy.isEmpty())||(graduationYear.isEmpty())||(location.isEmpty())){
            showError("Please fill in every field");
        }else {
            InternApp.showInternHomePage();
        }
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
