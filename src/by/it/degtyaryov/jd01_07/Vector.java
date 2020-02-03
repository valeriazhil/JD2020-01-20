package by.it.degtyaryov.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        // TODO добавить проверку соответствует ли полученная строка выражению {x.x, x.x, x.x}  - "\\{[-0-9\\. ,]+\\}"
        Matcher matcher = Pattern.compile("[-0-9]+(\\.[0-9]+)?").matcher(strVector);
        int countMatches = 0;
        while (matcher.find()) {
            countMatches++;
        }
        matcher.reset();
        double[] values = new double[countMatches];
        for (int i = 0; i < values.length; i++) {
            matcher.find();
            values[i] = Double.parseDouble(matcher.group());
        }
        this.value = values;
    }

    @Override
    public String toString() {
        StringBuilder strVector = new StringBuilder();
        String separator = "";
        strVector.append("{");
        for (double element : value) {
            strVector.append(separator).append(element);
            separator = ", ";
        }
        strVector.append("}");
        return strVector.toString();
    }
}
