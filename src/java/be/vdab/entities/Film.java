/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.entities;

import java.math.BigDecimal;

/**
 *
 * @author kamil.laga
 */
public class Film {
    private long filmNr;
    private long genreNr;
    private String titel;
    private long voorraad;
    private long gereserveerd;
    private BigDecimal prijs;
    private long beschikbaar;
    
    public Film(long filmNr, long genreNr, String titel, long voorraad, long gereserveerd, BigDecimal prijs) {
        setFilmNr(filmNr);
        setGenreNr(genreNr);
        setTitel(titel);
        setVoorraad(voorraad);
        setGereserveerd(gereserveerd);
        setPrijs(prijs);
    }
    

    public long getFilmNr() {
        return filmNr;
    }
    public void setFilmNr(long filmNr) {
        this.filmNr = filmNr;
    }

    public long getGenreNr() {
        return genreNr;
    }
    public void setGenreNr(long genreNr) {
        this.genreNr = genreNr;
    }

    public String getTitel() {
        return titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }

    public long getVoorraad() {
        return voorraad;
    }
    public void setVoorraad(long voorraad) {
        this.voorraad = voorraad;
    }

    public long getGereserveerd() {
        return gereserveerd;
    }
    public void setGereserveerd(long gereserveerd) {
        this.gereserveerd = gereserveerd;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }
    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }
    
    public long getBeschikbaar() {
        return voorraad - gereserveerd;
    }
}
