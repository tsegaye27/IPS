package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
    private ScrollPane viewPostsPane;

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
    //if the company have posted internships
        createHBox();
        //else
//        noInternshipsPosted();
    }

    void noInternshipsPosted(){
        viewPostsPane.setVisible(false);
        noInternships.setVisible(true);
    }

    void createHBox(){
        AnchorPane anchorPane = new AnchorPane();

        anchorPane.getStyleClass().add("post-cards");

        anchorPane.setPrefWidth(440);
        anchorPane.setPrefHeight(180);

        Label titleLabel = new Label("title");
        Label durationLabel = new Label("duration");
        Label vacanciesLabel = new Label("vacancies");

        Button manageButton = new Button("Manage Internship");
        manageButton.getStyleClass().add("postBtn");
        manageButton.setOnAction(event -> {
            showPostEditor();
        });

        AnchorPane.setTopAnchor(titleLabel, 15.0);
        AnchorPane.setLeftAnchor(titleLabel, 190.0);

        AnchorPane.setTopAnchor(vacanciesLabel, 60.0);
        AnchorPane.setLeftAnchor(vacanciesLabel, 160.0);

        AnchorPane.setTopAnchor(durationLabel, 90.0);
        AnchorPane.setLeftAnchor(durationLabel, 160.0);

        AnchorPane.setTopAnchor(manageButton, 120.0);
        AnchorPane.setLeftAnchor(manageButton, 160.0);

        anchorPane.getChildren().addAll(titleLabel,durationLabel,vacanciesLabel, manageButton);

        titleLabel.getStyleClass().add("internship-title");
        durationLabel.getStyleClass().add("internship-details");
        vacanciesLabel.getStyleClass().add("internship-details");
        HBox hBox = new HBox(anchorPane);
        hBox.setSpacing(10);
        internshipsContainer.getChildren().add(hBox);
    }

    void showPostEditor(){
        viewPostsPane.setVisible(false);
        managePostPane.setVisible(true);
    }

    @FXML
    void returnToViewPostsBtnClicked(ActionEvent event){
        managePostPane.setVisible(false);
        viewPostsPane.setVisible(true);
    }

    @FXML
    void managedApplicantsBtnClicked(ActionEvent event) throws IOException{
        manageInternshipsBtn.setDisable(false);
        InternApp.showManagedApplicants();
    }

    @FXML
    void editPostBtnClicked(ActionEvent event){
        managePostPane.setVisible(false);
        internshipEditorPane.setVisible(true);
    }

    @FXML
    void deleteBtnClicked(ActionEvent event){

    }

    @FXML
    void updateBtnClicked(ActionEvent event){

    }

    @FXML
    void cancelBtnClicked(ActionEvent event){
        internshipEditorPane.setVisible(false);
        managePostPane.setVisible(true);
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
