package by.it.gerasimov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class TaskA1 {

    private List<Integer> grades;
    public static void main(String[] args) {
        TaskA1 taskA1 = new TaskA1();
        taskA1.grades = new ArrayList<>();
        Random random = new Random(System.nanoTime());
        for (int i = 0; i < 30; i++) {
            taskA1.grades.add(random.nextInt(10) + 1);
        }
        System.out.println(taskA1.grades);
        taskA1.clearBad(taskA1.grades);
        System.out.println(taskA1.grades);
    }
    private void clearBad(List<Integer> localName) {
        Iterator<Integer> iterator = localName.iterator();
        while (iterator.hasNext()) {
            Integer grade = iterator.next();
            if (grade < 4)
                iterator.remove();
        }

    }
}
