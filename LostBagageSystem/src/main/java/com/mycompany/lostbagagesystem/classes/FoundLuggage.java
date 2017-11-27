/*This Class is the main class for the found luggage Form in the Lost Bagage System
 */
package com.mycompany.lostbagagesystem.classes;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class FoundLuggage {

    private String registrationNumber;
    private String dateFound;
    private String timeFound;
    private String luggageType;
    private String brand;
    


    public FoundLuggage(String registrationNumber, String dateFound, String timeFound, String luggageType, String brand) {
        this.registrationNumber = registrationNumber;
        this.dateFound = dateFound;
        this.timeFound = timeFound;
        this.luggageType = luggageType;
        this.brand = brand;    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getDateFound() {
        return dateFound;
    }

    public void setDateFound(String dateFound) {
        this.dateFound = dateFound;
    }

    public String getTimeFound() {
        return timeFound;
    }

    public void setTimeFound(String timeFound) {
        this.timeFound = timeFound;
    }

    public String getLuggageType() {
        return luggageType;
    }

    public void setLuggageType(String luggageType) {
        this.luggageType = luggageType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    
    

}
