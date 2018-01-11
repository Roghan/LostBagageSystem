/*Controller Class voor het Nieuwe MedewerkerScherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.language;
import java.io.IOException;
<<<<<<< HEAD
=======
import java.security.MessageDigest;
import java.sql.ResultSet;
>>>>>>> master
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
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
    private TextField manVrouw;
    @FXML
    private TextField rol;
    @FXML
    private AnchorPane AdminPane;

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

        ConnectDB db = new ConnectDB("lbs_database");

        String acountN = acountnaam.getText();
<<<<<<< HEAD
        String wachtw = wachtwoord.getText();   
=======
        String wachtw = wachtwoord.getText();
>>>>>>> master
        String roll = rol.getText();
        
        String wachtwoord1 = sha256(wachtw);
        
        String query = String.format("INSERT INTO `gebruiker` "
                + "(`acountnaam`, `wachtwoord`, `rol`)"
<<<<<<< HEAD
                + " VALUES('%s', '%s', '%s')",
                acountN, wachtw, roll);
=======
                + " VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                acountN, wachtwoord1, roll);
>>>>>>> master

        int numberAffected = db.executeUpdateQuery(query);
        System.out.println(numberAffected);

        terug();

    }

}
