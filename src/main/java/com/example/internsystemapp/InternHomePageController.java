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
        private Button searchInternshipsBtn;

        @FXML
        private FontAwesomeIcon searchInternshipsIcon;
        public void displayFeaturedCard(){
            companyTitleLabel.setText("FaceBook");;
            internshipDurationLabel.setText("3 month");
            internshipLocationLabel.setText("New York");
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
        }
}
