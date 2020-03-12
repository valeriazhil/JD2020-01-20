package by.it.gerasimov.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String strValue) throws CalcException {
        strValue = strValue.trim().replace(" ", "");
        if (strValue.matches(Patterns.ASSIGNMENT)) {
            String[] map = strValue.split(Patterns.ASSIGNMENT_OPERATORS);
            Var var = calcLine(clearFromBrackets(map[1]), 0);
            Var.setVar(map[0], var);
            return var;
        } else {
            return calcLine(clearFromBrackets(strValue), 0);
        }
    }

    private String clearFromBrackets(String str) throws CalcException {
        Pattern bracket = Pattern.compile(Patterns.BRACKETS);
        Matcher m = bracket.matcher(str);
        if (!m.find()) {
            return str;
        }
        m.reset();
        while (m.find()) {
            String brackets = m.group();
            str = str.replace(brackets,
                calcLine(brackets.substring(1, brackets.length() - 1), 0).toString());
            m = bracket.matcher(str);
        }
        clearFromBrackets(str);
        return str;
    }

    private Var calcLine(String str, int priority) throws CalcException {
        if (priority == Patterns.OPERATIONS.length) {
            return Var.create(str);
        }
        String[] vars = str.split(Patterns.OPERATIONS[priority]);
        Var result = calcLine(vars[0], priority + 1);
        if (vars.length > 1) {
            Matcher m = Pattern.compile(Patterns.OPERATIONS[priority]).matcher(str);
            for (int j = 1; j < vars.length; j++) {
                if (m.find()) {
                    result = result.operate(calcLine(vars[j], priority + 1), m.group());
                }
            }
        }
        return result;
    }
}
