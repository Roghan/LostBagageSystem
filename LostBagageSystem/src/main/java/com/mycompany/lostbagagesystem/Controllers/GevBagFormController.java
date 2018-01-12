/*Controller Class voor het gevonden bagage Formulier
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.MainApp;
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.PDFExport;
import com.mycompany.lostbagagesystem.classes.language;
import com.mycompany.lostbagagesystem.models.ColourPicker;
import com.mycompany.lostbagagesystem.models.FormulierCheck;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Donovan Schaafsma
 */
public class GevBagFormController implements Initializable {
    
    boolean active;

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
    private MenuButton btnGevondenPlaats;
    @FXML
    private ToggleGroup plaats;
    @FXML
    private ToggleGroup IATA;
    @FXML
    private ToggleGroup IATA_VAN;
    @FXML
    private ToggleGroup IATA_NAAR;
    @FXML
    private MenuButton btnVliegveldID;
    @FXML
    private MenuButton btnVanVliegveldID;
    @FXML
    private MenuButton btnNaarVliegveldID;
    @FXML
    private ScrollPane formulierLeeg;

    private String datum;
    private String tijd;
    private String lostAndFound;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private String bagagelabel;
    private String vluchtnummer;
    private String typeBagage;
    private String merk;
    private String bijzondereOpmerking;
    private String van;
    private String naar;
    private String ralcode1;
    private String ralcode2;
    private String iataString;
    private String gevondenPlaats;

    @FXML
    void insturen(ActionEvent insturen) throws SQLException {
        System.out.println("KNOP INSTUREN INGEDRUKT");

        TextField[] reqFields = new TextField[]{


        };

        DatePicker[] datePickers = new DatePicker[]{
            txtDatum

        };

        TextField[] PhoneFields = new TextField[]{};

        TextField[] reqIntFields = new TextField[]{
            
                
        };

        MenuButton[] reqMenuButtons = new MenuButton[]{
            btnVliegveldID,
            btnVanVliegveldID,
            btnNaarVliegveldID,
            btnGevondenPlaats

        };

        boolean form = true ;//FormulierCheck.verification(reqIntFields, PhoneFields, datePickers, reqIntFields, reqMenuButtons);
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
            
            sendToDatabase();
        }
        
    }

    /**
     * Creates a prepared statement that sends an INSERT query to the database
     * for the Gevonden Bagage table
     *
     * @throws SQLException
     */
    public void sendToDatabase() throws SQLException {
        // Making a new prepared statement 
        PreparedStatement myStmt = null;
        Connection conn = null;
        ConnectDB db = new ConnectDB();
        int numberAffected = 0;

        // Updates persoonsgegevens
        String persoonsgegevens = "INSERT INTO `bagage` "
                + "(`State`, `Date`,`Time`, `Labelnumber`, `Type`, "
                + "`Brand`,`Color1`, `Color2`, `Characteristics`, `Airport`,"
                + "`Initial`, `Insertion`, `Surname`, "
                + "`Flightnumber`, `From`, `To`) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = db.getDBConnection();
            myStmt = conn.prepareStatement(persoonsgegevens);
            // Filling in the question marks from the query
            myStmt.setString(1, "Found");
            myStmt.setString(2, datum);
            myStmt.setString(3, tijd);
            myStmt.setString(4, bagagelabel);
            myStmt.setString(5, typeBagage);
            myStmt.setString(6, merk);
            myStmt.setString(7, ralcode1);
            myStmt.setString(8, ralcode2);
            myStmt.setString(9, bijzondereOpmerking);
            myStmt.setString(10, iataString);
            myStmt.setString(11, voorletters);
            myStmt.setString(12, tussenvoegsel);
            myStmt.setString(13, achternaam);
            myStmt.setString(14, vluchtnummer);
            myStmt.setString(15, van);
            myStmt.setString(16, naar);
//            myStmt.setString(0, lostAndFound);
//            myStmt.setString(0, gevondenPlaats);

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
    public void plaatsDropDown(ActionEvent event) {
        RadioMenuItem item = (RadioMenuItem) plaats.getSelectedToggle();
        gevondenPlaats = item.getText();
        btnGevondenPlaats.setText(gevondenPlaats);
        System.out.println(gevondenPlaats);
        
    }
    
    @FXML
    public void vanDropDown(ActionEvent event) {
        RadioMenuItem iattaItem = (RadioMenuItem) IATA_VAN.getSelectedToggle();
        van = iattaItem.getText();
        btnVanVliegveldID.setText(van);
        System.out.println(van);
        
    }

    @FXML
    public void naarDropDown(ActionEvent event) {
        RadioMenuItem iattaItem = (RadioMenuItem) IATA_NAAR.getSelectedToggle();
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
    
    public void exportPDF(ActionEvent event) throws IOException {
        PDFExport convert = new PDFExport();
        convert.addPage();
        convert.savePDF();
    }
        /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
