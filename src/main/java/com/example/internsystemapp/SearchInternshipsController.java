package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class SearchInternshipsController {

    @FXML
    void appliedInternshipsBtnClicked(ActionEvent event) throws IOException {
        InternApp.showAppliedInternships();
    }

    @FXML
    void homeBtnClicked(ActionEvent event) throws IOException{

    }

    @FXML
    void logoutBtnClicked(ActionEvent event) throws IOException {

    }

    @FXML
    void searchInternshipsBtnClicked(ActionEvent event) throws IOException {
        InternApp.showSearchInternships();
    }
}
