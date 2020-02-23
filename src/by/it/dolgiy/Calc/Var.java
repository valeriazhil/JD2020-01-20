package by.it.dolgiy.Calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String,Var> vars= new HashMap<>();

    public static Map<String, Var> getVars() {
        return vars;
    }

    static Var saveVar(String name, Var var){
        vars.put(name,var);
        return var;
    }

    static Var createVar(String str) throws CalcException{
        str = str.trim().replace("\\s+","");
        if (str.matches(Patterns.SCALAR)){
            return new Scalar(str);
        }
        else if (str.matches(Patterns.VECTOR)){
            return new Vector(str);
        }
        else if (str.matches(Patterns.MATRIX)){
            return new Matrix(str);
        }
        else if (vars.containsKey(str)) {
            return vars.get(str);
        }
        throw new CalcException("Невозможно создать "+str);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения "+this+" + "+other+" невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException("Операция вычитания "+this+" - "+other+" невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения "+this+" * "+other+" невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException("Операция деления "+this+" / "+other+" невозможна");
    }

    @Override
    public String toString() {
        return "Var";
    }

}
