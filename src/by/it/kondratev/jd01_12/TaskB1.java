package by.it.kondratev.jd01_12;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class TaskB1 {

    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String word = scanner.next();
            if (word.equals("end")) {
                break;
            } else {
                word = word.replaceAll("[^\\w']+", "");
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        System.out.println(map);
    }
}