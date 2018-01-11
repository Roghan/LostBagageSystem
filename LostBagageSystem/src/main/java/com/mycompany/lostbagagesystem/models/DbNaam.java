/*Test model voor het importeren en exporteren van data uit de database
 */
package com.mycompany.lostbagagesystem.models;

/**
 *
 * @author Youri Pel
 */
public class DbNaam {

    private int id;
    private String acountnaam;
    private String wachtwoord;
    private int rol;    
    private int blok;

    public DbNaam(int id, String acountnaam, String wachtwoord, int rol, int blok) {
        this.id = id;
        this.acountnaam = acountnaam;
        this.wachtwoord = wachtwoord;
        this.rol = rol;
        this.blok = blok;
    }

    public DbNaam(String registration_nr, String date_found, String time_found, String luggage_type, String brand, String arrived_with_flight, String luggage_tag, String location_found, String main_color, String size, String weight, String passanger_name, String city, String other_characteristics) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
