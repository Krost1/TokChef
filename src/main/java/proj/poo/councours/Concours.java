package proj.poo.councours;
import proj.poo.exception.*;
import proj.poo.personne.Chef;
import proj.poo.personne.Jury;
import proj.poo.personne.Padawans;
import proj.poo.preparation.Plat;


import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Concours implements Serializable,Comparable<Concours>{

    private LocalDate date;
    private List<Presentation> participants =  new ArrayList<>();
    private List<Jury> jury = new ArrayList<>();
    private NavigableSet<Concours> concoursfini = new TreeSet<>();
    private List<Concours> concoursPrevuOuEnCours = new ArrayList<>();
    public static final Logger logger = Logger.getLogger("Chef");

    public Concours() {
    }

    public Concours(LocalDate date) {
        this.date = date;
    }


    public void ajoutJury(int id, String nom, String prenom, String telephone, String genre) {
        jury.add(new Jury(id, nom, prenom, telephone, genre));
    }


    public void ajoutJury(Jury a) {
        jury.add(a);

    }


    public void ajouterparticipant(Chef a, Plat b) {

        if (Collections.frequency(participants, a) < 3) {

            participants.add(new Presentation(a, b));

        }

    }


    public void demarrageConcours() throws Participants {

        if (participants.size() <= 4 || jury.size() <= 2) {

            throw new Participants();

        } else {
            concoursPrevuOuEnCours.add(this);

            logger.log(Level.INFO, "Voici la liste des participants");

            for (Presentation c : participants) {

                logger.log(Level.INFO, "" + c.getChef().getNom() + " " + c.getChef().getPrenom());
            }

            logger.log(Level.INFO, "Voici la liste du jurys");

            for (Jury j : jury) {

                logger.log(Level.INFO, "" + j.getNom() + " " + j.getPrenom());
            }

        }

    }


    private Presentation notationEtResultat() {

        double max = 0.0;

        Presentation pmax = null;

        for (Presentation p : participants) {

            p.setNote(Math.random() * (20));

        }


        for (Presentation p : participants) {

            if (max <= p.getNote()) {

                max = p.getNote();

                pmax = p;
            }
        }
        return pmax;
    }


    public void finConcours(Concours x) {

        Presentation gagant = notationEtResultat();
        gagant.getChef().setVictoire(1);
        gagant.getChef().ajoutEtoile();
        Padawans padawans = gagant.getChef().getPadawan().first();

        Chef a = new Chef(padawans.getId(), padawans.getNom(), padawans.getPrenom()
                , padawans.getTelephone(), padawans.getGenre(), 0, 0);

        gagant.getChef().getPadawan().remove(padawans);

        a.creerPadawan(3, "blanquert", "gerad", "06.30.60.95",
                "homme", LocalDate.now());

        for (Presentation c : participants) {
            logger.log(Level.INFO, "" + c.getChef().getNom() + " " + c.getChef().getPrenom() + " " + c.getNote());

        }

        if (gagant.getChef().getNbEtoile() < 1 || gagant.getChef().getNbEtoile() < 3 || gagant.getChef().getNbEtoile() < 5) {
            gagant.getChef().setNbEtoile(1);
        }

        concoursPrevuOuEnCours.remove(x);

        concoursfini.add(x);

        logger.log(Level.INFO, "le chef gagant est " + gagant.getChef().getNom() +
                " " + gagant.getChef().getPrenom()
                + " avec son " + gagant.getPlat().getNom());

        logger.log(Level.INFO, "Il/elle a obtenu une note de " + gagant.getNote());

        logger.log(Level.INFO, "" + a.getNom() + " " + a.getPrenom() + " est " +
                "devenu un chef");
    }


    public void concours_auquel_un_chef_aOuParticipera(Chef chef) {

        for (Concours p : concoursfini) {

            if (p.concoursfini.contains(chef)) {

                logger.log(Level.INFO, "Il a participé au concours du " + p.getDate());

            }
        }

        }



        public LocalDate getDate() {
            return date;
        }

        public List<Presentation> getParticipants() {
            return participants;
        }

        public List<Jury> getJury() {
            return jury;
        }

        public NavigableSet<Concours> getConcoursfini() {
            return concoursfini;
        }





        @Override
        public int compareTo (Concours o){
            if (this.getDate().isBefore(o.getDate())) {
                return 1;
            } else if (this.getDate().isEqual(o.getDate())) {
                return 0;
            } else {
                return -1;
            }
        }
    }

