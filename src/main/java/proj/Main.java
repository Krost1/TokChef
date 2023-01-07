package proj;


import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import proj.poo.councours.Concours;
import proj.poo.councours.Presentation;
import proj.poo.exception.Participants;
import proj.poo.ingredient.*;
import proj.poo.personne.Chef;
import proj.poo.preparation.Plat;
import proj.poo.preparation.Recette;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.*;
import java.time.LocalDate;



public class Main {

    public static void main(String[] args){

        File fic = new File("Concours");

        LocalDate aujourdhui = LocalDate.now();

        Concours concours = new Concours(aujourdhui);

        double x = 0 ;

        Presentation pmax=null;


        if (!fic.exists()) {
            /*
             *
             *
             * Création du chef, padawan et du jurys
             *
             *
             */
            Chef chef = new Chef(1, "Canon", "Antoine", "06.30.87.87.52", "Homme", 0,3);
            Chef chef2 = new Chef(2, "Mendez", "Paco", "06.30.87.87.52", "Homme", 0,0);
            Chef chef3 = new Chef(3, "Sebaoui", "Riwane", "06.03.87.87.52", "Homme", 0,2);
            Chef chef4 = new Chef(4, "Van", "Samuel", "06.30.78.87.52", "Homme", 0,0);
            Chef chef5 = new Chef(5, "Mazz", "Mathieu", "06.30.87.87.25", "Homme", 0,1);

            concours.ajoutJury(1, "Carton", "Ella", "06.30.87.87.52", "Femme");
            concours.ajoutJury(2, "Jollette", "Ella", "06.30.87.17.52", "Femme");
            concours.ajoutJury(3, "Patrice", "MArk", "06.30.07.97.52", "Homme");



            chef.creerPadawan(1, "Carteru", "Eliot", "06.30.87.87.52", "Homme",LocalDate.of(2000,03,14));
            chef.creerPadawan(2, "Courtvoie", "Elise", "06.10.90.87.52", "Femme",LocalDate.of(2014,9,30));

            chef2.creerPadawan(3, "Bartese", "Juan", "06.02.78.87.52", "Homme",LocalDate.of(2010,6,14));
            chef2.creerPadawan(4, "Etho", "Risa", "06.10.90.07.02", "Femme",LocalDate.of(2005,10,14));

            chef3.creerPadawan(5, "Marlot", "Ethan", "06.30.87.87.00", "Homme",LocalDate.of(2017,7,14));
            chef3.creerPadawan(6, "Carlier", "Amandine", "06.00.90.87.52", "Femme",LocalDate.of(2006,1,14));

            chef4.creerPadawan(7, "Colpart", "Rowan", "06.30.01.00.52", "Homme",LocalDate.of(2018,6,14));
            chef4.creerPadawan(8, "Roux", "Elise", "06.10.02.01.52", "Femme",LocalDate.of(2020,4,14));

            chef5.creerPadawan(9, "Marchalale", "Ethienne", "06.30.03.87.09", "Homme",LocalDate.of(2015,8,14));
            chef5.creerPadawan(10, "Ladeuil", "Alexandra", "06.00.60.87.52", "Femme",LocalDate.of(2010,12,14));
            /*
             *
             *
             * Création d'ingrédiants
             *
             *
             */
            /*--------------Viande-----------*/
            Viande bourguignon = new Viande(1, "bourguidnon", true, 30, 150, 3.3, "a point");
            Viande crevette = new Viande(2, "crevette", false, 15, 87, 0, "précuit");
            /*--------------Legume-----------*/
            Legumes poivrons_vertsert = new Legumes(1, "poivrons verts", true, 25.8, 3);
            Legumes poivrons_rouges = new Legumes(2, "poivrons rouges", false, 23, 1.9);
            Legumes concasse_de_tommates = new Legumes(3, "concasse de tommates", true, 72, 3);
            Legumes oignons_rouge = new Legumes(4, "oignons rouge", true, 40, 1.7);
            Legumes oignons_blanc = new Legumes(5, "oignons blanc", true, 40.20, 2.80);
            Legumes ail = new Legumes(6, "ail", false, 5, 0.0);
            Legumes carotte = new Legumes(7, "carotte", true, 52, 2.7);
            Legumes pomme_de_terre = new Legumes(8, "pomme de terre", true, 144, 3.7);
            Legumes soja = new Legumes(9, "soja", true, 2, 0.13);
            Legumes riz = new Legumes(10, "riz", true, 13, 2.15);
            /*--------------Epice-----------*/
            Epices canelle = new Epices(1, "canelle", true, 0);
            Epices sel = new Epices(2, "sel", true, 0);
            Epices poivre = new Epices(3, "poivre", true, 0);
            Epices coriandre = new Epices(4, "coriandre", true, 0);
            /*--------------Autre-----------*/
            Autres huile_olive = new Autres(1, "huile d'olive", false, 90, 10);
            Autres vermicelles = new Autres(2, "vermicelles", true, 20, 50);
            Autres vin_rouge = new Autres(3, "vin rouge", false, 90, 12.5);
            Autres beurre = new Autres(4, "beurre", false, 327, 25);
            /*
             *
             * ajout d'un ingrediant dans une liste
             *
             *
             */
            Recette recet = new Recette();
            /*--------------Viande-----------*/
            recet.ajoutdeList(bourguignon);
            recet.ajoutdeList(crevette);
            /*--------------Legume-----------*/
            recet.ajoutdeList(poivrons_vertsert);
            recet.ajoutdeList(poivrons_rouges);
            recet.ajoutdeList(concasse_de_tommates);
            recet.ajoutdeList(oignons_rouge);
            recet.ajoutdeList(oignons_blanc);
            recet.ajoutdeList(ail);
            recet.ajoutdeList(carotte);
            recet.ajoutdeList(pomme_de_terre);
            recet.ajoutdeList(soja);
            recet.ajoutdeList(riz);
            /*--------------Epice-----------*/
            recet.ajoutdeList(canelle);
            recet.ajoutdeList(sel);
            recet.ajoutdeList(poivre);
            recet.ajoutdeList(coriandre);
            /*--------------Autre-----------*/
            recet.ajoutdeList(bourguignon);
            recet.ajoutdeList(bourguignon);
            recet.ajoutdeList(bourguignon);
            /*
             *
             *
             * Création des plats
             *
             *
             */
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


            Plat plat2 = new Plat("La chorba algeroise");
            plat2.ajouterIngrediant(sel, 2, "aucune");
            plat2.ajouterIngrediant(huile_olive, 2, "aucune");
            plat2.ajouterIngrediant(concasse_de_tommates, 1, "aucune");
            plat2.ajouterIngrediant(canelle, 0.5, "aucune");
            plat2.ajouterIngrediant(vermicelles, 2, "aucune");
            plat2.ajouterIngrediant(carotte, 1, "cuit");
            plat2.ajouterIngrediant(poivre, 2, "aucune");
            plat2.ajouterIngrediant(coriandre, 2, "aucune");
            plat2.ajouterIngrediant(pomme_de_terre, 2, "cuit");


            Plat plat3 = new Plat("Boeuf bourguignon");
            plat3.ajouterIngrediant(sel, 2, "aucune");
            plat3.ajouterIngrediant(poivre, 2, "aucune");
            plat3.ajouterIngrediant(carotte, 1, "cuit");
            plat3.ajouterIngrediant(oignons_blanc, 1, "cuit");
            plat3.ajouterIngrediant(vin_rouge, 50, "cuit");
            plat3.ajouterIngrediant(beurre, 1, "cuit");
            plat3.ajouterIngrediant(bourguignon, 1, "aucune");


            Plat plat4 = new Plat("Riz Cantonais");
            plat4.ajouterIngrediant(huile_olive, 50, "aucune");
            plat4.ajouterIngrediant(oignons_blanc, 2, "aucune");
            plat4.ajouterIngrediant(soja, 53, "cuit");
            plat4.ajouterIngrediant(riz, 200, "précuit");
            plat4.ajouterIngrediant(crevette, 60, "précuit");

            Plat plat5 = new Plat("Meli melo de crevettes au miel et nouilles sautees");
            plat5.ajouterIngrediant(sel, 2, "aucune");
            plat5.ajouterIngrediant(poivre, 2, "aucune");
            plat5.ajouterIngrediant(crevette, 6, "aucnue");
            plat5.ajouterIngrediant(carotte, 1, "aucune");
            plat5.ajouterIngrediant(poivrons_rouges, 1, "aucune");
            plat5.ajouterIngrediant(soja, 15, "aucune");
            plat5.ajouterIngrediant(ail, 15, "aucne");
            /*
             *
             *
             * Ajout du plat à la liste des plat du chef
             *
             *
             */
            chef.ajoutPlat(plat);
            chef.ajoutPlat(plat2);
            chef.ajoutPlat(plat3);
            chef.ajoutPlat(plat4);
            chef.ajoutPlat(plat5);

            chef2.ajoutPlat(plat);
            chef2.ajoutPlat(plat2);
            chef2.ajoutPlat(plat3);
            chef2.ajoutPlat(plat4);
            chef2.ajoutPlat(plat5);

            chef3.ajoutPlat(plat);
            chef3.ajoutPlat(plat2);
            chef3.ajoutPlat(plat3);
            chef3.ajoutPlat(plat4);
            chef3.ajoutPlat(plat5);


            chef4.ajoutPlat(plat);
            chef4.ajoutPlat(plat2);
            chef4.ajoutPlat(plat3);
            chef4.ajoutPlat(plat4);
            chef4.ajoutPlat(plat5);

            chef5.ajoutPlat(plat);
            chef5.ajoutPlat(plat2);
            chef5.ajoutPlat(plat3);
            chef5.ajoutPlat(plat4);
            chef5.ajoutPlat(plat5);
            /*
             *
             *
             * creation d'un concours
             *
             *
             *
             */
            concours.ajouterparticipant(chef, chef.getAl().get((int) (Math.random() * chef.getAl().size())));
            concours.ajouterparticipant(chef2, chef2.getAl().get((int) (Math.random() * chef2.getAl().size())));
            concours.ajouterparticipant(chef3, chef3.getAl().get((int) (Math.random() * chef3.getAl().size())));
            concours.ajouterparticipant(chef4, chef4.getAl().get((int) (Math.random() * chef4.getAl().size())));
            concours.ajouterparticipant(chef5, chef5.getAl().get((int) (Math.random() * chef5.getAl().size())));

            System.out.println("Bonsoir et bien venue a ce concours top chef de ce "+aujourdhui);

            try{
                concours.demarrageConcours();
                concours.finConcours(concours);

            } catch (Participants participants) {
                participants.printStackTrace();
            }
            /*
             *
             *
             * On Sauvegarde le concours
             *
             *
             *
             */
            try{
                FileOutputStream outFileStream = new FileOutputStream(fic);
                ObjectOutputStream outObjectStream = new ObjectOutputStream(outFileStream);
                outObjectStream.writeObject(concours);
                outObjectStream.close();
            } catch(FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            Jsonb jsonb = JsonbBuilder.create();
            String result = jsonb.toJson(recet.getI());
            System.out.println(result);

        }
        else {

            System.out.println("--- Bonsoir et bien venue a ce concours top chef de ce "+aujourdhui+" ---");

            File inFile = new File("Concours");

            FileInputStream inFileStream;

            try {
                /*
                 *
                 *
                 * On lit la sauvegarde
                 *
                 *
                 *
                 */
                inFileStream = new FileInputStream(inFile);

                ObjectInputStream inObjectStream = new ObjectInputStream(inFileStream);

                 concours = (Concours) inObjectStream.readObject();

                System.out.println("\n--Voici la liste des chefs inscrit au concours--\n");

                for (Presentation p:concours.getParticipants()){

                    System.out.println(p.getChef().getNom()+
                            " "+p.getChef().getPrenom());

                }

                System.out.println("\n--Voici la liste des jurys participant au concours--\n");

                for (int i =0; i<concours.getJury().size();++i){

                    System.out.println(concours.getJury().get(i).getNom()+
                            " "+concours.getJury().get(i).getPrenom());

                }

                for (Presentation p:concours.getParticipants()){

                    if (x<p.getNote()){

                        x=p.getNote();

                        pmax=p;

                    }
                }

                System.out.println("\n--Et le grand gagant de ce soir est "+pmax.getChef().getNom()
                        +" "+pmax.getChef().getPrenom()+" avec son "+pmax.getPlat().getNom()+" !!--\n\nil a obtenu la note de "+ x+"\n");

                inObjectStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Test");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();


        em.getTransaction().commit();
        em.close();
        emf.close();

        }

        //tri map

    }







