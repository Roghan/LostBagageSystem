/*Controller Class voor het gevonden bagage Formulier
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.MainApp;
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.models.ColourPicker;
import com.mycompany.lostbagagesystem.models.FormulierCheck;
import com.mycompany.lostbagagesystem.models.PopupMeldingen;
import com.mycompany.lostbagagesystem.models.SetRadioMenuButtonText;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Donovan Schaafsma
 */
public class GevBagFormController implements Initializable {

    @FXML
    private DatePicker txtDatum;
    @FXML
    private TextField txtTime;
    @FXML
    private TextField txtVliegveldID;
    @FXML
    private TextField txtLostAndFoundID;
    @FXML
    private TextField txtVoorletters;
    @FXML
    private TextField txtTussenvoegsel;
    @FXML
    private TextField txtAchternaam;
    @FXML
    private RadioButton checkM;
    @FXML
    private RadioButton checkV;
    @FXML
    private RadioButton checkO;
    @FXML
    private ToggleGroup genderGroup;
    @FXML
    private TextField txtLabelNummer;
    @FXML
    private TextField txtVluchtNummer;
    @FXML
    private TextField txtBestemming;
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
    private TextField txtBagageLabel;
    @FXML
    private MenuButton kleur1Menu;
    @FXML
    private MenuButton kleur2Menu;
    @FXML
<<<<<<< HEAD
    private MenuButton btnGevondenPlaats;
    @FXML
    private ToggleGroup Plaats;
    @FXML
=======
>>>>>>> parent of 5fd570c... Merge branch 'master' into statistiekenScherm
    private ToggleGroup IATA;
    @FXML
    private MenuButton btnVliegveldID;
    @FXML
    private MenuButton btnVanVliegveldID;
    @FXML
    private MenuButton btnNaarVliegveldID;

    private String datum;
    private String tijd;
    private String vliegveldID;
    private String lostAndFound;
    private String voorLetters;
    private String tussenVoegsel;
    private String achterNaam;
    private String merk;
    private String labelNummer;
    private String vluchtNummer;
    private String bestemming;
    private String typeBagage;
    private String merkBagage;
    private String bijzondereOpmerking;
    private String ralcode1;
    private String ralcode2;
    private String iataString;

    @FXML
    void insturen(ActionEvent insturen) throws SQLException {
        System.out.println("KNOP INSTUREN INGEDRUKT");

        voorLetters = txtVoorletters.getText();
        tussenVoegsel = txtTussenvoegsel.getText();
        achterNaam = txtAchternaam.getText();

        TextField[] reqFields = new TextField[]{
            txtVoorletters,
            txtAchternaam,
            txtTime,
            txtVliegveldID,
            txtLostAndFoundID,
            txtLabelNummer,
<<<<<<< HEAD
            txtVluchtNummer,};
=======
            txtVluchtNummer,
            txtBestemming

        };
>>>>>>> parent of 5fd570c... Merge branch 'master' into statistiekenScherm

        DatePicker[] datePickers = new DatePicker[]{
            txtDatum

        };

        TextField[] PhoneFields = new TextField[]{};

<<<<<<< HEAD
        TextField[] reqIntFields = new TextField[]{
            txtTime

        };
=======
        TextField[] reqIntFields = new TextField[]{};
>>>>>>> parent of 5fd570c... Merge branch 'master' into statistiekenScherm

        MenuButton[] reqMenuButtons = new MenuButton[]{
            btnVliegveldID,
            btnVanVliegveldID,
            btnNaarVliegveldID

        };

<<<<<<< HEAD
        boolean form = FormulierCheck.verification(reqIntFields, PhoneFields, datePickers, reqIntFields, reqMenuButtons);
        if (form) {
            tijd = txtTime.getText();
            datum = txtDatum.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//            lostAndFound = txtLostAndFoundID.getText();
            voorletters = txtVoorletters.getText();
            tussenvoegsel = txtTussenvoegsel.getText();
            achternaam = txtAchternaam.getText();
            vluchtnummer = txtVluchtNummer.getText();
            bagagelabel = txtBagageLabel.getText();
            typeBagage = txtTypeBagage.getText();
            merk = txtMerk.getText();
            bijzondereOpmerking = txtBijzondereOpmerking.getText();
        }

=======
        FormulierCheck.verification(reqIntFields, PhoneFields, datePickers, reqIntFields, reqMenuButtons);
>>>>>>> parent of 5fd570c... Merge branch 'master' into statistiekenScherm
    }

    /**
     * Creates a prepared statement that sends an INSERT query to the database
     * for the Gevonden Bagage table
     *
     * @throws SQLException
     */
//    public void sendToDatabase() throws SQLException {
//        // Making a new prepared statement 
//        PreparedStatement myStmt = null;
//        Connection conn = null;
//        ConnectDB db = new ConnectDB();
//        int numberAffected = 0;
//
//        // This is a test query 
//        String query = "INSERT INTO `vermistebagage` "
//                + "(`voorletters`,`tussenvoegsel`, `achternaam`) VALUES"
//                + "(?, ?, ?)";
//
//        try {
//            conn = db.getDBConnection();
//            myStmt = conn.prepareStatement(query);
//            // Filling in the question marks from the query
//            myStmt.setString(1, voorLetters);
//            myStmt.setString(2, tussenVoegsel);
//            myStmt.setString(3, achternaam);
//
//            // Execute INSERT sql statement
//            numberAffected = myStmt.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            // Closing the prepared statement for memory purposes
//            if (myStmt != null) {
//                myStmt.close();
//            }
//            // Closing the database connection for memory purposes
//            if (conn != null) {
//                conn.close();
//            }
//        }
//
//        System.out.println(numberAffected);
//
//    }
    public void sendToDatabase() throws SQLException {
        // Making a new prepared statement 
        PreparedStatement myStmt = null;
        Connection conn = null;
        ConnectDB db = new ConnectDB();
        int numberAffected = 0;

        // Updates persoonsgegevens
        String persoonsgegevens = "INSERT INTO `klant` "
                + "(`Voorletter`,`Tussenvoegsel`, `Achternaam`, `VluchtNummer`,"
                + "`State`, `Date`, `Time`, `LabelNummer`, `Type`, `Brand`, `Color1`, `Color2`,"
                + "`Characteristics`, `Luchthaven`) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = db.getDBConnection();
            myStmt = conn.prepareStatement(persoonsgegevens);
            // Filling in the question marks from the query
            myStmt.setString(1, voorLetters);
            myStmt.setString(2, tussenVoegsel);
            myStmt.setString(3, achterNaam);
            myStmt.setString(4, vluchtNummer);
            myStmt.setString(5, "Found");
            myStmt.setString(6, datum);
            myStmt.setString(7, tijd);
            myStmt.setString(8, labelNummer);
            myStmt.setString(9, typeBagage);
            myStmt.setString(10, merk);
            myStmt.setString(11, ralcode1);
            myStmt.setString(12, ralcode2);
            myStmt.setString(13, bijzondereOpmerking);
            myStmt.setString(14, iataString);

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
    public void gevondenPlaats(ActionEvent event) {
        SetRadioMenuButtonText.dropDown(btnGevondenPlaats, Plaats);

    }
<<<<<<< HEAD

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
=======
>>>>>>> parent of 5fd570c... Merge branch 'master' into statistiekenScherm

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
