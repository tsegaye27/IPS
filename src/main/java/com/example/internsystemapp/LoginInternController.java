package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginInternController {
        @FXML
        private TextField email;

        @FXML
        private TextField fullName;

        @FXML
        private Button loginBtn;

        @FXML
        private PasswordField password;

        @FXML
        private Hyperlink signUplink;

        @FXML
        void loginBtnClicked(ActionEvent event) throws IOException {
            InternApp.showHomePage();
        }
        @FXML
        void signUplinkClicked(ActionEvent event) throws IOException {
            InternApp.showSignUpPage();
        }

    }
