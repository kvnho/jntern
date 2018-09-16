package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.model.Listing;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXListView<Listing> applyListView;

    @FXML
    private JFXListView<Listing> appliedListView;

    @FXML
    private JFXButton addButton;

    private ObservableList<Listing> listings;


    @FXML
    void initialize() {

        addButton.setOnAction(event -> {
            try {
                addFormScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Listing myListing = new Listing();
        myListing.setCompany("Company 1");
        myListing.setPosition("Position 1");

        Listing myListing2 = new Listing();
        myListing2.setCompany("Company 2");
        myListing2.setPosition("Position 2");

        listings = FXCollections.observableArrayList();
        listings.addAll(myListing, myListing2);

        applyListView.setItems(listings);
        applyListView.setCellFactory(CellController -> new CellController());

    }

    private void addFormScreen() throws IOException {
        addButton.getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/sample/view/addForm.fxml"));
        Scene scene = new Scene(parent);

        Stage window = new Stage();
        window.setScene(scene);
        window.show();
    }
}