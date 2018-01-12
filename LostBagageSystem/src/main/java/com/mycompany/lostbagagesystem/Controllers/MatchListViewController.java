package com.mycompany.lostbagagesystem.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.language;
import com.mycompany.lostbagagesystem.models.MedewerkerBagageTable;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class MatchListViewController implements Initializable {

    @FXML
    TextField txtBagageLabelMatch;

    @FXML
    ListView listView;
    @FXML
    Button btnMatch;
    @FXML
    TextField txtVoorletters;
    @FXML
    TextField txtAchternaam;

    private ConnectDB db = new ConnectDB("lbs_database");

    private String labelNumberForMatch;

    private String filterText;
    private String BagageID;
    private String State;
    private String Labelnumber;
    private String Type;
    private String Brand;
    private String Color1;
    private String Color2;
    private String Characteristics;
    private String Location;
    private String Airport;
    private String From;
    private String To;
    private String Initial;
    private String Insertion;
    private String Surname;
    private String IsReturned;
    private ResultSet resultSet = null;
    private String txtBoxFilterString;
    private String selectedListviewItem;
    protected ObservableList<MedewerkerBagageTable> bagageTables = FXCollections.observableArrayList();
    private String initialForMatch;
    private String surnameForMatch;

    public void setTextBoxes() {

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelNumberForMatch = FormulierZoekenController.getLabel();
        txtBagageLabelMatch.setText(labelNumberForMatch);
        System.out.println("TEST Run on load window");
        System.out.println(labelNumberForMatch);

    }

    public void zoekMatch() throws SQLException {

        resultSetNoFilter();
        fillTable();

    }

    @FXML
    public void fillTable() throws SQLException {

        ObservableList<String> bagagetabel = FXCollections.observableArrayList();
        //Get all the results out of the database

        int bagageID = 0;
        while (resultSet.next()) {
            BagageID = resultSet.getString("BagageID");
            System.out.println(BagageID);
            State = resultSet.getString("State");
            System.out.println(State);
            Labelnumber = resultSet.getString("Labelnumber");
            Type = resultSet.getString("Type");
            Brand = resultSet.getString("Brand");
            Color1 = resultSet.getString("Color1");
            Color2 = resultSet.getString("Color2");
            Characteristics = resultSet.getString("Characteristics");
            Location = resultSet.getString("Location");
            Airport = resultSet.getString("Airport");
            From = resultSet.getString("From");
            To = resultSet.getString("To");
            Initial = resultSet.getString("Initial");
            Insertion = resultSet.getString("Insertion");
            Surname = resultSet.getString("Surname");
            IsReturned = resultSet.getString("IsReturned");

            bagageTables.add(new MedewerkerBagageTable(BagageID, State, Labelnumber, Type, Brand, Color1, Color2, Characteristics, Location, Airport, From, To, Initial, Insertion, Surname, IsReturned));

            String bagageString = bagageTables.get(bagageID).getLabelnumber();
            bagagetabel.add(bagageString);
            bagageID++;

            System.out.println(Labelnumber);
            System.out.println(bagagetabel);

        }
        listView.setItems(bagagetabel);
    }

    public void resultSetNoFilter() throws SQLException {
        String query = "SELECT `BagageID`,`State`,`Labelnumber`, `Type`,`Brand`,`Color1`,`Color2`,"
                + "`Characteristics`,`Location`,`Airport`,`From`,`To`,`Initial`,`Insertion`,`Surname`,`IsReturned` FROM `bagage` WHERE  IsReturned NOT LIKE '1' AND Labelnumber LIKE '" + labelNumberForMatch + "'";
        resultSet = db.executeResultSetQuery(query);

    }

    public void matchWith() {
        int selectedBagage = listView.getSelectionModel().getSelectedIndex();
        System.out.println(selectedBagage);
        initialForMatch = bagageTables.get(selectedBagage).getInitial();
        surnameForMatch = bagageTables.get(selectedBagage).getSurname();
        System.out.println(surnameForMatch);
        txtVoorletters.setText(initialForMatch);
        txtAchternaam.setText(surnameForMatch);

    }

}
