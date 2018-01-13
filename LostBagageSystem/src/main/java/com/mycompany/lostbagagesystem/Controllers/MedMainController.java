/*Controller Class voor het MedewerkerScherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.MainApp;
import com.mycompany.lostbagagesystem.classes.language;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Donovan Schaafsma
 */
public class MedMainController implements Initializable {

    @FXML
    private AnchorPane formulierLeeg;
    @FXML
    private AnchorPane MedewerkerPane;

    @FXML
    public void schadeFormulier(ActionEvent event) throws IOException {

        MainApp.loadFXMLFile(formulierLeeg, "/fxml/Schadeformulier.fxml");

    }

    @FXML
    public void gevondenBagageFormulier(ActionEvent event) throws IOException {

        MainApp.loadFXMLFile(formulierLeeg, "/fxml/GevondenBagageFormulier.fxml");

    }

    @FXML
    public void verlorenBagageFormulier(ActionEvent event) throws IOException {

        MainApp.loadFXMLFile(formulierLeeg, "/fxml/VermisteBagageFormulier.fxml");

    }

    @FXML
    public void logUit(ActionEvent event) throws IOException {

        MainApp.loadFXMLFile(formulierLeeg, "/fxml/InlogScherm.fxml");

    }

    @FXML
    public void zoekFormulier(ActionEvent event) throws IOException {

        MainApp.loadFXMLFile(formulierLeeg, "/fxml/FormulierZoeken.fxml");

    }

    @FXML
    public void importExcel(ActionEvent event) throws IOException {

        MainApp.loadFXMLFile(formulierLeeg, "/fxml/ExcelImportExport.fxml");

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
