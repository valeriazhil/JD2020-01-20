package by.it.gerasimov.calc;

class CalcException extends Exception {
    public CalcException() {
        log(this);
    }
    public CalcException(String message) {
        super("ERROR: " + message);
        log(this);
    }
    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
        log(this);
    }
    public CalcException(Throwable cause) {
        super(cause);
        log(this);
    }

    public static void log(CalcException e) {
        Logger logger = new Logger();
        logger.writeLog(e.getMessage());
    }
}
