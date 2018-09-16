package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import sample.database.DatabaseHandler;
import sample.model.Listing;

import javax.xml.crypto.Data;
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
    void initialize() {
        saveButton.setOnAction(event -> {
            try {
                createListing();
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

}
