package com.mycompany.lostbagagesystem;

import com.mycompany.lostbagagesystem.classes.PDFExport;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author is Marcel van Wilgenburg
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
    private Label statusMessage;

    @FXML
    public void gevonden3Dagen(ActionEvent event) throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        TableView pane = FXMLLoader.load(getClass().getResource("/fxml/ManagerschermGevonden3Dagen.fxml"));
        //maakt de oude table leeg
        TableLeeg.getChildren().setAll();
        //laad de nieuwe table in
        TableLeeg.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(TableLeeg.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg.heightProperty());

    }

    public void exportPDF(ActionEvent event) throws IOException {
        System.out.println("Button Press Print PDF");
        PDFExport doc = new PDFExport();
        doc.addPage();
        doc.savePDF();

        statusMessage.setText(doc.getSavedLabelText());

    }

}
