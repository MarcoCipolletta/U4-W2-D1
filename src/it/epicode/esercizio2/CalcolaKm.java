package it.epicode.esercizio2;

import com.sun.tools.javac.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class CalcolaKm {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(CalcolaKm.class);
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Inserisci i km percorsi: ");
            double km = scanner.nextDouble();

            System.out.print("Inserisci i litri di carburante consumati: ");
            double litri = scanner.nextDouble();

            if (litri == 0) {
                throw new ArithmeticException("Divisione per zero non permessa.");
            }

            double kmPerLitro = km / litri;
            System.out.println("Hai percorso " + kmPerLitro + " km/litro.");
            logger.info("Hai percorso " + kmPerLitro + " km/litro.");
        } catch (ArithmeticException e) {
            logger.error("Errore: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Errore generico: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}


