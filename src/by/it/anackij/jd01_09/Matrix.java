package by.it.anackij.jd01_09;


import java.util.Arrays;

class Matrix extends Var {
    private double[][] values;

    public Matrix(Matrix someMatrix) {
        this(someMatrix.values);
    }


    public Matrix(String str) {
        //{{2,3,,2},{3,3,5}}
        str.replace(" ", "").trim();
        String[] strRows = str.split("},");
        for (int i = 0; i < strRows.length; i++) {
            strRows[i] = strRows[i].replace("{", "").replace("}", "");
        }
        values = new double[strRows.length][0];
        for (int i = 0; i < strRows.length; i++) {
            String[] oneRow = strRows[i].split(",");
            values[i] = new double[oneRow.length];
            for (int j = 0; j < oneRow.length; j++) {
                values[i][j] = Double.parseDouble(oneRow[j]);
            }
        }
    }

    public Matrix(double[][] values) {
        this.values = new double[values.length][0];
        for (int i = 0; i < values.length; i++) {
            this.values[i] = new double[values[i].length];
            for (int j = 0; j < values[i].length; j++) {
                this.values[i][j] = values[i][j];
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.deepToString(values).replace('[', '{')
                .replace(']', '}');
    }
}
