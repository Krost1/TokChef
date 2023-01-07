package proj.poo.preparation;

import proj.poo.ingredient.Ingrediant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recette implements Serializable {

    private Ingrediant ingrediant;
    private List<Ingrediant> i = new ArrayList<>();
    private  double quantite;
    private String preparation;

    public Recette() {
    }

    public Recette(Ingrediant ingrediant, double quantite, String preparation) {
        this.ingrediant = ingrediant;
        this.quantite = quantite;
        this.preparation = preparation;
    }

    public void ajoutdeList(Ingrediant ingrediant){
        i.add(ingrediant);
    }


    public Ingrediant getIngrediant() {
        return ingrediant;
    }


    public void setIngrediant(Ingrediant ingrediant) {
        this.ingrediant = ingrediant;
    }


    public double  getQuantite() {
        return quantite;
    }


    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }


    public String getPreparation() {
        return preparation;
    }


    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }


    public List<Ingrediant> getI() {
        return i;
    }


    public void setI(List<Ingrediant> i) {
        this.i = i;
    }


    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }


}
