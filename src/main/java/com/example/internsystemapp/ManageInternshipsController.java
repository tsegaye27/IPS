package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Optional;

public class ManageInternshipsController {

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField companyNameField;

    @FXML
    private Label companyNameLabel;

    @FXML
    private TextField contactField;

    @FXML
    private Label contactLabel;

    @FXML
    private Button deleteBtn;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private Label descriptionLabel;

    @FXML
    private TextField durationField;

    @FXML
    private Label durationLabel;

    @FXML
    private Button editPostBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private AnchorPane internshipEditorPane;

    @FXML
    private VBox internshipsContainer;

    @FXML
    private TextField locationField;

    @FXML
    private Label locationLabel;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button manageInternshipsBtn;

    @FXML
    private AnchorPane managePostPane;

    @FXML
    private ScrollPane managePostsPane;

    @FXML
    private Label noInternships;

    @FXML
    private TextField paidUnpaidField;

    @FXML
    private Label paidUnpaidLabel;

    @FXML
    private Button postInternshipsBtn;

    @FXML
    private TextArea requirementsArea;

    @FXML
    private Label requirementsLabel;

    @FXML
    private Button returnToViewPostsBtn;

    @FXML
    private Label searchInternshipTitle;

    @FXML
    private TextField titleField;

    @FXML
    private Button updateBtn;

    @FXML
    private TextField vacanciesField;

    @FXML
    private Label vacanciesLabel;


    public void initialize(){
        manageInternshipsBtn.setDisable(true);
        displayInternships();
    }

    void displayInternships(){

    }

    @FXML
    void returnToViewPostsBtnClicked(ActionEvent event){

    }

    @FXML
    void editPostBtnClicked(ActionEvent event){

    }

    @FXML
    void deleteBtnClicked(ActionEvent event){

    }

    @FXML
    void updateBtnClicked(ActionEvent event){

    }

    @FXML
    void cancelBtnClicked(ActionEvent event){

    }

    @FXML
    void homeBtnClicked(ActionEvent event) throws IOException {
        manageInternshipsBtn.setDisable(false);
        InternApp.showCmpHomePage();
    }

    @FXML
    void logoutBtnClicked(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to Logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            InternApp.showWelcomePage();
            DBUtills.setCurrentCmpId(0);
        }
    }

    @FXML
    void postInternshipsBtnClicked(ActionEvent event) throws IOException {
        manageInternshipsBtn.setDisable(false);
        InternApp.showPostInternships();
    }

}
