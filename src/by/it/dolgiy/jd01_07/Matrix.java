package by.it.dolgiy.jd01_07;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var{

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix){
//        Pattern pattern = Pattern.compile("[\\\\{\\d\\\\.\\d\\\\,\\\\ ]+");
//        Matcher matcher = pattern.matcher(strMatrix);
//        double[][] strMatrix1 ={};
//        while (matcher.find()) {
//            String word = matcher.group();
//            int last = strMatrix1.length;
//            strMatrix1 = Arrays.copyOf(strMatrix1, last + 1);
//            for (int i = 0; i < strMatrix1.length; i++) {
//                Pattern pattern1 = Pattern.compile("[\\d\\\\.\\d]+");
//                Matcher matcher1 = pattern1.matcher(word);
//                while (matcher1.find()) {
//                    String word1 = matcher1.group();
//                    for (int j = 0; j < strMatrix1.length; j++) {
//                        int lastJ = strMatrix1[j].length;
//                        strMatrix1 = Arrays.copyOf(strMatrix1,lastJ+1);
//                        strMatrix1[i][j] = Double.parseDouble(word1);
//                    }
//                }
//            }
//        }
//        this.value = strMatrix1;
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
