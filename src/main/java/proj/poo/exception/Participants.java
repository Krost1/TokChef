package proj.poo.exception;

import java.io.Serializable;
import java.util.logging.Logger;

public class Participants extends Throwable implements Serializable {
    public Participants() {
        Logger logger = Logger.getLogger("Concours");
        logger.warning("Il n'y a pas assez de participant");

    }
}
