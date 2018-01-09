/*Class voor het importeren en exporteren van Bagage gegevens
 */
package com.mycompany.lostbagagesystem.models;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class bagageTabel {
        private int BagageID;
        private String Date;
        private String Time;
        private String State;
        private String Labelnumber;
        private String Type;
        private String Brand;
        private int Color1;
        private int Color2;
        private String Characteristics;
        private boolean IsReturned;
        private String Airport;
        private String Location;
        private String Initial;
        private String Insertion;
        private String Surname;
        private String Street;
        private String Housenumber;
        private String Zipcode;
        private String City;
        private String Email;
        private String Phone1;
        private String Phone2;
        private String Flightnumber;
        private String From;
        private String To;
        private String Vstreet;
        private String Vhuisnummer;
        private String Vzipcode;
        private String Vcity;
        private String Hotelname;

    public bagageTabel(int BagageID, String Date, String Time, String State, String Labelnumber, String Type, String Brand, int Color1, int Color2, String Characteristics, boolean IsReturned, String Airport, String Location, String Initial, String Insertion, String Surname, String Street, String Housenumber, String Zipcode, String City, String Email, String Phone1, String Phone2, String Flightnumber, String From, String To, String Vstreet, String Vhuisnummer, String Vzipcode, String Vcity, String Hotelname) {
        this.BagageID = BagageID;
        this.Date = Date;
        this.Time = Time;
        this.State = State;
        this.Labelnumber = Labelnumber;
        this.Type = Type;
        this.Brand = Brand;
        this.Color1 = Color1;
        this.Color2 = Color2;
        this.Characteristics = Characteristics;
        this.IsReturned = IsReturned;
        this.Airport = Airport;
        this.Location = Location;
        this.Initial = Initial;
        this.Insertion = Insertion;
        this.Surname = Surname;
        this.Street = Street;
        this.Housenumber = Housenumber;
        this.Zipcode = Zipcode;
        this.City = City;
        this.Email = Email;
        this.Phone1 = Phone1;
        this.Phone2 = Phone2;
        this.Flightnumber = Flightnumber;
        this.From = From;
        this.To = To;
        this.Vstreet = Vstreet;
        this.Vhuisnummer = Vhuisnummer;
        this.Vzipcode = Vzipcode;
        this.Vcity = Vcity;
        this.Hotelname = Hotelname;
    }

    public int getBagageID() {
        return BagageID;
    }

    public void setBagageID(int BagageID) {
        this.BagageID = BagageID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
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

    public int getColor1() {
        return Color1;
    }

    public void setColor1(int Color1) {
        this.Color1 = Color1;
    }

    public int getColor2() {
        return Color2;
    }

    public void setColor2(int Color2) {
        this.Color2 = Color2;
    }

    public String getCharacteristics() {
        return Characteristics;
    }

    public void setCharacteristics(String Characteristics) {
        this.Characteristics = Characteristics;
    }

    public boolean getIsReturned() {
        return IsReturned;
    }

    public void setIsReturned(boolean IsReturned) {
        this.IsReturned = IsReturned;
    }

    public String getAirport() {
        return Airport;
    }

    public void setAirport(String Airport) {
        this.Airport = Airport;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getInitial() {
        return Initial;
    }

    public void setInitial(String Initial) {
        this.Initial = Initial;
    }

    public String getInsertion() {
        return Insertion;
    }

    public void setInsertion(String Insertion) {
        this.Insertion = Insertion;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getHousenumber() {
        return Housenumber;
    }

    public void setHousenumber(String Housenumber) {
        this.Housenumber = Housenumber;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String Zipcode) {
        this.Zipcode = Zipcode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone1() {
        return Phone1;
    }

    public void setPhone1(String Phone1) {
        this.Phone1 = Phone1;
    }

    public String getPhone2() {
        return Phone2;
    }

    public void setPhone2(String Phone2) {
        this.Phone2 = Phone2;
    }

    public String getFlightnumber() {
        return Flightnumber;
    }

    public void setFlightnumber(String Flightnumber) {
        this.Flightnumber = Flightnumber;
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

    public String getVstreet() {
        return Vstreet;
    }

    public void setVstreet(String Vstreet) {
        this.Vstreet = Vstreet;
    }

    public String getVhuisnummer() {
        return Vhuisnummer;
    }

    public void setVhuisnummer(String Vhuisnummer) {
        this.Vhuisnummer = Vhuisnummer;
    }

    public String getVzipcode() {
        return Vzipcode;
    }

    public void setVzipcode(String Vzipcode) {
        this.Vzipcode = Vzipcode;
    }

    public String getVcity() {
        return Vcity;
    }

    public void setVcity(String Vcity) {
        this.Vcity = Vcity;
    }

    public String getHotelname() {
        return Hotelname;
    }

    public void setHotelname(String Hotelname) {
        this.Hotelname = Hotelname;
    }

}
