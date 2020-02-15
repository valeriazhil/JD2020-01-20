package by.it.makarenko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private List<Integer> grade;


    private void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            Integer gradete = iterator.next();
            if(gradete<4)
            iterator.remove();
        }
    }

    public static void main(String[] args) {
        TaskA1 taskA1 = new TaskA1();
        taskA1.grade=new ArrayList<>();
        Random random = new Random(System.nanoTime());
        for (int i = 0; i < 20; i++) {
            taskA1.grade.add(random.nextInt(10)+1);
        }
        System.out.println(taskA1.grade);
        taskA1.clearBad(taskA1.grade);
        System.out.println(taskA1.grade);
        

    }
}
