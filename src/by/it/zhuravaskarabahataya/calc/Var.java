package by.it.zhuravaskarabahataya.calc;

import java.util.*;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar (String varName, Var var){
        vars.put(varName, var);
        return var;
    }

    static void printvar (){
        List<String> keys = new ArrayList<>(vars.keySet());
        for (String key : keys) {
            System.out.println(key + "=" + vars.get(key));
        }
    }

    static void sortVar (){
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
    public Var add(Var other) {
        System.out.println("Операция " + this + " + " + other + " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция " + this + " - " + other + " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция " + this + " * " + other + " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция " + this + " / " + other + " невозможна");
        return null;
    }

    static Var create(String strVar){
        strVar = strVar.trim().replace(" ", "");
        if (strVar.matches(Patterns.SCALAR)){
            return new Scalar(strVar);
        }
        else if (strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }
        else if (strVar.matches(Patterns.MATRIX)){
            return new Matrix((strVar));
        }
        else if (vars.containsKey(strVar)){
            return vars.get(strVar);
        }
        else {
            return null; //stub
        }


    }
}
