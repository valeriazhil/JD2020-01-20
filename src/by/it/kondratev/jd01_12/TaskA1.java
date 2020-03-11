package by.it.kondratev.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class TaskA1 {

    private List<Integer> values = new ArrayList<>();

    public static void main(String[] args) {
        Random random = new Random();
        TaskA1 balls = new TaskA1();
        for (int i = 0; i < 20; i++) {
            int randomBall = (int)(Math.random()*10+1);
            balls.values.add(randomBall);
        }
        System.out.println("All balls: " + balls.values);
        clearBad(balls.values);
        System.out.println("Without bad balls: " + balls.values);
    }

    static void clearBad(List<Integer> grades)  {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() <= 3) {
                iterator.remove();
            }
        }
    }
}
