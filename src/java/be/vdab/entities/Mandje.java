

package be.vdab.entities;

import be.vdab.DAO.FilmDAO;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author kamil.laga
 */
public class Mandje {
    private List<Film> films = new CopyOnWriteArrayList<Film>();
   
    public void addFilm(Film film){
        films.add(film);
    }
    
   public synchronized void removeByFilmNr(long filmNr){
        //Film film = filmDAO.readFilmNr(filmNr);
       for (Film film : films) {
           if (film.getFilmNr() == filmNr) {
               films.remove(film);
           }
       } 
    }
    

    public List<Film> getFilms() {
        return films;
    }
    public void setFilms(List<Film> films) {
        this.films = films;
    }
    
    public BigDecimal getTotaal(){
        BigDecimal totaal = new BigDecimal(0);
        BigDecimal prijs = new BigDecimal(0);
        for (Film film : films) {
            prijs = film.getPrijs();
            totaal = totaal.add(prijs);
        }
        return totaal;
    }
    
    public int getSize() {
        return films == null ? 0 : films.size();
    }
    
}
