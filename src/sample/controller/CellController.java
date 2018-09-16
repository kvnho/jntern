package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sample.model.Listing;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CellController extends JFXListCell<Listing> {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    private Label companyLabel;

    @FXML
    private Label positionLabel;

    @FXML
    private JFXButton editButton;

    private FXMLLoader fxmlLoader;

    @FXML
    void initialize() {

    }

    @Override
    public void updateItem(Listing item, boolean empty) {
        super.updateItem(item, empty);

        if(empty || item == null){
            setText(null);
            setGraphic(null);
        }
        else{
            if(fxmlLoader == null){
                fxmlLoader = new FXMLLoader(getClass().getResource("/sample/view/cell.fxml"));
                fxmlLoader.setController(this);

                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            companyLabel.setText(item.getCompany());
            positionLabel.setText(item.getPosition());

            setText(null);
            setGraphic(rootAnchorPane);
        }
    }
}