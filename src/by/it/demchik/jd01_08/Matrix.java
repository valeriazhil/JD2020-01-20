package by.it.demchik.jd01_08;

import java.util.Arrays;

class Matrix extends Var {
//создание матрцы,двумерного массива
    private double[][] values;

    public Matrix(double[][] array) {
        this.values = new double[array.length][0];
        for (int i = 0; i < array.length; i++) {

            double[] row = array[i];

            this.values[i] = new double[row.length];

            for (int j = 0; j < row.length; j++) {
                this.values[i][j] = row[j];
            }
        }
    }

    public Matrix(Matrix someMatrix) {
            this(someMatrix.values);
        }


        public Matrix(String str) {
            //{{2,2,2},{3,3,4}}
            str=str.replace(" ","").trim();
            String[] strRows = str.split("},");
            for (int i = 0; i < strRows.length; i++) {
                strRows[i]=strRows[i].replace("{","").replace("}","");
            }
            values=new double[strRows.length][0];
            for (int i = 0; i < strRows.length; i++) {
                String[] oneRow=strRows[i].split(",");
                values[i]=new double[oneRow.length];
                for (int j = 0; j < oneRow.length; j++) {
                    values[i][j]=Double.parseDouble(oneRow[j]);
                }
            }
        }

    @Override
    public String toString() {
        //[[1,2],[3,4]]
        return Arrays.deepToString(values)
                .replace('[', '{')
                .replace(']', '}');
    }
}

