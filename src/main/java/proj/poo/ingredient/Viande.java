package proj.poo.ingredient;
import java.io.Serializable;

public class Viande extends Ingrediant implements Serializable {

    private double tauxGraisse;
    private double masseEnG;
    private String typeCuisson;

    public Viande() {
    }
    public Viande(int id, String nom, Boolean Bio, int calorie,double masseEnG,double tauxGraisse,String typeCuisson) {
        super(id, nom, Bio, calorie);
        this.masseEnG = masseEnG;
        this.tauxGraisse = tauxGraisse;
        this.typeCuisson = typeCuisson;
    }


    public double getTauxGraisse() {
        return tauxGraisse;
    }

    public double getMasseEnG() {
        return masseEnG;
    }

    public String getTypeCuisson() {
        return typeCuisson;
    }
}
