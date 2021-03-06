package com.mycompany.lostbagagesystem.classes;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class Language {

    private static Locale currentLocale;

    public static Locale getCurrentLocale() {
        return currentLocale;
    }

    public static void setCurrentLocale(Locale currentLocale) {
        Language.currentLocale = currentLocale;
    }

    public static String getTranslationString(String TLK) {
        ResourceBundle bundle = ResourceBundle.getBundle("Bundles.Lang", currentLocale);
        String String = bundle.getString(TLK);

        return String;
    }

}
