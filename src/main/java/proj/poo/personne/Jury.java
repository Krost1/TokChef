package proj.poo.personne;
import java.io.Serializable;


public class Jury extends Personne implements Serializable {
    private  int nombreParticipation;
    public  boolean plusieurPart;

    public Jury() {
    }

    public Jury(int id, String nom, String prenom, String telephone, String genre ) {
        super(id, nom, prenom, telephone, genre);
    }





}
