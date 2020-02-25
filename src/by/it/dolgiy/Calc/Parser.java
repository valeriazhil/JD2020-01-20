package by.it.dolgiy.Calc;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String exp) throws CalcException{
        exp = exp.trim().replace("\\s+","");
        String[] part = exp.split(Patterns.OPERATION,2);
        if (part.length==1){
            return Var.createVar(exp);
        }
        Var two = Var.createVar(part[1]);
        if (exp.contains("=")){
            return Var.saveVar(part[0],two);
        }
        Var one = Var.createVar(part[0]);
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(exp);
        if (matcher.find()){
            String operation = matcher.group();
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return null;
    }
}
