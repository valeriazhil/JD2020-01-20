package by.it.degtyaryov.calc;

import by.it.degtyaryov.calc.i18n.ResManager;
import by.it.degtyaryov.calc.i18n.TextResource;

public class VarCreator {

    public static Var create(String operand) throws CalcException {
        operand = operand.trim().replace(" ", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        } else if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        } else if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        } else if (Var.getVariables().containsKey(operand)) {
            return Var.getVariables().get(operand);
        } else {
            throw new CalcException(String.format(ResManager.INSTANCE.get(TextResource.UNKNOWN_VARIABLE), operand));
        }
    }
}
