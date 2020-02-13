package by.it.degtyaryov.calc;

import java.util.Map;

class Printer {

    public void print(Var variable) {
        if (variable != null) {
            System.out.println(variable);
        }
    }

    public void printVariables() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Var> element : Var.getVariables().entrySet()) {
            sb.append(element.getKey());
            sb.append('=');
            sb.append(element.getValue());
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
