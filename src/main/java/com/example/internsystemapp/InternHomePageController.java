package com.example.internsystemapp;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class InternHomePageController {

        @FXML
        private Button appliedInternshipsBtn;

        @FXML
        private Label companyTitleLabel;

        @FXML
        private Label companyTitleLabel1;

        @FXML
        private Label companyTitleLabel2;
        @FXML
        private Label companyTitleLabel3;

        @FXML
        private Button findYourProgramsBtn;

        @FXML
        private Button homeBtn;

        @FXML
        private Hyperlink internshipDetailsLink;

        @FXML
        private Label internshipDurationLabel;

        @FXML
        private Label internshipDurationLabel1;

        @FXML
        private Label internshipDurationLabel2;

        @FXML
        private Label internshipDurationLabel3;

        @FXML
        private Label internshipLocationLabel;

        @FXML
        private Label internshipLocationLabel1;

        @FXML
        private Label internshipLocationLabel2;

        @FXML
        private Label internshipLocationLabel3;

        @FXML
        private Button logoutBtn;

        @FXML
        private Button searchInternshipsBtn;

        @FXML
        private FontAwesomeIcon searchInternshipsIcon;
        public void displayFeaturedCard(){
            companyTitleLabel.setText("FaceBook");;
            internshipDurationLabel.setText("Duration : 3 month");
            internshipLocationLabel.setText("Location : New York");

            companyTitleLabel1.setText("Telegram");
            internshipDurationLabel1.setText("Duration : 2 month");
            internshipLocationLabel1.setText("Location : Addis Ababa");

            companyTitleLabel2.setText("Amazon");
            internshipDurationLabel2.setText("Duration : 2 month");
            internshipLocationLabel2.setText("Location : Addis Ababa");

            companyTitleLabel3.setText("Instagram");
            internshipDurationLabel3.setText("Duration : 2 month");
            internshipLocationLabel3.setText("Location : Addis Ababa");
        }

    @FXML
        void appliedInternshipsBtnClicked(ActionEvent event) throws IOException{
            InternApp.showAppliedInternships();
        }

        @FXML
        void findYourProgramsBtnClicked(ActionEvent event) throws IOException {
            InternApp.showSearchInternships();
        }

        @FXML
        void homeBtnClicked(ActionEvent event) throws IOException {
            InternApp.showInternHomePage();
        }

        @FXML
        void internshipDetailsLinkClicked(ActionEvent event) {

        }

        @FXML
        void logoutBtnClicked(ActionEvent event) throws IOException{
            InternApp.showInternLoginPage();
        }

        @FXML
        void searchInternshipsBtnClicked(ActionEvent event) throws IOException{
            InternApp.showSearchInternships();
        }

        public void initialize(AnchorPane anchorPane){
            AnchorPane ap1 = (AnchorPane) anchorPane.getChildren().get(4);
            companyTitleLabel = (Label) ap1.getChildren().get(0);
            internshipDurationLabel = (Label) ap1.getChildren().get(1);
            internshipLocationLabel = (Label) ap1.getChildren().get(2);

            AnchorPane ap2 = (AnchorPane) anchorPane.getChildren().get(6);
            companyTitleLabel1 = (Label) ap2.getChildren().get(0);
            internshipDurationLabel1 = (Label) ap2.getChildren().get(1);
            internshipLocationLabel1 = (Label) ap2. getChildren().get(2);

            AnchorPane ap3 = (AnchorPane) anchorPane.getChildren().get(7);
            companyTitleLabel2 = (Label) ap3.getChildren().get(0);
            internshipDurationLabel2 = (Label) ap3.getChildren().get(1);
            internshipLocationLabel2 = (Label) ap3.getChildren().get(2);

            AnchorPane ap4 = (AnchorPane) anchorPane.getChildren().get(8);
            companyTitleLabel3 = (Label) ap4.getChildren().get(0);
            internshipDurationLabel3 = (Label) ap4.getChildren().get(1);
            internshipLocationLabel3 = (Label) ap4.getChildren().get(2);
        }
}
