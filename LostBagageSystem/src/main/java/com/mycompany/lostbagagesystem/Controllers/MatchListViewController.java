 package com.mycompany.lostbagagesystem.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.PDFExport;
import com.mycompany.lostbagagesystem.classes.language;
import com.mycompany.lostbagagesystem.models.ColourPicker;
import com.mycompany.lostbagagesystem.models.MedewerkerBagageTable;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class MatchListViewController implements Initializable {

    @FXML
    private TextField txtBagageLabelMatch;

    @FXML
    private ListView listView;
    @FXML
    private Button btnMatch;
    @FXML
    private TextField txtVoorletters;
    @FXML
    private TextField txtAchternaam;
    @FXML
    private TextField txtTussenvoegsel;
    @FXML
    private DatePicker txtDatum;
    @FXML
    private TextField txtTijd;
    @FXML
    private TextField txtStraatnaam;
    @FXML
    private TextField txtHuisnummer;
    @FXML
    private TextField txtPostcode;
    @FXML
    private TextField txtWoonplaats;
    @FXML
    private TextField txtVakantieStraatnaam;
    @FXML
    private TextField txtVakantieHuisnummer;
    @FXML
    private TextField txtVakantiePostcode;
    @FXML
    private TextField txtVakantiePlaats;
    @FXML
    private TextField txtHotelNaam;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTelefoon;
    @FXML
    private TextField txtMobielnummer;
    @FXML
    private TextField txtVluchtnummer;
    @FXML
    private TextField txtTypeBagage;
    @FXML
    private TextField txtMerk;
    @FXML
    private TextArea txtBijzondereOpmerking;
    @FXML
    private MenuButton btnVliegveldID;
    @FXML
    private MenuButton btnVanVliegveldID;
    @FXML
    private MenuButton btnNaarVliegveldID;
    @FXML
    private MenuButton kleur1Menu;
    @FXML
    private MenuButton kleur2Menu;
    @FXML
    private ToggleGroup kleur1;
    @FXML
    private ToggleGroup kleur2;
    @FXML
    private ToggleGroup iata;
    @FXML
    private ToggleGroup iataVan;
    @FXML
    private ToggleGroup iataNaar;
    

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
    private String iataString;
    private String van;
    private String naar;
    private String ralcode1;
    private String ralcode2;

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
    
    public void exporterenPDF(ActionEvent event) throws IOException {
        PDFExport export = new PDFExport();
        String staat = "Returned";
        String datum = txtDatum.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String tijd = txtTijd.getText(); 
        String voorletters = txtVoorletters.getText();
        String tussenvoegsel = txtTussenvoegsel.getText();
        String achternaam = txtAchternaam.getText();
        String adres = txtStraatnaam.getText();
        String huisnummer = txtWoonplaats.getText();
        String postcode = txtPostcode.getText();
        String woonplaats = txtWoonplaats.getText();
        String vStraatnaam = txtVakantieStraatnaam.getText();
        String vHuisnummer = txtVakantieHuisnummer.getText();
        String vPostcode = txtVakantiePostcode.getText();
        String vPlaats = txtVakantiePlaats.getText();
        String hotelnaam = txtHotelNaam.getText();
        String email = txtEmail.getText();
        String telefoon = txtTelefoon.getText();
        String mobiel = txtMobielnummer.getText();
        String vluchtnummer = txtVluchtnummer.getText(); 
        String labelnummer = txtBagageLabelMatch.getText();
        String typeBagage = txtTypeBagage.getText();
        String merk = txtMerk.getText();
        String bijzondereKenmerken = txtBijzondereOpmerking.getText();
        export.addPage(staat, datum, tijd, voorletters, tussenvoegsel, 
                achternaam, adres, huisnummer, postcode, woonplaats, 
                vStraatnaam, vHuisnummer, vPostcode, vPlaats, hotelnaam, 
                email, telefoon, mobiel, vluchtnummer, van, naar, 
                labelnummer, typeBagage, merk, 
                ralcode1, ralcode2, bijzondereKenmerken);
        export.savePDF();
    }
    
    @FXML
    public void IATACHECK(ActionEvent event) {
        RadioMenuItem iattaItem = (RadioMenuItem) iata.getSelectedToggle();
        iataString = iattaItem.getText();
        btnVliegveldID.setText(iataString);
        System.out.println(iataString);

    }

    @FXML
    public void vanDropDown(ActionEvent event) {
        RadioMenuItem iattaItem = (RadioMenuItem) iataVan.getSelectedToggle();
        van = iattaItem.getText();
        btnVanVliegveldID.setText(van);
        System.out.println(van);

    }

    @FXML
    public void naarDropDown(ActionEvent event) {
        RadioMenuItem iattaItem = (RadioMenuItem) iataNaar.getSelectedToggle();
        naar = iattaItem.getText();
        btnNaarVliegveldID.setText(naar);
        System.out.println(naar);

    }

    @FXML
    public void kleurkiezer1(ActionEvent event) {
        RadioMenuItem item = (RadioMenuItem) kleur1.getSelectedToggle();
        String kleur = item.getText();
        kleur1Menu.setText(kleur);
        System.out.println(kleur);
        ralcode1 = ColourPicker.GetColour(kleur);

    }

    @FXML
    public void kleurkiezer2(ActionEvent event) {
        RadioMenuItem item = (RadioMenuItem) kleur2.getSelectedToggle();
        String kleur = item.getText();
        kleur2Menu.setText(kleur);
        System.out.println(kleur);
        ralcode2 = ColourPicker.GetColour(kleur);
    }

}
