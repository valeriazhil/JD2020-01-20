package by.it.bunkov.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        String line = scanner.nextLine();
        while (!line.equals("end")) {
            text.append(line).append('\n');
            line = scanner.nextLine();
        }
        String[] words = text.toString().split("[^A-z']+");
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            if (frequency.containsKey(word)) {
                Integer value = frequency.get(word);
                frequency.put(word, ++value);
            } else {
                frequency.put(word, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}