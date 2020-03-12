package by.it.gerasimov.calc;

import by.it.gerasimov.calc.translate.Messages;
import by.it.gerasimov.calc.translate.ResMan;

class CalcException extends Exception {

    public CalcException() {
        log(this);
    }

    public CalcException(String message) {
        super(ResMan.INSTANCE.get(Messages.ERROR) + ": " + message);
        log(this);
    }

    public CalcException(String message, Throwable cause) {
        super(ResMan.INSTANCE.get(Messages.ERROR) + ": " + message, cause);
        log(this);
    }

    public CalcException(Throwable cause) {
        super(cause);
        log(this);
    }

    public static void log(CalcException e) {
        Logger logger = Logger.getInstance();
        logger.writeLog(e.getMessage());
    }
}
