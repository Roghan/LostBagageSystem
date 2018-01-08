/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem.models;

import com.mycompany.lostbagagesystem.classes.Language;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class FormulierCheck {

    private static boolean fieldsAreFilled;
    private static boolean phoneIsInt;
    private static boolean txtIsNotInt;
    private static int totalArrayLenght;
    private static boolean txtIsInt;
    private static boolean menuButtonIsFilled;

    public static boolean verification(TextField[] reqTextFields, TextField[] PhoneFields, DatePicker[] datePickers, TextField[] intTextFields, MenuButton[] reqMenuButtons) {

        totalArrayLenght = (reqTextFields.length + datePickers.length + PhoneFields.length + intTextFields.length + reqMenuButtons.length);
        fieldsAreFilled = fieldsAreFilled(reqTextFields, datePickers, PhoneFields, intTextFields, totalArrayLenght, reqMenuButtons);
        phoneIsInt = isInteger(PhoneFields);
        txtIsNotInt = isNotInteger(reqTextFields);
        txtIsInt = isTextFieldInteger(intTextFields);
        menuButtonIsFilled = isMenuButtonFilled(reqMenuButtons);

        return checkForm(reqTextFields, PhoneFields, datePickers, intTextFields, reqMenuButtons);

    }

    public static boolean checkForm(TextField[] reqTextFields, TextField[] PhoneFields, DatePicker[] datePickers, TextField[] intTextFields, MenuButton menuButtons[]) {
        System.out.println(fieldsAreFilled);
        System.out.println(phoneIsInt);
        System.out.println(txtIsNotInt);
        System.out.println(txtIsInt);
        System.out.println(menuButtonIsFilled);
        if (fieldsAreFilled) {
            if (phoneIsInt && txtIsNotInt && txtIsInt && menuButtonIsFilled) {
                System.out.println("Document is goed ingevuld");
                return true;

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
                    for (int i = 0; i < reqTextFields.length; i++) {
                        boolean wrongField = isWrongField(reqTextFields[i]);
                        if (wrongField) {
                            reqFieldWarning(reqTextFields[i]);

                        }
                    }
                    PopupNietIngevuldeVelden.warningBoxText();

                }

                if (txtIsInt != true) {
                    for (int i = 0; i < intTextFields.length; i++) {
                        boolean wrongField = isWrongField(intTextFields[i]);
                        if (wrongField != true) {
                            reqFieldWarning(intTextFields[i]);

                        }
                    }

                    PopupNietIngevuldeVelden.warningBoxIsNotInt();
                }

            }

        } else {

            System.out.println("WARNING BOX TRIGGER");
            warningBox();

        }
        return false;
    }

    public static boolean fieldsAreFilled(TextField reqTextFields[], DatePicker datePickers[], TextField PhoneFields[], TextField intIsTextField[], int totalArrayLenght, MenuButton[] reqMenuButtons) {
        boolean[] checkList = new boolean[totalArrayLenght];
        //Set initial Count for Boolean array
        int count = 0;

        //Check Req Text Fields
        if (reqTextFields.length != 0) {
            for (TextField reqField : reqTextFields) {
                checkList[count] = reqTextFieldsCheck(reqField);
                System.out.println(checkList[count] + " REQ  TEXT FIELDS");
                count++;

            }

        }

        //Check Req Date Fields
        if (datePickers.length != 0) {
            for (DatePicker datePicker : datePickers) {
                checkList[count] = datePickerCheck(datePicker);
                System.out.println(checkList[count] + " REQ DATE FIELDS");
                count++;

            }

        }

        //Check if text fields are ints
        if (intIsTextField.length != 0) {
            for (int i = 0; i < intIsTextField.length; i++) {
                checkList[count] = reqTextFieldsCheck(intIsTextField[i]);
                System.out.println(checkList[count] + " REQ TEXT IS INT");
                count++;
            }

        }
        //Check Menu Buttons
        if (reqMenuButtons.length != 0) {
            for (int i = 0; i < reqMenuButtons.length; i++) {
                checkList[count] = menuButtonCheck(reqMenuButtons[i]);
                System.out.println(checkList[count] + "MENU BUTTON");
                count++;
            }

        }

        //Check Phone Fields
        if (PhoneFields.length != 0) {
            //Set initial Phone fields
            int phoneCount = 0;

            //Start loop trough Phone Fields
            do {

                //Checks the phone fields
                if (phoneFieldCheck(PhoneFields[phoneCount]) != true) {

                    //resets phone fields error when one field is filled
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

        }

        boolean formIsComplete = true;

        for (int i = 0; i < checkList.length; i++) {
            System.out.println(checkList[i] + " Checklist Status ");
            if (checkList[i]) {
                formIsComplete = false;
                break;

            }

        }
        return formIsComplete;
    }

    public static boolean reqTextFieldsCheck(TextField textField) {

        boolean fieldNotFilled = false;

        if (textField.getText().trim().isEmpty()) {
            reqFieldWarning(textField);
            fieldNotFilled = true;
        } else {
            reqFieldWarningReset(textField);
        }

        return fieldNotFilled;
    }

    public static boolean datePickerCheck(DatePicker datePicker) {
        boolean check = false;

        try {

            String datum = datePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            datePicker.setStyle("");

        } catch (Exception e) {
            datePicker.setStyle("-fx-border-color : #ff0000;");
            check = true;

        }
        return check;
    }

    public static boolean phoneFieldCheck(TextField textField) {
        boolean check;
        check = textField.getText().isEmpty();

        return check;
    }

    public static boolean menuButtonCheck(MenuButton menuButton) {
        boolean check;
        boolean result;
        check = (menuButton.getText().equals(Language.getTranslationString("TLK6")) != true
                && menuButton.getText().equals(Language.getTranslationString("TLK130")) != true
                && menuButton.getText().equals(Language.getTranslationString("TLK131")) != true
                && menuButton.getText().equals(Language.getTranslationString("TLK106")) != true);
        if (check != true) {
            menuButton.setStyle("-fx-border-color : #ff0000;");
            return true;

        } else {
            menuButton.setStyle("");
            return false;

        }

    }

    public static void reqFieldWarning(TextField textField) {
        textField.setStyle("-fx-border-color : #ff0000;");

    }

    public static void reqFieldWarningReset(TextField textField) {
        textField.setStyle("");

    }

    public static void warningBox() {
        PopupNietIngevuldeVelden.warningBox();

    }

    public static boolean isInteger(TextField[] phoneFields) {

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

    public static boolean isTextFieldInteger(TextField[] intTextFields) {

        boolean isValidInteger = false;
        for (int i = 0; i < intTextFields.length; i++) {
            try {
                Long.parseLong(intTextFields[i].getText());

                // s is a valid integer
                isValidInteger = true;
            } catch (NumberFormatException ex) {
                // s is not an integer
            }

        }

        return isValidInteger;
    }

    public static boolean isNotInteger(TextField textField[]) {
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

    public static boolean isWrongField(TextField textField) {
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

    public static boolean isMenuButtonFilled(MenuButton menuButton[]) {
        boolean menuButtonStatus = true;
        for (int i = 0; i < menuButton.length; i++) {
            if (menuButton[i].getText().equals(Language.getTranslationString("TLK6"))
                    || menuButton[i].getText().equals(Language.getTranslationString("TLK130"))
                    || menuButton[i].getText().equals(Language.getTranslationString("TLK131"))
                    || menuButton[i].getText().equals(Language.getTranslationString("TLK106"))) {
                menuButtonStatus = false;
                System.out.println(menuButtonStatus + " MENU BUTTON STATE ");
                break;

            }

        }
        return menuButtonStatus;
    }

}
