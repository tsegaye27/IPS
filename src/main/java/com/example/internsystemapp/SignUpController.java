package com.example.internsystemapp;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SignUpController {
    @FXML
    private TextField fullNameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField fieldOfStudyField;

    @FXML
    private TextField graduationYearField;

    @FXML
    private TextField skillsField;

    @FXML
    private Button signUpButton;

    @FXML
    private Button closeButton;

    @FXML
    private Hyperlink loginLink;
    @FXML
    private Label statusLabel;

    @FXML
    private void signUpClicked(MouseEvent event) {
        // Retrieve input values
        try{
            String fullName = fullNameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            String fieldOfStudy = fieldOfStudyField.getText();
            String graduationYear = graduationYearField.getText();
            String skills = skillsField.getText();

            // Perform data validation
            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || fieldOfStudy.isEmpty() || graduationYear.isEmpty() || skills.isEmpty()) {
                statusLabel.setText("Please fill in all required fields.");
                return;
            }

            // Perform additional validation if needed

            // Process sign-up logic
            // Here, you can write the code to handle the sign-up process,
            // such as creating a new intern account, storing the information in a database, etc.

            // Provide feedback to the user
            statusLabel.setText("Sign-up successful!");

            // Clear input fields
            fullNameField.clear();
            emailField.clear();
            passwordField.clear();
            fieldOfStudyField.clear();
            graduationYearField.clear();
            skillsField.clear();
        }catch(Exception e){
        e.printStackTrace();
        }
    }

    @FXML
    private void closeClicked(MouseEvent event) {
        // Close the sign-up window
        closeButton.isVisible();
        Stage stage = (Stage) signUpButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void loginClicked(MouseEvent event) {
        // Handle the action when the user clicks on the "Already have an account" link
        // You can navigate to the login page or show a login dialog here

        System.out.println("Open login page or show login dialog");
    }
}
