package com.mycompany.lostbagagesystem.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
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
    private TextField txtVoornaam;
    
    @FXML
    private TextField txtTussenvoegsel;
            
    @FXML
    private TextField txtAchternaam;
    
    @FXML
    private TextField txtGeboortedatum;
    
    @FXML
    private TextField txtPostcode;
    
    @FXML
    private TextField txtHuisnummer;
    
    @FXML
    private TextField txtTelefoonnummer;
    
    @FXML
    private TextField txtManVrouw;
    
    @FXML
    private TextField txtRol;
    
    @FXML
    private Button btnAnnuleren;
    
    @FXML
    private Button btnVerzenden;
    
    @FXML
    private ScrollPane editPane;
    
    private String account;
    private String wachtwoord;
    private String voornaam;
    private String tussenvoegsel;
    private String achternaam;
    private String geboortedatum;
    private String postcode;
    private String huisnummer;
    private String telefoonnummer;
    private String manVrouw;
    private String rol;
   
    
    @FXML
    public void medewerkerWijzigen() throws SQLException{
//        PreparedStatement myStmt = null;
//        Connection conn = null;
        ConnectDB db = new ConnectDB();
        ResultSet rs = null;

        // This is a test query 
        String query = "SELECT `voornaam`, `achternaam`"
                + "FROM `gebruiker` WHERE `id` = 1";
        
        
        rs = db.executeResultSetQuery(query);
        try {
            if (true) {
                 txtVoornaam.setPromptText("text");
                //txtVoornaam.setText(voornaam);
                achternaam = rs.getString("achternaam");
                System.out.println(rs.getString("achternaam"));
                txtAchternaam.setText(achternaam);
            }
        } catch (Exception e) {
        }
        
//        try {
//            conn = db.getDBConnection();
//            myStmt = conn.prepareStatement(query);
//            myStmt.setInt(1, 1);
//            // Execute INSERT sql statement
//            rs = myStmt.executeQuery();
//            System.out.println(myStmt.executeQuery());
//            //System.out.println(rs);
//            if (rs.next()) {
//                System.out.println("yee");
//                txtVoornaam.setText(rs.getString("voornaam"));
//                System.out.println("huh");
//                achternaam = rs.getString("achternaam");
//                txtAchternaam.setText(achternaam);
//                System.out.println("hode");
//            }
//            
//            
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            // Closing the prepared statement for memory purposes
//            if (myStmt != null) {
//                myStmt.close();
//            }
//            // Closing the database connection for memory purposes
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        System.out.println("gelukt");
//        return rs;
        
    }
    
//    public ResultSet query() throws SQLException{
//    
//    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
