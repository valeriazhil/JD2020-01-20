package by.it.degtyaryov.calc;

import by.it.degtyaryov.calc.i18n.ResManager;
import by.it.degtyaryov.calc.i18n.TextResource;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private static final Map<String, Integer> OPERATION_PRIORITY = new HashMap<>();

    static {
        OPERATION_PRIORITY.put("=", 0);
        OPERATION_PRIORITY.put("+", 1);
        OPERATION_PRIORITY.put("-", 1);
        OPERATION_PRIORITY.put("*", 2);
        OPERATION_PRIORITY.put("/", 2);
    }

    private ResManager res = ResManager.INSTANCE;

    public Var calc(String expressions) throws CalcException {
        expressions = expressions.trim().replace(" ", "");

        expressions = calcSubExpressions(expressions);

        String[] strOperands = expressions.split(Patterns.OPERATOR);
        List<String> operands = new ArrayList<>(Arrays.asList(strOperands));
        if (operands.size() == 1) {
            return VarCreator.create(expressions);
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
        return VarCreator.create(operands.get(0));
    }

    private String calcSubExpressions(String expressions) throws CalcException {
        while (expressions.contains("(") && expressions.contains(")")) {
            String sub = getSubExpression(expressions);
            String subWithoutBrackets = sub.substring(1, sub.length() - 1);
            expressions = expressions.replace(sub, calc(subWithoutBrackets).toString());
        }
        return expressions;
    }

    private String getSubExpression(String expressions) {
        Deque<Character> deque = new LinkedList<>();
        int firstBracket = 0;
        int lastBracket = 0;
        boolean findFirst = false;
        char[] chars = expressions.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                if (!findFirst) {
                    firstBracket = i;
                    findFirst = true;
                } else {
                    deque.addLast('(');
                }
            } else if (chars[i] == ')') {
                if (deque.size() == 0) {
                    lastBracket = i;
                    break;
                } else {
                    deque.pollLast();
                }
            }
        }
        return expressions.substring(firstBracket, lastBracket + 1);
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
        Var varRight = VarCreator.create(strRight);
        if (operator.equals("=")) {
            VarSaver.saveVariable(strLeft, varRight);
            return varRight;
        }
        Var varLeft = VarCreator.create(strLeft);

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
