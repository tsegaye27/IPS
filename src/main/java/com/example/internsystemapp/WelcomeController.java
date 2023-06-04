package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class WelcomeController {

        @FXML
        private Button companyBtn;

        @FXML
        private Button internBtn;

        @FXML
        void companyBtnClicked(ActionEvent event) throws IOException{
                InternApp.showCmpSignUpPage();
        }

        @FXML
        void internBtnClicked(ActionEvent event) throws IOException{
                InternApp.showInternSignUpPage();
        }

}