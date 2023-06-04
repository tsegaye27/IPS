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
        InternApp.showHomePage();
    }
    @FXML
    void loginLinkClicked(ActionEvent event) throws IOException {
        InternApp.showLoginPage();
    }

}
