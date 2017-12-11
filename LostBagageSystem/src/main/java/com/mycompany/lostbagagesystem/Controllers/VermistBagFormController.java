/*Controller Class voor het vermiste BagageScherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import com.mycompany.lostbagagesystem.classes.VermisteBagageFormulier;
import com.mycompany.lostbagagesystem.models.PopupNietIngevuldeVelden;
import com.mycompany.lostbagagesystem.models.ToggleGroupResult;
import com.mycompany.lostbagagesystem.models.reqFieldsCheck;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

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

    private String time;
    private String datum;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void insturen(ActionEvent insturen) {
        System.out.println("KNOP INSTUREN INGEDRUKT");

        time = txtTime.getText();
        vliegveldID = txtVliegveldID.getText();
        voorLetters = txtVoorletters.getText();
        tussenVoegsel = txtTussenvoegsel.getText();
        achterNaam = txtAchternaam.getText();
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

        TextField[] reqFields = new TextField[]{
            txtVluchtNummer,
            txtLabelNummer,
            txtBestemming,
            txtVoorletters,
            txtAchternaam,
            txtStraatnaam,
            txtHuisNummer,
            txtPostcode,
            txtVliegveldID,
            txtTime,
            txtWoonplaats,
            txtEmail,
            txtLandnaam

        };

        DatePicker[] datePickers = new DatePicker[]{
            txtDatum,
            txtGeboorteDatum

        };

        TextField[] PhoneFields = new TextField[]{
            txtTelefoon,
            txtMobielNummer

        };

        TextField[] reqIntFields = new TextField[]{};

        int totalArrayLenght = (reqFields.length + datePickers.length + PhoneFields.length);

        boolean fieldsAreFilled = fieldsAreFilled(reqFields, datePickers, PhoneFields, totalArrayLenght);
        boolean phoneIsInt = isInteger(PhoneFields);
        boolean txtIsNotInt = isNotInteger(reqFields);

        if (fieldsAreFilled) {
            if (phoneIsInt && txtIsNotInt) {
                System.out.println("Document is goed ingevuld");
                //sendToDatabase();

            } else {

                if (phoneIsInt != true) {
                    for (int i = 0; i < PhoneFields.length; i++) {

                        if (PhoneFields[i].getText().isEmpty() != true) {
                            reqFieldWarning(PhoneFields[i]);
                        }
                    }

                    PopupNietIngevuldeVelden.warningBoxPhone();
                }

                if (txtIsNotInt != true) {
                    for (int i = 0; i < reqFields.length; i++) {
                        boolean wrongField = isWrongField(reqFields[i]);
                        if (wrongField) {
                            reqFieldWarning(reqFields[i]);

                        }
                    }

                }

            }

        } else {

            System.out.println("WARNING BOX TRIGGER");
            warningBox();
        }

    }

    public boolean fieldsAreFilled(TextField reqFields[], DatePicker datePickers[], TextField PhoneFields[], int totalArrayLenght) {
        boolean[] checkList = new boolean[totalArrayLenght];
        int count = 0;

        for (TextField reqField : reqFields) {
            checkList[count] = reqFieldsCheck(reqField);
            count++;
        }

        for (DatePicker datePicker : datePickers) {
            checkList[count] = datePickerCheck(datePicker);
            count++;
        }
        int phoneCount = 0;
        do {

            if (phoneFieldChecker(PhoneFields[phoneCount]) != true) {
                for (TextField PhoneField : PhoneFields) {
                    System.out.println("TELEFOON VELD GOED");
                    checkList[count] = false;
                    count++;
                    reqFieldWarningReset(PhoneField);
                }
                phoneCount = PhoneFields.length;
            } else {
                System.out.println("TELEFOON VELD FOUT");
                reqFieldWarning(PhoneFields[phoneCount]);

                checkList[phoneCount] = true;
                phoneCount++;

            }

        } while (phoneCount < PhoneFields.length);

        boolean formIsComplete = true;

        for (int i = 0; i < checkList.length;
                i++) {
            if (checkList[i]) {
                formIsComplete = false;
                break;

            }

        }
        return formIsComplete;
    }

    public void makeVermistBagForm() {
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

    }

    public boolean reqFieldsCheck(TextField textField) {

        boolean fieldNotFilled = false;

        if (textField.getText().trim().isEmpty()) {
            reqFieldWarning(textField);
            fieldNotFilled = true;
        } else {
            reqFieldWarningReset(textField);
        }

        return fieldNotFilled;
    }

    public boolean datePickerCheck(DatePicker datePicker) {
        boolean check = false;

        try {

            datum = datePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            datePicker.setStyle("");

        } catch (Exception e) {
            datePicker.setStyle("-fx-border-color : #ff0000;");
            check = true;

        }
        return check;
    }

    public boolean phoneFieldChecker(TextField textField) {
        boolean check;
        check = textField.getText().isEmpty();

        return check;
    }

    public void reqFieldWarning(TextField textField) {
        textField.setStyle("-fx-border-color : #ff0000;");

    }

    public void reqFieldWarningReset(TextField textField) {
        textField.setStyle("");

    }

    public void sendToDatabase() {
        ConnectDB db = new ConnectDB("fystestdb");
        String query = String.format("INSERT INTO `vermistebagage` "
                + "(`voorletters`,`tussenvoegsel`, `achternaam`, `geboortedatum`, `nationaliteit`)"
                + " VALUES('%s', '%s', '%s', '%s', '%s')",
                voorLetters, tussenVoegsel, achterNaam, geboorteDatum, landNaam);

        int numberAffected = db.executeUpdateQuery(query);

        System.out.println(numberAffected);

        System.out.println(datum);

    }

    public void warningBox() {
        PopupNietIngevuldeVelden.warningBox();

    }

    public boolean isInteger(TextField phoneFields[]) {

        boolean isValidInteger = false;
        for (int i = 0; i < phoneFields.length; i++) {
            try {
                Long.parseLong(phoneFields[i].getText());

                // s is a valid integer
                isValidInteger = true;
            } catch (NumberFormatException ex) {
                // s is not an integer
            }

        }

        return isValidInteger;
    }

    public boolean isNotInteger(TextField textField[]) {
        System.out.println("CHECK NOT INT");

        boolean isNotInteger = false;
        for (int i = 0; i < textField.length; i++) {
            try {
                Long.parseLong(textField[i].getText());
                System.out.println("NOT INT FALSE");
                isNotInteger = false;
                break;

            } catch (NumberFormatException ex) {
                isNotInteger = true;
                System.out.println("NOT INT TRUE");

            }

        }

        return isNotInteger;

    }

    public boolean isWrongField(TextField textField) {
        System.out.println("CHECK WRONG FIELD");

        boolean wrongField = false;

        try {
            Long.parseLong(textField.getText());
            System.out.println("WRONG FIELD");
            wrongField = true;

        } catch (NumberFormatException ex) {
            System.out.println("NOT WRONG FIELD");

        }

        return wrongField;

    }

}
