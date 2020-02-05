package by.it.anackij.jd01_07;

public class Matrix extends Var {
    private String stringValue;
    private Matrix values;
    private double[][] doublesArrayValue = {{1, 2},
            {3,4}};

    public Matrix() {
    }

    public Matrix(double[][] value) {
        this.doublesArrayValue = value;
    }

    public Matrix(Matrix values) {
        this.values = values;
    }


    public Matrix(String str) {
        this.stringValue = str;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        int endRow = doublesArrayValue.length;
        String delimiter = "";
        out.append('{');
        for (int i = 0; i < doublesArrayValue.length; i++) {
            out.append('{');
            for (int j = 0; j < doublesArrayValue[0].length; j++) {

                delimiter = "";
                out.append(delimiter).append(doublesArrayValue[i][j]);
                if (j < doublesArrayValue[0].length - 1) {
                    delimiter = ", ";
                    out.append(delimiter);
                }
            }
            out.append('}');
            out.append(delimiter);
            if (i < doublesArrayValue.length-1) {
                delimiter = ", ";
                out.append(delimiter);
            }
        }
        out.append('}');
        return out.toString();
    }
}
