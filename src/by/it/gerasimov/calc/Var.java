package by.it.gerasimov.calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static HashMap<String, Var> vars = new HashMap<>();
    public static void printVars() {
        for (Map.Entry<String, Var> entry : vars.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
    public static void sortVars() {
        ArrayList<String> keys = new ArrayList<>(vars.keySet());
        Collections.sort(keys);
        for (String key : keys) {
            System.out.println(key + "=" + vars.get(key));
        }
    }
    public static Var getVar(String key) {
        return vars.get(key);
    }
    public static void setVar(String key, String value) throws CalcException {
        vars.put(key, Var.create(value));
    }
    public static void setVar(String key, Var var) {
        vars.put(key, var);
    }

    static Var create(String strValue) throws CalcException {
        strValue = strValue.trim().replace(" ", "");
        if (strValue.matches(Patterns.SCALAR)) {
            return new Scalar(strValue);
        } else if (strValue.matches(Patterns.VECTOR)) {
            return new Vector(strValue);
        } else if (strValue.matches(Patterns.MATRIX)) {
            return new Matrix(strValue);
        } else if (strValue.matches(Patterns.VARIABLE)) {
            if (vars.containsKey(strValue)) {
                return vars.get(strValue);
            } else {
                throw new CalcException("Не найдена переменная " + strValue);
            }
        } else {
            throw new CalcException("Неверный формат ввода");
        }
    }
    @Override
    public String toString() {
        return "X";
    }
    public Var operate(Var other, String operator) throws CalcException {
        switch (operator) {
            case "+":
                return this.add(other);
            case "-":
                return this.sub(other);
            case "*":
                return this.mul(other);
            case "/":
                return this.div(other);
            default:
                return null;
        }
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

    protected Var reverseAdd(Scalar other) throws CalcException {
        throw new CalcException("Операция " + other + " + " + other + " невозможна");
    }
    protected Var reverseAdd(Vector other) throws CalcException {
        throw new CalcException("Операция " + other + " + " + other + " невозможна");
    }
    protected Var reverseAdd(Matrix other) throws CalcException {
        throw new CalcException("Операция " + other + " + " + other + " невозможна");
    }
    protected Var reverseSub(Scalar other) throws CalcException {
        throw new CalcException("Операция " + other + " - " + other + " невозможна");
    }
    protected Var reverseSub(Vector other) throws CalcException {
        throw new CalcException("Операция " + other + " - " + other + " невозможна");
    }
    protected Var reverseSub(Matrix other) throws CalcException {
        throw new CalcException("Операция " + other + " - " + other + " невозможна");
    }
    protected Var reverseMul(Scalar other) throws CalcException {
        throw new CalcException("Операция " + other + " * " + other + " невозможна");
    }
    protected Var reverseMul(Vector other) throws CalcException {
        throw new CalcException("Операция " + other + " * " + other + " невозможна");
    }
    protected Var reverseMul(Matrix other) throws CalcException {
        throw new CalcException("Операция " + other + " * " + other + " невозможна");
    }
    protected Var reverseDiv(Scalar other) throws CalcException {
        throw new CalcException("Операция " + other + " / " + other + " невозможна");
    }
    protected Var reverseDiv(Vector other) throws CalcException {
        throw new CalcException("Операция " + other + " / " + other + " невозможна");
    }
    protected Var reverseDiv(Matrix other) throws CalcException {
        throw new CalcException("Операция " + other + " / " + other + " невозможна");
    }
}
