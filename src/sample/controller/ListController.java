package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.database.DatabaseHandler;
import sample.model.Listing;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    private DatabaseHandler databaseHandler;


    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        listings = FXCollections.observableArrayList();

        databaseHandler = new DatabaseHandler();
        ResultSet resultSet = databaseHandler.getListing();

        while (resultSet.next()){
            Listing listing = new Listing();
            listing.setListingId(resultSet.getInt("listingid"));
            listing.setCompany(resultSet.getString("company"));
            listing.setPosition(resultSet.getString("position"));
            listing.setLocation(resultSet.getString("location"));
            listing.setLink(resultSet.getString("link"));

            listings.addAll(listing);
        }

        applyListView.setItems(listings);
        applyListView.setCellFactory(CellController -> new CellController());


        addButton.setOnAction(event -> {
            try {
                addFormScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private void addFormScreen() throws IOException {
        addButton.getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/sample/view/addForm.fxml"));
        Scene scene = new Scene(parent);

        Stage window = new Stage();
        window.setTitle("jntern");
        window.setScene(scene);
        window.show();
    }

}