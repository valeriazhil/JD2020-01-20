package by.it.dolgiy.jd01_09;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String exp){
        exp = exp.trim().replace("\\s+","");
        String[] part = exp.split(Patterns.OPERATION,2);
        if (part.length==1){
            return Var.createVar(exp);
        }
        Var one = Var.createVar(part[0]);
        Var two = Var.createVar(part[1]);
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
