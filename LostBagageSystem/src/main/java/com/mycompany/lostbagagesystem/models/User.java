/*Test Class voor het laten zien van werknemens in een table
 */
package com.mycompany.lostbagagesystem.models;

/**
 *
 * @author
 */
public class User {

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
     * @return the werknemer
     */
    public String getWerknemer() {
        return werknemer;
    }

    /**
     * @param werknemer the werknemer to set
     */
    public void setWerknemer(String werknemer) {
        this.werknemer = werknemer;
    }

    /**
     * @return the locatie
     */
    public String getLocatie() {
        return locatie;
    }

    /**
     * @param locatie the locatie to set
     */
    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    /**
     * @return the actief
     */
    public boolean isActief() {
        return actief;
    }

    /**
     * @param actief the actief to set
     */
    public void setActief(boolean actief) {
        this.actief = actief;
    }
    
    
}
