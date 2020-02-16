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
        Matcher mDoubles = Pattern.compile("-?[0-9]+(\\.[0-9]+)?").matcher(strVector);
        int countDoubles = 0;
        while (mDoubles.find()) {
            countDoubles++;
        }
        mDoubles.reset();
        double[] value = new double[countDoubles];
        for (int i = 0; i < value.length; i++) {
            mDoubles.find();
            value[i] = Double.parseDouble(mDoubles.group());
        }
        this.value = value;
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