package by.it.kondratev.jd01_07;

class Matrix extends Var {

    private double[][] array;

    Matrix(double[ ][ ]  value) {
        array = value;
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.substring(1, strMatrix.length() - 2);
        String[] row = strMatrix.split("},");
        for (int i = 0; i <row.length ; i++) {
            row[i] = row[i].substring(1);
        }
        String [] cols = row[0].split(",");
        double [][] mas = new double[row.length][cols.length];
        for (int i = 0; i < row.length ; i++) {
            String [] col = row[i].split(",");
            for (int j = 0; j < col.length ; j++) {
                mas[i][j] = Double.parseDouble(col[j]);

            }
        }
        array = mas;
    }

    Matrix(Matrix matrix) {
        array = matrix.array;
    }


    public String toString() {
        StringBuilder s = new StringBuilder("{{");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                s.append(array[i][j]);
                if (j==array[0].length-1 && i!=array.length-1) s.append("}, {");
                   else if (j==array[0].length-1 && i==array.length-1) s.append("}}");
                           else s.append(", ");
            }
        }

        return s.toString();
    }


}