/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem.models;

/**
 *
 * @author User
 */
public class bagageTabel {
        private String registration_nr;
        private String date_found;
        private String time_found;
        private String luggage_type;
        private String brand;
        private String arrived_with_flight;
        private String luggage_tag;
        private String location_found;
        private String main_color;
        private String second_color;
        private String size;
        private String weight;
        private String passanger_name;
        private String city;
        private String other_characteristics;
        
    public bagageTabel(String registration_nr, String date_found, String time_found, String luggage_type, String brand, String arrived_with_flight, String luggage_tag, String location_found, String main_color, String second_color, String size, String weight, String passanger_name, String city, String other_characteristics) {
        this.registration_nr = registration_nr;
        this.date_found = date_found;
        this.time_found = time_found;
        this.luggage_type = luggage_type;
        this.brand = brand;
        this.arrived_with_flight = arrived_with_flight;
        this.luggage_tag = luggage_tag;
        this.location_found = location_found;
        this.main_color = main_color;
        this.second_color = second_color;
        this.size = size;
        this.weight = weight;
        this.passanger_name = passanger_name;
        this.city = city;
        this.other_characteristics = other_characteristics;
    }

    public String getRegistration_nr() {
        return registration_nr;
    }

    public void setRegistration_nr(String registration_nr) {
        this.registration_nr = registration_nr;
    }

    public String getDate_found() {
        return date_found;
    }

    public void setDate_found(String date_found) {
        this.date_found = date_found;
    }

    public String getTime_found() {
        return time_found;
    }

    public void setTime_found(String time_found) {
        this.time_found = time_found;
    }

    public String getLuggage_type() {
        return luggage_type;
    }

    public void setLuggage_type(String luggage_type) {
        this.luggage_type = luggage_type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getArrived_with_flight() {
        return arrived_with_flight;
    }

    public void setArrived_with_flight(String arrived_with_flight) {
        this.arrived_with_flight = arrived_with_flight;
    }

    public String getLuggage_tag() {
        return luggage_tag;
    }

    public void setLuggage_tag(String luggage_tag) {
        this.luggage_tag = luggage_tag;
    }

    public String getLocation_found() {
        return location_found;
    }

    public void setLocation_found(String location_found) {
        this.location_found = location_found;
    }

    public String getMain_color() {
        return main_color;
    }

    public void setMain_color(String main_color) {
        this.main_color = main_color;
    }

    public String getSecond_color() {
        return second_color;
    }

    public void setSecond_color(String second_color) {
        this.second_color = second_color;
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

    public String getPassanger_name() {
        return passanger_name;
    }

    public void setPassanger_name(String passanger_name) {
        this.passanger_name = passanger_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOther_characteristics() {
        return other_characteristics;
    }

    public void setOther_characteristics(String other_characteristics) {
        this.other_characteristics = other_characteristics;
    }

    
}
