/*Controller Class voor het SchadeFormulier
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.models.FormulierCheck;
import com.mycompany.lostbagagesystem.models.PopupMeldingen;
import com.mycompany.lostbagagesystem.models.SetRadioMenuButtonText;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Donovan Schaafsma
 */
public class SchadeformulierController implements Initializable {

    @FXML
    private TextField txtVoorletters;

    @FXML
    private TextField txtTussenvoegsel;

    @FXML
    private TextField txtAchternaam;

    @FXML
    private RadioButton checkM;

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private RadioButton checkV;

    @FXML
    private RadioButton checkO;

    @FXML
    private TextField txtStraatnaam;

    @FXML
    private TextField txtHuisNummer;

    @FXML
    private TextField txtPostcode;

    @FXML
    private TextField txtWoonplaats;

    @FXML
    private DatePicker txtGeboorteDatum;

    @FXML
    private TextField txtLandnaam;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTelefoon;

    @FXML
    private TextField txtMobielNummer;

    @FXML
    private TextField txtBankrekening;

    @FXML
    private TextField txtAchternaamGast;

    @FXML
    private TextField txtPostcodeGast;

    @FXML
    private TextField txtHuisNummerGast;

    @FXML
    private TextField txtBagageLabel;

    @FXML
    private TextField txtTypeBagage;

    @FXML
    private TextField txtMerk;

    @FXML
    private MenuButton kleur1Menu;

    @FXML
    private MenuButton kleur2Menu;

    @FXML
    private RadioButton clrBlack;

    @FXML
    private ToggleGroup kleur1;

    @FXML
    private RadioButton clrWhite;

    @FXML
    private RadioButton clrSilver;

    @FXML
    private RadioButton clrGray;

    @FXML
    private RadioButton clrRed;

    @FXML
    private RadioButton clrMaroon;

    @FXML
    private RadioButton clrOlive;

    @FXML
    private RadioButton clrYellow;

    @FXML
    private RadioButton clrLime;

    @FXML
    private RadioButton clrGreen;

    @FXML
    private RadioButton clrAqua;

    @FXML
    private RadioButton clrTeal;

    @FXML
    private RadioButton clrBlue;

    @FXML
    private RadioButton clrNavy;

    @FXML
    private RadioButton clrPink;

    @FXML
    private RadioButton clrPurple;

    @FXML
    private RadioButton clrBlack1;

    @FXML
    private ToggleGroup kleur2;

    @FXML
    private RadioButton clrWhite1;

    @FXML
    private RadioButton clrSilver1;

    @FXML
    private RadioButton clrGray1;

    @FXML
    private RadioButton clrRed1;

    @FXML
    private RadioButton clrMaroon1;

    @FXML
    private RadioButton clrOlive1;

    @FXML
    private RadioButton clrYellow1;

    @FXML
    private RadioButton clrLime1;

    @FXML
    private RadioButton clrGreen1;

    @FXML
    private RadioButton clrAqua1;

    @FXML
    private RadioButton clrTeal1;

    @FXML
    private RadioButton clrBlue1;

    @FXML
    private RadioButton clrNavy1;

    @FXML
    private RadioButton clrPink1;

    @FXML
    private RadioButton clrPurple1;

    @FXML
    private RadioButton clrBlack2;

    @FXML
    private ToggleGroup kleur3;

    @FXML
    private RadioButton clrWhite2;

    @FXML
    private RadioButton clrSilver2;

    @FXML
    private RadioButton clrGray2;

    @FXML
    private RadioButton clrRed2;

    @FXML
    private RadioButton clrMaroon2;

    @FXML
    private RadioButton clrOlive2;

    @FXML
    private RadioButton clrYellow2;

    @FXML
    private RadioButton clrLime2;

    @FXML
    private RadioButton clrGreen2;

    @FXML
    private RadioButton clrAqua2;

    @FXML
    private RadioButton clrTeal2;

    @FXML
    private RadioButton clrBlue2;

    @FXML
    private RadioButton clrNavy2;

    @FXML
    private RadioButton clrPink2;

    @FXML
    private RadioButton clrPurple2;

    @FXML
    private Button btnFotoToevoegen;

    @FXML
    private TextField txtSchadePlaats;

    @FXML
    private TextField txtSchadeLand;

    @FXML
    private DatePicker txtSchadeDatum;

    @FXML
    private DatePicker txtDatumBeginReis;

    @FXML
    private TextField txtSchadeTijd;

    @FXML
    private Button annuleren3;

    @FXML
    private DatePicker txtDatum;

    @FXML
    private TextArea txtBijzondereOpmerking;

    @FXML
    private TextField txtVluchtNummer;

    @FXML
    private Button insturen;

    @FXML
    private ToggleGroup IATA;

    @FXML
    private ToggleGroup IATA_VAN;

    @FXML
    private ToggleGroup IATA_NAAR;

    @FXML
    private AnchorPane TableLeeg2;

    @FXML
    private MenuButton btnVanVliegveldID;

    @FXML
    private MenuButton btnNaarVliegveldID;

    @FXML
    private MenuButton btnVliegveldID;

    //String's voor het bewaren van de gegevens uit de textvelden
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private String datum;
    private String bankRekening;
    private String straatnaam;
    private String huisnummer;
    private String postcode;
    private String woonplaats;
    private String email;
    private String telefoon;
    private String mobiel;
    private String bagagelabel;
    private String typeBagage;
    private String merk;
    private String bijzondereOpmerking;
    private String vluchtNummer;
    private String schadePlaats;
    private String schadeLand;
    private String van;
    private String naar;
    private String ralcode1;
    private String ralcode2;
    private String iataString;

    @FXML
    void annuleren3(ActionEvent event) {

    }

    @FXML
    void insturen(ActionEvent event) throws SQLException {
        System.out.println("KNOP INSTUREN INGEDRUKT");

        TextField[] reqTextFields = new TextField[]{
            txtVoorletters,
            txtAchternaam,
            txtBankrekening,
            txtStraatnaam,
            txtPostcode,
            txtWoonplaats,
            txtVluchtNummer,
            txtEmail,
            txtSchadePlaats,
            txtSchadeLand

        };

        DatePicker[] datePickers = new DatePicker[]{
            txtDatum
        };

        TextField[] PhoneFields = new TextField[]{
            txtTelefoon,
            txtMobielNummer

        };

        TextField[] reqIntFields = new TextField[]{
            txtHuisNummer

        };

        MenuButton[] reqMenuButtons = new MenuButton[]{
            btnVliegveldID,
            btnVanVliegveldID,
            btnNaarVliegveldID,
            kleur1Menu

        };

        boolean form = FormulierCheck.verification(reqTextFields, PhoneFields, datePickers, reqTextFields, reqMenuButtons);
        if (form) {
            voorletters = txtVoorletters.getText();
            tussenvoegsel = txtTussenvoegsel.getText();
            achternaam = txtAchternaam.getText();
            bankRekening = txtBankrekening.getText();
            datum = txtDatum.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            straatnaam = txtStraatnaam.getText();
            huisnummer = txtHuisNummer.getText();
            postcode = txtPostcode.getText();
            woonplaats = txtWoonplaats.getText();
            email = txtEmail.getText();
            telefoon = txtTelefoon.getText();
            mobiel = txtMobielNummer.getText();
            vluchtNummer = txtVluchtNummer.getText();
            schadePlaats = txtSchadePlaats.getText();
            schadeLand = txtSchadeLand.getText();
            bagagelabel = txtBagageLabel.getText();
            typeBagage = txtTypeBagage.getText();
            merk = txtMerk.getText();
            bijzondereOpmerking = txtBijzondereOpmerking.getText();

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
                + "(`State`, `Date`, `Labelnumber`, `Type`, "
                + "`Brand`,`Color1`, `Color2`, `Characteristics`, `Airport`,"
                + "`Initial`, `Insertion`, `Surname`,"
                + "`Street`, `Housenumber`, `Zipcode`, `City`, `Email`,"
                + "`Phone1`, `Phone2`, `Flightnumber`, `From`, `To`) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = db.getDBConnection();
            myStmt = conn.prepareStatement(persoonsgegevens);
            // Filling in the question marks from the query
            myStmt.setString(1, "Damaged");
            myStmt.setString(2, datum);
            myStmt.setString(3, bagagelabel);
            myStmt.setString(4, typeBagage);
            myStmt.setString(5, merk);
            myStmt.setString(6, ralcode1);
            myStmt.setString(7, ralcode2);
            myStmt.setString(8, bijzondereOpmerking);
            myStmt.setString(9, iataString);
            myStmt.setString(10, voorletters);
            myStmt.setString(11, tussenvoegsel);
            myStmt.setString(12, achternaam);
            myStmt.setString(13, straatnaam);
            myStmt.setString(14, huisnummer);
            myStmt.setString(15, postcode);
            myStmt.setString(16, woonplaats);
            myStmt.setString(17, email);
            myStmt.setString(18, telefoon);
            myStmt.setString(19, mobiel);
            myStmt.setString(20, vluchtNummer);
            myStmt.setString(21, van);
            myStmt.setString(22, naar);

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
