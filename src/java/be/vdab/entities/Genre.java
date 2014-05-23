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
public class Genre {
    private long genreNr;
    private String Naam;
    
    public Genre(long genreNr, String Naam) {
        setGenreNr(genreNr);
        setNaam(Naam);
    }
    
    public void setGenreNr(long genreNr) {
        this.genreNr=genreNr;
    }
    public long getGenreNr() {
        return genreNr;
    }
    
    public void setNaam(String Naam) {
        this.Naam = Naam;
    }
    public String getNaam() {
        return Naam;
    }
}
