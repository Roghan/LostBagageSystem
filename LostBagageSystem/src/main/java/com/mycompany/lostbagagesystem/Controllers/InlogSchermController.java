/*Controller Class voor het inlog Scherm
*Deze class word later samengevoegd met de InlogControllers
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.Language;
import com.mycompany.lostbagagesystem.models.PopupNietIngevuldeVelden;
import com.mycompany.lostbagagesystem.models.ToggleGroupResult;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class InlogSchermController implements Initializable {

    /**
     * Initializes the controller class.
     *
     * @throws java.sql.SQLException
     */
    @FXML
    private TextField username;

    @FXML
    private TextField wachtwoord;

    @FXML
    private AnchorPane TableLeeg;

    @FXML
    private ToggleButton langNL;

    @FXML
    private ToggleButton langGB;

    @FXML
    private RadioMenuItem langTR;

    @FXML
    private RadioMenuItem langES;

    @FXML
    private ToggleGroup langSetting;

    private Locale GB = new Locale("en", "GB");
    private Locale NL = new Locale("nl", "NL");
    private Locale TR = new Locale("tr", "TR");
    private Locale ES = new Locale("es", "ES");
    private Locale locale;

    @FXML
    public void handleButtonAction() throws SQLException, IOException {
        ConnectDB db = new ConnectDB("fystestdb");
        ResultSet resultSet;
        int rol;
        String user = username.getText();
        String pass = wachtwoord.getText();

        resultSet = db.executeResultSetQuery("SELECT `acountnaam`, `wachtwoord`, `rol` "
                + "FROM gebruiker WHERE acountnaam = " + "'" + user + "'"
                + " AND wachtwoord = " + "'" + pass + "'");

        System.out.println(resultSet);

        setLang();

        if (resultSet.next()) {

            System.out.println("Je bent COOL!!");
            rol = resultSet.getInt("rol");
            System.out.println(rol);
            adminPad(rol);
        } else {
            username.setStyle("-fx-border-color : #ff0000;");
            wachtwoord.setStyle("-fx-border-color : #ff0000;");
            PopupNietIngevuldeVelden.warningBoxPass();
            System.out.println("Je hoort hier niet!!!");
        }

    }

    public Locale setLang() {

        if (langNL.isSelected()) {
            Language.setCurrentLocale(NL);
            return NL;

        } else if (langGB.isSelected()) {
            Language.setCurrentLocale(GB);
            return GB;

        } else if (langTR.isSelected()) {
            Language.setCurrentLocale(TR);
            return TR;

        } else if (langES.isSelected()) {
            Language.setCurrentLocale(ES);
            return ES;

        }
        return null;
    }

    public void changeLang() throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/InlogScherm.fxml"), ResourceBundle.getBundle("Bundles.Lang", setLang())); //laad de nieuwe table in de bestaande anchorpane
        //maakt de oude table leeg
        TableLeeg.getChildren().setAll();
        //laad de nieuwe table in
        TableLeeg.getChildren().setAll(pane);

        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(TableLeeg.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg.heightProperty());
        
        if (setLang().equals(GB)) {
            langGB.setSelected(true);
            
        }

    }

    @FXML
    public void adminPad(int rol) throws IOException {
        if (rol == 1) {
            //laad de nieuwe table in de bestaande anchorpane
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Administratorscherm.fxml"), ResourceBundle.getBundle("Bundles.Lang", Language.getCurrentLocale())); //laad de nieuwe table in de bestaande anchorpane
            //maakt de oude table leeg
            TableLeeg.getChildren().setAll();
            //laad de nieuwe table in
            TableLeeg.getChildren().setAll(pane);

            //geeft de nieuwe table de juiste groote
            pane.prefWidthProperty().bind(TableLeeg.widthProperty());
            pane.prefHeightProperty().bind(TableLeeg.heightProperty());

        } else if (rol == 2) {
            //laad de nieuwe table in de bestaande anchorpane
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/ManagerScherm.fxml"), ResourceBundle.getBundle("Bundles.Lang", Language.getCurrentLocale())); //laad de nieuwe table in de bestaande anchorpane
            //maakt de oude table leeg
            TableLeeg.getChildren().setAll();
            //laad de nieuwe table in
            TableLeeg.getChildren().setAll(pane);
            //geeft de nieuwe table de juiste groote
            pane.prefWidthProperty().bind(TableLeeg.widthProperty());
            pane.prefHeightProperty().bind(TableLeeg.heightProperty());
        } else if (rol == 3) {
            //laad de nieuwe table in de bestaande anchorpane
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Medewerkersscherm.fxml"), ResourceBundle.getBundle("Bundles.Lang", Language.getCurrentLocale())); //laad de nieuwe table in de bestaande anchorpane
            //maakt de oude table leeg
            TableLeeg.getChildren().setAll();
            //laad de nieuwe table in
            TableLeeg.getChildren().setAll(pane);
            //geeft de nieuwe table de juiste groote
            pane.prefWidthProperty().bind(TableLeeg.widthProperty());
            pane.prefHeightProperty().bind(TableLeeg.heightProperty());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
