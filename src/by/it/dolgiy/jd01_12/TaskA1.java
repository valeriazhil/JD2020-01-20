package by.it.dolgiy.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class TaskA1 {

    private List<Integer> list = new ArrayList<>();

    void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            Integer grade = iterator.next();
            if (grade<4){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        TaskA1 taskA1 = new TaskA1();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            taskA1.list.add(random.nextInt(10)+1);
        }
        System.out.println(taskA1.list);
        taskA1.clearBad(taskA1.list);
        System.out.println(taskA1.list);
    }
}
