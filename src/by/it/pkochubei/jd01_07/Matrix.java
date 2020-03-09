package by.it.pkochubei.jd01_07;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;


    public Matrix(double[][] values) {
        this.value=new double[values.length][values[0].length];
        for (int i = 0; i < this.value.length; i++) {
            System.arraycopy(values[i], 0, this.value[i], 0, this.value[i].length);
        }
    }


    public Matrix(Matrix m) {
        this(m.value);
    }

    public Matrix(String m) {
        String[] rowRaw = m.replace(" ", "").split("},");
        for (int i = 0; i < rowRaw.length; i++) {
            rowRaw[i]=rowRaw[i].replace("{","").replace("}","");
        }
        value=new double[rowRaw.length][0];
        for (int i = 0; i < rowRaw.length; i++) {
            String[] v = rowRaw[i].split(",");
            value[i]=new double[v.length];
            for (int j = 0; j < value[i].length; j++) {
                value[i][j]=Double.parseDouble(v[j]);
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.deepToString(value)
                .replace('[','{')
                .replace(']','}');
    }
}