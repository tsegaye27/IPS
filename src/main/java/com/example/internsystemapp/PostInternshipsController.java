package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

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
    @FXML
    private Label titleFieldLabel;
    @FXML
    private Label companyNameFieldLabel;
    @FXML
    private Label locationFieldLabel;
    @FXML
    private Label durationFieldLabel;
    @FXML
    private Label contactFieldLabel;
    @FXML
    private Label paidUnpaidFieldLabel;
    @FXML
    private Label vacanciesFieldLabel;
    @FXML
    private Label requirementsFieldLabel;
    @FXML
    private Label descriptionFieldLabel;


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
    void postBtnClicked(ActionEvent event) throws IOException {
        DBUtills.postInternship(DBUtills.getCurrentCmpId(), titleFieldLabel.getText(), durationFieldLabel.getText(), requirementsFieldLabel.getText(),descriptionFieldLabel.getText(),paidUnpaidFieldLabel.getText(), Integer.parseInt(vacanciesFieldLabel.getText()));
        titleField.clear();
        durationField.clear();
        paidUnpaidField.clear();
        vacanciesField.clear();
        requirementsArea.clear();
        descriptionArea.clear();
        InternApp.showPostInternships();
    }


    @FXML
    void nextBtnClicked(ActionEvent event){
        if(validateInputs()){
            titleFieldLabel.setText(titleField.getText());
            companyNameFieldLabel.setText(companyNameField.getText());
            locationFieldLabel.setText(locationField.getText());
            durationFieldLabel.setText(durationField.getText());
            contactFieldLabel.setText(contactField.getText());
            paidUnpaidFieldLabel.setText(paidUnpaidField.getText());
            vacanciesFieldLabel.setText(vacanciesField.getText());
            requirementsFieldLabel.setText(requirementsArea.getText());
            descriptionFieldLabel.setText(descriptionArea.getText());
            postInternshipPane.setVisible(false);
            viewPostPane.setVisible(true);
        }else{
            showError("Please enter all the necessary information");
        }

    }

    @FXML
    void reviewedApplicantsBtnClicked(ActionEvent event) throws IOException{
        postInternshipsBtn.setDisable(false);
        InternApp.showReviewedApplicants();
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
        ResultSet rst = DBUtills.getData(SQL);
        while(rst.next()){
            companyNameField.setText(rst.getString("name"));
            contactField.setText(rst.getString("email"));
            locationField.setText(rst.getString("location"));
        }
    }


}
