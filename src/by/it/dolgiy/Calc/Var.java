package by.it.dolgiy.Calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

abstract class Var implements Operation {

    private static Map<String,Var> vars= new HashMap<>();

    public static Map<String, Var> getVars() {
        return vars;
    }

    static Var saveVar(String name, Var var){
        vars.put(name,var);
        return var;
    }

    static Var createVar(String str){
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
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения "+this+" + "+other+" невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания "+this+" - "+other+" невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения "+this+" * "+other+" невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления "+this+" / "+other+" невозможна");
        return null;
    }

    @Override
    public String toString() {
        return "Var";
    }

}
