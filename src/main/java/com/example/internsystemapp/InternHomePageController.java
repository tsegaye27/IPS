package com.example.internsystemapp;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.*;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class InternHomePageController {

        @FXML
        private AnchorPane applicationForm;
        @FXML
        private Button appliedInternshipsBtn;
        @FXML
        private Button applyNowBtn;

        @FXML
        private Button cancelBtn;

        @FXML
        private Label vacanciesLabel;

        @FXML
        private TextField emailField;

        @FXML
        private TextArea statementOfInterestArea;

        @FXML
        private TextArea experienceArea;

        @FXML
        private TextField gitHubURLField;
        @FXML
        private Button submitBtn;

        @FXML
        private TextField fullNameField;

        @FXML
        private TextField phoneNumberField;

        @FXML
        private TextField locationField;

        @FXML
        private TextField universityNameField;

        @FXML
        private TextField degreeField;

        @FXML
        private ComboBox<Integer> yearOfStudyBox;

        @FXML
        private TextField skillsField;
        @FXML
        private Label companyNameLabel;

        @FXML
        private Label companyTitleLabel;

        @FXML
        private Button findYourProgramsBtn;

        @FXML
        private Button homeBtn;

        @FXML
        public Hyperlink internshipDetailsLink;

        @FXML
        private Label internshipDurationLabel;

        @FXML
        private Label internshipLocationLabel;

        @FXML
        private Button logoutBtn;
        @FXML
        private Label paidUnpaidLabel;

        @FXML
        private Label requirementsLabel;
        @FXML
        private Label durationLabel;
        @FXML
        private Label contactLabel;
        @FXML
        private Label descriptionLabel;
        @FXML
        private Hyperlink internshipDetailsLink1;

        @FXML
        private Hyperlink internshipDetailsLink2;

        @FXML
        private Hyperlink internshipDetailsLink22;

        @FXML
        private Label internshipDurationLabel1;
        @FXML
        private Label internshipTitle;

        @FXML
        private Label internshipDurationLabel2;

        @FXML
        private Label internshipDurationLabel3;

        @FXML
        private Label internshipLocationLabel1;

        @FXML
        private Label internshipLocationLabel2;

        @FXML
        private Label internshipLocationLabel3;

        @FXML
        private Label locationLabel;
        @FXML
        private Button returnToFeaturedBtn;
        @FXML
        private Button searchInternshipsBtn;

        @FXML
        private GridPane gridPane;
        @FXML
        private AnchorPane internshipDetailsPane;
        @FXML
        private FontAwesomeIcon searchInternshipsIcon;

        private int currInternshipId;

        public int getCurrInternshipId(){

            return currInternshipId;

        }


        String SQL;
        public void setCurrInternshipId(int intId){
            this.currInternshipId = intId;
        }

    public InternHomePageController() throws SQLException {
    }

public void initialize(){
        homeBtn.setDisable(true);
        yearOfStudyBox.getItems().add(1);
        yearOfStudyBox.getItems().add(2);
        yearOfStudyBox.getItems().add(3);
        yearOfStudyBox.getItems().add(4);
        yearOfStudyBox.getItems().add(5);
        }

        @FXML
        void appliedInternshipsBtnClicked(ActionEvent event) throws IOException{
            homeBtn.setDisable(false);
            InternApp.showAppliedInternships();
        }
        @FXML
        void findYourProgramsBtnClicked(ActionEvent event) throws IOException {
            InternApp.showSearchInternships();
        }
        void setDetails() throws SQLException {
            internshipTitle.setText(rst.getString("title"));
            requirementsLabel.setText(rst.getString("requirements"));
            companyNameLabel.setText(rst.getString("name"));
            paidUnpaidLabel.setText(rst.getString("type"));
            locationLabel.setText(rst.getString("location"));
            durationLabel.setText(rst.getString("duration"));
            contactLabel.setText(rst.getString("email"));
            descriptionLabel.setText(rst.getString("description"));
            vacanciesLabel.setText(rst.getString("numberOfApplicantsNeeded"));
        }
        ResultSet rst = DBUtills.getFeaturedInternships();

        @FXML
        void internshipDetailsLinkClicked(ActionEvent event) throws SQLException {
            Hyperlink hyperlink = (Hyperlink) event.getSource();
            String id = hyperlink.getId();
            if(Objects.equals(id, internshipDetailsLink.getId())){
                if (rst.next()) {
                    // Read the values of the columns in the first row
                    setDetails();
                    setCurrInternshipId(rst.getInt("id"));
                    rst.previous();
                }
            }else if(Objects.equals(id, internshipDetailsLink1.getId())){
                if (rst.next() && rst.next()) {
                    setDetails();
                    setCurrInternshipId(rst.getInt("id"));
                    rst.previous();
                    rst.previous();
                }
            }else if(Objects.equals(id, internshipDetailsLink2.getId())){
                if (rst.next() && rst.next()&& rst.next()) {
                    setDetails();
                    setCurrInternshipId(rst.getInt("id"));
                    rst.previous();
                    rst.previous();
                    rst.previous();
                }
            }else if(Objects.equals(id, internshipDetailsLink22.getId())){
                if (rst.next() && rst.next()&& rst.next() && rst.next()) {
                    setDetails();
                    setCurrInternshipId(rst.getInt("id"));
                    rst.previous();
                    rst.previous();
                    rst.previous();
                    rst.previous();
                }
            }
            gridPane.setVisible(false);
            internshipDetailsPane.setVisible(true);
        }

        @FXML
        void logoutBtnClicked(ActionEvent event) throws IOException{
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
                DBUtills.setCurrentInternId(0);
            }
        }
        @FXML
        void searchInternshipsBtnClicked(ActionEvent event) throws IOException{
            homeBtn.setDisable(false);
            InternApp.showSearchInternships();
        }
        @FXML
        void returnToFeaturedBtnClicked(ActionEvent event) {
            internshipDetailsPane.setVisible(false);
            gridPane.setVisible(true);
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
            String yearOfStudy = yearOfStudyBox.getSelectionModel().getSelectedItem().toString();
            if(validateInputs()){
                DBUtills.addApplication(event, DBUtills.getCurrentInternId(), getCurrInternshipId(), Integer.parseInt(yearOfStudy), universityNameField.getText(), skillsField.getText(),gitHubURLField.getText(), statementOfInterestArea.getText(), experienceArea.getText());
                universityNameField.clear();
                skillsField.clear();
                gitHubURLField.clear();
                yearOfStudyBox.getSelectionModel().clearSelection();
                statementOfInterestArea.clear();
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

        if(fullName.trim().isEmpty()||interest.trim().isEmpty()||exp.trim().isEmpty()||email.trim().isEmpty()||gitLink.trim().isEmpty()||universityName.isEmpty()|| yearOfStudy.isEmpty()||skills.isEmpty()){
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

        void loadFeaturedInternships(AnchorPane anchorPane) throws SQLException {
            int i = 0;
            while (rst.next()) {
                    GridPane gp = (GridPane) anchorPane.getChildren().get(4);
                    AnchorPane ap = (AnchorPane) gp.getChildren().get(i);
                    companyTitleLabel = (Label) ap.getChildren().get(0);
                    internshipDurationLabel = (Label) ap.getChildren().get(1);
                    internshipLocationLabel = (Label) ap.getChildren().get(2);

                    companyTitleLabel.setText(rst.getString("title"));
                    internshipLocationLabel.setText(rst.getString("location"));
                    internshipDurationLabel.setText(rst.getString("duration"));

                    i++;

                }


        }
}
