package proj.poo.ingredient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="Ingrediant")
public  class Ingrediant implements Serializable {
    @Id
    @Column(name = "id")
    protected  int id;
    @Column(name = "NAME")
    protected String nom;
    @Column(name = "BIO")
    protected boolean Bio;
    @Column(name = "KCAL")
    protected double calories;

    public Ingrediant() {
    }

    public Ingrediant(int id, String nom, boolean Bio, double calorie){
        this.id=id;
        this.nom=nom;
        this.Bio=Bio;
        this.calories=calorie;
    }


    public int getId() {
        return id;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isBio() {
        return Bio;
    }



    public double getCalories() {
        return calories;
    }


}
