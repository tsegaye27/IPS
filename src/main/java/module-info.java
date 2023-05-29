module com.example.internsystemapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.internsystemapp to javafx.fxml;
    exports com.example.internsystemapp;
}