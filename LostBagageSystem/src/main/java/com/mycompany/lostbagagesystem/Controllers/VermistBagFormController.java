/*Controller Class voor het vermiste BagageScherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.BagageToevoegenObject;
import com.mycompany.lostbagagesystem.classes.language;
import com.mycompany.lostbagagesystem.models.FormulierCheck;
import com.mycompany.lostbagagesystem.models.PopupNietIngevuldeVelden;
import com.mycompany.lostbagagesystem.models.ToggleGroupResult;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
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

    @FXML
    private ResourceBundle bundle;
    private Locale locale;

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
    private ArrayList<BagageToevoegenObject> koffers = new ArrayList<>();
    private int koffercount;
    

    @FXML
    void annuleren3(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        koffercount = 0;
        setItems();

    }

    @FXML
    void annulerenKofferToevoegen(ActionEvent event) {
        System.out.println("Knop Bagage Toevoegen Annuleren ingedrukt");

        Stage stage = (Stage) btnAnnuleren3.getScene().getWindow();

        stage.close();

    }

    @FXML
    public void bagageToevoegen(ActionEvent toevoegen) throws IOException {
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ToevoegenBagage_Vermist.fxml"), ResourceBundle.getBundle("Bundles.Lang", language.getCurrentLocale()));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Bagage Toevoegen");
        stage.setMaximized(false);
        stage.setScene(scene);
        stage.show();
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

        TextField[] reqTextFields = new TextField[]{
            txtVluchtNummer,
            txtLabelNummer,
            txtBestemming,
            txtVoorletters,
            txtAchternaam,
            txtStraatnaam,
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

        TextField[] reqIntFields = new TextField[]{
            txtHuisNummer};

        FormulierCheck.verification(reqTextFields, PhoneFields, datePickers, reqIntFields);

    }

    @FXML
    public void toevoegenKoffer(ActionEvent event) {
        System.out.println("Knop bagage Toevoegen ingedrukt");

        bagageLabel = txtBagageLabel.getText();
        typeBagage = txtTypeBagage.getText();
        merk = txtMerk.getText();
        bijzondereOpmerking = txtBijzondereOpmerking.getText();

        colour = ToggleGroupResult.getPick(kleur1);
        System.out.println(colour);
        colour2 = ToggleGroupResult.getPick(kleur2);
        System.out.println(colour2);
        colour3 = ToggleGroupResult.getPick(kleur3);
        System.out.println(colour3);

        if (colour.equals("Empty") && colour2.equals("Empty") && colour3.equals("Empty")) {
            PopupNietIngevuldeVelden.warningBox();

        } else {
            TextField[] reqTextFields = new TextField[]{
                txtBagageLabel,
                txtMerk,
                txtTypeBagage

            };
            DatePicker[] datePickers = new DatePicker[]{};

            TextField[] PhoneFields = new TextField[]{};

            TextField[] reqIntFields = new TextField[]{};

            //boolean formGoedIngevuld = FormulierCheck.verification(reqTextFields, PhoneFields, datePickers, reqIntFields);
            if (true) {
                koffers.add(koffercount, new BagageToevoegenObject(bagageLabel, typeBagage, merk, bijzondereOpmerking, colour, colour2, colour3));
               // items.add(koffers.get(koffercount).getBagageLabel());
                System.out.println(koffers.get(koffercount).getBagageLabel());

                koffercount++;

                Stage stage = (Stage) btnAnnuleren3.getScene().getWindow();

                stage.close();
                //items.add("TEST");
                setItems();

            }

        }

    }

    @FXML
    public void setItems() {
        ObservableList<String> items = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<>();
        items.add("TEST");
        listView.getItems().setAll(items);
        listView.refresh();

    }

}
