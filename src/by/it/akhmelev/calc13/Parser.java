package by.it.akhmelev.calc13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) throws CalcException {
        expression=expression.trim().replace(" ","");
        //2+3
        String[] part = expression.split(Patterns.OPERATION,2);
        if (part.length==1)
            return Var.create(expression);
        Var right= Var.create(part[1]);
        if (expression.contains("=")){
            Var.save(part[0],right);
            return right;
        }
        Var left= Var.create(part[0]);
        Pattern compile = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = compile.matcher(expression);
        if (matcher.find()){
            String operation=matcher.group();
            switch (operation) {
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);
            }
        }

        return null;
    }


}
