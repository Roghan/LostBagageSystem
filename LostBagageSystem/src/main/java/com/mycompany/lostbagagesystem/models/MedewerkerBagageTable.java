/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem.models;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class MedewerkerBagageTable {

    private String BagageID;
    private String State;
    private String Labelnumber;
    private String Type;
    private String Brand;
    private String Color1;
    private String Color2;
    private String Characteristics;
    private String Location;
    private String Airport;
    private String From;
    private String To;
    private String Passnameandcity;
    private String IsReturned;

    public MedewerkerBagageTable(String BagageID, String State, String Labelnumber, String Type, String Brand, String Color1, String Color2, String Characteristics, String Location, String Airport, String From, String To, String Passnameandcity, String IsReturned) {
        this.BagageID = BagageID;
        this.State = State;
        this.Labelnumber = Labelnumber;
        this.Type = Type;
        this.Brand = Brand;
        this.Color1 = Color1;
        this.Color2 = Color2;
        this.Characteristics = Characteristics;
        this.Location = Location;
        this.Airport = Airport;
        this.From = From;
        this.To = To;
        this.Passnameandcity = Passnameandcity;
        this.IsReturned = IsReturned;
    }

    public String getBagageID() {
        return BagageID;
    }

    public void setBagageID(String BagageID) {
        this.BagageID = BagageID;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getLabelnumber() {
        return Labelnumber;
    }

    public void setLabelnumber(String Labelnumber) {
        this.Labelnumber = Labelnumber;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public String getColor1() {
        return Color1;
    }

    public void setColor1(String Color1) {
        this.Color1 = Color1;
    }

    public String getColor2() {
        return Color2;
    }

    public void setColor2(String Color2) {
        this.Color2 = Color2;
    }

    public String getCharacteristics() {
        return Characteristics;
    }

    public void setCharacteristics(String Characteristics) {
        this.Characteristics = Characteristics;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getAirport() {
        return Airport;
    }

    public void setAirport(String Airport) {
        this.Airport = Airport;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String From) {
        this.From = From;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String To) {
        this.To = To;
    }

    public String getPassnameandcity() {
        return Passnameandcity;
    }

    public void setPassnameandcity(String Passnameandcity) {
        this.Passnameandcity = Passnameandcity;
    }

    public String getIsReturned() {
        return IsReturned;
    }

    public void setIsReturned(String IsReturned) {
        this.IsReturned = IsReturned;
    }

<<<<<<< HEAD
    @Override
    public String toString() {
        return "State : " + State + " , Labelnumber : " + Labelnumber + " , Type : " + Type + " , Characteristics : " + Characteristics + " , Passnameandcity : " + Passnameandcity;
    }

=======
>>>>>>> parent of 5fd570c... Merge branch 'master' into statistiekenScherm
}
