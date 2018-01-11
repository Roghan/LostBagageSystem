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

<<<<<<< HEAD
    public DbNaam(int id, String acountnaam, String wachtwoord, int rol, int blok) {
=======
    public DbNaam(int id, String acountnaam, String wachtwoord, 
             int rol, int blok) {
>>>>>>> master
        this.id = id;
        this.acountnaam = acountnaam;
        this.wachtwoord = wachtwoord;
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
<<<<<<< HEAD
    
=======

>>>>>>> master
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
