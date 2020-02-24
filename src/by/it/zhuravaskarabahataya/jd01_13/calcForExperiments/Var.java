package by.it.zhuravaskarabahataya.jd01_13.calcForExperiments;

import java.util.*;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String varName, Var var) {
        vars.put(varName, var);
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


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция " + this + " + " + other + " невозможна");
    }

    public Var add(Scalar other) throws CalcException {
        throw new CalcException("Операция " + this + " + " + other + " невозможна");
    }

    public Var add(Vector other) throws CalcException {
        throw new CalcException("Операция " + this + " + " + other + " невозможна");
    }

    public Var add(Matrix other) throws CalcException {
        throw new CalcException("Операция " + this + " + " + other + " невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция " + this + " - " + other + " невозможна");
    }

    public Var sub(Scalar other) throws CalcException {
        throw new CalcException("Операция " + this + " - " + other + " невозможна");
    }

    public Var sub(Vector other) throws CalcException {
        throw new CalcException("Операция " + this + " - " + other + " невозможна");
    }

    public Var sub(Matrix other) throws CalcException {
        throw new CalcException("Операция " + this + " - " + other + " невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция " + this + " * " + other + " невозможна");
    }

    public Var mul(Scalar other) throws CalcException {
        throw new CalcException("Операция " + this + " * " + other + " невозможна");
    }

    public Var mul(Vector other) throws CalcException {
        throw new CalcException("Операция " + this + " * " + other + " невозможна");
    }

    public Var mul(Matrix other) throws CalcException {
        throw new CalcException("Операция " + this + " * " + other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция " + this + " / " + other + " невозможна");
    }

    public Var div(Scalar other) throws CalcException {
        throw new CalcException("Операция " + this + " / " + other + " невозможна");
    }

    public Var div(Vector other) throws CalcException {
        throw new CalcException("Операция " + this + " / " + other + " невозможна");
    }

    public Var div(Matrix other) throws CalcException {
        throw new CalcException("Операция " + this + " / " + other + " невозможна");
    }

    static Var create(String strVar) throws CalcException {
        strVar = strVar.trim().replace(" ", "");
        if (strVar.matches(Patterns.SCALAR)) {
            return createScalar(strVar);
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

    public static Scalar createScalar (String str){
        return new Scalar(str);
    }
}
