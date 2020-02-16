package by.it.degtyaryov.jd01_12;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class TaskB1 {

    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String value = scanner.next();

            if (value.equals("end")) {
                break;
            } else {
                value = value.replaceAll("[^\\w']+", "");
                if (map.containsKey(value)) {
                    map.put(value, map.get(value) + 1);
                } else {
                    map.put(value, 1);
                }
            }
        }

        System.out.println(map);
    }
}