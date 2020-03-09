package by.it.akhmelev.calc19;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> map = new HashMap<>();

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Operation " + this + " + " + other + "is impossible");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Operation " + this + " - " + other + " is impossible");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Operation " + this + " * " + other + " is impossible");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Operation " + this + " / " + other + " is impossible");
    }

    static Var create(String strVar) throws CalcException {
        //1.0 {1.0, 2.0} {{1,2},{3,4}}
        strVar = strVar.trim().replace(" ", "");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else {
            Var var = map.get(strVar);
            if (var != null)
                return var;
            else
                throw new CalcException("No var " + strVar);
        }
        //TODO throw error
    }

    @Override
    public String toString() {
        return "abstract Var";
    }

    static void save(String name, Var var) {
        map.put(name, var);
        saveVars();
    }

    private static final String FILE_NAME = Helper.getPath(Var.class, "vars.txt");

    private static void saveVars() {
        try (PrintWriter printWriter = new PrintWriter(FILE_NAME)) {
            for (Map.Entry<String, Var> entry : map.entrySet()) {
                printWriter.printf("%s=%s\n", entry.getKey(), entry.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void loadVars() {
        Parser p=new Parser();

        try {
            Files
                    .lines(Paths.get(FILE_NAME))
                    .forEach(s -> {
                        try {
                            p.calc(s);
                        } catch (CalcException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
