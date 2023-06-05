package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AppliedInternshipsController {
    @FXML
    private Button appliedInternshipsBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button searchInternshipsBtn;

    @FXML
    void appliedInternshipsBtnClicked(ActionEvent event) throws IOException {
        InternApp.showAppliedInternships();
    }

    @FXML
    void homeBtnClicked(ActionEvent event) throws IOException {
        InternApp.showInternHomePage();
    }

    @FXML
    void logoutBtnClicked(ActionEvent event) throws IOException {
        InternApp.showInternLoginPage();
    }

    @FXML
    void searchInternshipsBtnClicked(ActionEvent event) throws IOException {
        InternApp.showSearchInternships();
    }
}
