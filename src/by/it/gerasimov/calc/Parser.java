package by.it.gerasimov.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String strValue) {
        strValue = strValue.trim().replace(" ", "");
        return calc(strValue, 0);
    }

    private Var calc(String str, int priority) {
        if (priority == Patterns.OPERATIONS.length) {
            return Var.create(str);
        }
        String[] vars = str.split(Patterns.OPERATIONS[priority]);
        Var result = calc(vars[0], priority + 1);
        if (vars.length > 1) {
            Matcher m = Pattern.compile(Patterns.OPERATIONS[priority]).matcher(str);
            for (int j = 1; j < vars.length; j++) {
                if (m.find()) {
                    result = result.operate(calc(vars[j], priority + 1), m.group());
                }
            }
        }
        return result;
    }


}
