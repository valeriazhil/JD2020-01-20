package by.it.dolgiy.Calc2;


import by.it.dolgiy.Calc.translate.CalcErrors;
import by.it.dolgiy.Calc.translate.ResMan;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

abstract class Var implements Operation {

    static ResMan man = ResMan.INSTANCE;
    private static Map<String, Var> vars= new HashMap<>();
    private static String fileVarPath = TaskH.getPath(Var.class,"Vars.txt");

    static Var saveVar(String name, Var var){
        vars.put(name,var);
        try (final PrintWriter printWriter = new PrintWriter(fileVarPath)){
            Set<Map.Entry<String, Var>> entries = vars.entrySet();
            for (Map.Entry<String, Var> entry : entries) {
                printWriter.println(entry.getKey()+"="+entry.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return var;
    }

    static void loadVars() {
        Parser parser = new Parser();
        try {
            Files
                    .lines(Paths.get(fileVarPath))
                    .forEach(s -> {
                        try {
                            parser.calc(s);
                        } catch (CalcException e) {
                            throw new RuntimeException();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printVar() {
        Set<Map.Entry<String, Var>> entries = vars.entrySet();
        for (Map.Entry<String, Var> entry : entries) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }

    static void sortVar() {
        List<String> keys = new ArrayList<>(vars.keySet());
        Collections.sort(keys);
        for (String key : keys) {
            System.out.println(key + "=" + vars.get(key));
        }
    }

    static Var createVar(String strVar) throws CalcException {
        strVar = strVar.trim().replace(" ","");
        if (strVar.matches(Patterns.SCALAR)){
            return new Scalar(strVar);
        }
        else if (strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }
        else if (strVar.matches(Patterns.MATRIX)){
            return new Matrix(strVar);
        }
        else if (vars.containsKey(strVar)) {
            return vars.get(strVar);
        }
        throw new CalcException(man.get(CalcErrors.IMPOSSIBLE_TO_CREATE)+" "+strVar);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format(man.get(CalcErrors.ADD),this,other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format(man.get(CalcErrors.SUB),this,other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format(man.get(CalcErrors.MUL),this,other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(man.get(CalcErrors.DIV),this,other));

    }

    @Override
    public String toString() {
        return "Var";
    }

}
