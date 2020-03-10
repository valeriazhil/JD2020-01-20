package by.it.dolgiy.Calc;

import by.it.dolgiy.Calc.translate.CalcErrors;
import by.it.dolgiy.Calc.translate.ResMan;

class Printer {
    static ResMan man = ResMan.INSTANCE;
    void print(Var var) {
        if (var!=null)
            System.out.println(var);
        else
            System.err.println(man.getString(CalcErrors.CALC_ERROR));
    }
    public void message(String message) {
        System.out.println(message);
    }
}
