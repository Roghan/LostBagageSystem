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
    private Button btnAnnuleren;

    @FXML
    private Button btnVerzenden;

    @FXML
    private ScrollPane editPane;

    private String account;
    private String wachtwoord;
    private String rol;

    @FXML
    private AnchorPane AdminPane;

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
    public void sendEdit() {

    }

    @FXML
    public void medewerkerWijzigen() throws SQLException {
//        PreparedStatement myStmt = null;
//        Connection conn = null;
//        ConnectDB db = new ConnectDB();
//        ResultSet rs = null;
//
//        // This is a test query 
//        String query = "SELECT `accountnaam`, `wachtwoord`, `rol`"
//                + "FROM `gebruiker` WHERE `id` = 1";
//        
//        
//        rs = db.executeResultSetQuery(query);
//        try {
//            if (true) {
//                txtAccountnaam.setPromptText("text");
//                //txtVoornaam.setText(voornaam);
//                txtWachtwoord = rs.getString("wachtwoord");
//                System.out.println(rs.getString("achternaam"));
//                txtAchternaam.setText(achternaam);
//            }
//        } catch (Exception e) {
//        }

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
