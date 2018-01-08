/*Controller Class voor het Nieuwe MedewerkerScherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.Language;
import java.io.IOException;
import java.security.MessageDigest;
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
    private TextField voornaam;
    @FXML
    private TextField achternaam;
    @FXML
    private TextField geboortedatum;
    @FXML
    private TextField postcode;
    @FXML
    private TextField huisnummer;
    @FXML
    private TextField telefoonnummer;
    @FXML
    private TextField manVrouw;
    @FXML
    private TextField rol;
    @FXML
    private AnchorPane TableLeeg;

    public void terug() throws IOException {
        //laad de nieuwe table in de bestaande anchorpane
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/AdminMedewerkerView.fxml"), ResourceBundle.getBundle("Bundles.Lang", Language.getCurrentLocale())); //laad de nieuwe table in de bestaande anchorpane
        //maakt de oude table leeg
        TableLeeg.getChildren().setAll();
        //laad de nieuwe table in
        TableLeeg.getChildren().setAll(pane);
        //geeft de nieuwe table de juiste groote
        pane.prefWidthProperty().bind(TableLeeg.widthProperty());
        pane.prefHeightProperty().bind(TableLeeg.heightProperty());
    }

    @FXML
    public void annuleeredit(ActionEvent event) throws IOException {
        terug();
    }

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
    public void sendtodatabase() throws IOException {

        ConnectDB db = new ConnectDB("fystestdb");

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

        String wachtwoord1 = sha256(wachtw);
        
        String query = String.format("INSERT INTO `gebruiker` "
                + "(`acountnaam`, `wachtwoord`, `voornaam`, `achternaam`, "
                + "`geboortedatum`, `postcode`, `huisnummer`, `telefoonnummer`, "
                + "`man/vrouw`, `rol`)"
                + " VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                acountN, wachtwoord1, voorN, achterN, geboorteD, postC, huisN, telefoonN, manV, roll);

        int numberAffected = db.executeUpdateQuery(query);
        System.out.println(numberAffected);

        terug();

    }

}
