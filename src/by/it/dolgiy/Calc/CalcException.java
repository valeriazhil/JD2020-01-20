package by.it.dolgiy.Calc;

import by.it.dolgiy.Calc.translate.CalcErrors;
import by.it.dolgiy.Calc.translate.ResMan;

class CalcException extends Exception {

    static ResMan man = ResMan.INSTANCE;

    public CalcException() {
    }

    public CalcException(String message) {
        super(man.get(CalcErrors.CALC_ERROR)+ message);
        Logger.writeError(man.get(CalcErrors.CALC_ERROR)+ message);
    }

    public CalcException(String message, Throwable cause) {
        super(man.get(CalcErrors.CALC_ERROR)+message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
