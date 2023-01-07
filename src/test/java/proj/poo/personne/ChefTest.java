package proj.poo.personne;

import org.junit.jupiter.api.Test;
import proj.poo.ingredient.Autres;
import proj.poo.ingredient.Epices;
import proj.poo.ingredient.Legumes;
import proj.poo.preparation.Plat;


import static org.junit.jupiter.api.Assertions.*;

class ChefTest {

    @Test
    void getAl() {
        Chef chef = new Chef(1, "Canon", "Antoine", "06.30.87.87.52", "Homme", 0,2);

        Legumes poivrons_vertsert = new Legumes(1, "poivrons verts", true, 25.8, 3);
        Legumes poivrons_rouges = new Legumes(2, "poivrons rouges", false, 23, 1.9);
        Legumes concasse_de_tommates = new Legumes(3, "concasse de tommates", true, 72, 3);
        Legumes oignons_rouge = new Legumes(4, "oignons rouge", true, 40, 1.7);
        Legumes oignons_blanc = new Legumes(5, "oignons blanc", true, 40.20, 2.80);
        Legumes ail = new Legumes(6, "ail", false, 5, 0.0);
        Epices sel = new Epices(2, "sel", true, 0);
        Epices poivre = new Epices(3, "poivre", true, 0);
        Autres huile_olive = new Autres(1, "huile d'olive", false, 90, 10);

        Plat plat = new Plat("Tchoutchouka");
        plat.ajouterIngrediant(poivrons_vertsert, 2, "cuit");
        plat.ajouterIngrediant(poivrons_rouges, 2, "cuit");
        plat.ajouterIngrediant(concasse_de_tommates, 4, "cuit");
        plat.ajouterIngrediant(oignons_rouge, 2, "cuit");
        plat.ajouterIngrediant(oignons_blanc, 1, "cuit");
        plat.ajouterIngrediant(ail, 1, "aucune");
        plat.ajouterIngrediant(huile_olive, 1, "aucune");
        plat.ajouterIngrediant(sel, 1, "aucune");
        plat.ajouterIngrediant(poivre, 1, "aucune");

        chef.ajoutPlat(plat);
        assertEquals(plat,chef.getAl().get(0));
    }
}