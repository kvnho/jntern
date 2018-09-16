package sample.controller;

import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class ListController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXListView<?> wishlistListView;

    @FXML
    private JFXListView<?> appliedListView;

    @FXML
    void initialize() {

    }
}
