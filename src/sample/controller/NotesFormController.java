package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class NotesFormController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXButton backButton;

    @FXML
    private JFXButton notesButton;

    @FXML
    private JFXButton infoButton;

    @FXML
    private JFXTextArea notesTextArea;

    @FXML
    void initialize() {

    }
}
