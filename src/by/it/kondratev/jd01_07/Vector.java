package by.it.kondratev.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private double[] mas;

    Vector(double [] mas) {
    this.mas = mas;
    }

    Vector(Vector vector) {
        mas = vector.mas;
    }


    Vector(String  StrVector) {
        String[] arr = StrVector.split(" ");
        double [] array = new double [arr.length];
        for (int i = 0; i < arr.length ; i++) {
            array [i] = Double.parseDouble(arr[i]);
        }
        mas = array;
    }

    @Override
    public String toString() {
        double[] massive = mas;
        StringBuilder s = new StringBuilder("{"+massive[0]);
        for (int i = 1; i < massive.length; i++) {
            s.append(", ").append(massive[i]);
        }
        s.append("}");
        return s.toString();
    }

    @Override
    void toString(double[] massive) {

    }

}

