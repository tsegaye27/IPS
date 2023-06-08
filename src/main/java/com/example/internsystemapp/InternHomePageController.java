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

import java.io.IOException;
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
        private TextField emailField;

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
        private TextField yearOfStudyField;

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
        private Hyperlink internshipDetailsLink;

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
        private Hyperlink internshipDetailsLink1;

        @FXML
        private Hyperlink internshipDetailsLink2;

        @FXML
        private Hyperlink internshipDetailsLink22;

        @FXML
        private Label internshipDurationLabel1;

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

        public void initialize(){
            homeBtn.setDisable(true);
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

        @FXML
        void internshipDetailsLinkClicked(ActionEvent event) {
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
        void applyNowBtnClicked(ActionEvent event){
            internshipDetailsPane.setVisible(false);
            applicationForm.setVisible(true);
        }

        @FXML
        void submitBtnClicked(ActionEvent event){
            if(validateInputs()){
                //save into database
            }else{
                showError("Please fill every field");
            }
        }

        private boolean validateInputs(){
            String fullName = fullNameField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneNumberField.getText();
            String location = locationField.getText();
            String universityName = universityNameField.getText();
            String degree = degreeField.getText();
            String yearOfStudy = yearOfStudyField.getText();
            String skills = skillsField.getText();

            if(fullName.isEmpty()||email.isEmpty()||phoneNumber.isEmpty()||location.isEmpty()||universityName.isEmpty()||degree.isEmpty()||yearOfStudy.isEmpty()||skills.isEmpty()){
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

        void loadFeaturedInternships(AnchorPane anchorPane){

            //Dummy data for featured internships
            String[] titles = {"Internship 1", "Internship 2", "Internship 3", "Internship 4"};
            String[] locations = {"Location 1", "Location 2", "Location 3", "Location 4"};
            String[] durations = {"Duration 1", "Duration 2", "Duration 3", "Duration 4"};

            for(int i=0; i < titles.length; i++){

            GridPane gp = (GridPane) anchorPane.getChildren().get(4);
            AnchorPane ap = (AnchorPane) gp.getChildren().get(i);
            companyTitleLabel = (Label) ap.getChildren().get(0);
            internshipDurationLabel = (Label) ap.getChildren().get(1);
            internshipLocationLabel = (Label) ap.getChildren().get(2);

            companyTitleLabel.setText(titles[i]);
            internshipLocationLabel.setText(locations[i]);
            internshipDurationLabel.setText(durations[i]);
            }
        }
}
