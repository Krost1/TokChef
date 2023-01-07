package proj.poo.personne;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


public class Padawans extends  Personne implements Serializable,Comparable<Padawans> {


    private LocalDate entreeEnService;
    public Padawans() {
    }



    public Padawans(int id, String nom, String prenom, String telephone,String genre, LocalDate entrerEnService){
        super(id, nom, prenom, telephone,genre);
        this.entreeEnService=entrerEnService;
    }

    public LocalDate getEntreeEnService() {
        return entreeEnService;
    }




    @Override
    public int compareTo(Padawans o) {
        if (this.getEntreeEnService().isBefore(o.getEntreeEnService())){
            return -1;
        }else if (this.getEntreeEnService().isEqual(o.getEntreeEnService())){
            return 0;
        }else{
            return 1;
        }
    }
}
