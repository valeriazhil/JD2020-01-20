package by.it.akhmelev.jd01_07;

import java.util.Arrays;

public class Matrix extends Var{

    private double[][] values;


    public Matrix(double[][] values) {
        this.values=new double[values.length][values[0].length];
        for (int i = 0; i < this.values.length; i++) {
            for (int j = 0; j < this.values[i].length; j++) {
                this.values[i][j]=values[i][j];
            }
        }
    }

    public Matrix(Matrix m) {
        this(m.values);
    }

    public Matrix(String m) {
        //{{1,2},{3,4}}
        String[] rowRaw = m.replace(" ", "").split("},");
        for (int i = 0; i < rowRaw.length; i++) {
            rowRaw[i]=rowRaw[i].replace("{","").replace("}","");
        }
        values=new double[rowRaw.length][0];
        for (int i = 0; i < rowRaw.length; i++) {
            String[] v = rowRaw[i].split(",");
            values[i]=new double[v.length];
            for (int j = 0; j < values[i].length; j++) {
                values[i][j]=Double.parseDouble(v[j]);
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.deepToString(values)
                .replace('[','{')
                .replace(']','}');
    }
}
