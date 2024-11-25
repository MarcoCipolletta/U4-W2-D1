package it.epicode.esercizio3.conti;

import it.epicode.esercizio3.exception.BancaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContoOnLine extends ContoCorrente {
    private static final Logger logger = LoggerFactory.getLogger(ContoOnLine.class);

    private double maxPrelievo;

    public ContoOnLine(String titolare, double saldo, double maxPrelievo) {
        super(titolare, saldo);
        this.maxPrelievo = maxPrelievo;
    }

    @Override
    public void preleva(double x) throws BancaException {
        if (x > maxPrelievo) {
            logger.error("Prelievo non autorizzato: importo richiesto (" + x +") supera il massimo consentito ("+ maxPrelievo +").");
            throw new BancaException("Il prelievo non è disponibile");
        }
        super.preleva(x);
    }

    public void stampaSaldo() {
        logger.info("Saldo disponibile: "+ restituisciSaldo());
    }
}

