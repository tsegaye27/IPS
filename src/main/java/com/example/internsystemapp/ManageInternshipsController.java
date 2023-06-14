package com.example.internsystemapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

public class ManageInternshipsController {

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField companyNameField;

    @FXML
    private Label companyNameLabel;

    @FXML
    private TextField contactField;

    @FXML
    private Label contactLabel;

    @FXML
    private Button deleteBtn;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private Label descriptionLabel;

    @FXML
    private TextField durationField;

    @FXML
    private Label durationLabel;

    @FXML
    private Button editPostBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private AnchorPane internshipEditorPane;

    @FXML
    private VBox internshipsContainer;

    @FXML
    private TextField locationField;

    @FXML
    private Label locationLabel;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button manageInternshipsBtn;

    @FXML
    private AnchorPane managePostPane;

    @FXML
    private ScrollPane viewPostsPane;

    @FXML
    private Label noInternships;

    @FXML
    private TextField paidUnpaidField;

    @FXML
    private Label paidUnpaidLabel;

    @FXML
    private Button postInternshipsBtn;

    @FXML
    private TextArea requirementsArea;

    @FXML
    private Label requirementsLabel;

    @FXML
    private Button returnToViewPostsBtn;

    @FXML
    private Label searchInternshipTitle;

    @FXML
    private TextField titleField;

    @FXML
    private Button updateBtn;

    @FXML
    private TextField vacanciesField;

    @FXML
    private Label vacanciesLabel;
    private int currentInternshipId = 0;
    public int getCurrentInternshipId() {
        return currentInternshipId;
    }

    public void setCurrentInternshipId(int currentInternshipId) {
        this.currentInternshipId = currentInternshipId;
    }
    String SQL;
    public void initialize() throws SQLException {
        manageInternshipsBtn.setDisable(true);
        internshipsContainer.setSpacing(10);
        displayInternships();
    }

    void displayInternships() throws SQLException {
        SQL = "select id, Title, duration, numberOfApplicantsNeeded from internshipposts where company_id ="+DBUtills.getCurrentCmpId();
        ResultSet rst = DBUtills.getData(SQL);
        if(rst.isBeforeFirst()){
            //if the company have posted an internship
            while(rst.next()){
//                createHBox(rst.getInt("id"), rst.getString("Title"), rst.getString("duration"), rst.getString("numberOfApplicantsNeeded"));
                createHBox(rst.getInt("id"), rst.getString("Title"), rst.getString("duration"), rst.getString("numberOfApplicantsNeeded"));
            }
        }else{
            noInternshipsPosted();
        }
    }

    void noInternshipsPosted(){
        viewPostsPane.setVisible(false);
        noInternships.setVisible(true);
    }

    void createHBox(int id, String title, String duration, String vacancies){
        AnchorPane anchorPane = new AnchorPane();

        anchorPane.getStyleClass().add("post-cards");

        anchorPane.setPrefWidth(440);
        anchorPane.setPrefHeight(180);

        Label titleLabel = new Label(title);
        Label durationLabel = new Label(duration);
        Label vacanciesLabel = new Label(vacancies);

        Button manageButton = new Button("Manage Internship");
        manageButton.getStyleClass().add("postBtn");
        manageButton.setOnAction(event -> {
            try {
                showPostEditor(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        AnchorPane.setTopAnchor(titleLabel, 15.0);
        AnchorPane.setLeftAnchor(titleLabel, 190.0);

        AnchorPane.setTopAnchor(vacanciesLabel, 60.0);
        AnchorPane.setLeftAnchor(vacanciesLabel, 160.0);

        AnchorPane.setTopAnchor(durationLabel, 90.0);
        AnchorPane.setLeftAnchor(durationLabel, 160.0);

        AnchorPane.setTopAnchor(manageButton, 120.0);
        AnchorPane.setLeftAnchor(manageButton, 160.0);

        anchorPane.getChildren().addAll(titleLabel,durationLabel,vacanciesLabel, manageButton);

        titleLabel.getStyleClass().add("internship-title");
        durationLabel.getStyleClass().add("internship-details");
        vacanciesLabel.getStyleClass().add("internship-details");
        HBox hBox = new HBox(anchorPane);
        hBox.setSpacing(10);
        internshipsContainer.getChildren().add(hBox);
    }

    void showPostEditor(int id) throws SQLException {
        setCurrentInternshipId(id);
        SQL = "select company.name, company.location, company.email, internshipposts.duration,internshipposts.id,  internshipposts.title, internshipposts.type, internshipposts.requirements, internshipposts.description, internshipposts.numberOfApplicantsNeeded from company inner join internshipposts on company.id = internshipposts.company_id where company.id = "+DBUtills.getCurrentCmpId()+" and internshipposts.id = "+getCurrentInternshipId();
        ResultSet rst = DBUtills.getData(SQL);
        while(rst.next()){
            searchInternshipTitle.setText(rst.getString("title"));
            companyNameLabel.setText(rst.getString("name"));
            locationLabel.setText(rst.getString("location"));
            durationLabel.setText(rst.getString("duration"));
            contactLabel.setText(rst.getString("email"));
            paidUnpaidLabel.setText(rst.getString("type"));
            vacanciesLabel.setText(rst.getString("numberOfApplicantsNeeded"));
            requirementsLabel.setText(rst.getString("requirements"));
            descriptionLabel.setText(rst.getString("description"));
        }
        viewPostsPane.setVisible(false);
        managePostPane.setVisible(true);
    }

    @FXML
    void returnToViewPostsBtnClicked(ActionEvent event){
        managePostPane.setVisible(false);
        viewPostsPane.setVisible(true);
    }

    @FXML
    void managedApplicantsBtnClicked(ActionEvent event) throws IOException{
        manageInternshipsBtn.setDisable(false);
        InternApp.showManagedApplicants();
    }

    @FXML
    void editPostBtnClicked(ActionEvent event){
        titleField.setText(searchInternshipTitle.getText());
        companyNameField.setText(companyNameLabel.getText());
        locationField.setText(locationLabel.getText());
        durationField.setText(durationLabel.getText());
        contactField.setText(contactLabel.getText());
        paidUnpaidField.setText(paidUnpaidLabel.getText());
        vacanciesField.setText(vacanciesLabel.getText());
        requirementsArea.setText(requirementsLabel.getText());
        descriptionArea.setText(descriptionLabel.getText());
        managePostPane.setVisible(false);
        internshipEditorPane.setVisible(true);
    }

    @FXML
    void deleteBtnClicked(ActionEvent event) throws SQLException {
        DBUtills.deletePost(getCurrentInternshipId());
        showInformation("Post Deleted");
        displayInternships();
        returnToViewPostsBtnClicked(event);

    }

    @FXML
    void updateBtnClicked(ActionEvent event) throws SQLException {

        if(!Objects.equals(titleField.getText(), searchInternshipTitle.getText()) || !Objects.equals(durationField.getText(), durationLabel.getText()) || !Objects.equals(paidUnpaidField.getText(), paidUnpaidLabel.getText()) || !Objects.equals(vacanciesField.getText(), vacanciesLabel.getText()) || !Objects.equals(requirementsArea.getText(), requirementsLabel.getText()) || !Objects.equals(descriptionArea.getText(), descriptionLabel.getText()) ){
            int updateCount = 0;
            if(!Objects.equals(titleField.getText(), searchInternshipTitle.getText())){
                DBUtills.updateTitle(titleField.getText(), getCurrentInternshipId());
                updateCount++;
            }
            if(!Objects.equals(durationField.getText(), durationLabel.getText())){
                DBUtills.updateDuration(durationField.getText(), getCurrentInternshipId());
                updateCount++;
            }
            if( !Objects.equals(paidUnpaidField.getText(), paidUnpaidLabel.getText())){
                DBUtills.updatePaidUnpaid(paidUnpaidField.getText(), getCurrentInternshipId());
                updateCount++;
            }
            if(!Objects.equals(vacanciesField.getText(), vacanciesLabel.getText())){
                DBUtills.updateVacancies(vacanciesField.getText(), getCurrentInternshipId());
                updateCount++;
            }
            if(!Objects.equals(requirementsArea.getText(), requirementsLabel.getText())){
                DBUtills.updateRequirements(requirementsArea.getText(), getCurrentInternshipId());
                updateCount++;
            }
            if(!Objects.equals(descriptionArea.getText(), descriptionLabel.getText())){
                DBUtills.updateDescription(descriptionArea.getText(), getCurrentInternshipId());
                updateCount++;
            }
            String message = Integer.toString(updateCount)+" changes made";
            showInformation(message);
            cancelBtnClicked(event);
            showPostEditor(getCurrentInternshipId());

        }else{
            showError("There is nothing to be changed");
        }
    }

    @FXML
    void cancelBtnClicked(ActionEvent event){
        internshipEditorPane.setVisible(false);
        managePostPane.setVisible(true);
    }

    @FXML
    void homeBtnClicked(ActionEvent event) throws IOException {
        manageInternshipsBtn.setDisable(false);
        InternApp.showCmpHomePage();
    }

    @FXML
    void logoutBtnClicked(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to Logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            InternApp.showWelcomePage();
            DBUtills.setCurrentCmpId(0);
        }
    }

    @FXML
    void postInternshipsBtnClicked(ActionEvent event) throws IOException {
        manageInternshipsBtn.setDisable(false);
        InternApp.showPostInternships();
    }
    private void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public void showInformation(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }


}
