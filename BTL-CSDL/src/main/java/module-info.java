module com.btlcsdl {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.btlcsdl to javafx.fxml;
    exports com.btlcsdl;
    exports com.btlcsdl.controller;
    opens com.btlcsdl.controller to javafx.fxml;
}