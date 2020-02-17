package by.it.dolgiy.Calc;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value=new double[value.length][0];
        for (int i = 0; i < value.length; i++) {
            double[] row=value[i];
            this.value[i]=new double[row.length];
            for (int j = 0; j < row.length; j++) {
                this.value[i][j]=row[j];
            }
        }
//        this.value=new double[value.length][value[0].length];
//        for (int i = 0; i < this.value.length; i++) {
//            for (int j = 0; j < this.value[i].length; j++) {
//                this.value[i][j] = value[i][j];
//            }
//        }
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix){
        String[] rowRaw = strMatrix.replace(" ", "").split("},");
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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] add1=new double[value.length][value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        add1[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                    }
                }
            return new Matrix(add1);
        }
        else if (other instanceof Matrix) {
            double[][] add1=new double[value.length][value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    add1[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(add1);
        }
        return super.add(other);
    }


    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] sub1=new double[value.length][value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    sub1[i][j] = this.value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(sub1);
        }
        else if (other instanceof Matrix) {
            double[][] sub1 = new double[value.length][value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    sub1[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(sub1);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[][] mul1=new double[value.length][value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    mul1[i][j] = this.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(mul1);
        }
        else if (other instanceof Vector){
            double[][] mul1=new double[value.length][value[0].length];
            double[] mul2=new double[value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    mul1[i][j] = this.value[i][j] * ((Vector) other).getValue()[j];
                    mul2[i] += mul1[i][j];
                }
            }
            return new Vector(mul2);
        }
        else if (other instanceof Matrix){
            double[][] mul1=new double[value.length][value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    for (int k = 0; k < this.value.length; k++) {
                        mul1[i][j] =mul1[i][j] + this.value[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(mul1);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                if (j < value[i].length-1)
                    sb.append(", ");
            }
            sb.append("}");
            if (i < value.length-1)
                sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
