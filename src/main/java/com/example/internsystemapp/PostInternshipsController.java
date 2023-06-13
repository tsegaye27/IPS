package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class PostInternshipsController {
    @FXML
    private Button homeBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button manageInternshipsBtn;

    @FXML
    private Button nextBtn;

    @FXML
    private TextField titleField;

    @FXML
    private TextField companyNameField;

    @FXML
    private TextField locationField;

    @FXML
    private TextField durationField;

    @FXML
    private TextField contactField;

    @FXML
    private TextField paidUnpaidField;

    @FXML
    private TextField vacanciesField;

    @FXML
    private TextArea requirementsArea;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private AnchorPane postInternshipPane;

    @FXML
    private Button postInternshipsBtn;

    public void initialize(){
        postInternshipsBtn.setDisable(true);
    }

    @FXML
    void homeBtnClicked(ActionEvent event) throws IOException {
        postInternshipsBtn.setDisable(false);
        InternApp.showCmpHomePage();
    }
    @FXML
    void logoutBtnClicked(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to Logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            InternApp.showWelcomePage();
            DBUtills.setCurrentCmpId(0);
        }
    }

    @FXML
    void nextBtnClicked(){

    }

    @FXML
    void manageInternshipsBtnClicked(ActionEvent event) throws IOException {
        postInternshipsBtn.setDisable(false);
        InternApp.showManageInternships();
    }
}
