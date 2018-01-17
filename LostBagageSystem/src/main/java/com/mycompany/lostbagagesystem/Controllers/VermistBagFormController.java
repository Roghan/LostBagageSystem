/*Controller Class voor het vermiste BagageScherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.PDFExport;
import com.mycompany.lostbagagesystem.models.FormulierCheck;
import com.mycompany.lostbagagesystem.models.PopupMeldingen;
import com.mycompany.lostbagagesystem.models.SetRadioMenuButtonText;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class VermistBagFormController implements Initializable {

    @FXML
    private MenuButton btnVliegveldID;
    @FXML
    private DatePicker txtDatum;
    @FXML
    private TextField txtTime;
    @FXML
    private TextField txtVoorletters;
    @FXML
    private TextField txtTussenvoegsel;
    @FXML
    private TextField txtAchternaam;
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
    private TextField txtBagageLabel;
    @FXML
    private TextField txtTypeBagage;
    @FXML
    private TextField txtMerk;
    @FXML
    private ToggleGroup kleur1;
    @FXML
    private ToggleGroup kleur2;
    @FXML
    private TextArea txtBijzondereOpmerking;
    @FXML
    private MenuButton kleur1Menu;
    @FXML
    private MenuButton kleur2Menu;
    @FXML
    private TextField txtVan;
    @FXML
    private TextField txtNaar;
    @FXML
    private ToggleGroup IATA;
    @FXML
    private ToggleGroup IATA_VAN;
    @FXML
    private ToggleGroup IATA_NAAR;
    @FXML
    private MenuButton btnVanVliegveldID;
    @FXML
    private MenuButton btnNaarVliegveldID;

    //String's voor het bewaren van de gegevens uit de textvelden
    private String time;
    private String datum;
    private String voorLetters;
    private String tussenVoegsel;
    private String achterNaam;
    private String straatNaam;
    private String huisNummer;
    private String postCode;
    private String woonPlaats;
    private String vakantieStraatNaam;
    private String vakantieHuisNummer;
    private String vakantiePostCode;
    private String vakantieWoonPlaats;
    private String naamHotel;
    private String email;
    private String telefoonNummer;
    private String mobielNummer;
    private String vluchtNummer;
    private String bagageLabel;
    private String typeBagage;
    private String merk;
    private String bijzondereOpmerking;
    private String van;
    private String naar;
    private String ralcode1;
    private String ralcode2;
    private String iataString;
    private String Passnameandcity;

    @FXML
    void annuleren3(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void insturen(ActionEvent insturen) throws SQLException {
        System.out.println("KNOP INSTUREN INGEDRUKT");

        TextField[] reqTextFields = new TextField[]{
            txtVoorletters,
            txtAchternaam,
            txtStraatnaam,
            txtWoonplaats,
            txtVluchtNummer,
            txtTime

        };

        DatePicker[] datePickers = new DatePicker[]{
            txtDatum

        };

        TextField[] PhoneFields = new TextField[]{
            txtTelefoon,
            txtMobielNummer

        };

        TextField[] reqIntFields = new TextField[]{};

        MenuButton[] reqMenuButtons = new MenuButton[]{
            btnVliegveldID,
            btnVanVliegveldID,
            btnNaarVliegveldID,
            kleur1Menu

        };

        boolean form = FormulierCheck.verification(reqTextFields, PhoneFields, datePickers, reqIntFields, reqMenuButtons);
        if (form) {
            time = txtTime.getText();
            datum = txtDatum.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            voorLetters = txtVoorletters.getText();
            tussenVoegsel = txtTussenvoegsel.getText();
            achterNaam = txtAchternaam.getText();
            straatNaam = txtStraatnaam.getText();
            huisNummer = txtHuisNummer.getText();
            postCode = txtPostcode.getText();
            woonPlaats = txtWoonplaats.getText();
            email = txtEmail.getText();
            telefoonNummer = txtTelefoon.getText();
            mobielNummer = txtMobielNummer.getText();
            vluchtNummer = txtVluchtNummer.getText();
            bagageLabel = txtBagageLabel.getText();
            typeBagage = txtTypeBagage.getText();
            merk = txtMerk.getText();
            bijzondereOpmerking = txtBijzondereOpmerking.getText();
            vakantieStraatNaam = txtVakantieStraatnaam.getText();
            vakantieHuisNummer = txtVakantieHuisNummer.getText();
            vakantiePostCode = txtVakantiePostcode.getText();
            vakantieWoonPlaats = txtVakantiePlaats.getText();
            naamHotel = txthotelNaam.getText();

            Passnameandcity = voorLetters + ", " + tussenVoegsel + " " + achterNaam + ", " + woonPlaats;

            sendToDatabase();
        }

    }

    public void sendToDatabase() throws SQLException {
        // Making a new prepared statement 
        PreparedStatement myStmt = null;
        Connection conn = null;
        ConnectDB db = new ConnectDB();
        int numberAffected = 0;

        // Updates persoonsgegevens
        String persoonsgegevens = "INSERT INTO `bagage` "
                + "(`State`, `Date`, `Time`, `Labelnumber`, `Type`, "
                + "`Brand`,`Color1`, `Color2`, `Characteristics`, `Airport`,"
                + "`Passnameandcity`,"
                + "`Street`, `Housenumber`, `Zipcode`, `Email`,"
                + "`Phone1`, `Phone2`, `Flightnumber`, `From`, `To`,"
                + "`Vstreet`, `Vhousenumber`, `Vzipcode`, `Vcity`, `Hotelname`) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = db.getDBConnection();
            myStmt = conn.prepareStatement(persoonsgegevens);
            // Filling in the question marks from the query
            myStmt.setString(1, "Lost");
            myStmt.setString(2, datum);
            myStmt.setString(3, time);
            myStmt.setString(4, bagageLabel);
            myStmt.setString(5, typeBagage);
            myStmt.setString(6, merk);
            myStmt.setString(7, ralcode1);
            myStmt.setString(8, ralcode2);
            myStmt.setString(9, bijzondereOpmerking);
            myStmt.setString(10, iataString);
            myStmt.setString(11, Passnameandcity);
            myStmt.setString(12, straatNaam);
            myStmt.setString(13, huisNummer);
            myStmt.setString(14, postCode);
            myStmt.setString(15, email);
            myStmt.setString(16, telefoonNummer);
            myStmt.setString(17, mobielNummer);
            myStmt.setString(18, vluchtNummer);
            myStmt.setString(19, van);
            myStmt.setString(20, naar);
            myStmt.setString(21, vakantieStraatNaam);
            myStmt.setString(22, vakantieHuisNummer);
            myStmt.setString(23, vakantiePostCode);
            myStmt.setString(24, vakantieWoonPlaats);
            myStmt.setString(25, naamHotel);

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

        System.out.println(numberAffected);
        if (numberAffected == 1) {
            PopupMeldingen.gegevensVerstuurd();
        }

    }

    @FXML
    public void IATACHECK(ActionEvent event) {
        SetRadioMenuButtonText.dropDown(btnVliegveldID, IATA);

    }

    @FXML
    public void vanDropDown(ActionEvent event) {
        SetRadioMenuButtonText.dropDown(btnVanVliegveldID, IATA_VAN);

    }

    @FXML
    public void naarDropDown(ActionEvent event) {
        SetRadioMenuButtonText.dropDown(btnNaarVliegveldID, IATA_NAAR);

    }

    @FXML
    public void kleurkiezer1(ActionEvent event) {
        ralcode1 = SetRadioMenuButtonText.kleurkiezer(kleur1Menu, kleur1);

    }

    @FXML
    public void kleurkiezer2(ActionEvent event) {
        ralcode2 = SetRadioMenuButtonText.kleurkiezer(kleur2Menu, kleur2);
    }

    @FXML
    public void exportPDF(ActionEvent event) throws IOException {
        //Test output for console
        System.out.println("Button Press Print PDF");
        //Call the PDFExport class
        PDFExport doc = new PDFExport();
        //Add a new page to the pdf file
        doc.addPage();
        //Prompts the FileChooser
        doc.savePDF();

    }

}
