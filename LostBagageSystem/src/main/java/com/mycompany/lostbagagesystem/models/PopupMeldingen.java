/*This class has the model for the Warning Popup If fields are not correctly filled
 */
package com.mycompany.lostbagagesystem.models;

import com.mycompany.lostbagagesystem.classes.language;
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
        alert.setTitle(language.getTranslationString("TLK211"));
        alert.setHeaderText(null);
        alert.setContentText(language.getTranslationString("TLK211"));

        alert.showAndWait();

    }

    public static void warningBoxPass() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(language.getTranslationString("TLK105"));
        alert.setHeaderText(null);
        alert.setContentText(language.getTranslationString("TLK105"));

        alert.showAndWait();

    }

    public static void gegevensVerstuurd() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(language.getTranslationString("TLK207"));
        alert.setHeaderText(null);
        alert.setContentText(language.getTranslationString("TLK207"));

        alert.showAndWait();

    }

}
