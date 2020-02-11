package by.it.dolgiy.jd01_07;

class Matrix extends Var{

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
