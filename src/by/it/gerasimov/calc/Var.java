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
    public static void setVar(String key, String value) {
        vars.put(key, Var.create(value));
    }
    public static void setVar(String key, Var var) {
        vars.put(key, var);
    }
    static Var create(String strValue) {
        strValue = strValue.trim().replace(" ", "");
        if (strValue.matches(Patterns.SCALAR)) {
            return new Scalar(strValue);
        } else if (strValue.matches(Patterns.VECTOR)) {
            return new Vector(strValue);
        } else if (strValue.matches(Patterns.MATRIX)) {
            return new Matrix(strValue);
        } else if (strValue.matches(Patterns.VARIABLE)) {
            return vars.get(strValue);
        } else {
            return null; //stub
            //TODO throw error
        }
    }
    @Override
    public String toString() {
        return "X";
    }
    public Var operate(Var other, String operator) {
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
    public Var add(Var other) {
//        System.out.println("Операция " + this + " + " + other + " невозможна");
        return null;
    }
    @Override
    public Var sub(Var other) {
//        System.out.println("Операция " + this + " - " + other + " невозможна");
        return null;
    }
    @Override
    public Var mul(Var other) {
//        System.out.println("Операция " + this + " * " + other + " невозможна");
        return null;
    }
    @Override
    public Var div(Var other) {
//        System.out.println("Операция " + this + " / " + other + " невозможна");
        return null;
    }

    protected Var reverseAdd(Scalar other) {
//        System.out.println("Операция " + other + " + " + this + " невозможна");
        return null;
    }
    protected Var reverseAdd(Vector other) {
//        System.out.println("Операция " + other + " + " + this + " невозможна");
        return null;
    }
    protected Var reverseAdd(Matrix other) {
//        System.out.println("Операция " + other + " + " + this + " невозможна");
        return null;
    }
    protected Var reverseSub(Scalar other) {
//        System.out.println("Операция " + other + " - " + this + " невозможна");
        return null;
    }
    protected Var reverseSub(Vector other) {
//        System.out.println("Операция " + other + " - " + this + " невозможна");
        return null;
    }
    protected Var reverseSub(Matrix other) {
//        System.out.println("Операция " + other + " - " + this + " невозможна");
        return null;
    }
    protected Var reverseMul(Scalar other) {
//        System.out.println("Операция " + other + " * " + this + " невозможна");
        return null;
    }
    protected Var reverseMul(Vector other) {
//        System.out.println("Операция " + other + " * " + this + " невозможна");
        return null;
    }
    protected Var reverseMul(Matrix other) {
//        System.out.println("Операция " + other + " * " + this + " невозможна");
        return null;
    }
    protected Var reverseDiv(Scalar other) {
//        System.out.println("Операция " + other + " / " + this + " невозможна");
        return null;
    }
    protected Var reverseDiv(Vector other) {
//        System.out.println("Операция " + vector + " / " + this + " невозможна");
        return null;
    }
    protected Var reverseDiv(Matrix other) {
//        System.out.println("Операция " + vector + " / " + this + " невозможна");
        return null;
    }
}
