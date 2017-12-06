package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.MainApp;
import com.mycompany.lostbagagesystem.classes.FoundLuggage;
import com.mycompany.lostbagagesystem.classes.PDFExport;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;


/**
 *
 * @author is Marcel van Wilgenburg
 */
public class ManMainController implements Initializable {

    @FXML
    private AnchorPane Medewerkerscherm;

    @FXML
    private TextField zoekMedewerker;

    @FXML
    private Button Medewerkers;
    
    @FXML
    private Button Gevonden3Dagen;

    @FXML
    private Button Gevonden21Dagen;

    @FXML
    private Button Verloren3Dagen;

    @FXML
    private Button Verloren21Dagen;

    @FXML
    private Button Vergelijk3Dagen;

    @FXML
    private Button Vergelijk21Dagen;

    @FXML
    private AnchorPane TableLeeg;
    
    @FXML
    private TableView tableGevonden3;

    private ObservableList<FoundLuggage> userList;

    private int userIdCounter;

    @FXML
    private Label statusMessage;

    @FXML
    private TableView table;
    
    @FXML
    private Button Loguit;
    
    @FXML
    private AnchorPane ManagerPane;

    @FXML
        public void logUit(ActionEvent event) throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/InlogScherm.fxml")); //laad de nieuwe table in de bestaande anchorpane
        //maakt de oude table leeg
        ManagerPane.getChildren().setAll();
        //laad de nieuwe table in
        ManagerPane.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(ManagerPane.widthProperty());
        pane.prefHeightProperty().bind(ManagerPane.heightProperty());
        }
    
    @FXML
    public void medewerkers (ActionEvent event) throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/ManagerMedewerkerview.fxml")); //laad de nieuwe table in de bestaande anchorpane
        //maakt de oude table leeg
        TableLeeg.getChildren().setAll();
        //laad de nieuwe table in
        TableLeeg.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(TableLeeg.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg.heightProperty());
    }
    
    
    public void gevonden3Dagen(ActionEvent event) throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        SplitPane pane = FXMLLoader.load(getClass().getResource("/fxml/ManagerschermGevonden3Dagen.fxml")); //laad de nieuwe table in de bestaande anchorpane
        //maakt de oude table leeg
        TableLeeg.getChildren().setAll();
        //laad de nieuwe table in
        TableLeeg.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(TableLeeg.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg.heightProperty());
        
        

    }
    
    @FXML
    public void gevonden21Dagen(ActionEvent event) throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        SplitPane pane = FXMLLoader.load(getClass().getResource("/fxml/ManagerschermGevonden21Dagen.fxml")); //laad de nieuwe table in de bestaande anchorpane
        //maakt de oude table leeg
        TableLeeg.getChildren().setAll();
        //laad de nieuwe table in
        TableLeeg.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(TableLeeg.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg.heightProperty());
        
        
        

    }
    
    @FXML
    public void verloren3Dagen(ActionEvent event) throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        SplitPane pane = FXMLLoader.load(getClass().getResource("/fxml/ManagerschermVerloren3Dagen.fxml")); //laad de nieuwe table in de bestaande anchorpane
        //maakt de oude table leeg
        TableLeeg.getChildren().setAll();
        //laad de nieuwe table in
        TableLeeg.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(TableLeeg.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg.heightProperty());
        

    }
    
    @FXML
    public void verloren21Dagen(ActionEvent event) throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        SplitPane pane = FXMLLoader.load(getClass().getResource("/fxml/ManagerschermVerloren21Dagen.fxml")); //laad de nieuwe table in de bestaande anchorpane
        //maakt de oude table leeg
        TableLeeg.getChildren().setAll();
        //laad de nieuwe table in
        TableLeeg.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(TableLeeg.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg.heightProperty());
        

    }
    
    @FXML
    public void vergelijk3Dagen(ActionEvent event) throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/ManagerschermVergelijk3Dagen.fxml")); //laad de nieuwe table in de bestaande anchorpane
        //maakt de oude table leeg
        TableLeeg.getChildren().setAll();
        //laad de nieuwe table in
        TableLeeg.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(TableLeeg.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg.heightProperty());
        

    }
    
    @FXML
    public void vergelijk21Dagen(ActionEvent event) throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/ManagerschermVergelijk21Dagen.fxml")); //laad de nieuwe table in de bestaande anchorpane
        //maakt de oude table leeg
        TableLeeg.getChildren().setAll();
        //laad de nieuwe table in
        TableLeeg.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(TableLeeg.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg.heightProperty());
        

    }

    @FXML
    public void exportPDF(ActionEvent event) throws IOException {
        //Test output for console
        System.out.println("Button Press Print PDF");
        //Call the PDFExport class
        PDFExport doc = new PDFExport();
        //Add a new page to the pdf file
        doc.addPage();
        //Prompts the FileChooser
        doc.savePDF();

        statusMessage.setText(doc.getSavedLabelText());

    }

//    @FXML
//    public void listView(ActionEvent event) throws IOException {
//        //Test output to concole
//        System.out.println("Button Press Import Excel File");
//        
//        File file = MainApp.selectFileToOpen();
//        
//        if (file != null) {
//            String fileName = file.getAbsolutePath();
//            
//            List<FoundLuggage> foundLuggage = FoundLuggage.importFoundLuggageFromExcel(fileName);
//            
//            statusMessage.setText("Aantal Koffers") ;
//            
//        } else {
//            statusMessage.setText("Import Cancelled");
//        }
//        
//}
    public void getProduct() {
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


   

}
