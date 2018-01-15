/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem.classes;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class Medewerker {
    
    int id;
    String acountnaam;
    String wachtwoord;
    int rol;
    int block;

    public Medewerker(int id, String acountnaam, String wachtwoord, int rol, int block) {
        this.id = id;
        this.acountnaam = acountnaam;
        this.wachtwoord = wachtwoord;
        this.rol = rol;
        this.block = block;
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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }
    
    
    
    
    
}
