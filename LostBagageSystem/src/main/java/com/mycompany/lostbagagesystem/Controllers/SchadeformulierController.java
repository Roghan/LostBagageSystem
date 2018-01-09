/*Controller Class voor het SchadeFormulier
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.models.ColourPicker;
import com.mycompany.lostbagagesystem.models.FormulierCheck;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
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
    private Button insturen;

    @FXML
    private AnchorPane TableLeeg2;

    @FXML
    private MenuButton btnVanVliegveldID;
    @FXML
    private MenuButton btnNaarVliegveldID;
    @FXML
    private MenuButton btnVliegveldID;

    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private String geboortedatum;
    private String landnaam;
    private String merk;
    private String bankRekening;
    private String straatnaam;
    private String huisnummer;
    private String postcode;
    private String woonplaats;
    private String email;
    private String telefoon;
    private String mobiel;
    private String bagageLabel;
    private String typeBagage;
    private String merkBagage;
    private String bijzondereOpmerking;
    private String schadeDatum;
    private String datumBeginReis;
    private String schadeTijd;
    private String schadePlaats;
    private String schadeLand;
    private String ralcode1;
    private String ralcode2;
    private String iataString;

    @FXML
    void annuleren3(ActionEvent event) {

    }

    @FXML
    void insturen(ActionEvent event) {
        System.out.println("KNOP INSTUREN INGEDRUKT");

        voorletters = txtVoorletters.getText();
        tussenvoegsel = txtTussenvoegsel.getText();
        achternaam = txtAchternaam.getText();
        landnaam = txtLandnaam.getText();
        bankRekening = txtBankrekening.getText();
        straatnaam = txtStraatnaam.getText();
        huisnummer = txtHuisNummer.getText();
        postcode = txtPostcode.getText();
        woonplaats = txtWoonplaats.getText();
        email = txtEmail.getText();
        telefoon = txtTelefoon.getText();
        mobiel = txtMobielNummer.getText();
        bagageLabel = txtBagageLabel.getText();
        typeBagage = txtTypeBagage.getText();
        merkBagage = txtMerk.getText();
        bijzondereOpmerking = null;
        schadeTijd = txtSchadeTijd.getText();
        schadePlaats = txtSchadePlaats.getText();
        schadeLand = txtSchadeLand.getText();

        TextField[] reqTextFields = new TextField[]{
            txtVoorletters,
            txtAchternaam,
            txtBankrekening,
            txtStraatnaam,
            txtPostcode,
            txtWoonplaats,
            txtEmail,
            txtLandnaam

        };

        DatePicker[] datePickers = new DatePicker[]{
            txtGeboorteDatum,
            txtSchadeDatum,
            txtDatumBeginReis

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
            btnNaarVliegveldID

        };

        FormulierCheck.verification(reqTextFields, PhoneFields, datePickers, reqTextFields, reqMenuButtons);

    }

    public void sendToDatabase() throws SQLException {
        // Making a new prepared statement 
        PreparedStatement myStmt = null;
        Connection conn = null;
        ConnectDB db = new ConnectDB();
        int numberAffected = 0;

        // Updates persoonsgegevens
        String persoonsgegevens = "INSERT INTO `klant` "
                + "(`Voorletter`,`Tussenvoegsel`, `Achternaam`, `Straat`, `HuisNummer`, `Postcode`, "
                + "`Woonplaats`, `Email`, `Telefoon1`, `Telefoon2`, `VluchtNummer`,"
                + "`State`, `Date`, `Time`, `LabelNummer`, `Type`, `Brand`, `Color1`, `Color2`,"
                + "`Characteristics`, `Luchthaven`) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = db.getDBConnection();
            myStmt = conn.prepareStatement(persoonsgegevens);
            // Filling in the question marks from the query
            myStmt.setString(1, voorletters);
            myStmt.setString(2, tussenvoegsel);
            myStmt.setString(3, achternaam);
            //myStmt.setString(4, vluchtNummer);
            myStmt.setString(4, straatnaam);
            myStmt.setString(5, huisnummer);
            myStmt.setString(6, postcode);
            myStmt.setString(7, woonplaats);
            myStmt.setString(8, email);
            myStmt.setString(9, telefoon);
            myStmt.setString(10, mobiel);
            //myStmt.setString(11, vluchtNummer);
            myStmt.setString(5, "Damaged");
            //myStmt.setString(6, datum);
            //myStmt.setString(7, tijd);
            myStmt.setString(8, bagageLabel);
            myStmt.setString(9, typeBagage);
            myStmt.setString(10, merk);
            myStmt.setString(11, ralcode1);
            myStmt.setString(12, ralcode2);
            myStmt.setString(13, bijzondereOpmerking);
            //myStmt.setString(14, iataString);

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

    }

//    @FXML
//    public void IATACHECK(ActionEvent event) {
//        RadioMenuItem iattaItem = (RadioMenuItem) IATA.getSelectedToggle();
//        iataString = iattaItem.getText();
//        btnVliegveldID.setText(iataString);
//        System.out.println(iataString);
//
//    }
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
