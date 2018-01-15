/*Controller Class voor het Nieuwe MedewerkerScherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.MainApp;
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.language;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Youri Pel
 */
public class NewMedewerker {

    @FXML
    private TextField acountnaam;
    @FXML
    private TextField wachtwoord;
    @FXML
    private TextField rol;
    @FXML
    private AnchorPane AdminPane;

    public void medewerkersView() throws IOException{
        terug();
    }
    
        @FXML
    public void logUit(ActionEvent event) throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/InlogScherm.fxml"), ResourceBundle.getBundle("Bundles.Lang", language.getCurrentLocale())); //laad de nieuwe table in de bestaande anchorpane
        //maakt de oude table leeg
        AdminPane.getChildren().setAll();
        //laad de nieuwe table in
        AdminPane.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(AdminPane.widthProperty());
        pane.prefHeightProperty().bind(AdminPane.heightProperty());
    }
    
    public void terug() throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Administratorscherm.fxml"), ResourceBundle.getBundle("Bundles.Lang", language.getCurrentLocale())); //laad de nieuwe table in de bestaande anchorpane
        //maakt de oude table leeg
        AdminPane.getChildren().setAll();
        //laad de nieuwe table in
        AdminPane.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(AdminPane.widthProperty());
        pane.prefHeightProperty().bind(AdminPane.heightProperty());
    }

    @FXML
    public void annuleeredit(ActionEvent event) throws IOException {
        terug();
    }

    @FXML
    public void sendtodatabase() throws IOException {

        ConnectDB db = new ConnectDB("lbs_database");

        String acountN = acountnaam.getText();
        String wachtw = wachtwoord.getText();
        String voorN = voornaam.getText();
        String achterN = achternaam.getText();
        String geboorteD = geboortedatum.getText();
        String postC = postcode.getText();
        String huisN = huisnummer.getText();
        String telefoonN = telefoonnummer.getText();
        String manV = manVrouw.getText();
        String roll = rol.getText();
<<<<<<< HEAD
        System.out.println("roll = " + roll);
        System.out.println("wachtw = " + wachtw);
        System.out.println("acountN = " + acountN);
        String wachtwoord1 = sha256(wachtw);
        
        String query = String.format("INSERT INTO `gebruiker` "
                + "(`acountnaam`, `wachtwoord`, `rol`)"
                + " VALUES('%s', '%s', '%s')",
                acountN, wachtwoord1, roll);
=======

        String query = String.format("INSERT INTO `gebruiker` "
                + "(`acountnaam`, `wachtwoord`, `voornaam`, `achternaam`, "
                + "`geboortedatum`, `postcode`, `huisnummer`, `telefoonnummer`, "
                + "`man/vrouw`, `rol`)"
                + " VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                acountN, wachtw, voorN, achterN, geboorteD, postC, huisN, telefoonN, manV, roll);
>>>>>>> parent of 5fd570c... Merge branch 'master' into statistiekenScherm

        int numberAffected = db.executeUpdateQuery(query);
        System.out.println(numberAffected);

        terug();

    }

}
