module com.example.internsystemapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires fontawesomefx;


    opens com.example.internsystemapp to javafx.fxml;
    exports com.example.internsystemapp;
}