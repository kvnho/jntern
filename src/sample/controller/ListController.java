package sample.controller;

import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ListController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXListView<String> wishlistListView;

    @FXML
    private JFXListView<String> appliedListView;


    ObservableList<String> wishlist = FXCollections.observableArrayList("Job 1", "Job 2", "Job 3", "Job 4");
    ObservableList<String> appliedlist = FXCollections.observableArrayList("Job 1", "Job 2", "Job 3", "Job 4");


    @FXML
    void initialize() {
        wishlistListView.setItems(wishlist);
        wishlistListView.setVerticalGap(10.0);
        wishlistListView.setExpanded(true);

        appliedListView.setItems(appliedlist);
        appliedListView.setVerticalGap(10.0);
        appliedListView.setExpanded(true);



    }
}
