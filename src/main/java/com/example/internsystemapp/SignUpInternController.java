package com.example.internsystemapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class SignUpInternController{
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy");
    DateTimeFormatter dOBFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    @FXML
    private TextField emailField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private ComboBox<String> genderBox;

    @FXML
    private Button hideConfirmPasswordBtn;

    @FXML
    private Button hidePasswordBtn;

    @FXML
    private Button showConfirmPasswordBtn;

    @FXML
    private Button showPasswordBtn;

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

    public void initialize(){
        genderBox.getItems().add("Male");
        genderBox.getItems().add("Female");
    }

    private boolean validateEmail(){
            String email = emailField.getText();

            if (email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                return true;
            } else {
                return false;
        }
    }
    @FXML
    void signUpClicked(ActionEvent event) throws IOException {
        if (!validateInputs()){
            showError("Please fill in every field");
        }
        else{
            if(validateEmail()){
                LocalDate graduationYearDate = graduationYearField.getValue();
                LocalDate dateOfBirthDate = dateOfBirthField.getValue();
                String dateOfBirth = dateOfBirthDate.format(dOBFormatter);
                String graduationYear = graduationYearDate.format(formatDate);

                if(validateInputs()){
                    DBUtills.signUpIntern(event, fullNameField.getText(), emailField.getText(), passwordField.getText(),Integer.parseInt(phoneNumberField.getText()), fieldOfStudyField.getText(), dateOfBirth, graduationYear, locationField.getText());
                    InternApp.showInternLoginPage();
                }
                else showError("Please fill in every field");
            }else showError("Invalid Email");
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
        String gender = genderBox.getSelectionModel().getSelectedItem();
        String confirmPassword = confirmPasswordField.getText();

        if(fullName.trim().isEmpty()||email.trim().isEmpty()||gender.isEmpty()||password.trim().isEmpty()||confirmPassword.trim().isEmpty()||phoneNumber.trim().isEmpty()||graduationYear.toString().trim().isEmpty()|| fieldOfStudy.trim().isEmpty()||location.trim().isEmpty()||dateOfBirth.toString().trim().isEmpty()){
            return false;
        }
        return true;
    }

    @FXML
    void hideConfirmPasswordBtnClicked(ActionEvent event){
        hideConfirmPasswordBtn.setVisible(false);
        showConfirmPasswordBtn.setVisible(true);
    }

    @FXML
    void hidePasswordBtnClicked(ActionEvent event){
        hidePasswordBtn.setVisible(false);
        showPasswordBtn.setVisible(true);
    }

    @FXML
    void showConfirmPasswordBtnClicked(ActionEvent event){
        showConfirmPasswordBtn.setVisible(false);
        hideConfirmPasswordBtn.setVisible(true);
    }

    @FXML
    void showPasswordBtnClicked(ActionEvent event){
        showPasswordBtn.setVisible(false);
        hidePasswordBtn.setVisible(true);
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
