package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.database.DatabaseHandler;
import sample.model.Listing;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
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
    private JFXButton applyButton;

    private FXMLLoader fxmlLoader;

    private DatabaseHandler databaseHandler;


    @FXML
    void initialize() {
    }

    @Override
    public void updateItem(Listing item, boolean empty) {
        super.updateItem(item, empty);

        databaseHandler = new DatabaseHandler();

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



            applyButton.setOnMouseClicked(event -> {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI(item.getLink()));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            });

            rootAnchorPane.setOnMouseClicked(event -> {
                rootAnchorPane.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/view/editForm.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setTitle("jntern");
                stage.setScene(new Scene(root));

                EditFormController editFormController = loader.getController();
                editFormController.setCompanyTextField(item.getCompany());
                editFormController.setPositionTextField(item.getPosition());
                editFormController.setLocationTextField(item.getLocation());
                editFormController.setLinkTextField(item.getLink());

                editFormController.saveButton.setOnAction(event1 -> {
                    try {
                        databaseHandler.editListing(item.getListingId(), editFormController.getCompanyTextField(), editFormController.getPositionTextField(), editFormController.getLocationTextField(), editFormController.getLinkTextField());

                        editFormController.saveButton.getScene().getWindow().hide();
                        Parent parent = FXMLLoader.load(getClass().getResource("/sample/view/list.fxml"));
                        Scene scene = new Scene(parent);
                        Stage window = new Stage();
                        window.setTitle("jntern");
                        window.setScene(scene);
                        window.show();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });




                stage.show();
            });
        }
    }


}