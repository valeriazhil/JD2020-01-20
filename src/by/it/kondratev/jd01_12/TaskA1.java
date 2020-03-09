package by.it.kondratev.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class TaskA1 {

    private static final int MIN_MARK = 1;
    private static final int MAX_MARK = 10;
    private List<Integer> values = new ArrayList<>();

    public static void main(String[] args) {
        Random random = new Random();
        TaskA1 marks = new TaskA1();
        for (int i = 0; i < 20; i++) {
            int randomMark = random.nextInt(MIN_MARK) + MAX_MARK;
            marks.values.add(randomMark);
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
