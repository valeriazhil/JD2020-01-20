package by.it.lomazki.Example;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        double[] value;
        String strVector = "{1.0, 2.0, 4.0}";


        String[] arrStrVector = strVector.replaceAll("[{} ]+", "").split(",");
        value = new double[arrStrVector.length];
        System.out.println(Arrays.toString(value));
        System.out.println(arrStrVector.length);
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(arrStrVector[i]);
            System.out.println(value[i] +" "+ arrStrVector[i]);
        }


    }
}
