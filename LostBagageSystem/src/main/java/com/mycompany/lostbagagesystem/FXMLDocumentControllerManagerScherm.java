package com.mycompany.lostbagagesystem;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author is
 */
public class FXMLDocumentControllerManagerScherm {

    @FXML
    private AnchorPane Medewerkerscherm;

    @FXML
    private TextField zoekMedewerker;

    @FXML
    private Button Gevonden3Dagen;

    @FXML
    private Button Gevonden21Dagen;

    @FXML
    private Button verloren3Dagen;

    @FXML
    private Button Verloren21Dagen;

    @FXML
    private Button Vergelijk3Dagen;

    @FXML
    private Button Vergelijk21Dagen;

    @FXML
    private AnchorPane TableLeeg;

    @FXML
    private TableView<?> tableGevonden3;

    @FXML
    private void gevonden3Dagen(ActionEvent event) throws IOException {
        TableView pane = FXMLLoader.load(getClass().getResource("/fxml/ManagerschermGevonden3Dagen.fxml"));

        TableLeeg.getChildren().setAll();

        TableLeeg.getChildren().setAll(pane);

        pane.prefWidthProperty().bind(TableLeeg.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg.heightProperty());

    }

}
