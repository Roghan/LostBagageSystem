/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem.models;

/**
 *
 * @author Youri
 */
public class DbNaam {

    private int id;
    private String acountnaam;
    private String wachtwoord;
    private String voornaam;
    private String achternaam;
    private String geboortedatum;
    private String postcode;
    private String huisnummer;    
    private String telefoonnummer;
    private int manVrouw;
    private int rol;    
    private int blok;

    public DbNaam(int id, String acountnaam, String wachtwoord, 
            String voornaam, String achternaam, String geboortedatum, 
            String postcode, String huisnummer, String telefoonnummer, 
            int manVrouw, int rol, int blok) {
        this.id = id;
        this.acountnaam = acountnaam;
        this.wachtwoord = wachtwoord;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.telefoonnummer = telefoonnummer;
        this.manVrouw = manVrouw;
        this.rol = rol;
        this.blok = blok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcountnaam() {
        return acountnaam;
    }

    public void setAcountnaam(String acountnaam) {
        this.acountnaam = acountnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public int getManVrouw() {
        return manVrouw;
    }

    public void setManVrouw(int manVrouw) {
        this.manVrouw = manVrouw;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getBlok() {
        return blok;
    }

    public void setBlok(int blok) {
        this.blok = blok;
    }


}
