package by.it.zhuravaskarabahataya.calc;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

abstract class Var implements Operation {

    private static String varsFile = Helper.getPath("vars.txt", Var.class);
    private static Map<String, Var> vars = Helper.getMapFromFile(varsFile);


    static Var saveVar(String varName, Var var) {
        vars.put(varName, var);
        Helper.varToFile(varName, var, varsFile);
        return var;
    }

    static void printvar() {
        List<String> keys = new ArrayList<>(vars.keySet());
        for (String key : keys) {
            System.out.println(key + "=" + vars.get(key));
        }
    }

    static void sortVar() {
        List<String> keys = new ArrayList<>(vars.keySet());
        Collections.sort(keys);
        for (String key : keys) {
            System.out.println(key + "=" + vars.get(key));
        }
    }

    @Override
    public String toString() {
        return "abstract Var";
    }

    public Var addVar(Var var){
        System.out.println("Вызвали addVar Var");
        return var;
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция " + this + " + " + other + " невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция " + this + " - " + other + " невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция " + this + " * " + other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция " + this + " / " + other + " невозможна");
    }

    static Var create(String strVar) throws CalcException {
        strVar = strVar.trim().replace(" ", "");
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix((strVar));
        } else if (vars.containsKey(strVar)) {
            return vars.get(strVar);
        } else {
            Var var = vars.get(strVar);
            if (var == null) {
                throw new CalcException("Переменная не найдена " + strVar);
            } else {
                return var;
            }
        }
    }


}
