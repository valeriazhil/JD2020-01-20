package by.it.gerasimov.calc;

import by.it.gerasimov.calc.translate.Messages;
import by.it.gerasimov.calc.translate.ResMan;

class Printer {

    public void print(Var var) throws CalcException {
        if (var != null) {
            System.out.println(var);
        } else {
            throw new CalcException(ResMan.INSTANCE.get(Messages.NOT_FOUND_VAR));
        }
    }
}
