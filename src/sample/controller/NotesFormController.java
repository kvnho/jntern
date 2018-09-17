package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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
        backButton.setOnAction(event -> {
            try {
                listScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        infoButton.setOnAction(event -> {
            try {
                infoScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    private void infoScreen() throws IOException {
        notesButton.getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/sample/view/editForm.fxml"));
        Scene scene = new Scene(parent);

        Stage window = new Stage();
        window.setTitle("jntern");
        window.setScene(scene);
        window.show();
    }

    private void listScreen() throws IOException {
        backButton.getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/sample/view/list.fxml"));
        Scene scene = new Scene(parent);

        Stage window = new Stage();
        window.setTitle("jntern");
        window.setScene(scene);
        window.show();
    }
}
