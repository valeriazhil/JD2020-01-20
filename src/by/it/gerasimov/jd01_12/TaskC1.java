package by.it.gerasimov.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> names = new HashMap<>();
        int index = 1;
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            names.put(index, line);
            index++;
        }
        Set<String> values = new HashSet<>();
        for (Iterator<Map.Entry<Integer, String>> it = names.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Integer, String> entry = it.next();
            if (!values.contains(entry.getValue())) {
                values.add(entry.getValue());
            } else {
                it.remove();
            }
        }
        System.out.println(names);
    }
}
