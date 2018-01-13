package com.mycompany.lostbagagesystem.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.PDFExport;
import com.mycompany.lostbagagesystem.classes.language;
import com.mycompany.lostbagagesystem.models.MedewerkerBagageTable;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class MatchListViewController extends FormulierZoekenController implements Initializable {

    @FXML
    private TextField txtBagageLabelMatch;

    @FXML
    private ListView<MedewerkerBagageTable> listView;
    @FXML
    private Button btnMatch;
    @FXML
    private TextField txtNS;
    @FXML
    private TextField txtAchternaam;

    @FXML
    private DatePicker txtDatum;

    @FXML
    private TextField txtTime;

    @FXML
    private TextField txtIATA;

    @FXML
    private TextField txtStraatnaam;

    @FXML
    private TextField txtHuisNummer;

    @FXML
    private TextField txtPostcode;

    @FXML
    private TextField txtWoonplaats;

    @FXML
    private TextField txtVakantieStraatnaam;

    @FXML
    private TextField txtVakantieHuisNummer;

    @FXML
    private TextField txtVakantiePostcode;

    @FXML
    private TextField txtVakantiePlaats;

    @FXML
    private TextField txthotelNaam;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTelefoon;

    @FXML
    private TextField txtMobielNummer;

    @FXML
    private TextField txtVluchtNummer;

    @FXML
    private TextField txtVan;

    @FXML
    private TextField txtNaar;

    @FXML
    private TextField txtTypeBagage;

    @FXML
    private TextField txtMerk;

    @FXML
    private Text Kleur1Text;

    @FXML
    private TextField txtKleur1;

    @FXML
    private TextField txtKleur2;

    @FXML
    private TextArea txtBijzondereOpmerking;

    @FXML
    private DatePicker txtDatum1;

    @FXML
    private TextField txtTime1;

    @FXML
    private TextField txtIATA1;

    @FXML
    private TextField txtNS1;

    @FXML
    private TextField txtStraatnaam1;

    @FXML
    private TextField txtHuisNummer1;

    @FXML
    private TextField txtPostcode1;

    @FXML
    private TextField txtWoonplaats1;

    @FXML
    private TextField txtVakantieStraatnaam1;

    @FXML
    private TextField txtVakantieHuisNummer1;

    @FXML
    private TextField txtVakantiePostcode1;

    @FXML
    private TextField txtVakantiePlaats1;

    @FXML
    private TextField txthotelNaam1;

    @FXML
    private TextField txtEmail1;

    @FXML
    private TextField txtTelefoon1;

    @FXML
    private TextField txtMobielNummer1;

    @FXML
    private TextField txtVluchtNummer1;

    @FXML
    private TextField txtVan1;

    @FXML
    private TextField txtNaar1;

    @FXML
    private TextField txtBagageLabelMatch1;

    @FXML
    private TextField txtMerk1;

    @FXML
    private TextField txtTypeBagage1;

    @FXML
    private Text Kleur1Text1;

    @FXML
    private TextField txtKleur21;

    @FXML
    private TextField txtKleur11;

    @FXML
    private TextArea txtBijzondereOpmerking1;

    @FXML
    private Text txtState;

    @FXML
    private Button btnAnnuleren3;

    @FXML
    private Button btnInsturen;

    @FXML
    private Text bagageID;

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
    private String IsReturned;
    private ResultSet resultSet = null;
    protected ObservableList<MedewerkerBagageTable> bagageTables = FXCollections.observableArrayList();
    private String initialForMatch;
    private String surnameForMatch;
    private String Passnameandcity;
    private MedewerkerBagageTable bagage;

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

        FormulierZoekenController parant = new FormulierZoekenController();
        parant.getAirport();

        txtBagageLabelMatch.setText(getSelectedBagage().getLabelnumber());

        if (getSelectedBagage().getState().equals("Lost")) {
            txtState.setText(getSelectedBagage().getState() + " " + language.getTranslationString("TLK203") + " Found");

        } else {
            txtState.setText(getSelectedBagage().getState() + " " + language.getTranslationString("TLK203") + " Lost");

        }
        txtTypeBagage.setText(getSelectedBagage().getType());
        txtMerk.setText(getSelectedBagage().getBrand());
        txtKleur1.setText(getSelectedBagage().getColor1());
        txtKleur2.setText(getSelectedBagage().getColor2());
        txtBijzondereOpmerking.setText(getSelectedBagage().getCharacteristics());
        txtIATA.setText(getSelectedBagage().getAirport());
        txtVan.setText(getSelectedBagage().getFrom());
        txtNaar.setText(getSelectedBagage().getTo());
        txtNS.setText(getSelectedBagage().getPassnameandcity());

    }

    public void setBagage(MedewerkerBagageTable medewerkerBagageTable) {
        this.bagage = medewerkerBagageTable;

    }

    public void zoekMatch() throws SQLException {

        System.out.println(super.State);

//        resultSetNoFilter();
//        fillTable();
    }

    @FXML
    @Override
    public void fillTable() throws SQLException {

        ObservableList<String> bagagetabel = FXCollections.observableArrayList();
        //Get all the results out of the database
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
            Passnameandcity = resultSet.getString("Passnameandcity");
            IsReturned = resultSet.getString("IsReturned");

            bagageTables.add(new MedewerkerBagageTable(BagageID, State, Labelnumber, Type, Brand, Color1, Color2, Characteristics, Location, Airport, From, To, Passnameandcity, IsReturned));

        }
        listView.setItems(bagageTables);
    }

    public void matchWith() {
        if (listView.getSelectionModel().getSelectedItem() != null) {
            MedewerkerBagageTable medewerkerBagageTable = listView.getSelectionModel().getSelectedItem();

            txtBagageLabelMatch1.setText(medewerkerBagageTable.getLabelnumber());
            bagageID.setText(medewerkerBagageTable.getBagageID());
            txtState.setText(medewerkerBagageTable.getState());
            txtTypeBagage1.setText(medewerkerBagageTable.getType());
            txtMerk1.setText(medewerkerBagageTable.getBrand());
            txtKleur11.setText(medewerkerBagageTable.getColor1());
            txtKleur21.setText(medewerkerBagageTable.getColor2());
            txtBijzondereOpmerking1.setText(medewerkerBagageTable.getCharacteristics());
            txtIATA1.setText(medewerkerBagageTable.getAirport());
            txtVan1.setText(medewerkerBagageTable.getFrom());
            txtNaar.setText(medewerkerBagageTable.getTo());
            txtNS1.setText(medewerkerBagageTable.getPassnameandcity());

        }

    }

    public void exporterenPDF(ActionEvent event) throws IOException {
        PDFExport export = new PDFExport();
        export.addPage();
        export.savePDF();
    }

}
