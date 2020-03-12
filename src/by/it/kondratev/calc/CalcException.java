package by.it.kondratev.calc;

public class CalcException extends Exception {
    public CalcException() {
    }

    CalcLogger logger = CalcLogger.getInstance();

    public CalcException(String message) {
        super("ERROR: " + message);
        logger.log("ERROR: " + message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
        logger.log("ERROR: " + message);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: " + message, cause, enableSuppression, writableStackTrace);
        logger.log("ERROR: " + message);
    }
}
