package by.it.makarenko.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression){
        String [] operand = expression.split(Patterns.OPERATION);
        Var left = Var.createVar(operand[0]);
        Var right = Var.createVar(operand[1]);
        if (left==null||right==null)
            return null;
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()){
            String operation = m.group();
            switch (operation){
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);

            }
        }
        return null;
    }
}
