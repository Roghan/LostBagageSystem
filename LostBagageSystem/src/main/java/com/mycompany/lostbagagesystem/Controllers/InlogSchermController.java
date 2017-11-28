package com.mycompany.lostbagagesystem.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.lostbagagesystem.classes.MyJDBC;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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
//    @FXML
//    private Button testdbbutton;
//    
//    @FXML
//    public void testdb() throws SQLException {
//        //test and demo the JDBC functionality
//        DBConnect.createTestDatabase("fystestdb");
//        DBConnect db = new DBConnect("fystestdb");
//
//        int id;
//        String voornaam;
//        String achternaam;
//        //show results
//        ResultSet resultSet;
//
//        resultSet = db.executeResultSetQuery("SELECT `id`, `voornaam`, `achternaam`");
//
//        while (resultSet.next()) {
//            id = resultSet.getInt("id");
//            voornaam = resultSet.getString("voornaam");
//            achternaam = resultSet.getString("achternaam");
//
//            System.out.printf("%d = %s %s%n", id, voornaam, achternaam);
//
//        }
//    }
    @FXML
    public void testdb() throws SQLException {

        // test and demo the JDBC functionality
//        MyJDBC.createTestDatabase("AirlineDemo");
        MyJDBC db = new MyJDBC("AirlineDemo");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a code, name and timezone: ");
        String code = scanner.nextLine(); // hier stond scanner.next();
        // je moet hier ff checken of de data in de db past, ik deed net length 4 en dan krijg ik dus error want field length in db is maar 3aha jaa
        /*
        maar ff waarom doet die het hier wel goed let op
        */

        String name = scanner.nextLine();

        int timeZone = Integer.parseInt(scanner.nextLine());
        // als je iets anders dan een int hier ingooit krijg je een error, dus moet je ff kijken hoe je die error gaat handelen

        //Insert into
        String query = String.format("INSERT INTO airport(`IATACode`, `Name`, `TimeZone`)"
                + " VALUES('%s', '%s', %d)", code, name, timeZone);

        int numberAffected = db.executeUpdateQuery(query);

        ResultSet resultSet = null;
        try {
            resultSet = db.executeResultSetQuery("SELECT `Name`, `TimeZone` FROM Airport");
        } catch (Exception e) {
            System.out.println("SQLException: bv geen entries in db gevonden/connectie is niet geopend oid");
            System.out.println(e);
        }
        
        
        if (resultSet == null) {
            db.close();
            return;
        }
        
        while (resultSet.next()) {
            name = resultSet.getString("Name");
            timeZone = resultSet.getInt("TimeZone");

            System.out.printf("%s = %d%n", name, timeZone);
        }
        db.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

}
