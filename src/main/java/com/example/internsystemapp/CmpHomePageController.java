package com.example.internsystemapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.xml.transform.Result;
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
    private Button acceptBtn;

    @FXML
    private Label degreeLabel;

    @FXML
    private TableView<ApplicantsList> applicantsView;


    @FXML
    private TableColumn <ApplicantsList, String> emailColumn;

    @FXML
    private TableColumn<ApplicantsList,String> fullNameColumn;

    @FXML
    private TableColumn<ApplicantsList,String> universityNameColumn;

    @FXML
    private Button viewDetailsBtn;
    @FXML
    private Label emailLabel;

    @FXML
    private Label experienceLabel;
    @FXML
    private Label fullNameLabel;
    @FXML
    private Label universityNameLabel;
    @FXML
    private Label yearOfStudyLabel;
    @FXML
    private Label skillsLabel;
    @FXML
    private Label statementOfInterestLabel;

    @FXML
    private Button backBtn;

    @FXML
    private Label gitHubURLLabel;

    @FXML
    private Button rejectBtn;
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

    void displayPostedInternships() throws SQLException {
        SQL = "select id, Title, duration, numberOfApplicantsNeeded from internshipposts where company_id ="+DBUtills.getCurrentCmpId();
        ResultSet rst = DBUtills.getData(SQL);
        if(rst.isBeforeFirst()){
            //if the company have posted an internship
            while(rst.next()){
                createHBox(rst.getInt("id"), rst.getString("Title"), rst.getString("duration"), rst.getString("numberOfApplicantsNeeded"));
            }
        }else{
            noPost();
        }
        //else there are no posted internships
    }

    void noPost(){
        postsPane.setVisible(false);
        noPostLabel.setVisible(true);
    }

    void createHBox(int id, String title, String duration, String vacancies){
            AnchorPane anchorPane = new AnchorPane();

            anchorPane.getStyleClass().add("post-cards");

            anchorPane.setPrefWidth(440);
            anchorPane.setPrefHeight(180);

            Label titleLabel = new Label(title);
            Label durationLabel = new Label(duration);
            Label vacanciesLabel = new Label(vacancies);

//            Button manageButton = new Button("Manage Internship");
//            manageButton.getStyleClass().add("cancelBtn");
//            manageButton.setOnAction(event -> {
//                showPostEditor();
//            });

            Button viewDetails = new Button("View Applicants");
            viewDetails.getStyleClass().add("submitBtn");
            viewDetails.setOnAction(event -> {
                try {
                    showApplications(id);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
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
    void viewDetailsBtnClicked(ActionEvent event) throws SQLException {
        ApplicantsList selectedItem = applicantsView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            int rowIndex = applicantsView.getSelectionModel().getSelectedIndex();
            String selectedEmail = applicantsView.getColumns().get(1).getCellData(rowIndex).toString();
            SQL = "select stud.id, stud.fullName, stud.email, stud.dept, application.universityName, application.yearOfStudy, application.skills, application.gitURL, application.interests, application.experience from stud inner join application on stud.id = application.internId where stud.email = '"+selectedEmail+"'";
            System.out.println(SQL);
            ResultSet rst = DBUtills.getData(SQL);
            while(rst.next()){
                fullNameLabel.setText(rst.getString("fullName"));
                emailLabel.setText(rst.getString("email"));
                universityNameLabel.setText(rst.getString("universityName"));
                degreeLabel.setText(rst.getString("dept"));
                yearOfStudyLabel.setText(rst.getString("yearOfStudy"));
                skillsLabel.setText(rst.getString("skills"));
                gitHubURLLabel.setText(rst.getString("gitURL"));
                statementOfInterestLabel.setText(rst.getString("interests"));
                experienceLabel.setText(rst.getString("experience"));
                break;
            }
            viewApplicantDetails.setVisible(false);
            applicationRequest.setVisible(true);
        } else {
            showError("select an application to view");
        }

    }

//    void showPostEditor(){
//        postedInternshipsContainer.setVisible(false);
//        postDetailsPane.setVisible(true);
//    }

    void showApplications(int id) throws SQLException {
        postsPane.setVisible(false);
        viewApplicantDetails.setVisible(true);
        tableViewInfo(id);
    }
    ObservableList<ApplicantsList> applicants= FXCollections.observableArrayList();
    void tableViewInfo(int id) throws SQLException {
        applicants.clear();
        SQL = "select stud.id, stud.fullName, stud.email, application.universityName, application.status from stud inner join application on stud.id = application.internId where internshipId = "+id;
        ResultSet rst = DBUtills.getData(SQL);
        if(rst.isBeforeFirst()){
            while(rst.next()){
                if(Objects.equals(rst.getString("status"), "pending")){
                    applicants.add(new ApplicantsList(rst.getString("fullName"),rst.getString("email"), rst.getString("universityName")));
                }
            }
        }
        applicantsView.setItems(applicants);

        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        universityNameColumn.setCellValueFactory(new PropertyValueFactory<>("universityName"));

    }

    @FXML
    void backBtnClicked(ActionEvent event){
        viewApplicantDetails.setVisible(false);
        postsPane.setVisible(true);
    }

    @FXML
    void acceptBtnClicked(ActionEvent event){
        DBUtills.acceptIntern(emailLabel.getText());
        postsPane.setVisible(true);
        viewApplicantDetails.setVisible(false);
    }

    @FXML
    void rejectBtnClicked(ActionEvent event){
        DBUtills.rejectIntern(emailLabel.getText());
        postsPane.setVisible(true);
        viewApplicantDetails.setVisible(false);
    }

    @FXML
    void returnToPostedBtnClicked(ActionEvent event){
        viewApplicantDetails.setVisible(true);
        applicationRequest.setVisible(false);
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
    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }



}
