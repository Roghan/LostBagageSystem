/*Controller Class voor het vermiste BagageScherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.VermisteBagageFormulier;
import com.mycompany.lostbagagesystem.models.ToggleGroupResult;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
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

/**
 *
 * @author Marcel van Wilgenburg
 */
public class VermistBagFormController implements Initializable {

    @FXML
    private TextField txtVliegveldID;
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
    private TextField txtGeboorteDatum;
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

    private String time;
    private LocalDate datum;
    private String vliegveldID;
    private String voorLetters;
    private String tussenVoegsel;
    private String achterNaam;
    private String geboorteDatum;
    private String gender;
    private String landNaam;
    private String straatNaam;
    private String huisNummer;
    private String postCode;
    private String woonPlaats;
    private String email;
    private String telefoonNummer;
    private String mobielNummer;
    private String labelNummer;
    private String vluchtNummer;
    private String bestemming;
    private String bagageLabel;
    private String typeBagage;
    private String merk;
    private String bijzondereOpmerking;

    private String colour;
    private String colour2;
    private String colour3;

    @FXML
    void annuleren3(ActionEvent event) {

    }

    @FXML
    void insturen(ActionEvent insturen) {
        System.out.println("KNOP INSTUREN INGEDRUKT");
        VermisteBagageFormulier vermistBagForm = new VermisteBagageFormulier(
                time,
                datum,
                vliegveldID,
                voorLetters,
                tussenVoegsel,
                achterNaam,
                geboorteDatum,
                landNaam,
                gender,
                straatNaam,
                huisNummer,
                postCode,
                woonPlaats,
                email,
                telefoonNummer,
                mobielNummer,
                labelNummer,
                vluchtNummer,
                bestemming,
                bagageLabel,
                typeBagage,
                merk,
                bijzondereOpmerking,
                colour,
                colour2,
                colour3
        );

        time = txtTime.getText();
        datum = txtDatum.getValue();
        vliegveldID = txtVliegveldID.getText();
        voorLetters = txtVoorletters.getText();
        tussenVoegsel = txtTussenvoegsel.getText();
        achterNaam = txtAchternaam.getText();
        geboorteDatum = txtGeboorteDatum.getText();
        landNaam = txtLandnaam.getText();
        gender = ToggleGroupResult.getPick(genderGroup);
        straatNaam = txtStraatnaam.getText();
        huisNummer = txtHuisNummer.getText();
        postCode = txtPostcode.getText();
        woonPlaats = txtWoonplaats.getText();
        email = txtEmail.getText();
        telefoonNummer = txtTelefoon.getText();
        mobielNummer = txtMobielNummer.getText();
        labelNummer = txtLabelNummer.getText();
        vluchtNummer = txtVluchtNummer.getText();
        bestemming = txtBestemming.getText();
        bagageLabel = txtBagageLabel.getText();
        typeBagage = txtTypeBagage.getText();
        merk = txtMerk.getText();
        bijzondereOpmerking = txtBijzondereOpmerking.getText();
        colour = ToggleGroupResult.getPick(kleur1);
        colour2 = ToggleGroupResult.getPick(kleur2);
        colour3 = ToggleGroupResult.getPick(kleur3);
        
        
        
        System.out.println(vermistBagForm.toString());
        
        ConnectDB db = new ConnectDB("fystestdb");


        String query = String.format("INSERT INTO `vermistebagage` "
                + "(`voorletters`,`tussenvoegsel`, `achternaam`, `geboortedatum`, `nationaliteit`)"
                + " VALUES('%s', '%s', '%s', '%s', '%s')",
                voorLetters,tussenVoegsel,achterNaam,geboorteDatum,landNaam);

        int numberAffected = db.executeUpdateQuery(query);
        System.out.println(numberAffected);

        
        
    }

    @FXML
    public File opslaanDocument() {

        return null;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
