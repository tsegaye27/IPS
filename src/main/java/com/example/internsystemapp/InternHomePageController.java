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
        private GridPane gridPane;
        @FXML
        private FontAwesomeIcon searchInternshipsIcon;

    @FXML
        void appliedInternshipsBtnClicked(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AppliedInternships.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) appliedInternshipsBtn.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }

        @FXML
        void findYourProgramsBtnClicked(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchInternships.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) findYourProgramsBtn.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        @FXML
        void homeBtnClicked(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InternHomePage.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) homeBtn.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        @FXML
        void internshipDetailsLinkClicked(ActionEvent event) {

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchInternships.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) searchInternshipsBtn.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
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
