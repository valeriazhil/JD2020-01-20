package by.it.degtyaryov.jd01_08;

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

    Matrix(String strMatrix) {
        Pattern patternVectors = Pattern.compile("\\{[0-9\\., -]+\\}"); // шаблон для поиска подмассивов {х.х, х.х}
        Pattern patternNums = Pattern.compile("-?[0-9]+(\\.[0-9]+)?"); // шаблон для поиска чисел в подмассиве х.х х.х
        Matcher matchVectors = patternVectors.matcher(strMatrix);
        Matcher matchNums;
        int countVectors = 0;
        int countNums = 0;
        while (matchVectors.find()) {
            countVectors++;
            countNums = 0;
            matchNums = patternNums.matcher(matchVectors.group());
            while (matchNums.find()) {
                countNums++;
            }
        }
        double[][] value = new double[countVectors][countNums];
        matchVectors.reset();
        int indexVector = 0;
        int indexNum = 0;
        while (matchVectors.find()) {
            matchNums = patternNums.matcher(matchVectors.group());
            while (matchNums.find()) {
                value[indexVector][indexNum++] = Double.parseDouble(matchNums.group());
            }
            indexVector++;
            indexNum = 0;
        }
        this.value = value;
    }

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