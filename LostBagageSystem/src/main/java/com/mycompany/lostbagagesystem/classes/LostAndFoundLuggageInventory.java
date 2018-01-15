/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem.classes;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class LostAndFoundLuggageInventory {

    private String registrationNr;
    private LocalDate dateFound;
    private String timeFound;
    private String luggageType;
    private String brand;
    private String flightNumber;
    private String luggageTag;
    private String locationFound;
    private String mainColor;
    private String secondColor;
    private String size;
    private String weight;
    private String passNameAndCity;
    private String charateristics;

    public LostAndFoundLuggageInventory(String registrationNr, LocalDate dateFound, String timeFound, String luggageType, String brand, String flightNumber, String luggageTag, String locationFound, String mainColor, String secondColor, String size, String weight, String passNameAndCity, String charateristics) {
        this.registrationNr = registrationNr;
        this.dateFound = dateFound;
        this.timeFound = timeFound;
        this.luggageType = luggageType;
        this.brand = brand;
        this.flightNumber = flightNumber;
        this.luggageTag = luggageTag;
        this.locationFound = locationFound;
        this.mainColor = mainColor;
        this.secondColor = secondColor;
        this.size = size;
        this.weight = weight;
        this.passNameAndCity = passNameAndCity;
        this.charateristics = charateristics;
    }

    public String getRegistrationNr() {
        return registrationNr;
    }

    public void setRegistrationNr(String registrationNr) {
        this.registrationNr = registrationNr;
    }

    public LocalDate getDateFound() {
        return dateFound;
    }

    public void setDateFound(LocalDate dateFound) {
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

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getLuggageTag() {
        return luggageTag;
    }

    public void setLuggageTag(String luggageTag) {
        this.luggageTag = luggageTag;
    }

    public String getLocationFound() {
        return locationFound;
    }

    public void setLocationFound(String locationFound) {
        this.locationFound = locationFound;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public String getSecondColor() {
        return secondColor;
    }

    public void setSecondColor(String secondColor) {
        this.secondColor = secondColor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPassNameAndCity() {
        return passNameAndCity;
    }

    public void setPassNameAndCity(String passNameAndCity) {
        this.passNameAndCity = passNameAndCity;
    }

    public String getCharateristics() {
        return charateristics;
    }

    public void setCharateristics(String charateristics) {
        this.charateristics = charateristics;
    }

}
