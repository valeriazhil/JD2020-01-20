package by.it.lomazki.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    private static String [] proposal = {};
    private static int [] count = {};

    public static void main(String[] args) {
        String text = Poem.text.replaceAll("[\\.\\.\\.]{2,}"," ");
        String text2 = text.replaceAll("[\\s+,\":\\\\n-]+"," ");
        StringBuilder sb = new StringBuilder(text2);
        Pattern pattern = Pattern.compile("[А-ЯЁ][А-Яа-яёЁ ]+");
        Matcher matcher = pattern.matcher(sb);

        while (matcher.find()) {
            int last = proposal.length;
            proposal = Arrays.copyOf(proposal, last+1);
            proposal[last] = matcher.group();
        }
        for (int i = 0; i < proposal.length; i++) {
            int length = proposal[i].length();
            count = Arrays.copyOf(count, count.length+1);
            count[count.length-1] = length;
        }
        Arrays.sort(count, 0, count.length);
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < proposal.length; j++) {
                if (proposal[j].length() == count[i])
                    System.out.println(proposal[j]);
            }
        }
    }
}
