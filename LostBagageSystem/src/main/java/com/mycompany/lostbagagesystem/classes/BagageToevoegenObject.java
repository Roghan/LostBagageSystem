/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem.classes;

/**
 *
 * @author Zilverdrake
 */
public class BagageToevoegenObject {

    private String bagageLabel;
    private String typeBagage;
    private String merk;
    private String bijzondereOpmerking;
    private String colour;
    private String colour2;
    private String colour3;

    public BagageToevoegenObject(String bagageLabel, String typeBagage, String merk, String bijzondereOpmerking, String colour, String colour2, String colour3) {
        this.bagageLabel = bagageLabel;
        this.typeBagage = typeBagage;
        this.merk = merk;
        this.bijzondereOpmerking = bijzondereOpmerking;
        this.colour = colour;
        this.colour2 = colour2;
        this.colour3 = colour3;
    }

    public String getBagageLabel() {
        return bagageLabel;
    }

    public void setBagageLabel(String bagageLabel) {
        this.bagageLabel = bagageLabel;
    }

    public String getTypeBagage() {
        return typeBagage;
    }

    public void setTypeBagage(String typeBagage) {
        this.typeBagage = typeBagage;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getBijzondereOpmerking() {
        return bijzondereOpmerking;
    }

    public void setBijzondereOpmerking(String bijzondereOpmerking) {
        this.bijzondereOpmerking = bijzondereOpmerking;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getColour2() {
        return colour2;
    }

    public void setColour2(String colour2) {
        this.colour2 = colour2;
    }

    public String getColour3() {
        return colour3;
    }

    public void setColour3(String colour3) {
        this.colour3 = colour3;
    }

}
