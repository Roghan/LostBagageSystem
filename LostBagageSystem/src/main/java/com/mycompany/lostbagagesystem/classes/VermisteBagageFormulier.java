/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem.classes;

import com.mycompany.lostbagagesystem.models.ToggleGroupResult;
import java.time.LocalDate;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Zilverdrake
 */
public class VermisteBagageFormulier {

    @Override
    public String toString() {

        return time + " " + datum + " " + vliegveldID + " " + voorLetters;
        
    }

    private String time;
    private LocalDate datum;
    private String vliegveldID;
    private String voorLetters;
    private String tussenVoegsel;
    private String achterNaam;
    private String geboorteDatum;
    private String landNaam;
    private String gender;
    private String straatNaam;
    private String huisNummer;
    private String postCode;
    private String woonPlaats;
    private String email;
    private String telefoonNummer;
    private String mobielNummer;
    private String labelNummer;
    private String vluchtNummer;
    private String bestemming;
    private String bagageLabel;
    private String typeBagage;
    private String merk;
    private String bijzondereOpmerking;

    private String colour;
    private String colour1;
    private String colour2;

    private ToggleGroup group;

    public VermisteBagageFormulier(String time, LocalDate datum, String vliegveldID, String voorLetters,
            String tussenVoegsel, String achterNaam, String geboorteDatum, String landNaam, String gender, String straatNaam, String huisNummer, String postCode,
            String woonPlaats, String email, String telefoonNummer, String mobielNummer, String labelNummer,
            String vluchtNummer, String bestemming, String bagageLabel, String typeBagage, String merk,
            String bijzondereOpmerking, String colour, String colour1, String colour2) {
        this.time = time;
        this.datum = datum;
        this.vliegveldID = vliegveldID;
        this.voorLetters = voorLetters;
        this.tussenVoegsel = tussenVoegsel;
        this.achterNaam = achterNaam;
        this.geboorteDatum = geboorteDatum;
        this.landNaam = landNaam;
        this.gender = gender;
        this.straatNaam = straatNaam;
        this.huisNummer = huisNummer;
        this.postCode = postCode;
        this.woonPlaats = woonPlaats;
        this.email = email;
        this.telefoonNummer = telefoonNummer;
        this.mobielNummer = mobielNummer;
        this.labelNummer = labelNummer;
        this.vluchtNummer = vluchtNummer;
        this.bestemming = bestemming;
        this.bagageLabel = bagageLabel;
        this.typeBagage = typeBagage;
        this.merk = merk;
        this.bijzondereOpmerking = bijzondereOpmerking;
        this.colour = colour;
        this.colour1 = colour1;
        this.colour2 = colour2;
    }

    public void setColour() {
        this.colour = ToggleGroupResult.getPick(group);
        this.colour1 = ToggleGroupResult.getPick(group);
        this.colour2 = ToggleGroupResult.getPick(group);

    }

}
