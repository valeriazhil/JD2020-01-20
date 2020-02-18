package by.it.anackij.jd01_08;


import static java.lang.System.*;

public class Matrix extends Var implements Operation {
    private double[][] values;

    public double[][] getValues() {
        return values;
    }

    public Matrix(double[][] values) {
        this.values = new double[values.length][];
        for (int i = 0; i < values.length; i++) {
            this.values[i] = new double[values.length];
            arraycopy(values[i], 0, this.values[i], 0, values[i].length);
        }
    }

    public Matrix(Matrix someMatrix) {
        this(someMatrix.values);
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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] result = this.values;
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < values.length; j++) {
                    result[i][j] += ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);

        } else if (other instanceof Matrix) {
            double[][] arrFirst = values;
            double[][] arrSecond = ((Matrix) other).getValues();
            double[][] result = new double[arrFirst.length][arrFirst[0].length];

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] += arrFirst[i][j] + arrSecond[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] result = this.values;
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < values.length; j++) {
                    result[i][j] -= ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);

        } else if (other instanceof Matrix && values.length == ((Matrix) other).getValues().length) {
            double[][] arrFirst = this.values;
            double[][] arrSecond = ((Matrix) other).getValues();
            double[][] result = new double[arrFirst.length][arrFirst[0].length];

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = arrFirst[i][j] - arrSecond[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {

            double[][] result = this.values;
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] *= ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);

        }
        if (other instanceof Vector && values.length == ((Vector) other).getValues().length){

            double[]result = new double[((Vector) other).getValues().length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i]+= this.values[i][j]*((Vector) other).getValues()[j];
                }
            }
            return new Vector(result);
        }
        else if (other instanceof Matrix && values.length == ((Matrix) other).getValues().length) {

            double[][] arrFirst = this.values;
            double[][] arrSecond = ((Matrix) other).getValues();
            double[][] result = new double[values.length][values.length];
            for (int i = 0; i < arrFirst.length; i++) {
                for (int j = 0; j < arrFirst.length; j++) {
                    for (int k = 0; k < arrFirst.length; k++) {
                        result[i][j]+= arrFirst[i][k] * arrSecond[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() == 0) {
                return null;
            }
            double[][] result = new double[values.length][];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < values.length; j++) {
                    result[i][j] += ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        return super.div(other);
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
