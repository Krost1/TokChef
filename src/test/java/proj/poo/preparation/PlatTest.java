package proj.poo.preparation;

import org.junit.jupiter.api.Test;
import proj.poo.ingredient.Autres;
import proj.poo.ingredient.Epices;
import proj.poo.ingredient.Legumes;
import proj.poo.ingredient.Viande;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PlatTest {

    @Test
    void calorie() {

        Legumes poivrons_vertsert = new Legumes(1, "poivrons verts", true, 25.8, 3);
        Legumes poivrons_rouges = new Legumes(2, "poivrons rouges", false, 23, 1.9);
        Legumes concasse_de_tommates = new Legumes(3, "concasse de tommates", true, 72, 3);
        Legumes oignons_rouge = new Legumes(4, "oignons rouge", true, 40, 1.7);


        Plat plat = new Plat("Tchoutchouka");
        plat.ajouterIngrediant(poivrons_vertsert, 2, "cuit");
        plat.ajouterIngrediant(poivrons_rouges, 2, "cuit");
        plat.ajouterIngrediant(concasse_de_tommates, 4, "cuit");
        plat.ajouterIngrediant(oignons_rouge, 2, "cuit");

        assertEquals(465.6,plat.calorie());



    }

}