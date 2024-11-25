package it.epicode.esercizio1;

import java.util.Scanner;

public class EsercizioArray {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];


        for (int i = 0; i < array.length; i++) {
            array[i] = (int)( Math.random()*10) + 1;
        }

        System.out.println("Array iniziale:");
        stampaArray(array);

        while (true) {
            try {
                System.out.println("Inserisci un numero (0 per uscire): ");
                int numero = scanner.nextInt();
                if (numero == 0) break;

                System.out.println("Inserisci la posizione (1-5): ");
                int posizione = scanner.nextInt() -1 ;

                array[posizione] = numero;
                System.out.println("Nuovo stato dell'array:");
                stampaArray(array);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Errore: Posizione non valida. Riprova.");
            } catch (Exception e) {
                System.err.println("Errore generico: " + e.getMessage());
                scanner.next();
            }
        }

        scanner.close();
    }

    private static void stampaArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}



