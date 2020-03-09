package by.it.bunkov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        String[] rows = Poem.text.split("\n");
        int maxCount = -1;
        for (String row : rows) {
            if (row.length() > maxCount) {
                maxCount = row.length();
            }
        }
        int[] spaces = new int[rows.length];
        Pattern space = Pattern.compile(" ");
        int index = 0;
        for (int i = 0; i < rows.length; i++) {
            Matcher m;
            m = space.matcher(rows[i]);
            while (m.find()) {
                spaces[i]++;
            }
            int diff = maxCount - rows[i].length();
            int minSpaces = diff / spaces[i];
            int addSpaces = diff % spaces[i];
            m.reset();
            while (m.find()) {
                for (int j = 0; j < minSpaces; j++) {
                    text.insert(index + m.start(), " ");
                    index++;
                }
                if (addSpaces > 0) {
                    text.insert(index + m.start(), " ");
                    index++;
                    addSpaces--;
                }
            }
            index += rows[i].length() + 1;
        }
        System.out.println(text);
    }
}
