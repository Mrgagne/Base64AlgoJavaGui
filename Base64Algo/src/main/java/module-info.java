module com.example.base64algo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.base64algo to javafx.fxml;
    exports com.example.base64algo;
}