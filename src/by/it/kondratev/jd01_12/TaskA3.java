package by.it.kondratev.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskA3 {

    public static void main(String[] args) {
        int posZero = 0;
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String inputValue = scanner.next();
            if (inputValue.equals("end")) {
                break;
            }
            Integer number = Integer.valueOf(inputValue);
            if (number < 0) {
                list.add(number);
            } else if (number == 0) {
                list.add(posZero, number);
            } else {
                list.add(posZero++, number);
            }
        }

        System.out.println(list);
    }
}
