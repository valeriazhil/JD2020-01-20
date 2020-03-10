package by.it.kondratev.jd01_12;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class TaskB1 {

    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String inputValue = scanner.next();
            if (inputValue.equals("end")) {
                break;
            } else {
                inputValue = inputValue.replaceAll("[^\\w']+", "");
                if (map.containsKey(inputValue)) {
                    map.put(inputValue, map.get(inputValue) + 1);
                } else {
                    map.put(inputValue, 1);
                }
            }
        }

        System.out.println(map);
    }
}