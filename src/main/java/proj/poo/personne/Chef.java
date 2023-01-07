package proj.poo.personne;

import proj.poo.preparation.Plat;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chef extends Personne implements Serializable {

    private int nbEtoile;
    private int victoire;
    private List<Plat> al =  new ArrayList<>();

    private NavigableSet<Padawans> padawan = new TreeSet<>();
    public static final Logger logger = Logger.getLogger("Plat");

    public Chef() {
    }

    public Chef(int id, String nom, String prenom, String telephone, String genre, int nbEtoile,int victoire) {
        super(id, nom, prenom, telephone, genre);
        this.nbEtoile = nbEtoile;
        this.victoire=victoire;
    }



    public void creerPadawan(int id, String nom, String prenom, String telephone, String genre, LocalDate entrerEnService){
        padawan.add(new Padawans(id,nom,prenom,telephone,genre,entrerEnService));

    }


    public void ajout(Padawans padawans){
        padawan.add(padawans);
    }


    public void afficheParcallorie(Chef chef){
        for (int i =0;i<=chef.getAl().size();++i){
            logger.log(Level.INFO,""+chef.getAl().get(i).getNom()+" "+chef.getAl().get(i).calorie());
        }
    }


    public void ajoutPlat(Plat p){
        if (!connaiPlat(p)){
            al.add(p);
        }
    }


    public Boolean connaiPlat(Plat p){

        return al.contains(p);
    }


    public void ajoutEtoile(){
        if (5<victoire){
            nbEtoile=3;
        }
        if (3<victoire){
            nbEtoile=2;
        }
        if (1<victoire){
            nbEtoile=1;
        }

    }


    public int getNbEtoile() {
        return nbEtoile;
    }


    public void setNbEtoile(int nbEtoile) {
        this.nbEtoile = nbEtoile;
    }


    public List<Plat> getAl() {
        return al;
    }


    public void setAl(List<Plat> al) {
        this.al = al;
    }

    public NavigableSet<Padawans> getPadawan() {
        return padawan;
    }

    public void setPadawan(NavigableSet<Padawans> padawan) {
        this.padawan = padawan;
    }



    public int getVictoire() {
        return victoire;
    }
    public void setVictoire(int victoire) {
        this.victoire = victoire;
    }

}
