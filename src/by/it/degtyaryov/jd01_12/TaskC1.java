package by.it.degtyaryov.jd01_12;

import java.util.*;

class TaskC1 {

    private static int id;

    public static void main(String[] args) {
        Map<Integer, String> allValues = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String value = scanner.nextLine();
            if (value.equals("end")) {
                break;
            } else {
                allValues.put(id++, value);
            }
        }

        System.out.println("Все значения: " + allValues);
        trimDuplicateValues(allValues);
        System.out.println("Уникальные значения: " + allValues);
    }

    private static void trimDuplicateValues(Map<Integer, String> map) {
        Set<String> existValues = new HashSet<>();
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            if (existValues.contains(entry.getValue())) {
                iterator.remove();
            } else {
                existValues.add(entry.getValue());
            }
        }
    }
}
