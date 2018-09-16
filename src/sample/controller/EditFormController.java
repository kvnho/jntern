package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class EditFormController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField companyTextField;

    @FXML
    private JFXTextField linkTextField;

    @FXML
    private JFXTextField positionTextField;

    @FXML
    private JFXTextField locationTextField;

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXButton backButton;

    @FXML
    private JFXButton notesButton;

    @FXML
    private JFXButton appliedButton;

    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXButton infoButton;

    @FXML
    void initialize() {

    }
}
