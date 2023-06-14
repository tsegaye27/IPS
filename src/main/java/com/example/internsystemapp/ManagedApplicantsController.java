package com.example.internsystemapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Optional;

public class ManagedApplicantsController {

    @FXML
    private TableView<ApplicantsList> acceptedApplicantsView;

    @FXML
    private Button acceptedBackBtn;

    @FXML
    private TableColumn<ApplicantsList, String> acceptedEmailColumn;

    @FXML
    private TableColumn<ApplicantsList, String> acceptedFullNameColumn;

    @FXML
    private TableColumn<ApplicantsList, String> acceptedUniversityNameColumn;

    @FXML
    private Button homeBtn;

    @FXML
    private VBox internshipsContainer;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button manageInternshipsBtn;

    @FXML
    private Button managedApplicantsBtn;

    @FXML
    private Label noInternships;

    @FXML
    private Button postInternshipsBtn;

    @FXML
    private TableView<ApplicantsList> rejectedApplicantsView;

    @FXML
    private Button rejectedBackBtn;

    @FXML
    private TableColumn<ApplicantsList, String> rejectedEmailColumn;

    @FXML
    private TableColumn<ApplicantsList, String> rejectedFullNameColumn;

    @FXML
    private TableColumn<ApplicantsList, String> rejectedUniversityNameColumn;

    @FXML
    private AnchorPane viewAcceptedApplicantsPane;

    @FXML
    private ScrollPane viewPostsPane;

    @FXML
    private AnchorPane viewRejectedApplicantsPane;

    public void initialize(){
        managedApplicantsBtn.setDisable(true);
        displayInternships();
    }

    void displayInternships(){
        //if the company have posted an internship
        createHBox();
        //else
        //viewPostsPane.setVisible(false);
        //noInternships.setVisible(true);
    }

    void createHBox(){
        AnchorPane anchorPane = new AnchorPane();

        anchorPane.getStyleClass().add("post-cards");

        anchorPane.setPrefWidth(440);
        anchorPane.setPrefHeight(100);

        Label titleLabel = new Label("title");

        Button acceptedButton = new Button("Accepted Applicants");
        acceptedButton.getStyleClass().add("submitBtn");
        acceptedButton.setOnAction(event -> {
            showAccepted();
        });
        Button rejectedButton = new Button("Rejected Applicants");
        rejectedButton.getStyleClass().add("cancelBtn");
        rejectedButton.setOnAction(event -> {
            showRejected();
        });

        AnchorPane.setTopAnchor(titleLabel, 10.0);
        AnchorPane.setLeftAnchor(titleLabel, 190.0);

        AnchorPane.setTopAnchor(acceptedButton, 60.0);
        AnchorPane.setLeftAnchor(acceptedButton, 50.0);

        AnchorPane.setTopAnchor(rejectedButton, 60.0);
        AnchorPane.setLeftAnchor(rejectedButton, 250.0);

        anchorPane.getChildren().addAll(titleLabel,acceptedButton,rejectedButton);

        titleLabel.getStyleClass().add("internship-title");
        HBox hBox = new HBox(anchorPane);
        hBox.setSpacing(10);
        internshipsContainer.getChildren().add(hBox);
    }

    void showAccepted(){
        viewPostsPane.setVisible(false);
        viewAcceptedApplicantsPane.setVisible(true);
        tableViewAccepted();
    }

    void tableViewAccepted(){
        ObservableList<ApplicantsList> accepted= FXCollections.observableArrayList(
                new ApplicantsList("John Doe", "matt@doe.com", "Gonder")
        );

        acceptedApplicantsView.setItems(accepted);

        acceptedFullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        acceptedEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        acceptedUniversityNameColumn.setCellValueFactory(new PropertyValueFactory<>("universityName"));
    }

    void showRejected(){
        viewPostsPane.setVisible(false);
        viewRejectedApplicantsPane.setVisible(true);
        tableViewRejected();
    }

    void tableViewRejected(){
        ObservableList<ApplicantsList> rejected= FXCollections.observableArrayList(
                new ApplicantsList("rejectedName", "rejectedEmail","rejectedUniversityName")
        );

        rejectedApplicantsView.setItems(rejected);

        rejectedFullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        rejectedEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        rejectedUniversityNameColumn.setCellValueFactory(new PropertyValueFactory<>("universityName"));
    }
    @FXML
    void homeBtnClicked(ActionEvent event) throws IOException {
        managedApplicantsBtn.setDisable(false);
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
    void manageInternshipsBtnClicked(ActionEvent event) throws IOException {
        managedApplicantsBtn.setDisable(false);
        InternApp.showManageInternships();
    }

    @FXML
    void acceptedBackBtnClicked(){
        viewAcceptedApplicantsPane.setVisible(false);
        viewPostsPane.setVisible(true);
    }

    @FXML
    void rejectedBackBtnClicked(){
        viewRejectedApplicantsPane.setVisible(false);
        viewPostsPane.setVisible(true);
    }

    @FXML
    void postInternshipsBtnClicked(ActionEvent event) throws IOException {
        managedApplicantsBtn.setDisable(false);
        InternApp.showPostInternships();
    }

}
