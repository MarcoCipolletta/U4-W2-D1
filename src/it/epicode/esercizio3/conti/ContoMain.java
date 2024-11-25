package it.epicode.esercizio3.conti;

    import it.epicode.esercizio3.exception.BancaException;
    import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ContoMain {


    private static final Logger logger = LoggerFactory.getLogger(ContoMain.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creazione degli oggetti ContoCorrente e ContoOnLine
        ContoCorrente contoCorrente = new ContoCorrente("Mario Rossi", 1000);
        ContoOnLine contoOnline = new ContoOnLine("Luigi Bianchi", 2000, 500);

        boolean continua = true;

        while (continua) {
            System.out.println("\nScegli il conto da utilizzare:");
            System.out.println("1. Conto Corrente");
            System.out.println("2. Conto Online");
            System.out.println("3. Esci");
            System.out.print("Scelta: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    try {
                        System.out.print("Inserisci l'importo da prelevare dal conto corrente: ");
                        double importo = scanner.nextDouble();
                        contoCorrente.preleva(importo);
                        logger.info("Prelievo dal conto corrente completato. Saldo attuale: " + contoCorrente.restituisciSaldo());
                    } catch (BancaException e) {
                        logger.error("Errore durante il prelievo dal conto corrente: " + e.getMessage());
                    } catch (Exception e) {
                        logger.error("Errore generico: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Inserisci l'importo da prelevare dal conto online: ");
                        double importo = scanner.nextDouble();
                        contoOnline.preleva(importo);
                        logger.info("Prelievo dal conto online completato. Saldo attuale: " + contoOnline.restituisciSaldo());
                    } catch (BancaException e) {
                        logger.error("Errore durante il prelievo dal conto online: " + e.getMessage());
                    } catch (Exception e) {
                        logger.error("Errore generico: " + e.getMessage());
                    }
                    break;

                case 3:
                    continua = false;
                    logger.info("Uscita dall'applicazione.");
                    break;

                default:
                    logger.warn("Scelta non valida. Riprova.");
                    break;
            }
        }

        scanner.close();
        logger.info("Applicazione terminata.");
    }



}
