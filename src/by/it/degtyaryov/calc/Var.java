package by.it.degtyaryov.calc;

import by.it.degtyaryov.calc.i18n.ResManager;
import by.it.degtyaryov.calc.i18n.TextResource;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static final String VARS_FILE = Helper.getPath(Var.class, "var.txt");
    private static Map<String, Var> variables = new HashMap<>();

    private static ResManager res = ResManager.INSTANCE;

    public static Var saveVariable(String key, Var value) {
        Var var = variables.put(key, value);
        saveVars();
        return var;
    }

    public static void loadVars() throws IOException, CalcException {
        try (BufferedReader reader = new BufferedReader(new FileReader(VARS_FILE))) {
            String var;
            while ((var = reader.readLine()) != null) {
                String[] split = var.trim().split("=");
                variables.put(split[0], VarCreator.create(split[1]));
            }
        }
    }

    private static void saveVars() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(VARS_FILE))) {
            for (Map.Entry<String, Var> entry : variables.entrySet()) {
                String line = String.format("%s=%s%n", entry.getKey(), entry.getValue());
                Logger.getInstance().log(line);
                writer.printf(line);
            }
        } catch (IOException e) {
            Logger.getInstance().log(e.getMessage());
            e.printStackTrace();
        }
    }

    public static Map<String, Var> getVariables() {
        return variables;
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format(res.get(TextResource.ADD_OPERATION_IMPOSSIBLE), other, this));
    }

    public abstract Var add(Scalar scalar) throws CalcException;

    public abstract Var add(Vector vector) throws CalcException;

    public abstract Var add(Matrix matrix) throws CalcException;

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format(res.get(TextResource.SUB_OPERATION_IMPOSSIBLE), other, this));
    }

    public abstract Var sub(Scalar scalar) throws CalcException;

    public abstract Var sub(Vector vector) throws CalcException;

    public abstract Var sub(Matrix matrix) throws CalcException;

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format(res.get(TextResource.MUL_OPERATION_IMPOSSIBLE), other, this));
    }

    public abstract Var mul(Scalar scalar) throws CalcException;

    public abstract Var mul(Vector vector) throws CalcException;

    public abstract Var mul(Matrix matrix) throws CalcException;

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(res.get(TextResource.DIV_OPERATION_IMPOSSIBLE), other, this));
    }

    public abstract Var div(Scalar scalar) throws CalcException;

    public abstract Var div(Vector vector) throws CalcException;

    public abstract Var div(Matrix matrix) throws CalcException;
}
