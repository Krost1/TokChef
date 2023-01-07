package proj.poo.personne;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {
    @Test
    public  final  void testFlux(){
        Personne per = new Personne(1,"dener","gerad","06.30.97.60.30","Homme");

        File outFile = new File("test");
        try {
            FileOutputStream outFileStream =
                    new FileOutputStream(outFile);
            ObjectOutputStream outObjectStream =
                    new ObjectOutputStream(outFileStream);
            outObjectStream.writeObject(per);
            outObjectStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(outFile);

        File inFile = new File("test");
        FileInputStream inFileStream;
        try {
            inFileStream = new FileInputStream(inFile);
            ObjectInputStream inObjectStream = new ObjectInputStream(inFileStream);

            per = (Personne) inObjectStream.readObject();
            System.out.println(per.nom + " " +
                    per.prenom+ " " + per.genre);
            inObjectStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}