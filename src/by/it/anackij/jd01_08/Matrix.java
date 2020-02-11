package by.it.anackij.jd01_08;


public class Matrix extends Var {
    private double[][] values;

    public Matrix(Matrix someMatrix) {
        this(someMatrix.values);
    }

    public Matrix(double[][] values) {
        this.values = new double[values.length][];
        for (int i = 0; i < values.length; i++) {
            this.values[i] = new double[values.length];
            for (int j = 0; j < values[i].length; j++) {
                this.values[i][j] = values[i][j];
            }
        }
    }


    public Matrix(String str) {
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

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        int endRow = values.length;
        String delimiter = "";
        out.append('{');
        for (int i = 0; i < values.length; i++) {
            out.append('{');
            for (int j = 0; j < values[0].length; j++) {

                delimiter = "";
                out.append(delimiter).append(values[i][j]);
                if (j < values[0].length - 1) {
                    delimiter = ", ";
                    out.append(delimiter);
                }
            }
            out.append('}');
            out.append(delimiter);
            if (i < values.length - 1) {
                delimiter = ", ";
                out.append(delimiter);
            }
        }
        out.append('}');
        return out.toString();
    }
}
