package by.it.degtyaryov.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

   /* Matrix(String strMatrix) {
        Matcher mArrays = Pattern.compile("\\{[-0-9\\. ,]+\\}").matcher(strMatrix);
        int countArrays = 0;
        while (mArrays.find()) {
            countArrays++;
        }
        mArrays.reset();

        for (int i = 0; i < countArrays; i++) {
            mArrays.find();
            String array = mArrays.group();
            Matcher mElements = Pattern.compile("[-0-9]+(\\.[0-9]+)?").matcher(array);
            int countNums = 0;
            while (mElements.find()) {
                countNums++;
            }
            mElements.reset();
            double[][] value = new double[countArrays][countNums];
            for (int j = 0; j < value[i].length; j++) {
                matcher.find();
                value[i][j] = Double.parseDouble(mElements.group());
            }
            mArrays.find();
        }
        this.value = value;
    }*/

    @Override
    public String toString() {
        StringBuilder strVector = new StringBuilder();
        String separArrays = "";
        strVector.append("{");
        for (double[] array : value) {
            strVector.append(separArrays).append("{");
            separArrays = ", ";
            String separElements = "";
            for (double element : array) {
                strVector.append(separElements).append(element);
                separElements = ", ";
            }
            strVector.append("}");
        }
        strVector.append("}");
        return strVector.toString();
    }
}
