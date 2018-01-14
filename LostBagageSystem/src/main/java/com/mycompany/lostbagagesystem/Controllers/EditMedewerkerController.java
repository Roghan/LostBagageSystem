package com.mycompany.lostbagagesystem.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.language;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dono
 */
public class EditMedewerkerController implements Initializable {

    @FXML
    private TextField txtAccountnaam;

    @FXML
    private TextField txtWachtwoord;

    @FXML
    private TextField txtRol;

    @FXML
    private AnchorPane AdminPane;
    
    private static String acountnaam;
    private static String wachtwoord;
    private static int rol;
    private static int userId;

    @FXML
    public void annuleer() throws IOException {
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
    public void sendEdit(ActionEvent event) {
//        if(!changesMade){
//            return;
//        }
        String acountN = txtAccountnaam.getText();
        String wachtw = txtWachtwoord.getText();
        String roll = txtRol.getText();

        
        ConnectDB db = new ConnectDB("lbs_database");
            String query = String.format("UPDATE gebruiker SET acountnaam = '%s',"
                    + "wachtwoord = '%s', rol = '%s' WHERE id = '%s'", 
                    acountN, wachtw, roll, userId);
            db.executeUpdateQuery(query);
            System.out.println("query = " + query);
    }
    
    public void medewerkerWijzigen(int userId) throws SQLException {
        ConnectDB db = new ConnectDB("lbs_database");
        ResultSet resultSet; 
        String acountnaam;
        String wachtwoord;
        int rol;
        
//        String user = txtAccountnaam.getText();
//        String pass = txtWachtwoord.getText();
//        String rol = txtRol.getText();
        
               
        resultSet = db.executeResultSetQuery("SELECT `acountnaam`, `wachtwoord`, `rol` "
                + "FROM gebruiker WHERE id = " + "'" + userId + "'");
        
        resultSet.next();
        acountnaam = resultSet.getString("acountnaam");
        System.out.println("acountnaam = " + acountnaam);
        wachtwoord = resultSet.getString("wachtwoord");
        System.out.println("wachtwoord = " + wachtwoord);
        rol = resultSet.getInt("rol");
        System.out.println("rol = " + rol);

        this.userId = userId;
        this.acountnaam = acountnaam;
        this.wachtwoord = wachtwoord;
        this.rol = rol;
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String a = acountnaam;
        txtAccountnaam.setText(a);
        String b = wachtwoord;
        txtWachtwoord.setText(b);
        String c = Integer.toString(rol);
        txtRol.setText(c);
    }

}
