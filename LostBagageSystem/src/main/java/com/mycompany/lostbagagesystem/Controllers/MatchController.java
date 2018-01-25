package com.mycompany.lostbagagesystem.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.PDFExport;
import com.mycompany.lostbagagesystem.classes.Language;
import com.mycompany.lostbagagesystem.models.ColourPicker;
import com.mycompany.lostbagagesystem.models.MedewerkerBagageTable;
import com.mycompany.lostbagagesystem.models.PopupMeldingen;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class MatchController extends FormulierZoekenController implements Initializable {

    @FXML
    private TextField txtBagageLabelMatch;

    @FXML
    private ListView<MedewerkerBagageTable> listView;

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
    private TextField txtVakantiePlaats;

    @FXML
    private TextField txthotelNaam;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTelefoon;

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
    private ToggleGroup filter;

    @FXML
    private TextField txtNS;

    @FXML
    private Button btnAnnuleren;

    @FXML
    private TextField txtMobielNummer;
    @FXML
    private TextField txtVakantiePostcode;
    @FXML
    private TextField txtVakantiePostcode1;

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
    private String filterState;
    private String BagageIDSelected;

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
        RadioButton r = (RadioButton) filter.getSelectedToggle();
        filterState = r.getText();

        try {
            BagageID = getSelectedBagage().getBagageID();
            if (getSelectedBagage().getState().equals("Lost")) {
                State = "Found";
                txtState.setText(getSelectedBagage().getState() + " " + Language.getTranslationString("TLK203") + " Found");
            } else {
                State = "Lost";
                txtState.setText(getSelectedBagage().getState() + " " + Language.getTranslationString("TLK203") + " Lost");

            }

            getSelectedBagageInfo();
            fillFields();
        } catch (SQLException ex) {

        }

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MedewerkerBagageTable>() {
            @Override
            public void changed(ObservableValue<? extends MedewerkerBagageTable> observableValue, MedewerkerBagageTable s, MedewerkerBagageTable s2) {
                try {

                    if (listView.getSelectionModel().getSelectedItem() == null) {

                    } else {
                        BagageID = listView.getSelectionModel().getSelectedItem().getBagageID();
                        BagageIDSelected = listView.getSelectionModel().getSelectedItem().getBagageID();
                        getSelectedBagageInfoForMatch();
                        fillCompareFields();

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(MatchController.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public void zoekMatch(ActionEvent event) throws SQLException {

        if (filterState.equals(Language.getTranslationString("TLK204"))) {
            getFoundMatch();
            fillList();
        } else if (filterState.equals(Language.getTranslationString("TLK205"))) {
            getFoundMatchAll();
            fillList();

        }

    }

    @FXML
    public void fillFields() throws SQLException {

        while (resultSet.next()) {
            Date date = resultSet.getDate("Date");

            if (date != null) {
                txtDatum.setValue(resultSet.getDate("Date").toLocalDate());
            }

//            for (int i = 0; i < textFields.length; i++) {
//                textFields[i].setText(resultSet.getString(databaseStrings[i]));
            txtTime.setText(resultSet.getString("Time"));
            txtIATA.setText(resultSet.getString("Airport"));
            txtNS.setText(resultSet.getString("Passnameandcity"));
            txtStraatnaam.setText(resultSet.getString("Street"));
            txtHuisNummer.setText(resultSet.getString("Housenumber"));
            txtPostcode.setText(resultSet.getString("Zipcode"));
            txtWoonplaats.setText(resultSet.getString("City"));
            txtVakantieStraatnaam.setText(resultSet.getString("Vstreet"));
            txtVakantieHuisNummer.setText(resultSet.getString("Vhousenumber"));
            txtVakantiePostcode.setText(resultSet.getString("Vzipcode"));
            txtVakantiePlaats.setText(resultSet.getString("Vcity"));
            txthotelNaam.setText(resultSet.getString("Hotelname"));
            txtEmail.setText(resultSet.getString("Email"));
            txtTelefoon.setText(resultSet.getString("Phone1"));
            txtMobielNummer.setText(resultSet.getString("Phone2"));
            txtVluchtNummer.setText(resultSet.getString("Flightnumber"));
            txtVan.setText(resultSet.getString("From"));
            txtNaar.setText(resultSet.getString("To"));
            txtBagageLabelMatch.setText(resultSet.getString("Labelnumber"));
            txtTypeBagage.setText(resultSet.getString("Type"));
            txtMerk.setText(resultSet.getString("Brand"));
            txtKleur1.setText(resultSet.getString("Color1"));
            txtKleur2.setText(resultSet.getString("Color2"));
            txtBijzondereOpmerking.setText(resultSet.getString("Characteristics"));
        }

    }

    @FXML
    public void fillList() throws SQLException {

        listView.getItems().clear();

        //Get all the results out of the database
        while (resultSet.next()) {
            BagageID = resultSet.getString("BagageID");
            State = resultSet.getString("State");
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

    public void getFoundMatch() throws SQLException {
        String query = "SELECT * FROM `bagage` WHERE `State` = '" + State + "' AND (  `Labelnumber` = '" + txtBagageLabelMatch.getText() + "' "
                + " OR `Flightnumber` = '" + txtVluchtNummer.getText() + "' OR `Type` = '" + txtTypeBagage.getText() + "')";
        resultSet = db.executeResultSetQuery(query);
    }

    public void getFoundMatchAll() throws SQLException {
        String query = "SELECT * FROM `bagage` WHERE `State` = '" + State + "'  ";
        resultSet = db.executeResultSetQuery(query);
    }

    public void getSelectedBagageInfo() throws SQLException {
        String query = "SELECT * FROM `bagage` WHERE `BagageID` = '" + BagageID + "' ";
        resultSet = db.executeResultSetQuery(query);
    }

    public void getSelectedBagageInfoForMatch() throws SQLException {
        String query = "SELECT * FROM `bagage` WHERE `BagageID` = '" + BagageID + "' ";
        resultSet = db.executeResultSetQuery(query);
    }

    public void exporterenPDF(ActionEvent event) throws IOException {
        PDFExport export = new PDFExport();

        LocalDate lokaleDatum = LocalDate.now();
        DateTimeFormatter formaat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String datum = lokaleDatum.format(formaat);

        String tijd = txtTime.getText();
        if (tijd == null) {
            tijd = " ";
        }
        String naamEnStad = txtNS.getText();
        if (naamEnStad == null) {
            naamEnStad = " ";
        }
        String adres = txtStraatnaam.getText();
        if (adres == null) {
            adres = " ";
        }
        String huisnummer = txtWoonplaats.getText();
        if (huisnummer == null) {
            huisnummer = " ";
        }
        String postcode = txtPostcode.getText();
        if (postcode == null) {
            postcode = " ";
        }
        String woonplaats = txtWoonplaats.getText();
        if (woonplaats == null) {
            woonplaats = " ";
        }
        String vStraatnaam = txtVakantieStraatnaam.getText();
        if (vStraatnaam == null) {
            vStraatnaam = " ";
        }
        String vHuisnummer = txtVakantieHuisNummer.getText();
        if (vHuisnummer == null) {
            vHuisnummer = " ";
        }
        String vPostcode = txtVakantiePostcode.getText();
        if (vPostcode == null) {
            vPostcode = " ";
        }
        String vPlaats = txtVakantiePlaats.getText();
        if (vPlaats == null) {
            vPlaats = " ";
        }
        String hotelnaam = txthotelNaam.getText();
        if (hotelnaam == null) {
            hotelnaam = " ";
        }
        String email = txtEmail.getText();
        if (email == null) {
            email = " ";
        }
        String telefoon = txtTelefoon.getText();
        if (telefoon == null) {
            telefoon = " ";
        }
        String mobiel = txtMobielNummer.getText();
        if (mobiel == null) {
            mobiel = " ";
        }
        export.addPage(datum, tijd, naamEnStad, adres, huisnummer, postcode, woonplaats,
                vStraatnaam, vHuisnummer, vPostcode, vPlaats, hotelnaam,
                email, telefoon, mobiel);
        export.savePDF();
    }

    @FXML
    public void fillCompareFields() throws SQLException {

        while (resultSet.next()) {
            Date date = resultSet.getDate("Date");

            if (date != null) {
                txtDatum1.setValue(resultSet.getDate("Date").toLocalDate());
            }

            txtTime1.setText("");
            txtIATA1.setText("");
            txtNS1.setText("");
            txtStraatnaam1.setText("");
            txtHuisNummer1.setText("");
            txtPostcode1.setText("");
            txtWoonplaats1.setText("");
            txtVakantieStraatnaam1.setText("");
            txtVakantieHuisNummer1.setText("");
            txtVakantiePostcode1.setText("");
            txtVakantiePlaats1.setText("");
            txthotelNaam1.setText("");
            txtEmail1.setText("");
            txtTelefoon1.setText("");
            txtMobielNummer1.setText("");
            txtVluchtNummer1.setText("");
            txtVan1.setText("");
            txtNaar1.setText("");
            txtBagageLabelMatch1.setText("");
            txtTypeBagage1.setText("");
            txtMerk1.setText("");
            txtKleur11.setText("");
            txtKleur21.setText("");
            txtBijzondereOpmerking1.setText("");

            txtTime1.setText(resultSet.getString("Time"));
            txtIATA1.setText(resultSet.getString("Airport"));
            txtNS1.setText(resultSet.getString("Passnameandcity"));
            txtStraatnaam1.setText(resultSet.getString("Street"));
            txtHuisNummer1.setText(resultSet.getString("Housenumber"));
            txtPostcode1.setText(resultSet.getString("Zipcode"));
            txtWoonplaats1.setText(resultSet.getString("City"));
            txtVakantieStraatnaam1.setText(resultSet.getString("Vstreet"));
            txtVakantieHuisNummer1.setText(resultSet.getString("Vhousenumber"));
            txtVakantiePostcode1.setText(resultSet.getString("Vzipcode"));
            txtVakantiePlaats1.setText(resultSet.getString("Vcity"));
            txthotelNaam1.setText(resultSet.getString("Hotelname"));
            txtEmail1.setText(resultSet.getString("Email"));
            txtTelefoon1.setText(resultSet.getString("Phone1"));
            txtMobielNummer1.setText(resultSet.getString("Phone2"));
            txtVluchtNummer1.setText(resultSet.getString("Flightnumber"));
            txtVan1.setText(resultSet.getString("From"));
            txtNaar1.setText(resultSet.getString("To"));
            txtBagageLabelMatch1.setText(resultSet.getString("Labelnumber"));
            txtTypeBagage1.setText(resultSet.getString("Type"));
            txtMerk1.setText(resultSet.getString("Brand"));
            txtKleur11.setText(resultSet.getString("Color1"));
            txtKleur21.setText(resultSet.getString("Color2"));
            txtBijzondereOpmerking1.setText(resultSet.getString("Characteristics"));

        }

    }

    public void getFilters(ActionEvent event) throws SQLException {

        RadioButton r = (RadioButton) filter.getSelectedToggle();
        filterState = r.getText();

        zoekMatch(event);

    }

    @FXML
    public void mergeFields(ActionEvent event) throws SQLException {

   //     if (txtDatum.getValue() == null) {
            txtDatum.setValue(txtDatum1.getValue());

  //      }

        //if (txtTime.getText() == null) {
            txtTime.setText(txtTime1.getText());
    //    }

//        if (txtIATA.getText() == null) {
           txtIATA.setText(txtIATA1.getText());
//        }
       if (txtNS.getText() == null) {
            txtNS.setText(txtNS1.getText());
      }
//        if (txtStraatnaam.getText() == null) {
          txtStraatnaam.setText(txtStraatnaam1.getText());
//        }
//
//        if (txtHuisNummer.getText() == null) {
          txtHuisNummer.setText(txtHuisNummer1.getText());
//        }
//
//        if (txtPostcode.getText() == null) {
            txtPostcode.setText(txtPostcode1.getText());
//        }
//        if (txtWoonplaats.getText() == null) {
            txtWoonplaats.setText(txtWoonplaats1.getText());
//        }
//        if (txtVakantieStraatnaam.getText() == null) {
            txtVakantieStraatnaam.setText(txtVakantieStraatnaam1.getText());
//        }
//        if (txtVakantieHuisNummer.getText() == null) {
            txtVakantieHuisNummer.setText(txtVakantieHuisNummer1.getText());
//        }
//        if (txtPostcode.getText() == null) {
            txtPostcode.setText(txtPostcode1.getText());
//        }
//        if (txtVakantiePlaats.getText() == null) {
            txtVakantiePlaats.setText(txtVakantiePlaats1.getText());
//        }
//        if (txthotelNaam.getText() == null) {
            txthotelNaam.setText(txthotelNaam1.getText());
//        }
//        if (txtEmail.getText() == null) {
            txtEmail.setText(txtEmail1.getText());
//        }
        if (txtTelefoon.getText() == null) {
            txtTelefoon.setText(txtTelefoon1.getText());
        }
        if (txtMobielNummer.getText() == null) {
            txtMobielNummer.setText(txtMobielNummer1.getText());
        }
//        if (txtVluchtNummer.getText() == null) {
            txtVluchtNummer.setText(txtVluchtNummer1.getText());
//        }
//        if (txtVan.getText() == null) {
            txtVan.setText(txtVan1.getText());
//        }
//        if (txtNaar.getText() == null) {
            txtNaar.setText(txtNaar1.getText());
//        }
//        if (txtBagageLabelMatch.getText() == null) {
            txtBagageLabelMatch.setText(txtBagageLabelMatch1.getText());
//        }
//        if (txtTypeBagage.getText() == null) {
            txtTypeBagage.setText(txtTypeBagage1.getText());
//        }
//        if (txtMerk.getText() == null) {
            txtMerk.setText(txtMerk1.getText());
//        }
//        if (txtKleur1.getText() == null) {
            txtKleur1.setText(txtKleur11.getText());
//        }
//        if (txtKleur2.getText() == null) {
            txtKleur2.setText(txtKleur21.getText());
//        }
//        if (txtBijzondereOpmerking.getText() == null) {
            txtBijzondereOpmerking.setText(txtBijzondereOpmerking1.getText());
//        }
    }

    @FXML
    public void vervang(ActionEvent event) {

        txtTime.setText("");
        txtIATA.setText("");
        txtNS.setText("");
        txtStraatnaam.setText("");
        txtHuisNummer.setText("");
        txtPostcode.setText("");
        txtWoonplaats.setText("");
        txtVakantieStraatnaam.setText("");
        txtVakantieHuisNummer.setText("");
        txtVakantiePostcode.setText("");
        txtVakantiePlaats.setText("");
        txthotelNaam.setText("");
        txtEmail.setText("");
        txtTelefoon.setText("");
        txtMobielNummer.setText("");
        txtVluchtNummer.setText("");
        txtVan.setText("");
        txtNaar.setText("");
        txtBagageLabelMatch.setText("");
        txtTypeBagage.setText("");
        txtMerk.setText("");
        txtKleur1.setText("");
        txtKleur2.setText("");
        txtBijzondereOpmerking.setText("");

        txtDatum.setValue(txtDatum1.getValue());
        txtTime.setText(txtTime1.getText());
        txtIATA.setText(txtIATA1.getText());
        txtNS.setText(txtNS1.getText());
        txtStraatnaam.setText(txtStraatnaam1.getText());
        txtHuisNummer.setText(txtHuisNummer1.getText());
        txtPostcode.setText(txtPostcode1.getText());
        txtWoonplaats.setText(txtWoonplaats1.getText());
        txtVakantieStraatnaam.setText(txtVakantieStraatnaam1.getText());
        txtVakantieHuisNummer.setText(txtVakantieHuisNummer1.getText());
        txtVakantiePostcode.setText(txtVakantiePostcode1.getText());
        txtVakantiePlaats.setText(txtVakantiePlaats1.getText());
        txthotelNaam.setText(txthotelNaam1.getText());
        txtEmail.setText(txtEmail.getText());
        txtTelefoon.setText(txtTelefoon1.getText());
        txtMobielNummer.setText(txtMobielNummer1.getText());
        txtVluchtNummer.setText(txtVluchtNummer1.getText());
        txtVan.setText(txtVan1.getText());
        txtNaar.setText(txtNaar1.getText());
        txtBagageLabelMatch.setText(txtBagageLabelMatch1.getText());
        txtTypeBagage.setText(txtTypeBagage1.getText());
        txtMerk.setText(txtMerk1.getText());
        txtKleur1.setText(txtKleur11.getText());
        txtKleur2.setText(txtKleur21.getText());
        txtBijzondereOpmerking.setText(txtBijzondereOpmerking1.getText());

    }

    @FXML
    public void sendToDatabase(ActionEvent event) throws SQLException {
        // Making a new prepared statement 
        PreparedStatement myStmt = null;
        Connection conn = null;
        int numberAffected = 0;

        // Updates persoonsgegevens
        String persoonsgegevens = "INSERT INTO `bagage` "
                + "(`State`, `Date`, `Time`, `Labelnumber`, `Type`, "
                + "`Brand`,`Color1`, `Color2`, `Characteristics`, `Airport`,"
                + "`Passnameandcity`,"
                + "`Street`, `Housenumber`, `Zipcode`, `Email`,"
                + "`Phone1`, `Phone2`, `Flightnumber`, `From`, `To`,"
                + "`Vstreet`, `Vhousenumber`, `Vzipcode`, `Vcity`, `Hotelname`,`IsReturned`) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = db.getDBConnection();
            myStmt = conn.prepareStatement(persoonsgegevens);
            // Filling in the question marks from the query
            myStmt.setString(1, "Returned");
            myStmt.setString(2, txtDatum.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            myStmt.setString(3, txtTime.getText());
            myStmt.setString(4, txtBagageLabelMatch.getText());
            myStmt.setString(5, txtTypeBagage.getText());
            myStmt.setString(6, txtMerk.getText());
            myStmt.setString(7, ColourPicker.GetColour(txtKleur1.getText()));
            myStmt.setString(8, ColourPicker.GetColour(txtKleur2.getText()));
            myStmt.setString(9, txtBijzondereOpmerking.getText());
            myStmt.setString(10, txtIATA.getText());
            myStmt.setString(11, txtNS.getText());
            myStmt.setString(12, txtStraatnaam.getText());
            myStmt.setString(13, txtHuisNummer.getText());
            myStmt.setString(14, txtPostcode.getText());
            myStmt.setString(15, txtEmail.getText());
            myStmt.setString(16, txtTelefoon.getText());
            myStmt.setString(17, txtMobielNummer.getText());
            myStmt.setString(18, txtVluchtNummer.getText());
            myStmt.setString(19, txtVan.getText());
            myStmt.setString(20, txtNaar.getText());
            myStmt.setString(21, txtVakantieStraatnaam.getText());
            myStmt.setString(22, txtVakantieHuisNummer.getText());
            myStmt.setString(23, txtVakantiePostcode.getText());
            myStmt.setString(24, txtVakantiePlaats.getText());
            myStmt.setString(25, txthotelNaam.getText());
            myStmt.setInt(26, 1);

            // Execute INSERT sql statement
            numberAffected = myStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // Closing the prepared statement for memory purposes
            if (myStmt != null) {
                myStmt.close();
            }
            // Closing the database connection for memory purposes
            if (conn != null) {
                conn.close();
            }
        }

        removeOldEntry();

        System.out.println(numberAffected);

        if (numberAffected >= 1) {
            PopupMeldingen.gegevensVerstuurd();
        }

    }

    @FXML
    public void close(ActionEvent event) {
        Stage stage = (Stage) btnAnnuleren.getScene().getWindow();
        stage.close();

    }

    public void removeOldEntry() throws SQLException {

        if (getSelectedBagage().getState().equals("Lost")) {
            String id = getSelectedBagage().getBagageID();
            String query = "UPDATE `lbs_database`.`bagage` SET `IsReturned`='1' WHERE `BagageID`= '" + id + "' ;";
            db.executeUpdateQuery(query);

            query = "DELETE FROM `bagage` WHERE BagageID = '" + BagageIDSelected + "' ";
            db.executeUpdateQuery(query);

        } else {

            String id = getSelectedBagage().getBagageID();
            String query = "UPDATE `lbs_database`.`bagage` SET `IsReturned`='1' WHERE `BagageID`= '" + BagageIDSelected + "' ;";
            db.executeUpdateQuery(query);

            query = "DELETE FROM `bagage` WHERE BagageID = '" + id + "' ";
            db.executeUpdateQuery(query);

        }

    }

}
