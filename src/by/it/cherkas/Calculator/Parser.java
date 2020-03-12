package by.it.cherkas.Calculator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private Var oneOper(String strLeft, String operation, String srtRight) throws CalcException {
        Var right = Var.create(srtRight);
        if (operation.equals("=")) {
            Var.saveVar(strLeft, right);
            return right;
        }
        Var left = Var.create(strLeft);
        switch (operation) {
            case "+": {
                return left.add(right);
            }
            case "-": {
                return left.sub(right);
            }
            case "*": {
                return left.mul(right);
            }
            case "/": {
                return left.div(right);
            }
        }

        return null;
    }


    Var calc(String expression) throws CalcException {
        expression = expression.trim().replace(" ", "");
        while (expression.contains("(")) {
            Matcher matcherBrackets = Pattern.compile(Patterns.BRACKETS).matcher(expression);
            while (matcherBrackets.find()) {
                String expressionInBrackets = matcherBrackets.group();
                Var inBrackets = calc(expressionInBrackets);
                String strVarInBrackets = inBrackets.toString();
                expression = expression.replace(expressionInBrackets, "");
                expression = expression.replace("()", strVarInBrackets);
            }
        }
        String[] strings = expression.split(Patterns.OPERATION);
        List<String> operands = new ArrayList<>(Arrays.asList(strings));
        if (operands.size() == 1) {
            return Var.create(expression);
        }
        List<String> operations = new ArrayList<>();
        Matcher matcherOperation = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcherOperation.find()) {
            operations.add(matcherOperation.group());
        }
        while (!operations.isEmpty()) {
            int index = getIndexOperation(operations);
            String op = operations.remove(index);
            String strLeft = operands.remove(index);
            String strRight = operands.remove(index);
            Var var = oneOper(strLeft, op, strRight);
            operands.add(index, var.toString());
        }

        return Var.create(operands.get(0));
    }

    private static final Map<String, Integer> priorityMap = new HashMap<>();
    static {
        priorityMap.put("=", 0);
        priorityMap.put("-", 1);
        priorityMap.put("+", 1);
        priorityMap.put("*", 2);
        priorityMap.put("/", 2);
    }

    private int getIndexOperation(List<String> operation) {
        int index = -1;
        int currentPriority = -1;
        for (int i = 0; i < operation.size(); i++) {
            String op = operation.get(i);
            if (priorityMap.get(op) > currentPriority) {
                index = i;
                currentPriority = priorityMap.get(op);
            }

        }
        return index;
    }

}

