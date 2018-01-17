package com.mycompany.lostbagagesystem.models;

import javafx.scene.control.RadioButton;
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
