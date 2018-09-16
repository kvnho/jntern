package sample.controller;

import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import sample.model.Listing;

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

    private ObservableList<Listing> listings;


    @FXML
    void initialize() {

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
}
