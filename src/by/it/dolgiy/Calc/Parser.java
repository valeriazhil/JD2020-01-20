package by.it.dolgiy.Calc;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private Var oneOperation(String strLeft, String operation, String strRight) throws CalcException {
        Var right = Var.createVar(strRight);
        if (operation.equals("=")) {
            Var.saveVar(strLeft, right);
            return right;
        }
        Var left = Var.createVar(strLeft);
        switch (operation) {
            case "+":
                Logger.writeExpression((left+"+"+right),left.add(right).toString());
                return left.add(right);
            case "-":
                Logger.writeExpression((left+"-"+right),left.sub(right).toString());
                return left.sub(right);
            case "*":
                Logger.writeExpression((left+"*"+right),left.mul(right).toString());
                return left.mul(right);
            case "/":
                Logger.writeExpression((left+"/"+right),left.div(right).toString());
                return left.div(right);
        }
        return null;
    }

    Var calc(String exp) throws CalcException {
        String exp1 = exp;
        exp = exp.trim().replace("\\s+","");
        String[] strings = exp.split(Patterns.OPERATION);
        List<String> operands = new ArrayList<>(Arrays.asList(strings));
        if (operands.size()==1){
            return Var.createVar(exp);
        }
        List<String> operation = new ArrayList<>();
        Matcher matcherOperation = Pattern.compile(Patterns.OPERATION).matcher(exp);
        while (matcherOperation.find()) {
            operation.add(matcherOperation.group());
        }
        while (!operation.isEmpty()) {
            int index = getIndexOperation(operation);
            String op = operation.remove(index);
            String strLeft = operands.remove(index);
            String strRight = operands.remove(index);
            Var res = oneOperation(strLeft, op, strRight);
            operands.add(index, res.toString());
        }
        Logger.writeExpression(exp1,Var.createVar(operands.get(0)).toString());
        return Var.createVar(operands.get(0));
    }

    private static final Map<String,Integer> PR_MAP =new HashMap<>();
    static {
        PR_MAP.put("=",0);
        PR_MAP.put("+",1);
        PR_MAP.put("-",1);
        PR_MAP.put("*",2);
        PR_MAP.put("/",2);
    }

    private int getIndexOperation(List<String> operation) {
        int index=-1;
        int current=-1;
        for (int i = 0; i < operation.size(); i++) {
            String op = operation.get(i);
            if (PR_MAP.get(op)>current){
                index=i;
                current= PR_MAP.get(op);
            }
        }
        return index;
    }

}
