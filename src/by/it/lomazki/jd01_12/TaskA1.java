package by.it.lomazki.jd01_12;

import java.util.ArrayList;
import java.util.List;

public class TaskA1 {


    private List<Integer> list = new ArrayList<>();


    public static void main(String[] args) {
        TaskA1 task = new TaskA1();

        for (int i = 0; i < 25; i++) {
            task.list.add((int)Math.ceil(Math.random()*10));
        }
        System.out.println(task.list);
        for (int i = 0; i < task.list.size(); i++) {
            if (task.list.get(i) <4)
                task.list.remove(i);
        }
    }
}
