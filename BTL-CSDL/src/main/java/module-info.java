module com.btlcsdl {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.btlcsdl to javafx.fxml;
    exports com.btlcsdl;
}