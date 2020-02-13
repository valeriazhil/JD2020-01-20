package by.it.degtyaryov.calc;

import java.util.*;

class Printer {

    public void print(Var variable) {
        if (variable != null) {
            System.out.println(variable);
        }
    }

    public void printVariables(boolean needSort) {
        Set<Map.Entry<String, Var>> entries;
        // при создании TreeMap значения сортируются по ключу
        entries = (needSort) ? new TreeMap<>(Var.getVariables()).entrySet() : Var.getVariables().entrySet();

        // для возможности сортировки как по ключу, так и по значению, необходимо использовать метод Collections.sort
        // но необходимо реализовать дополнительно компаратор в классе Var
        /*List<Map.Entry<String, Var>> list = new ArrayList<>(Var.getVariables().entrySet());
        list.sort(Map.Entry.comparingByKey());
        System.out.print(list);*/

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
