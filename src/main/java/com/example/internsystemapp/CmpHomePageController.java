package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class CmpHomePageController {

    @FXML
    private Button homeBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button manageInternshipsBtn;

    @FXML
    private Button postInternshipsBtn;

    @FXML
    void homeBtnClicked(ActionEvent event) {

    }


    @FXML
    void manageInternshipsBtnClicked(ActionEvent event) {

    }

    @FXML
    void postInternshipsBtnClicked(ActionEvent event) {

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
        }
    }

}
