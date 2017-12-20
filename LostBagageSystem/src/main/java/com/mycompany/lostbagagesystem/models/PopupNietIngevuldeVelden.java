/*This class has the model for the Warning Popup If fields are not correctly filled
 */
package com.mycompany.lostbagagesystem.models;

import javafx.scene.control.Alert;

/**
 *
 * @author MarcelVanWilgenburg
 */
public class PopupNietIngevuldeVelden {

    /**
     *
     */
    public static void warningBox() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("informatie vereist");
        alert.setHeaderText(null);
        alert.setContentText("Vul alle vereiste informatie in!");

        alert.showAndWait();

    }

    public static void warningBoxPhone() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Telefoonnummer");
        alert.setHeaderText(null);
        alert.setContentText("Telefoonnummer mag alleen uit cijfers bestaan");

        alert.showAndWait();

    }

    public static void warningBoxText() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Text");
        alert.setHeaderText(null);
        alert.setContentText("Textvelden mogen geen cijfers bevatten!");

        alert.showAndWait();

    }

    public static void warningBoxIsNotInt() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Text");
        alert.setHeaderText(null);
        alert.setContentText("Cijfer velden mogen alleen cijfers Bevatten");

        alert.showAndWait();

    }

}
