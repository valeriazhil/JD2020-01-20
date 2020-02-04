package by.it.dolgiy.jd01_07;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var{

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        Pattern pattern = Pattern.compile("[\\d\\\\.\\d]+");
        Matcher matcher = pattern.matcher(strVector);
        double[] strVector1 ={};
        while (matcher.find()) {
            String word = matcher.group();
            int last = strVector1.length;
            strVector1 = Arrays.copyOf(strVector1, last + 1);
            strVector1[last] = Double.parseDouble(word);
        }
        this.value = strVector1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value){
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
