package by.it.degtyaryov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class TaskA1 {

    private List<Integer> values = new ArrayList<>();

    public static void main(String[] args) {
        Random random = new Random();
        TaskA1 marks = new TaskA1();
        for (int i = 0; i < 20; i++) {
            marks.values.add(random.nextInt(10) + 1);
        }
        System.out.println("Все оценки: " + marks.values);
        clearBad(marks.values);
        System.out.println("Без плохих оценок: " + marks.values);
    }

    private static void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() <= 3) {
                iterator.remove();
            }
        }
    }
}
