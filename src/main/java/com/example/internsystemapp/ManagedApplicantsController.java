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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
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
    private int currentInternshipId = 0;
    public int getCurrentInternshipId() {
        return currentInternshipId;
    }

    public void setCurrentInternshipId(int currentInternshipId) {
        this.currentInternshipId = currentInternshipId;
    }
    String SQL;
    public void initialize() throws SQLException {
        managedApplicantsBtn.setDisable(true);
        internshipsContainer.setSpacing(10);
        displayInternships();
    }

    void displayInternships() throws SQLException {
        SQL = "select id, Title from internshipposts where company_id ="+DBUtills.getCurrentCmpId();
        ResultSet rst = DBUtills.getData(SQL);
        if(rst.isBeforeFirst()){
            //if the company have posted an internship
            while(rst.next()){
//                createHBox(rst.getInt("id"), rst.getString("Title"), rst.getString("duration"), rst.getString("numberOfApplicantsNeeded"));
                createHBox(rst.getInt("id"), rst.getString("Title"));
            }
        }else{
            viewPostsPane.setVisible(false);
            noInternships.setVisible(true);
        }

    }

    void createHBox(int id, String Title){
        AnchorPane anchorPane = new AnchorPane();

        anchorPane.getStyleClass().add("post-cards");

        anchorPane.setPrefWidth(440);
        anchorPane.setPrefHeight(100);

        Label titleLabel = new Label(Title);

        Button acceptedButton = new Button("Accepted Applicants");
        acceptedButton.getStyleClass().add("submitBtn");
        acceptedButton.setOnAction(event -> {
            try {
                showAccepted(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        Button rejectedButton = new Button("Rejected Applicants");
        rejectedButton.getStyleClass().add("cancelBtn");
        rejectedButton.setOnAction(event -> {
            try {
                showRejected(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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

    void showAccepted(int id) throws SQLException {
        setCurrentInternshipId(id);
        viewPostsPane.setVisible(false);
        viewAcceptedApplicantsPane.setVisible(true);
        tableViewAccepted(id);
    }

    void tableViewAccepted(int id) throws SQLException {
        ObservableList<ApplicantsList> accepted= FXCollections.observableArrayList(
                new ApplicantsList("John Doe", "matt@doe.com", "Gonder")
        );
        accepted.clear();
        SQL = "select stud.id, stud.fullName, stud.email, application.universityName, application.status from stud inner join application on stud.id = application.internId where internshipId = "+id;
        ResultSet rst = DBUtills.getData(SQL);
        if(rst.isBeforeFirst()){
            while(rst.next()){
                if(Objects.equals(rst.getString("status"), "accepted")){
                    accepted.add(new ApplicantsList(rst.getString("fullName"),rst.getString("email"), rst.getString("universityName")));
                }
            }
        }
        acceptedApplicantsView.setItems(accepted);

        acceptedFullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        acceptedEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        acceptedUniversityNameColumn.setCellValueFactory(new PropertyValueFactory<>("universityName"));
    }

    void showRejected(int id) throws SQLException {
        setCurrentInternshipId(id);
        viewPostsPane.setVisible(false);
        viewRejectedApplicantsPane.setVisible(true);
        tableViewRejected(id);
    }

    void tableViewRejected(int id) throws SQLException {
        ObservableList<ApplicantsList> rejected= FXCollections.observableArrayList(
                new ApplicantsList("rejectedName", "rejectedEmail","rejectedUniversityName")
        );
        rejected.clear();
        SQL = "select stud.id, stud.fullName, stud.email, application.universityName, application.status from stud inner join application on stud.id = application.internId where internshipId = "+id;
        ResultSet rst = DBUtills.getData(SQL);
        if(rst.isBeforeFirst()){
            while(rst.next()){
                if(Objects.equals(rst.getString("status"), "rejected")){
                    rejected.add(new ApplicantsList(rst.getString("fullName"),rst.getString("email"), rst.getString("universityName")));
                }
            }
        }
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
