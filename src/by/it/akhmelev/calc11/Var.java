package by.it.akhmelev.calc11;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String,Var> map=new HashMap<>();

    @Override
    public Var add(Var other) {
        System.out.println("Операция "+this+" + "+other+" невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция "+this+" - "+other+" невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция "+this+" * "+other+" невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция "+this+" / "+other+" невозможна");
        return null;
    }

    static Var create(String strVar){
        //1.0 {1.0, 2.0} {{1,2},{3,4}}
        strVar=strVar.trim().replace(" ","");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else
            return map.get(strVar); //stub
            //TODO throw error
    }

    @Override
    public String toString() {
        return "abstract Var";
    }

    static void save(String name, Var var) {
        map.put(name,var);
    }
}
