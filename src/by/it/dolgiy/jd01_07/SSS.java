package by.it.dolgiy.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SSS {
    public static void main(String[] args) {
        String strMatrix = "{{1.0,2.0},{3.0,4.0}}";
        Pattern pattern = Pattern.compile("[\\\\{\\d\\\\.\\d\\\\,\\\\ ]+");
        Matcher matcher = pattern.matcher(strMatrix);
        double[][] strMatrix1 ={};
        while (matcher.find()) {
            String word = matcher.group();
            int last = strMatrix1.length;
            strMatrix1 = Arrays.copyOf(strMatrix1, last + 1);
            for (int i = 0; i < strMatrix1.length; i++) {
                Pattern pattern1 = Pattern.compile("[\\d\\\\.\\d]+");
                Matcher matcher1 = pattern1.matcher(word);
                while (matcher1.find()) {
                    String word1 = matcher1.group();
                    for (int j = 0; j < strMatrix1.length; j++) {
                        int lastJ = strMatrix1[j].length;
                        strMatrix1 = Arrays.copyOf(strMatrix1,lastJ+1);
                        strMatrix1[i][j] = Double.parseDouble(word1);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(strMatrix1));
    }
}
