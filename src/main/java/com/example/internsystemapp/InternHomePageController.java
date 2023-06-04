package com.example.internsystemapp;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class InternHomePageController {

    @FXML
    private Button appliedInternshipsBtn;

    @FXML
    private Button findYourProgramsBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button searchInternshipsBtn;

    @FXML
    private FontAwesomeIcon searchInternshipsIcon;

    @FXML
    void appliedInternshipsBtnClicked(ActionEvent event) throws IOException {
        InternApp.showAppliedInternships();
    }

    @FXML
    void findYourProgramsBtnClicked(ActionEvent event) throws IOException {
        InternApp.showSearchInternships();
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
