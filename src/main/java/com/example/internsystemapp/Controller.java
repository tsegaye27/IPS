package com.example.internsystemapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;

    public void loginButtonOnAction(ActionEvent e){
        
        if(usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false){
            loginMessageLabel.setText("You try to Login");
        }else{
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    public void cancelBUttonOnAction(ActionEvent e){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordPasswordField;


    @FXML
    private TextField usernameTextField;

}
