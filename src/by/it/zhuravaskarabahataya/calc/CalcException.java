package by.it.zhuravaskarabahataya.calc;

class CalcException extends Exception {
    public CalcException(String message) {
        super("ERROR:" + message);
        Log.writeExceptionToLogFile(message);
    }

    @SuppressWarnings("unused")
    public CalcException() {
        super();
    }

    @SuppressWarnings("unused")
    public CalcException(String message, Throwable cause) {
        super("ERROR:" + message, cause);
    }

    @SuppressWarnings("unused")
    public CalcException(Throwable cause) {
        super(cause);
    }

    @SuppressWarnings("unused")
    protected CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR:" + message, cause, enableSuppression, writableStackTrace);
    }
}
