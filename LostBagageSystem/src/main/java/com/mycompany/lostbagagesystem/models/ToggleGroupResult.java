/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem.models;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class ToggleGroupResult {

    private static String pick;

    public static String getPick(final ToggleGroup group) {
        RadioButton selectedButton = (RadioButton) group.getSelectedToggle();
        pick = selectedButton.getText();

        return pick;
    }

}
