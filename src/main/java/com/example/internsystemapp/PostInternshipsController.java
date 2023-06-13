package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.xml.xpath.XPathEvaluationResult;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class PostInternshipsController {
    @FXML
    private Button homeBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button manageInternshipsBtn;

    @FXML
    private Button nextBtn;

    @FXML
    private TextField titleField;

    @FXML
    private TextField companyNameField;

    @FXML
    private TextField locationField;
    @FXML
    private Button returnToEditPostBtn;

    @FXML
    private TextField durationField;

    @FXML
    private TextField contactField;

    @FXML
    private TextField paidUnpaidField;

    @FXML
    private TextField vacanciesField;

    @FXML
    private Button postBtn;

    @FXML
    private AnchorPane viewPostPane;

    @FXML
    private AnchorPane postInternshipPane;
    @FXML
    private TextArea requirementsArea;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private Button postInternshipsBtn;

    public void initialize() throws SQLException {
        postInternshipsBtn.setDisable(true);
        getCompanyDetail();
    }

    String SQL;
    @FXML
    void homeBtnClicked(ActionEvent event) throws IOException {
        postInternshipsBtn.setDisable(false);
        InternApp.showCmpHomePage();
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
            DBUtills.setCurrentCmpId(0);
        }
    }

    @FXML
    void returnToEditPostBtnClicked(ActionEvent event){
        viewPostPane.setVisible(false);
        postInternshipPane.setVisible(true);
    }

    @FXML
    void postBtnClicked(ActionEvent event){

    }


    @FXML
    void nextBtnClicked(ActionEvent event){
        if(validateInputs()){
            postInternshipPane.setVisible(false);
            viewPostPane.setVisible(true);
        }
        showError("Please Fill Every Field");
    }

    @FXML
    void manageInternshipsBtnClicked(ActionEvent event) throws IOException {
        postInternshipsBtn.setDisable(false);
        InternApp.showManageInternships();
    }
    private boolean validateInputs(){
        String title = titleField.getText();
        String companyName = companyNameField.getText();
        String location = locationField.getText();
        String duration = durationField.getText();
        String contact = contactField.getText();
        String wage = paidUnpaidField.getText();
        String vacancies = vacanciesField.getText();
        String req = requirementsArea.getText();
        String description = descriptionArea.getText();

        if(title.trim().isEmpty()||companyName.trim().isEmpty()||location.trim().isEmpty()||duration.trim().isEmpty()||contact.trim().isEmpty()||wage.trim().isEmpty()||vacancies.trim().isEmpty()||req.trim().isEmpty()||description.trim().isEmpty()){
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
    void getCompanyDetail() throws SQLException {
        SQL = "select name, email, location from company where id = "+DBUtills.getCurrentCmpId();
        System.out.println(SQL);
        ResultSet rst = DBUtills.getData(SQL);
        while(rst.next()){
            companyNameField.setText(rst.getString("name"));
            contactField.setText(rst.getString("email"));
            locationField.setText(rst.getString("location"));
        }
    }

}
