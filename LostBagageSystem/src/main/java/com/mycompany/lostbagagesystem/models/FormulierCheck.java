/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem.models;

import com.mycompany.lostbagagesystem.classes.ConnectDB;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class FormulierCheck {

    public static void verificaton(TextField[] reqFields, TextField[] PhoneFields, DatePicker[] datePickers) {
        
        int totalArrayLenght = (reqFields.length + datePickers.length + PhoneFields.length);
        boolean fieldsAreFilled = fieldsAreFilled(reqFields, datePickers, PhoneFields, totalArrayLenght);
        boolean phoneIsInt = isInteger(PhoneFields);
        boolean txtIsNotInt = isNotInteger(reqFields);

        checkForm(fieldsAreFilled, phoneIsInt, txtIsNotInt, reqFields, PhoneFields, datePickers);
    }

    public static void checkForm(boolean fieldsAreFilled, boolean phoneIsInt, boolean txtIsNotInt,
            TextField[] reqFields, TextField[] PhoneFields, DatePicker[] datePickers) {

        if (fieldsAreFilled) {
            if (phoneIsInt && txtIsNotInt) {
                System.out.println("Document is goed ingevuld");
                //sendToDatabase();

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
                    for (int i = 0; i < reqFields.length; i++) {
                        boolean wrongField = isWrongField(reqFields[i]);
                        if (wrongField) {
                            reqFieldWarning(reqFields[i]);

                        }
                    }

                }

            }

        } else {

            System.out.println("WARNING BOX TRIGGER");
            warningBox();
        }

    }

    public static boolean fieldsAreFilled(TextField reqFields[], DatePicker datePickers[], TextField PhoneFields[], int totalArrayLenght) {
        boolean[] checkList = new boolean[totalArrayLenght];
        int count = 0;

        for (TextField reqField : reqFields) {
            checkList[count] = reqFieldsCheck(reqField);
            count++;
        }

        for (DatePicker datePicker : datePickers) {
            checkList[count] = datePickerCheck(datePicker);
            count++;
        }
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

        boolean formIsComplete = true;

        for (int i = 0; i < checkList.length; i++) {
            if (checkList[i]) {
                formIsComplete = false;
                break;

            }

        }
        return formIsComplete;
    }

    public static boolean reqFieldsCheck(TextField textField) {

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

    public static boolean isInteger(TextField phoneFields[]) {

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
