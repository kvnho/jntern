package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.database.DatabaseHandler;
import sample.model.Listing;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    private JFXTextField positionTextField;

    @FXML
    private JFXTextField locationTextField;

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXButton backButton;

    @FXML
    void initialize() {
        backButton.setOnAction(event -> {
            listScreen();
        });
        saveButton.setOnAction(event -> {
            try {
                createListing();
                listScreen();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private void createListing() throws ClassNotFoundException, SQLException {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        String companyName = companyTextField.getText();
        String positionName = positionTextField.getText();
        String locationName = locationTextField.getText();
        String linkName = linkTextField.getText();

        Listing listing = new Listing(companyName, positionName, locationName, linkName);

        databaseHandler.createListing(listing);
    }

    private void listScreen(){
        backButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/list.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}