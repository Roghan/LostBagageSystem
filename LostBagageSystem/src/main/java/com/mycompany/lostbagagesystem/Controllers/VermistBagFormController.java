/*Controller Class voor het vermiste BagageScherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.language;
import com.mycompany.lostbagagesystem.models.ColourPicker;
import com.mycompany.lostbagagesystem.models.FormulierCheck;
import com.mycompany.lostbagagesystem.models.ToggleGroupResult;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    private TextField txtLandnaam;
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
    private TextField txtEmail;
    @FXML
    private TextField txtTelefoon;
    @FXML
    private TextField txtMobielNummer;
    @FXML
    private TextField txtLabelNummer;
    @FXML
    private TextField txtVluchtNummer;
    @FXML
    private TextField txtBestemming;
    @FXML
    private TextField txtBagageLabel;
    @FXML
    private TextField txtTypeBagage;
    @FXML
    private TextField txtMerk;
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
    private TextArea txtBijzondereOpmerking;
    @FXML
    private Button btnAnnuleren3;
    @FXML
    private Button btnInsturen;
    @FXML
    private Text Kleur1Text;
    @FXML
    private DatePicker txtGeboorteDatum;
    @FXML
    private ResourceBundle bundle;
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

    private Locale locale;

    private String time;
    private String datum;
    private String vliegveldID;
    private String voorLetters;
    private String tussenVoegsel;
    private String achterNaam;
    private String straatNaam;
    private String huisNummer;
    private String postCode;
    private String woonPlaats;
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

    @FXML
    void annuleren3(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void insturen(ActionEvent insturen) throws SQLException {
        System.out.println("KNOP INSTUREN INGEDRUKT");

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
        van = txtVan.getText();
        naar = txtNaar.getText();
        bagageLabel = txtBagageLabel.getText();
        typeBagage = txtTypeBagage.getText();
        merk = txtMerk.getText();
        bijzondereOpmerking = txtBijzondereOpmerking.getText();

        TextField[] reqTextFields = new TextField[]{
            txtVluchtNummer,
            txtBestemming,
            txtVoorletters,
            txtAchternaam,
            txtStraatnaam,
            txtPostcode,
            txtWoonplaats,
            txtEmail,
            txtVan,
            txtNaar

        };

        DatePicker[] datePickers = new DatePicker[]{
            txtDatum,
            txtGeboorteDatum

        };

        TextField[] PhoneFields = new TextField[]{
            txtTelefoon,
            txtMobielNummer

        };

        TextField[] reqIntFields = new TextField[]{
            txtHuisNummer};

        //boolean form = FormulierCheck.verification(reqTextFields, PhoneFields, datePickers, reqIntFields);
        if (true) {
            sendToDatabase();
        }

    }

    private void loadLang(String lang) {
        locale = new Locale(lang);
        bundle = ResourceBundle.getBundle("Bundles.Lang", locale);

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
                + "`Characteristics`, `Luchthaven`, `VluchtNummer`, `From`, `To`) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = db.getDBConnection();
            myStmt = conn.prepareStatement(persoonsgegevens);
            // Filling in the question marks from the query
            myStmt.setString(1, voorLetters);
            myStmt.setString(2, tussenVoegsel);
            myStmt.setString(3, achterNaam);
            myStmt.setString(4, straatNaam);
            myStmt.setString(5, huisNummer);
            myStmt.setString(6, postCode);
            myStmt.setString(7, woonPlaats);
            myStmt.setString(8, email);
            myStmt.setString(9, telefoonNummer);
            myStmt.setString(10, mobielNummer);
            myStmt.setString(11, vluchtNummer);
            myStmt.setString(12, "Lost");
            myStmt.setString(13, datum);
            myStmt.setString(14, time);
            myStmt.setString(15, bagageLabel);
            myStmt.setString(16, typeBagage);
            myStmt.setString(17, merk);
            myStmt.setString(18, ralcode1);
            myStmt.setString(19, ralcode2);
            myStmt.setString(20, bijzondereOpmerking);
            myStmt.setString(21, iataString);
            myStmt.setString(22, van);
            myStmt.setString(23, naar);

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

    @FXML
    public void IATACHECK(ActionEvent event) {
        RadioMenuItem iattaItem = (RadioMenuItem) IATA.getSelectedToggle();
        iataString = iattaItem.getText();
        btnVliegveldID.setText(iataString);
        System.out.println(iataString);

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
