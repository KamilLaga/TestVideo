/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.entities;

/**
 *
 * @author kamil.laga
 */
public class Klant {
    private long KlantNr;
    private String Familienaam;
    private String Voornaam;
    private String StraatNummer;
    private String Postcode;
    private String Gemeente;
    
    public Klant(long KlantNr, String Familienaam, String Voornaam, String StraatNummer, String Postcode, String Gemeente) {
        setKlantNr(KlantNr);
        setFamilienaam(Familienaam);
        setVoornaam(Voornaam);
        setStraatNummer(StraatNummer);
        setPostcode(Postcode);
        setGemeente(Gemeente);
    }


    public long getKlantNr() {
        return KlantNr;
    }
    public void setKlantNr(long KlantNr) {
        this.KlantNr = KlantNr;
    }

    public String getFamilienaam() {
        return Familienaam;
    }
    public void setFamilienaam(String Familienaam) {
        this.Familienaam = Familienaam;
    }

    public String getVoornaam() {
        return Voornaam;
    }
    public void setVoornaam(String Voornaam) {
        this.Voornaam = Voornaam;
    }

    public String getStraatNummer() {
        return StraatNummer;
    }
    public void setStraatNummer(String StraatNummer) {
        this.StraatNummer = StraatNummer;
    }

    public String getPostcode() {
        return Postcode;
    }
    public void setPostcode(String Postcode) {
        this.Postcode = Postcode;
    }

    public String getGemeente() {
        return Gemeente;
    }
    public void setGemeente(String Gemeente) {
        this.Gemeente = Gemeente;
    }
    

}
