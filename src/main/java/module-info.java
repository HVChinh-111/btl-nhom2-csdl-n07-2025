module org.example.btlcsdl {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.btlcsdl to javafx.fxml;
    exports org.example.btlcsdl;
    exports org.example.btlcsdl.controller;
    opens org.example.btlcsdl.controller to javafx.fxml;
}