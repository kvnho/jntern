package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class AddFormController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField companyTextField;

    @FXML
    private JFXTextField linkTextField;

    @FXML
    private JFXTextField titleTextField;

    @FXML
    private JFXTextField locationTextField;

    @FXML
    private JFXButton saveButton;

    @FXML
    void initialize() {

    }
}
