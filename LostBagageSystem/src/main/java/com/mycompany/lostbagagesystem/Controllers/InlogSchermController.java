package com.mycompany.lostbagagesystem.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.text.html.HTML;

/**
 * FXML Controller class
 *
 * @author Marcel
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
    public void handleButtonAction() throws SQLException{
        ConnectDB db = new ConnectDB("fystestdb");
        ResultSet resultSet;
        String user = username.getText();
        String pass = wachtwoord.getText();
        
        resultSet = db.executeResultSetQuery("SELECT `acountnaam`, `wachtwoord` "
                + "FROM gebruiker WHERE acountnaam = " + "'" + user + "'" + 
                        " AND wachtwoord = " + "'" + pass + "'");
        
        System.out.println(resultSet);

        if (resultSet.next()) {
            System.out.println("Je bent COOL!!");
        }else{
            System.out.println("Je hoort hier niet!!!");
        }
        
    }
    
    @FXML
    public void testdb() throws SQLException {

        ConnectDB db = new ConnectDB("fystestdb");

        
        String acountnaam;
        String wachtwoord;
        int rol;
        //show results
        ResultSet resultSet;

        resultSet = db.executeResultSetQuery("SELECT `acountnaam`, `wachtwoord`, `rol` FROM `gebruiker`");

        while (resultSet.next()) {
            
            acountnaam = resultSet.getString("acountnaam");
            wachtwoord = resultSet.getString("wachtwoord");
            rol = resultSet.getInt("rol");
            System.out.printf("%d = %s %s%n", rol, acountnaam, wachtwoord);
        }

        db.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
