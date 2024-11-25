package it.epicode.esercizio3.conti;

import it.epicode.esercizio3.exception.BancaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContoCorrente {
    private static final Logger logger = LoggerFactory.getLogger(ContoCorrente.class);

    private String titolare;
    private int nMovimenti;
    private final int maxMovimenti = 50;
    private double saldo;

    public ContoCorrente(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
        this.nMovimenti = 0;
    }

    public void preleva(double x) throws BancaException {
        if (saldo - x < 0) {
            throw new BancaException("Il conto è in rosso");
        }
        saldo -= x;
        nMovimenti++;
        logger.info("Prelievo effettuato: " + x + ". Saldo attuale: " + saldo);
    }

    public double restituisciSaldo() {
        return saldo;
    }
}
