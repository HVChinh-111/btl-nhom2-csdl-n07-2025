package org.example.btlcsdl.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ClinicManagementController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Clinic Management System!");
    }
}
