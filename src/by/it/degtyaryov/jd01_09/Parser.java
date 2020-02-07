package by.it.degtyaryov.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    public Var calc(String expressions) {
        expressions = expressions.trim().replace(" ", "");
        String[] operands = expressions.split(Patterns.OPERATOR);
        if (operands.length == 1) {
            return Var.create(expressions);
        }

        Var operOne = Var.create(operands[0]);
        Var operTwo = Var.create(operands[1]);

        Matcher operator = Pattern.compile(Patterns.OPERATOR).matcher(expressions);
        String op = "";
        if (operator.find()) {
            op = operator.group();
        }
        switch (op) {
            case "+":
                return operOne.add(operTwo);
            case "-":
                return operOne.sub(operTwo);
            case "*":
                return operOne.mul(operTwo);
            case "/":
                return operOne.div(operTwo);
            default:
                return null;
        }
    }
}
