package by.it.gerasimov.calc;

import by.it.gerasimov.calc.translate.Messages;
import by.it.gerasimov.calc.translate.ResMan;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

abstract class Var implements Operation {

    static ResMan manager = ResMan.INSTANCE;
    private static volatile HashMap<String, Var> vars = new HashMap<>();

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
        setVar(key, Var.create(value));
    }

    public static void setVar(String key, Var var) throws CalcException {
        vars.put(key, var);
        saveVars();
    }

    public static void loadVars() {
        try (BufferedReader br = new BufferedReader(new FileReader(Settings.pathToVars))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("=", 2);
                vars.put(split[0], Var.create(split[1]));
            }
        } catch (IOException | CalcException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveVars() throws CalcException {
        try (PrintWriter pw = new PrintWriter(Settings.pathToVars)) {
            for (Entry<String, Var> entry : vars.entrySet()) {
                pw.println(entry.getKey() + "=" + entry.getValue().toString());
            }
        } catch (FileNotFoundException e) {
            throw new CalcException(e.getMessage());
        }
    }

    public static void log(String str) {
        Logger logger = Logger.getInstance();
        logger.writeLog(str);
    }

    static Var create(String strValue) throws CalcException {
        VarCreator creator;
        strValue = strValue.trim().replace(" ", "");
        if (strValue.matches(Patterns.SCALAR)) {
            creator = new ScalarCreator();
        } else if (strValue.matches(Patterns.VECTOR)) {
            creator = new VectorCreator();
        } else if (strValue.matches(Patterns.MATRIX)) {
            creator = new MatrixCreator();
        } else if (strValue.matches(Patterns.VARIABLE)) {
            if (vars.containsKey(strValue)) {
                return vars.get(strValue);
            } else {
                throw new CalcException(manager.get(Messages.NOT_FOUND_VAR) + " " + strValue);
            }
        } else {
            throw new CalcException(manager.get(Messages.INVALID_INPUT));
        }
        return creator.getVar(strValue);
    }

    @Override
    public String toString() {
        return "X";
    }

    public Var operate(Var other, String operator) throws CalcException {
        Var result;
        switch (operator) {
            case "+":
                result = this.add(other);
                break;
            case "-":
                result = this.sub(other);
                break;
            case "*":
                result = this.mul(other);
                break;
            case "/":
                result = this.div(other);
                break;
            default:
                result = null;
        }
        log("Операция " + this + " " + operator + " " + other +
            (result != null ? " = " + result : "невозможна"));
        return result;
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(
            String.format(manager.get(Messages.ILLEGAL_OPERATION_EXCEPTION), this, '+', other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(
            String.format(manager.get(Messages.ILLEGAL_OPERATION_EXCEPTION), this, '-', other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(
            String.format(manager.get(Messages.ILLEGAL_OPERATION_EXCEPTION), this, '*', other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(
            String.format(manager.get(Messages.ILLEGAL_OPERATION_EXCEPTION), this, '/', other));
    }

    protected Var reverseAdd(Scalar other) throws CalcException {
        throw new CalcException(
            String.format(manager.get(Messages.ILLEGAL_OPERATION_EXCEPTION), other, '+', this));
    }

    protected Var reverseAdd(Vector other) throws CalcException {
        throw new CalcException(
            String.format(manager.get(Messages.ILLEGAL_OPERATION_EXCEPTION), other, '+', this));
    }

    protected Var reverseAdd(Matrix other) throws CalcException {
        throw new CalcException(
            String.format(manager.get(Messages.ILLEGAL_OPERATION_EXCEPTION), other, '+', this));
    }

    protected Var reverseSub(Scalar other) throws CalcException {
        throw new CalcException(
            String.format(manager.get(Messages.ILLEGAL_OPERATION_EXCEPTION), other, '-', this));
    }

    protected Var reverseSub(Vector other) throws CalcException {
        throw new CalcException(
            String.format(manager.get(Messages.ILLEGAL_OPERATION_EXCEPTION), other, '-', this));
    }

    protected Var reverseSub(Matrix other) throws CalcException {
        throw new CalcException(
            String.format(manager.get(Messages.ILLEGAL_OPERATION_EXCEPTION), other, '-', this));
    }

    protected Var reverseMul(Scalar other) throws CalcException {
        throw new CalcException(
            String.format(manager.get(Messages.ILLEGAL_OPERATION_EXCEPTION), other, '*', this));
    }

    protected Var reverseMul(Vector other) throws CalcException {
        throw new CalcException(
            String.format(manager.get(Messages.ILLEGAL_OPERATION_EXCEPTION), other, '*', this));
    }

    protected Var reverseMul(Matrix other) throws CalcException {
        throw new CalcException(
            String.format(manager.get(Messages.ILLEGAL_OPERATION_EXCEPTION), other, '*', this));
    }

    protected Var reverseDiv(Scalar other) throws CalcException {
        throw new CalcException(
            String.format(manager.get(Messages.ILLEGAL_OPERATION_EXCEPTION), other, '/', this));
    }

    protected Var reverseDiv(Vector other) throws CalcException {
        throw new CalcException(
            String.format(manager.get(Messages.ILLEGAL_OPERATION_EXCEPTION), other, '/', this));
    }

    protected Var reverseDiv(Matrix other) throws CalcException {
        throw new CalcException(
            String.format(manager.get(Messages.ILLEGAL_OPERATION_EXCEPTION), other, '/', this));
    }
}
