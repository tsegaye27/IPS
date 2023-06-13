package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

public class CmpHomePageController {

    @FXML
    private Button homeBtn;

    @FXML
    private Label companyNameLabel;
    @FXML
    private Label greetingName;
    @FXML
    private Button nextBtn;

    @FXML
    private AnchorPane applicationRequest;

    @FXML
    private Button returnToPostedBtn;
    @FXML
    private Label locationLabel;
    @FXML
    private Label durationLabel;
    @FXML
    private Label contactLabel;
    @FXML
    private Label paidUnpaidLabel;
    @FXML
    private Label requirementsLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Button editPostBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Label internshipTitle;
    @FXML
    private AnchorPane postDetailsPane;
    @FXML
    private Button logoutBtn;

    @FXML
    private Button manageInternshipsBtn;

    @FXML
    private Button postInternshipsBtn;

    @FXML
    private Label totalInternshipsLabel;

    @FXML
    private Label totalApplicationsLabel;

    @FXML
    private Label acceptedLabel;

    @FXML
    private Label vacanciesLabel;

    @FXML
    private AnchorPane viewApplicantDetails;
    @FXML
    private Label noPostLabel;
    @FXML
    private Label pendingLabel;

    @FXML
    private Label rejectedLabel;
    @FXML
    private VBox postedInternshipsContainer;

    @FXML
    private Button viewDetailsBtn;
    @FXML
    private ScrollPane postsPane;


    String SQL;
    private int internshipNo = 0;
    public int getInternshipNo() {
        return internshipNo;
    }

    public void setInternshipNo(int internshipNo) {
        this.internshipNo = internshipNo;
    }


    public CmpHomePageController() throws SQLException {
    }
   

    public void initialize() throws SQLException {
        homeBtn.setDisable(true);
        postedInternshipsContainer.setSpacing(10);
        displayPostedInternships();
        displayDashboard();
    }

    void displayPostedInternships(){
        //if the company have posted an internship
        createHBox();
        //else there are no posted internships
//        noPost();
    }

    void noPost(){
        postsPane.setVisible(false);
        noPostLabel.setVisible(true);
    }

    void createHBox(){
            AnchorPane anchorPane = new AnchorPane();

            anchorPane.getStyleClass().add("post-cards");

            anchorPane.setPrefWidth(440);
            anchorPane.setPrefHeight(180);

            Label titleLabel = new Label("Title");
            Label durationLabel = new Label("Duration");
            Label vacanciesLabel = new Label("Vacancies");

//            Button manageButton = new Button("Manage Internship");
//            manageButton.getStyleClass().add("cancelBtn");
//            manageButton.setOnAction(event -> {
//                showPostEditor();
//            });

            Button viewDetails = new Button("View Applicants");
            viewDetails.getStyleClass().add("submitBtn");
            viewDetails.setOnAction(event -> {
                showApplications();
            });

            AnchorPane.setTopAnchor(titleLabel, 15.0);
            AnchorPane.setLeftAnchor(titleLabel, 190.0);

            AnchorPane.setTopAnchor(vacanciesLabel, 60.0);
            AnchorPane.setLeftAnchor(vacanciesLabel, 160.0);

            AnchorPane.setTopAnchor(durationLabel, 90.0);
            AnchorPane.setLeftAnchor(durationLabel, 160.0);

//            AnchorPane.setTopAnchor(manageButton, 120.0);
//            AnchorPane.setLeftAnchor(manageButton, 70.0);

            AnchorPane.setTopAnchor(viewDetails, 140.0);
            AnchorPane.setLeftAnchor(viewDetails, 175.0);

            anchorPane.getChildren().addAll(titleLabel,durationLabel,vacanciesLabel, viewDetails);

            titleLabel.getStyleClass().add("internship-title");
            durationLabel.getStyleClass().add("internship-details");
            vacanciesLabel.getStyleClass().add("internship-details");
            HBox hBox = new HBox(anchorPane);
            hBox.setSpacing(10);
            postedInternshipsContainer.getChildren().add(hBox);
    }

    @FXML
    void viewDetailsBtnClicked(ActionEvent event){
        viewApplicantDetails.setVisible(false);
        applicationRequest.setVisible(true);
    }

    void showPostEditor(){
        postedInternshipsContainer.setVisible(false);
        postDetailsPane.setVisible(true);
    }

    void showApplications(){
        postedInternshipsContainer.setVisible(false);
        viewApplicantDetails.setVisible(true);
    }

    @FXML
    void acceptBtnClicked(ActionEvent event){

    }

    @FXML
    void rejectBtnClicked(ActionEvent event){

    }

    @FXML
    void nextBtnClicked(ActionEvent event){

    }

    @FXML
    void returnToPostedBtnClicked(ActionEvent event){
        postDetailsPane.setVisible(false);
        applicationRequest.setVisible(false);

        postedInternshipsContainer.setVisible(true);
    }
    @FXML
    void manageInternshipsBtnClicked(ActionEvent event) throws IOException {
        homeBtn.setDisable(false);
        InternApp.showManageInternships();
    }

    @FXML
    void postInternshipsBtnClicked(ActionEvent event) throws IOException {
        homeBtn.setDisable(false);
        InternApp.showPostInternships();
    }
    @FXML
    void logoutBtnClicked(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to Logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) logoutBtn.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            DBUtills.setCurrentCmpId(0);
        }
    }
    void displayDashboard() throws SQLException {
        SQL = "select id from internshipposts where company_id =" + DBUtills.getCurrentCmpId();
        System.out.println(SQL);
        ResultSet rst = DBUtills.getData(SQL);
        int intNo = 0;
        while (rst.next()) {
           intNo++;
        }
        setInternshipNo(intNo);
        totalInternshipsLabel.setText(Integer.toString(intNo));
        getCompanyName();
        getDashboardData();
    }
    void getCompanyName() throws SQLException {
        SQL = "select name from company where id =" + DBUtills.getCurrentCmpId();
        System.out.println(SQL);
        ResultSet rst = DBUtills.getData(SQL);
        while (rst.next()) {
            greetingName.setText(rst.getString("name"));
        }
    }
    void getDashboardData() throws SQLException {
        SQL = "select application.appId, application.internshipId, application.status, internshipposts.company_id from application inner join internshipposts on application.internshipId = internshipposts.id where company_id =" + DBUtills.getCurrentCmpId();
        ResultSet rst = DBUtills.getData(SQL);
        int applicationCounter = 0;
        int acceptedApplicationNumber = 0;
        int rejectedApplicationNumber = 0;
        int pendingApplicationNumber = 0;
        while (rst.next()) {
            applicationCounter++;
            if(Objects.equals(rst.getString("status"), "pending")){
                pendingApplicationNumber++;
            }else if(Objects.equals(rst.getString("status"), "accepted")){
                acceptedApplicationNumber++;
            }else{
                rejectedApplicationNumber++;
            }
        }
        totalApplicationsLabel.setText(Integer.toString(applicationCounter));
        acceptedLabel.setText(Integer.toString(acceptedApplicationNumber));
        rejectedLabel.setText(Integer.toString(rejectedApplicationNumber));
        pendingLabel.setText(Integer.toString(pendingApplicationNumber));
    }


}
