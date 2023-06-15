package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

public class SearchInternshipsController {
    @FXML
    private Button appliedInternshipsBtn;

    @FXML
    private Label vacanciesLabel;

    @FXML
    private AnchorPane applicationForm;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField degreeField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField locationField;
    @FXML
    private TextArea statementOfInterestArea;
    @FXML
    private TextArea experienceArea;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField skillsField;

    @FXML
    private Button submitBtn;

    @FXML
    private TextField universityNameField;
    @FXML
    private TextField gitHubURLField;

    @FXML
    private ToggleButton durationFilterBtn;

    @FXML
    private ToggleButton fieldsFilterBtn;

    @FXML
    private ToggleButton locationFilterBtn;

    @FXML
    private TextField searchField;

    @FXML
    private ComboBox<String> paymentStatusFilterBtn;

    @FXML
    private Button searchBtn;

    @FXML
    private VBox searchResultContainer;
    @FXML
    private Button homeBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button searchInternshipsBtn;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button applyNowBtn;

    @FXML
    private Label companyNameLabel;

    @FXML
    private Label contactLabel;

    @FXML
    private Label description;

    @FXML
    private Label durationLabel;

    @FXML
    private AnchorPane internshipDetailsPane;

    @FXML
    private ComboBox<Integer> yearOfStudyBox;
    @FXML
    private Label locationLabel;

    @FXML
    private Label paidUnpaidLabel;

    @FXML
    private Label requirementsLabel;

    @FXML
    private Button returnToFeaturedBtn;
    @FXML
    private Label searchInternshipTitle;
    @FXML
    private Label descriptionLabel;

    private int currInternshipId;

    public int getCurrInternshipId() {
        return currInternshipId;
    }

    public void setCurrInternshipId(int internshipId) {
        this.currInternshipId = internshipId;
    }

    public void initialize() {
        searchInternshipsBtn.setDisable(true);
        paymentStatusFilterBtn.getItems().add("paid");
        paymentStatusFilterBtn.getItems().add("unpaid");
        searchResultContainer.setSpacing(10);
        yearOfStudyBox.getItems().add(1);
        yearOfStudyBox.getItems().add(2);
        yearOfStudyBox.getItems().add(3);
        yearOfStudyBox.getItems().add(4);
        yearOfStudyBox.getItems().add(5);
    }
    String SQL;
    @FXML
    void searchBtnClicked(ActionEvent event) throws SQLException {
        String searchedText = searchField.getText();
        boolean filterByLocation = locationFilterBtn.isSelected();
        boolean filterByDuration = durationFilterBtn.isSelected();
        boolean filterByField = fieldsFilterBtn.isSelected();
        String selectedValue = paymentStatusFilterBtn.getSelectionModel().getSelectedItem();
        System.out.println(selectedValue);
        searchResultContainer.getChildren().clear();

        if (!Objects.equals(searchedText, "")) {

            String paidUnpaidFilter = (selectedValue != null) ? ((selectedValue.equals("unpaid")) ? " and internshipposts.type ='" + selectedValue + "'" : " and internshipposts.type != 'unpaid'") : "";
            if (filterByLocation) {
                //compare searchedText with location values in DB
                SQL = "SELECT internshipposts.id FROM internshipposts INNER JOIN company ON internshipposts.company_id = company.id where company.location like '%" + searchedText + "%'"+ paidUnpaidFilter;
                System.out.println(SQL);
            } else if (filterByDuration) {

                SQL = "SELECT id FROM internshipposts where duration like '%" + searchedText + "%'"+ paidUnpaidFilter;
                System.out.println(SQL);
            } else if (filterByField) {

                SQL = "SELECT id,requirements FROM internshipposts where requirements like '%" + searchedText + "%'"+paidUnpaidFilter;
                System.out.println(SQL);
//            SQL="SELECT internshipposts.id, internshipposts.title, internshipposts.duration, internshipposts.requirements, internshipposts.description, internshipposts.type, internshipposts.numberOfApplicantsNeeded, company.name, company.email,company.location FROM internshipposts INNER JOIN company ON internshipposts.company_id = company.id where internshipposts.requirements like '%"+searchedText+"%'";
            }
//        else if(selectedValue.equals("Paid")){
//                   createHBoxPaid();
//
//        }
            else {
                SQL = "SELECT internshipposts.id FROM internshipposts INNER JOIN company ON internshipposts.company_id = company.id where internshipposts.title like'%" + searchedText + "%' or company.name like '%" + searchedText + "%' or internshipposts.requirements like'%" + searchedText + "%' or internshipposts.duration like '%" + searchedText + "%' or company.location like '%" + searchedText + "%'"+paidUnpaidFilter;
                System.out.println(SQL);
            }

            ResultSet rst = DBUtills.searchInternships(SQL);
            if (rst.next()) {
                rst.previous();
                while (rst.next()) {
                    createHBox(rst.getInt("id"));
                }
            } else {
                noResultFound();
            }
        }else{
            showError("No keyword inserted");
        }
    }
    void createHBox( int id) throws SQLException {
        HBox hBox = new HBox();
        hBox.setSpacing(10);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefWidth(540);
        anchorPane.setPrefHeight(120);
        anchorPane.getStyleClass().add("featured-card");
        SQL ="SELECT internshipposts.title,internshipposts.duration, company.location FROM internshipposts INNER JOIN company ON internshipposts.company_id = company.id where internshipposts.id ="+id;
        ResultSet rst = DBUtills.searchInternships(SQL);

        Label internshipTitleLabel = null;
        Label internshipLocationLabel = null;
        Label internshipDurationLabel = null;
        while(rst.next()){
            //fetch from DB
            internshipTitleLabel = new Label(rst.getString("title"));
            internshipLocationLabel = new Label(rst.getString("location"));
            internshipDurationLabel = new Label(rst.getString("duration"));
        }


        Hyperlink readMoreLink = new Hyperlink("Read More");
        readMoreLink.setOnAction(event -> {
//            AnchorPane clickedAnchorPane = (AnchorPane) event.getSource();
//            String internshipId = (String) clickedAnchorPane.getUserData();

            try {
                showDetails(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        anchorPane.getChildren().addAll(internshipTitleLabel, internshipLocationLabel, internshipDurationLabel, readMoreLink);

        AnchorPane.setTopAnchor(internshipTitleLabel, 10.0);
        AnchorPane.setTopAnchor(internshipLocationLabel, 40.0);
        AnchorPane.setTopAnchor(internshipDurationLabel, 60.0);
        AnchorPane.setTopAnchor(readMoreLink,80.0);

        AnchorPane.setLeftAnchor(internshipTitleLabel, 230.0);
        AnchorPane.setLeftAnchor(internshipLocationLabel, 250.0);
        AnchorPane.setLeftAnchor(internshipDurationLabel, 250.0);
        AnchorPane.setLeftAnchor(readMoreLink, 240.0);

        internshipTitleLabel.getStyleClass().add("internship-title");
        internshipLocationLabel.getStyleClass().add("internship-details");
        internshipDurationLabel.getStyleClass().add("internship-details");
        readMoreLink.getStyleClass().add("login-link");


        hBox.getChildren().add(anchorPane);

        searchResultContainer.getChildren().add(hBox);
    }

    void showDetails(){
        scrollPane.setVisible(false);
        internshipDetailsPane.setVisible(true);
    }
    void showDetails(int id) throws SQLException {
        scrollPane.setVisible(false);
        SQL="SELECT internshipposts.id,internshipposts.company_id,internshipposts.title, internshipposts.duration, internshipposts.requirements, internshipposts.description, internshipposts.type, internshipposts.numberOfApplicantsNeeded, company.name, company.email,company.location FROM internshipposts INNER JOIN company ON internshipposts.company_id = company.id where internshipposts.id ="+id;
        System.out.println(SQL);
        ResultSet rst = DBUtills.searchInternships(SQL);
        while(rst.next()){
            searchInternshipTitle.setText(rst.getString("title"));
            companyNameLabel.setText(rst.getString("name"));
            locationLabel.setText(rst.getString("location"));
            durationLabel.setText(rst.getString("duration"));
            paidUnpaidLabel.setText(rst.getString("type"));
            contactLabel.setText(rst.getString("email"));
            requirementsLabel.setText(rst.getString("requirements"));
            descriptionLabel.setText(rst.getString("description"));
            vacanciesLabel.setText(rst.getString("numberOfApplicantsNeeded"));
            setCurrInternshipId(rst.getInt("id"));
            System.out.println(getCurrInternshipId());
        }
        internshipDetailsPane.setVisible(true);
    }

//
    void noResultFound(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("No result found!");
        alert.setHeaderText(null);
        alert.setTitle(null);
        alert.showAndWait();
    }

    @FXML
    void applyNowBtnClicked(ActionEvent event) throws SQLException {
        internshipDetailsPane.setVisible(false);


        SQL = "select fullName, email, dept from stud where id ="+DBUtills.getCurrentInternId();
        ResultSet rst = DBUtills.getData(SQL);
        while(rst.next()){
            fullNameField.setText(rst.getString("fullName"));
            emailField.setText(rst.getString("email"));
            degreeField.setText(rst.getString("dept"));
        }

        applicationForm.setVisible(true);
    }

    @FXML
    void submitBtnClicked(ActionEvent event){
        if(validateInputs()){
            DBUtills.addApplication(event, DBUtills.getCurrentInternId(), getCurrInternshipId(), Integer.parseInt(yearOfStudyBox.getValue().toString()), universityNameField.getText(), skillsField.getText(),gitHubURLField.getText(), statementOfInterestArea.getText(), experienceArea.getText());
            universityNameField.clear();
            skillsField.clear();
            gitHubURLField.clear();
            statementOfInterestArea.clear();
            yearOfStudyBox.getSelectionModel().clearSelection();
            experienceArea.clear();
        }else{
            showError("Please fill every field");
        }
    }

    private boolean validateInputs(){
        String fullName = fullNameField.getText();
        String email = emailField.getText();
        String universityName = universityNameField.getText();
        String degree = degreeField.getText();

        String yearOfStudy = yearOfStudyBox.getSelectionModel().getSelectedItem().toString();

        String skills = skillsField.getText();
        String gitLink = gitHubURLField.getText();
        String interest = statementOfInterestArea.getText();
        String exp = experienceArea.getText();

        if(fullName.trim().isEmpty()||interest.trim().isEmpty()||exp.trim().isEmpty()||email.trim().isEmpty()||gitLink.trim().isEmpty()||universityName.isEmpty()||yearOfStudy.isEmpty()||skills.isEmpty()){
            return false;
        }
        return true;
    }

    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void cancelBtnClicked(ActionEvent event){
        applicationForm.setVisible(false);
        internshipDetailsPane.setVisible(true);
    }

    @FXML
    void returnToFeaturedBtnClicked(ActionEvent event){
        internshipDetailsPane.setVisible(false);
        scrollPane.setVisible(true);
    }
    @FXML
    void appliedInternshipsBtnClicked(ActionEvent event) throws IOException {
        searchInternshipsBtn.setDisable(false);
        InternApp.showAppliedInternships();
    }

    @FXML

    void locationFilterBtnClicked(ActionEvent event){
        if(locationFilterBtn.isSelected()){
            durationFilterBtn.getStyleClass().remove("filterBtn-focused");
            fieldsFilterBtn.getStyleClass().remove("filterBtn-focused");
            locationFilterBtn.getStyleClass().add("filterBtn-focused");
//            paymentStatusFilterBtn.setValue(null);
//            paymentStatusFilterBtn.getSelectionModel().clearSelection();
//            paymentStatusFilterBtn.setPromptText("Choose");
        }else{
            locationFilterBtn.getStyleClass().remove("filterBtn-focused");
        }
    }

    @FXML
    void comboBoxFilterClicked(ActionEvent event){
        String selectedValue = paymentStatusFilterBtn.getSelectionModel().getSelectedItem();

        if(selectedValue!=null){
            durationFilterBtn.getStyleClass().remove("filterBtn-focused");
            durationFilterBtn.setSelected(false);
            fieldsFilterBtn.getStyleClass().remove("filterBtn-focused");
            fieldsFilterBtn.setSelected(false);
            locationFilterBtn.getStyleClass().remove("filterBtn-focused");
            locationFilterBtn.setSelected(false);
        }
    }

    @FXML
    void durationFilterBtnClicked(ActionEvent event){
        if(durationFilterBtn.isSelected()){
            durationFilterBtn.getStyleClass().add("filterBtn-focused");
            fieldsFilterBtn.getStyleClass().remove("filterBtn-focused");
            fieldsFilterBtn.setSelected(false);
            locationFilterBtn.getStyleClass().remove("filterBtn-focused");
            locationFilterBtn.setSelected(false);
        }else{
            durationFilterBtn.getStyleClass().remove("filterBtn-focused");
            durationFilterBtn.setSelected(false);
        }
    }

    @FXML
    void fieldsFilterBtnClicked(ActionEvent event){
        if(fieldsFilterBtn.isSelected()){
            durationFilterBtn.getStyleClass().remove("filterBtn-focused");
            durationFilterBtn.setSelected(false);
            fieldsFilterBtn.getStyleClass().add("filterBtn-focused");
            locationFilterBtn.getStyleClass().remove("filterBtn-focused");
            locationFilterBtn.setSelected(false);
        }else{
            fieldsFilterBtn.getStyleClass().remove("filterBtn-focused");
            fieldsFilterBtn.setSelected(false);
        }
    }
    @FXML
    void homeBtnClicked(ActionEvent event) throws IOException, SQLException {
        searchInternshipsBtn.setDisable(false);
        InternApp.showInternHomePage();
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
        }
    }
}
