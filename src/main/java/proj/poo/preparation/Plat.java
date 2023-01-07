package proj.poo.preparation;



import proj.poo.ingredient.Ingrediant;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Plat implements Serializable {

    private  String nom;
    private List<Recette> liste_ingrediant_dans_un_plat = new ArrayList<>();
    public static Logger logger = Logger.getLogger("Plat");

    public Plat() {
    }

    public Plat(String nom ) {
        this.nom = nom;
    }


    public void ajouterIngrediant(Recette ingrediant){

        liste_ingrediant_dans_un_plat.add(ingrediant);
    }


    public void ajouterIngrediant(Ingrediant i,double q, String p){
        liste_ingrediant_dans_un_plat.add(new Recette(i,q,p));

    }

    public void estBio(){

        Boolean bio = true;
        int x=0;
        while (bio){
            bio=liste_ingrediant_dans_un_plat.get(x).getIngrediant().isBio();
            ++x;
        }
       if (bio){
           logger.log(Level.INFO,""+getNom()+" est un plat bio");
       }else {
           logger.log(Level.INFO,""+getNom()+" n est pas un plat bio");
       }
    }


    public  double calorie(){
        double calorie=0;
        for (Recette r:liste_ingrediant_dans_un_plat){
            calorie=calorie+(r.getQuantite()*r.getIngrediant().getCalories());
        }
        return calorie;
    }


    public List<Recette> getliste_ingrediant_dans_un_plat() {
        return liste_ingrediant_dans_un_plat;
    }


    public void setAl(ArrayList<Recette> liste_ingrediant_dans_un_plat) {
        this.liste_ingrediant_dans_un_plat = liste_ingrediant_dans_un_plat;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


}
