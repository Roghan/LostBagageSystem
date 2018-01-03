/*Controller Class voor het Toevoegen BagageToevoegenObject Scherm
 */
package com.mycompany.lostbagagesystem.Controllers;

import com.mycompany.lostbagagesystem.classes.BagageToevoegenObject;
import com.mycompany.lostbagagesystem.models.FormulierCheck;
import com.mycompany.lostbagagesystem.models.PopupNietIngevuldeVelden;
import com.mycompany.lostbagagesystem.models.ToggleGroupResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
public class ToevoegenBagageController extends VermistBagFormController {

    @FXML
    private TextField txtBagageLabel;
    @FXML
    private TextField txtTypeBagage;
    @FXML
    private TextField txtMerk;
    @FXML
    private Text Kleur1Text;
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

    private Button btnInsturen1;
    private String bagageLabel;
    private String typeBagage;
    private String merk;
    private String bijzondereOpmerking;
    private String colour;
    private String colour2;
    private String colour3;

    private static BagageToevoegenObject koffer;

    @FXML
    @Override
    void insturen(ActionEvent event) {
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

            boolean formGoedIngevuld = FormulierCheck.verification(reqTextFields, PhoneFields, datePickers, reqIntFields);
            if (formGoedIngevuld) {
                koffer = new BagageToevoegenObject(bagageLabel, typeBagage, merk, bijzondereOpmerking, colour, colour2, colour3);

            }

        }

    }

    @FXML
    void annuleren(ActionEvent event) {
        System.out.println("Knop Bagage Toevoegen Annuleren ingedrukt");

        Stage stage = (Stage) btnAnnuleren3.getScene().getWindow();

        stage.close();

    }

}
