package com.mycompany.lostbagagesystem.models;

import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class SetRadioMenuButtonText {

    @FXML
    public static void dropDown(MenuButton button, ToggleGroup group) {
        RadioMenuItem iattaItem = (RadioMenuItem) group.getSelectedToggle();
        String item = iattaItem.getText();
        button.setText(item);
        System.out.println(item);

    }

    @FXML
    public static String kleurkiezer(MenuButton button, ToggleGroup group) {
        RadioMenuItem item = (RadioMenuItem) group.getSelectedToggle();
        String kleur = item.getText();
        button.setText(kleur);
        System.out.println(kleur);
        String ralcode = ColourPicker.GetColour(kleur);
        return ralcode;

    }

}
