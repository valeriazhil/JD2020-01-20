package by.it.zhuravaskarabahataya.calc;

import by.it.zhuravaskarabahataya.calc.translate.Error;
import by.it.zhuravaskarabahataya.calc.translate.ResMan;
import java.util.*;

abstract class Var implements Operation {

    private static ResMan manager = ResMan.INSTANCE;

    private static Map<String, Var> vars = FileHelper.getVarsMapFromFile(FileHelper.varsFile);

    static Var saveVar(String varName, Var var) {
        vars.put(varName, var);
        FileHelper.writeVarToFile(varName, var, FileHelper.varsFile);
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
    }

    @Override
    public String toString() {
        return "abstract Var";
    }


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format(manager.get(Error.ADD) , this, other));
    }

    public Var add(Scalar other) throws CalcException {
        throw new CalcException(String.format("Operation %s + %s is impossible", this, other));
    }

    public Var add(Vector other) throws CalcException {
        throw new CalcException(String.format("Operation %s + %s is impossible", this, other));
    }

    public Var add(Matrix other) throws CalcException {
        throw new CalcException(String.format("Operation %s + %s is impossible", this, other));
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
