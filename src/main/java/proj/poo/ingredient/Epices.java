package proj.poo.ingredient;
import java.io.Serializable;


public class Epices extends Ingrediant implements Serializable {

    public Epices() {
    }

    public Epices(int id, String nom, Boolean Bio, double calorie) {
        super(id, nom, Bio, calorie);

        this.calories = 0;
    }



}
