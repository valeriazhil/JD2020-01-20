package by.it.bunkov.calc;

import by.it.bunkov.calc.Var;

interface Operation {
    Var add(Var other) throws  CalcException;

    Var sub(Var other) throws  CalcException;

    Var mul(Var other) throws  CalcException;

    Var div(Var other) throws  CalcException;
}
