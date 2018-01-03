/*Model to return a RAL value based on colour selection
 */
package com.mycompany.lostbagagesystem.models;

import com.mycompany.lostbagagesystem.classes.language;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class ColourPicker {

    private static String ralCode;

    public static String GetColour(String colour) {

        if (language.getTranslationString("TLK63").equals(colour)) {
            ralCode = "1003";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK59").equals(colour)) {
            ralCode = "1024";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK107").equals(colour)) {
            ralCode = "2004";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK51").equals(colour)) {
            ralCode = "3000";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK108").equals(colour)) {
            ralCode = "3005";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK61").equals(colour)) {
            ralCode = "3017";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK65").equals(colour)) {
            ralCode = "4005";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK109").equals(colour)) {
            ralCode = "4010";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK53").equals(colour)) {
            ralCode = "5002";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK110").equals(colour)) {
            ralCode = "5015";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK111").equals(colour)) {
            ralCode = "5022";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK64").equals(colour)) {
            ralCode = "6004";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK56").equals(colour)) {
            ralCode = "6002";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK112").equals(colour)) {
            ralCode = "6022";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK113").equals(colour)) {
            ralCode = "6038";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK62").equals(colour)) {
            ralCode = "7015";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK114").equals(colour)) {
            ralCode = "9011";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK115").equals(colour)) {
            ralCode = "7000";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK116").equals(colour)) {
            ralCode = "8002";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK117").equals(colour)) {
            ralCode = "8011";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK118").equals(colour)) {
            ralCode = "8023";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK54").equals(colour)) {
            ralCode = "9001";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK50").equals(colour)) {
            ralCode = "9005";
            System.out.println(ralCode);
        } else if (language.getTranslationString("TLK119").equals(colour)) {
            ralCode = "1015";
            System.out.println(ralCode);
        }

        return ralCode;
    }

}