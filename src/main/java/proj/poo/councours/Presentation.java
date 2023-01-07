package proj.poo.councours;

import proj.poo.personne.Chef;
import proj.poo.preparation.Plat;

import java.io.Serializable;

public class Presentation implements Serializable {
    private Chef chef;
        private Plat plat;
        private double note;

    public Presentation() {
    }

    public Presentation(Chef chef, Plat plat) {
             this.chef = chef;
            this.plat = plat;

        }

    public Chef getChef() {
        return chef;
    }

        public Plat getPlat() {
            return plat;
        }



        public double getNote() {
            return note;
        }

        public void setNote(double note) {
            this.note = note;
        }



}
