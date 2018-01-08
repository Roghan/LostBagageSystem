/*Controller Class voor het MedewerkerScherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.Language;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.baseName;
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
    private TextField txtVoorletters;
    @FXML
    private TextField txtTussenvoegsel;
    @FXML
    private CheckBox checkM;
    @FXML
    private CheckBox checkV;
    @FXML
    private TextField txtAchternaam;
    @FXML
    private TextField txtStraatnaam;
    @FXML
    private TextField txtHuisNummer;
    @FXML
    private TextField txtPostcode;
    @FXML
    private TextField txtWoonplaats;
    @FXML
    private TextField txtGeboorteDatum;
    @FXML
    private TextField txtLandnaam;
    @FXML
    private TextField txtBankrekening;
    @FXML
    private TextField txtTelefoon;
    @FXML
    private TextField txtMobielNummer;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button schadeformbtn;
    @FXML
    private AnchorPane TableLeeg;
    @FXML
    private AnchorPane formulierLeeg;
    @FXML
    private Button Loguit;
    @FXML
    private AnchorPane MedewerkerPane;

    @FXML
    public void schadeFormulier(ActionEvent event) throws IOException {
        Locale locale = new Locale("en", "GB");

        ScrollPane pane = FXMLLoader.load(getClass().getResource("/fxml/Schadeformulier.fxml"), ResourceBundle.getBundle("Bundles.Lang", Language.getCurrentLocale()));

        formulierLeeg.getChildren().setAll();
        formulierLeeg.getChildren().setAll(pane);
        pane.prefWidthProperty().bind(formulierLeeg.widthProperty());
        pane.prefHeightProperty().bind(formulierLeeg.heightProperty());

    }

    @FXML
    public void gevondenBagageFormulier(ActionEvent event) throws IOException {
        ScrollPane pane = FXMLLoader.load(getClass().getResource("/fxml/GevondenBagageFormulier.fxml"), ResourceBundle.getBundle("Bundles.Lang", Language.getCurrentLocale()));
        formulierLeeg.getChildren().setAll();
        formulierLeeg.getChildren().setAll(pane);
        pane.prefWidthProperty().bind(formulierLeeg.widthProperty());
        pane.prefHeightProperty().bind(formulierLeeg.heightProperty());
    }

    @FXML
    public void verlorenBagageFormulier(ActionEvent event) throws IOException {
        ScrollPane pane = FXMLLoader.load(getClass().getResource("/fxml/VermisteBagageFormulier.fxml"), ResourceBundle.getBundle("Bundles.Lang", Language.getCurrentLocale()));

        formulierLeeg.getChildren().setAll();
        formulierLeeg.getChildren().setAll(pane);
        pane.prefWidthProperty().bind(formulierLeeg.widthProperty());
        pane.prefHeightProperty().bind(formulierLeeg.heightProperty());
    }

    @FXML
    public void logUit(ActionEvent event) throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/InlogScherm.fxml"), ResourceBundle.getBundle("Bundles.Lang", Language.getCurrentLocale())); //laad de nieuwe table in de bestaande anchorpane
        //maakt de oude table leeg
        MedewerkerPane.getChildren().setAll();
        //laad de nieuwe table in
        MedewerkerPane.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(MedewerkerPane.widthProperty());
        pane.prefHeightProperty().bind(MedewerkerPane.heightProperty());
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
