package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.Listing;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
    public JFXButton saveButton;

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
    private JFXButton applicationButton;

    @FXML
    void initialize() {

        backButton.setOnAction(event -> {
            try {
                listScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        applicationButton.setOnAction(event -> {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(getLinkTextField()));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });

        notesButton.setOnAction(event -> {
            try {
                notesScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public String getCompanyTextField() {
        return this.companyTextField.getText().trim();
    }

    public void setCompanyTextField(String company) {
        this.companyTextField.setText(company);
    }

    public String getLinkTextField() {
        return this.linkTextField.getText().trim();
    }

    public void setLinkTextField(String link) {
        this.linkTextField.setText(link);
    }

    public String getPositionTextField() {
        return this.positionTextField.getText().trim();
    }

    public void setPositionTextField(String position) {
        this.positionTextField.setText(position);
    }

    public String getLocationTextField() {
        return this.locationTextField.getText().trim();
    }

    public void setLocationTextField(String location) {
        this.locationTextField.setText(location);
    }

    private void notesScreen() throws IOException {
        notesButton.getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/sample/view/notesForm.fxml"));
        Scene scene = new Scene(parent);

        Stage window = new Stage();
        window.setScene(scene);
        window.show();
    }
    private void listScreen() throws IOException {
        backButton.getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/sample/view/list.fxml"));
        Scene scene = new Scene(parent);

        Stage window = new Stage();
        window.setScene(scene);
        window.show();
    }



}
