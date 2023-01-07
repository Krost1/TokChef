package proj.poo.ingredient;
import java.io.Serializable;

public class Autres extends Ingrediant implements Serializable {

    private double masseEnG;

    public Autres() {
    }

    public Autres(int id, String nom, boolean Bio, double calorie, double masseEnG) {
        super(id, nom, Bio, calorie);
        this.masseEnG = masseEnG;
    }



    public double getMasseEnG() {
        return masseEnG;
    }

}
