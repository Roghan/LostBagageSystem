/*Controller Class voor het SchadeFormulier
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.models.FormulierCheck;
import com.mycompany.lostbagagesystem.models.ToggleGroupResult;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
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

    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private String geboortedatum;
    private String landnaam;
    private String gender;
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
    private String bijzondereKenmerken;
    private String schadeDatum;
    private String datumBeginReis;
    private String schadeTijd;
    private String schadePlaats;
    private String schadeLand;

    private String colour;
    private String colour2;
    private String colour3;

//    @FXML
//    public void annuleren(ActionEvent event) throws IOException {
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Medewerkersscherm.fxml"));
//        TableLeeg2.getChildren().setAll();
//        TableLeeg2.getChildren().setAll(pane);
//        pane.prefWidthProperty().bind(TableLeeg2.widthProperty());
//        pane.prefHeightProperty().bind(TableLeeg2.heightProperty());
//
//    }
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
        gender = ToggleGroupResult.getPick(genderGroup);
        bankRekening = txtBankrekening.getText();
        straatnaam = txtStraatnaam.getText();
        huisnummer = txtHuisNummer.getText();
        postcode = txtPostcode.getText();
        woonplaats = txtWoonplaats.getText();
        email = txtEmail.getText();
        telefoon = txtTelefoon.getText();
        mobiel = txtMobielNummer.getText();
        bagageLabel = null;
        typeBagage = null;
        merkBagage = null;
        bijzondereKenmerken = null;
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

        FormulierCheck.verification(reqTextFields, PhoneFields, datePickers, reqIntFields);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
