package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.database.DatabaseHandler;
import sample.model.Listing;

import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddFormController {
    public static int listingId;

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
            try {
                listScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        saveButton.setOnAction(event -> {
            try {
                createListing();
                listScreen();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
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

    private void listScreen() throws IOException {
        backButton.getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/sample/view/list.fxml"));
        Scene scene = new Scene(parent);

        Stage window = new Stage();
        window.setScene(scene);
        window.show();
    }

    public void setListingId(int listingId){
        this.listingId = listingId;
    }
    public int getListingId(){
        return this.listingId;
    }

}