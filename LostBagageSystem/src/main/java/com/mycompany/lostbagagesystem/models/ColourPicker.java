/*Model to return a RAL value based on colour selection
 */
package com.mycompany.lostbagagesystem.models;

import com.mycompany.lostbagagesystem.classes.Language;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class ColourPicker {

    private static String ralCode;

    public static String GetColour(String colour) {

        if (Language.getTranslationString("TLK63").equals(colour)) {
            ralCode = "1003";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK59").equals(colour)) {
            ralCode = "1024";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK107").equals(colour)) {
            ralCode = "2004";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK51").equals(colour)) {
            ralCode = "3000";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK108").equals(colour)) {
            ralCode = "3005";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK61").equals(colour)) {
            ralCode = "3017";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK65").equals(colour)) {
            ralCode = "4005";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK109").equals(colour)) {
            ralCode = "4010";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK53").equals(colour)) {
            ralCode = "5002";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK110").equals(colour)) {
            ralCode = "5015";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK111").equals(colour)) {
            ralCode = "5022";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK64").equals(colour)) {
            ralCode = "6004";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK56").equals(colour)) {
            ralCode = "6002";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK112").equals(colour)) {
            ralCode = "6022";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK113").equals(colour)) {
            ralCode = "6038";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK62").equals(colour)) {
            ralCode = "7015";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK114").equals(colour)) {
            ralCode = "9011";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK115").equals(colour)) {
            ralCode = "7000";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK116").equals(colour)) {
            ralCode = "8002";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK117").equals(colour)) {
            ralCode = "8011";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK118").equals(colour)) {
            ralCode = "8023";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK54").equals(colour)) {
            ralCode = "9001";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK50").equals(colour)) {
            ralCode = "9005";
            System.out.println(ralCode);
        } else if (Language.getTranslationString("TLK119").equals(colour)) {
            ralCode = "1015";
            System.out.println(ralCode);
        }

        return ralCode;
    }

    public static String GetColourExcel(String colour) {

        if (colour.equals("Yellow")) {
            ralCode = "1003";
            System.out.println(ralCode);
        } else if (colour.equals("Olive")) {
            ralCode = "1024";
            System.out.println(ralCode);
        } else if (colour.equals("Orange")) {
            ralCode = "2004";
            System.out.println(ralCode);
        } else if (colour.equals("Red")) {
            ralCode = "3000";
            System.out.println(ralCode);
        } else if (colour.equals("Darkred")) {
            ralCode = "3005";
            System.out.println(ralCode);
        } else if (colour.equals("Pink")) {
            ralCode = "3017";
            System.out.println(ralCode);
        } else if (colour.equals("Purple")) {
            ralCode = "4005";
            System.out.println(ralCode);
        } else if (colour.equals("Violet")) {
            ralCode = "4010";
            System.out.println(ralCode);
        } else if (colour.equals("Blue")) {
            ralCode = "5002";
            System.out.println(ralCode);
        } else if (colour.equals("Lightblue")) {
            ralCode = "5015";
            System.out.println(ralCode);
        } else if (colour.equals("Darkblue")) {
            ralCode = "5022";
            System.out.println(ralCode);
        } else if (colour.equals("Bluegreen")) {
            ralCode = "6004";
            System.out.println(ralCode);
        } else if (colour.equals("Green")) {
            ralCode = "6002";
            System.out.println(ralCode);
        } else if (colour.equals("Darkgreen")) {
            ralCode = "6022";
            System.out.println(ralCode);
        } else if (colour.equals("Lightgreen")) {
            ralCode = "6038";
            System.out.println(ralCode);
        } else if (colour.equals("Gray")) {
            ralCode = "7015";
            System.out.println(ralCode);
        } else if (colour.equals("Darkgray")) {
            ralCode = "9011";
            System.out.println(ralCode);
        } else if (colour.equals("Lightgray")) {
            ralCode = "7000";
            System.out.println(ralCode);
        } else if (colour.equals("Brown")) {
            ralCode = "8002";
            System.out.println(ralCode);
        } else if (colour.equals("Darkbrown")) {
            ralCode = "8011";
            System.out.println(ralCode);
        } else if (colour.equals("Lightbrown")) {
            ralCode = "8023";
            System.out.println(ralCode);
        } else if (colour.equals("White")) {
            ralCode = "9001";
            System.out.println(ralCode);
        } else if (colour.equals("Black")) {
            ralCode = "9005";
            System.out.println(ralCode);
        } else if (colour.equals("Cream")) {
            ralCode = "1015";
            System.out.println(ralCode);
        }

        return ralCode;
    }

}
