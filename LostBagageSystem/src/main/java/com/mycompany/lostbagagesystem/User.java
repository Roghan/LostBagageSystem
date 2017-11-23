/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lostbagagesystem;

/**
 *
 * @author Youri
 */
class User {

    private int id;
    private String werknemer;
    private String locatie;
    private boolean actief;

    public User(int id, String werknemer, String locatie, boolean actief) {
        this.id = id;
        this.werknemer = werknemer;
        this.locatie = locatie;
        this.actief = actief;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return werknemer;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String werknemer) {
        this.werknemer = werknemer;
    }

    /**
     * @return the registerDate
     */
    public String getlocatie() {
        return locatie;
    }

    /**
     * @param registerDate the registerDate to set
     */
    public void setRegisterDate(String locatie) {
        this.locatie = locatie;
    }

    /**
     * @return the active
     */
    public boolean isactief() {
        return actief;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean actief) {
        this.actief = actief;
    }
}
