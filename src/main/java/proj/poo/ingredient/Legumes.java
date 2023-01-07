package proj.poo.ingredient;
import java.io.Serializable;


public class Legumes extends Ingrediant implements Serializable {

    private double tauxFibreenG;

    public Legumes() {
    }

    public Legumes(int id, String nom, Boolean Bio, double calorie, double tauxFibreenG) {
        super(id, nom, Bio, calorie);
        this.tauxFibreenG = tauxFibreenG;

    }

    public double getTauxFibreenG() {
        return tauxFibreenG;
    }

}
