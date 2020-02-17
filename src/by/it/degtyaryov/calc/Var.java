package by.it.degtyaryov.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> variables = new HashMap<>();

    public static Var saveVariable(String key, Var value) {
        return variables.put(key, value);
    }

    public static Map<String, Var> getVariables() {
        return variables;
    }

    public static Var create(String operand) throws CalcException {
        operand = operand.trim().replace(" ", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        } else if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        } else if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        } else if (variables.containsKey(operand)) {
            return variables.get(operand);
        } else {
            throw new CalcException("unknown variables " + operand);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Невозможно выполнить операцию " + other + " + " + this);
    }

    public abstract Var add(Scalar scalar) throws CalcException;

    public abstract Var add(Vector vector) throws CalcException;

    public abstract Var add(Matrix matrix) throws CalcException;

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Невозможно выполнить операцию " + other + " - " + this);
    }

    public abstract Var sub(Scalar scalar) throws CalcException;

    public abstract Var sub(Vector vector) throws CalcException;

    public abstract Var sub(Matrix matrix) throws CalcException;

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Невозможно выполнить операцию " + other + " * " + this);
    }

    public abstract Var mul(Scalar scalar) throws CalcException;

    public abstract Var mul(Vector vector) throws CalcException;

    public abstract Var mul(Matrix matrix) throws CalcException;

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Невозможно выполнить операцию " + other + " / " + this);
    }

    public abstract Var div(Scalar scalar) throws CalcException;

    public abstract Var div(Vector vector) throws CalcException;

    public abstract Var div(Matrix matrix) throws CalcException;
}
