/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem.models;

import java.time.format.DateTimeFormatter;
import javafx.scene.control.DatePicker;
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

    public static boolean verificaton(TextField[] reqTextFields, TextField[] PhoneFields, DatePicker[] datePickers, TextField[] intTextFields) {

        totalArrayLenght = (reqTextFields.length + datePickers.length + PhoneFields.length + intTextFields.length);
        fieldsAreFilled = fieldsAreFilled(reqTextFields, datePickers, PhoneFields, intTextFields, totalArrayLenght);
        phoneIsInt = isInteger(PhoneFields);
        txtIsNotInt = isNotInteger(reqTextFields);
        txtIsInt = isTextFieldInteger(intTextFields);

        return checkForm(fieldsAreFilled, phoneIsInt, txtIsNotInt, txtIsInt, reqTextFields, PhoneFields, datePickers, intTextFields);

    }

    public static boolean checkForm(boolean fieldsAreFilled, boolean phoneIsInt, boolean txtIsNotInt, boolean txtIsInt,
            TextField[] reqTextFields, TextField[] PhoneFields, DatePicker[] datePickers, TextField[] intTextFields) {

        if (fieldsAreFilled) {
            if (phoneIsInt && txtIsNotInt && txtIsInt) {
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

    public static boolean fieldsAreFilled(TextField reqTextFields[], DatePicker datePickers[], TextField PhoneFields[], TextField intIsTextField[], int totalArrayLenght) {
        boolean[] checkList = new boolean[totalArrayLenght];
        int count = 0;

        if (reqTextFields.length != 0) {
            for (TextField reqField : reqTextFields) {
                checkList[count] = reqTextFieldsCheck(reqField);
                count++;

            }

        }

        if (datePickers.length != 0) {
            for (DatePicker datePicker : datePickers) {
                checkList[count] = datePickerCheck(datePicker);
                count++;

            }

        }

        if (intIsTextField.length != 0) {
            for (int i = 0; i < intIsTextField.length; i++) {
                checkList[count] = reqTextFieldsCheck(intIsTextField[i]);
                count++;
            }

        }

        if (PhoneFields.length != 0) {
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

        }

        boolean formIsComplete = true;

        for (int i = 0; i < checkList.length; i++) {
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

    public static boolean phoneFieldChecker(TextField textField) {
        boolean check;
        check = textField.getText().isEmpty();

        return check;
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

}
