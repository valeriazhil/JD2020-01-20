package by.it.degtyaryov.calc;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Printer {

    public void print(Var variable) {
        if (variable != null) {
            System.out.println(variable);
        }
    }

    public void printVariables(boolean needSort) {
        Set<Map.Entry<String, Var>> entries;
        entries = (needSort) ? new TreeMap<>(Var.getVariables()).entrySet() : Var.getVariables().entrySet();

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Var> element : entries) {
            sb.append(element.getKey());
            sb.append('=');
            sb.append(element.getValue());
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
