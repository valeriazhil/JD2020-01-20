package by.it.degtyaryov.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    public Var calc(String expressions) {
        expressions = expressions.trim().replace(" ", "");
        String[] operands = expressions.split(Patterns.OPERATOR, 2);
        if (operands.length == 1) {
            return Var.create(expressions);
        }
       
        Var operTwo = Var.create(operands[1]);
        if (expressions.contains("=")) {
            return Var.saveVariable(operands[0], operTwo);
        }
		Var operOne = Var.create(operands[0]);

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
