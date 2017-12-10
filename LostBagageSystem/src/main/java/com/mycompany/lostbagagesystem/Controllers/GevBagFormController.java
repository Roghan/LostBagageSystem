/*Controller Class voor het gevonden bagage Formulier
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.MainApp;
import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.VermisteBagageFormulier;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import sun.applet.Main;

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
    
    private String datum;
    private String tijd;
    private String vliegveldID;
    private String lostAndFound;
    private String voorLetters;
    private String tussenVoegsel;
    private String achternaam;
    private String gender;
    private String labelNummer;
    private String vluchtNummer;
    private String bestemming;
    private String typeBagage;
    private String merkBagage;
    private String bijzondereOpmerking;
    
    private String colour;
    private String colour2;
    private String colour3;
    
    
    public void sendToDatabase() throws SQLException {
        PreparedStatement myStmt = null;
        int numberAffected = 0;
        ConnectDB db = new ConnectDB();
        
        String query = String.format("INSERT INTO `gevondenbagage` "
                + "(`voorletters`,`tussenvoegsel`, `achternaam`)"
                + " VALUES(?, ?, ?)");
        
        try {
            myStmt = db.getDBConnection().prepareStatement(query);
            myStmt.setString(1, voorLetters);
            myStmt.setString(2, tussenVoegsel);
            myStmt.setString(3, achternaam);
            
            // execute INSERT sql statement
            numberAffected = myStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (myStmt != null) {
                myStmt.close();
            }
            
        }


        System.out.println(numberAffected);

        System.out.println(datum);

    }
    
//    @FXML
//    void insturen(ActionEvent insturen) {
//        System.out.println("KNOP INSTUREN INGEDRUKT");
//        GevBagageFormulier vermistBagForm = new GevBagageFormulier(
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
