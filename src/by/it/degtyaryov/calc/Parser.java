package by.it.degtyaryov.calc;

import by.it.degtyaryov.calc.i18n.ResManager;
import by.it.degtyaryov.calc.i18n.TextResource;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private static final Map<String, Integer> OPERATION_PRIORITY = new HashMap<>();
    private ResManager res = ResManager.INSTANCE;

    static {
        OPERATION_PRIORITY.put("=", 0);
        OPERATION_PRIORITY.put("+", 1);
        OPERATION_PRIORITY.put("-", 1);
        OPERATION_PRIORITY.put("*", 2);
        OPERATION_PRIORITY.put("/", 2);
    }

    public Var calc(String expressions) throws CalcException {
        expressions = expressions.trim().replace(" ", "");
        String[] strOperands = expressions.split(Patterns.OPERATOR);
        List<String> operands = new ArrayList<>(Arrays.asList(strOperands));
        if (operands.size() == 1) {
            return Var.create(expressions);
        }

        List<String> operators = new ArrayList<>();
        Matcher operator = Pattern.compile(Patterns.OPERATOR).matcher(expressions);
        while (operator.find()) {
            operators.add(operator.group());
        }

        while (!operators.isEmpty()) {
            int index = getOperationIndex(operators);
            String op = operators.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var result = calcOneOperation(left, op, right);
            operands.add(index, result.toString());
        }
        return Var.create(operands.get(0));
    }

    private int getOperationIndex(List<String> operations) {
        int index = -1;
        int current = -1;

        for (int i = 0; i < operations.size(); i++) {
            String s = operations.get(i);
            if (OPERATION_PRIORITY.get(s) > current) {
                index = i;
                current = OPERATION_PRIORITY.get(s);
            }
        }
        return index;
    }

    private Var calcOneOperation(String strLeft, String operator, String strRight) throws CalcException {
        Var varRight = Var.create(strRight);
        if (operator.equals("=")) {
            Var.saveVariable(strLeft, varRight);
            return varRight;
        }
        Var varLeft = Var.create(strLeft);

        switch (operator) {
            case "+":
                return varLeft.add(varRight);
            case "-":
                return varLeft.sub(varRight);
            case "*":
                return varLeft.mul(varRight);
            case "/":
                return varLeft.div(varRight);
            default:
                throw new CalcException(String.format(res.get(TextResource.UNKNOWN_OPERATION), operator));
        }
    }
}
