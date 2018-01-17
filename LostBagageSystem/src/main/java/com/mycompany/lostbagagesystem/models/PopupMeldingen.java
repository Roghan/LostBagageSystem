/*This class has the model for the Warning Popup If fields are not correctly filled
 */
package com.mycompany.lostbagagesystem.models;

import com.mycompany.lostbagagesystem.classes.Language;
import javafx.scene.control.Alert;

/**
 *
 * @author MarcelVanWilgenburg
 */
public class PopupMeldingen {

    /**
     *
     */
    public static void warningBox() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(Language.getTranslationString("TLK211"));
        alert.setHeaderText(null);
        alert.setContentText(Language.getTranslationString("TLK211"));

        alert.showAndWait();

    }

    public static void warningBoxPass() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(Language.getTranslationString("TLK105"));
        alert.setHeaderText(null);
        alert.setContentText(Language.getTranslationString("TLK105"));

        alert.showAndWait();

    }

    public static void gegevensVerstuurd() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(Language.getTranslationString("TLK207"));
        alert.setHeaderText(null);
        alert.setContentText(Language.getTranslationString("TLK207"));

        alert.showAndWait();

    }

    public static void maakEerstEenSelectie() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(Language.getTranslationString("TLK212"));
        alert.setHeaderText(null);
        alert.setContentText(Language.getTranslationString("TLK212"));

        alert.showAndWait();

    }

    public static void kiesEerstEenFilter() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(Language.getTranslationString("TLK212"));
        alert.setHeaderText(null);
        alert.setContentText(Language.getTranslationString("TLK212"));

        alert.showAndWait();

    }

}
