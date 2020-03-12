package by.it.zhuravaskarabahataya.calc;

import by.it.zhuravaskarabahataya.calc.translate.Error;
import by.it.zhuravaskarabahataya.calc.translate.ResMan;

import java.util.*;

abstract class Var implements Operation {

    private static ResMan manager = ResMan.INSTANCE;

    static Map<String, Var> vars = FileHelper.getVarsMapFromFile(FileHelper.varsFile);

    static void saveVar(String varName, Var var) {
        vars.put(varName, var);
        FileHelper.writeVarToFile(varName, var, FileHelper.varsFile);
    }
//
//    static void printvar() {
//        List<String> keys = new ArrayList<>(vars.keySet());
//        for (String key : keys) {
//            System.out.println(key + "=" + vars.get(key));
//        }
//    }

    static void sortVar() {
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        List<String> keys = new ArrayList<>(vars.keySet());
        Collections.sort(keys);
    }

    @Override
    public String toString() {
        return "abstract Var";
    }


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format(manager.get(Error.ADD), this, other));
    }

    public Var add(Scalar other) throws CalcException {
        throw new CalcException(String.format(manager.get(Error.ADD), this, other));
    }

    public Var add(Vector other) throws CalcException {
        throw new CalcException(String.format(manager.get(Error.ADD), this, other));
    }

    public Var add(Matrix other) throws CalcException {
        throw new CalcException(String.format(manager.get(Error.ADD), this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format(manager.get(Error.SUB), this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format(manager.get(Error.MUL), this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(manager.get(Error.DIV), this, other));
    }

    static Var create(String strVar) throws CalcException {
        strVar = strVar.trim().replace(" ", "");
        VarCreator varCreator = null;
        if (strVar.matches(Patterns.SCALAR)) {
            varCreator = new ScalarCreator();
        } else if (strVar.matches(Patterns.VECTOR)) {
            varCreator = new VectorCreator();
        } else if (strVar.matches(Patterns.MATRIX)) {
            varCreator = new MatrixCreator();
        } else if (vars.containsKey(strVar)) {
            return vars.get(strVar);
        }
        if (varCreator != null) {
            return varCreator.createVar(strVar);
        } else {
            Var var = vars.get(strVar);
            if (var == null) {
                throw new CalcException(manager.get(Error.VAR_NOT_FOUND) + " (" + strVar + ")");
            } else {
                return var;
            }
        }
//        if (strVar.matches(Patterns.SCALAR)) {
//            return new Scalar(strVar);
//        } else if (strVar.matches(Patterns.VECTOR)) {
//            return new Vector(strVar);
//        } else if (strVar.matches(Patterns.MATRIX)) {
//            return new Matrix((strVar));
//        } else if (vars.containsKey(strVar)) {
//            return vars.get(strVar);
//        } else {
//            Var var = vars.get(strVar);
//            if (var == null) {
//                throw new CalcException(manager.get(Error.VAR_NOT_FOUND) +" ("+ strVar+")");
//            } else {
//                return var;
//            }
//        }
    }


}
