package by.it.degtyaryov.calc;

import by.it.degtyaryov.calc.i18n.ResManager;
import by.it.degtyaryov.calc.i18n.TextResource;

abstract class Var implements Operation {

    private static ResManager res = ResManager.INSTANCE;

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
