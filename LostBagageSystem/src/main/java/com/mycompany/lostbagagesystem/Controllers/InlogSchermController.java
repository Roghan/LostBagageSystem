/*Controller Class voor het inlog Scherm
*Deze class word later samengevoegd met de InlogControllers
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.language;
import com.mycompany.lostbagagesystem.models.PopupNietIngevuldeVelden;
import com.mycompany.lostbagagesystem.models.ToggleGroupResult;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
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
    public static String sha256(String base) {
    try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(base.getBytes("UTF-8"));
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    } catch(Exception ex){
       throw new RuntimeException(ex);
    }
}
    
    @FXML
    public void handleButtonAction() throws SQLException, IOException {
        ConnectDB db = new ConnectDB("lbs_database");
        ResultSet resultSet;
        int rol;
        String user = username.getText();
        String pass = wachtwoord.getText();
        
        String shawachtwoord = sha256(pass);
        int requiredBlok = 0;
        resultSet = db.executeResultSetQuery("SELECT `acountnaam`, `wachtwoord`, `rol` "
                + "FROM gebruiker WHERE acountnaam = " + "'" + user + "'"
                + " AND wachtwoord = " + "'" + shawachtwoord + "'" + "AND blok = " + "'" + requiredBlok + "'");

        System.out.println(resultSet);

        setLang();

        if (resultSet.next()) {

            System.out.println("Je bent COOL!!");
            rol = resultSet.getInt("rol");
            System.out.println(rol);
            adminPad(rol);
        } else {
            PopupNietIngevuldeVelden.warningBoxPass();
            System.out.println("Je hoort hier niet!!!");
        }

    }

    public Locale setLang() {

        if (langNL.isSelected()) {
            language.setCurrentLocale(NL);
            return NL;

        } else if (langGB.isSelected()) {
            language.setCurrentLocale(GB);
            return GB;

        } else if (langTR.isSelected()) {
            language.setCurrentLocale(TR);
            return TR;

        } else if (langES.isSelected()) {
            language.setCurrentLocale(ES);
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
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Administratorscherm.fxml"), ResourceBundle.getBundle("Bundles.Lang", language.getCurrentLocale())); //laad de nieuwe table in de bestaande anchorpane
            //maakt de oude table leeg
            TableLeeg.getChildren().setAll();
            //laad de nieuwe table in
            TableLeeg.getChildren().setAll(pane);

            //geeft de nieuwe table de juiste groote
            pane.prefWidthProperty().bind(TableLeeg.widthProperty());
            pane.prefHeightProperty().bind(TableLeeg.heightProperty());

        } else if (rol == 2) {
            //laad de nieuwe table in de bestaande anchorpane
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/ManagerScherm.fxml"), ResourceBundle.getBundle("Bundles.Lang", language.getCurrentLocale())); //laad de nieuwe table in de bestaande anchorpane
            //maakt de oude table leeg
            TableLeeg.getChildren().setAll();
            //laad de nieuwe table in
            TableLeeg.getChildren().setAll(pane);
            //geeft de nieuwe table de juiste groote
            pane.prefWidthProperty().bind(TableLeeg.widthProperty());
            pane.prefHeightProperty().bind(TableLeeg.heightProperty());
        } else if (rol == 3) {
            //laad de nieuwe table in de bestaande anchorpane
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Medewerkersscherm.fxml"), ResourceBundle.getBundle("Bundles.Lang", language.getCurrentLocale())); //laad de nieuwe table in de bestaande anchorpane
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

//wachtwoorden:
//1    YouriPel     a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3
//2    Marcel     03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4
//3    Donovan 5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5