package by.it.kondratev.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class TaskB3 {

    public static void main(String[] args) {
        ArrayList<String> namesA = new ArrayList<>();
        LinkedList<String> namesB = new LinkedList<>();
        LinkedList<String> namesC = new LinkedList<>();

        for (int i = 0; i < 4096; i++) {
            namesA.add("val" + i);
            namesB.add("val" + i);
            namesC.add("val" + i);
        }

        Timer timer = new Timer();
        System.out.println(process(namesA) + " " + timer);
        System.out.println(process(namesB) + " " + timer);
        System.out.println(processOnQueue(namesC) + " " + timer);
    }

    private static String process(ArrayList<String> peoples) {
        boolean deleteName = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (deleteName) {
                    iterator.remove();
                }
                deleteName = !deleteName;
            }
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        boolean deleteName = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (deleteName) {
                    iterator.remove();
                }
                deleteName = !deleteName;
            }
        }
        return peoples.get(0);
    }

    private static String processOnQueue(LinkedList<String> peoples) {
        boolean deleteName = false;
        Queue<String> qu = peoples;
        while (qu.size() > 1) {
            if (deleteName) {
                qu.poll();
            } else {
                qu.offer(qu.poll());
            }
            deleteName = !deleteName;
        }
        return qu.element();
    }

    private static class Timer {
        private long iniTime;
        private Double delta;

        public Timer() {
            iniTime = System.nanoTime();
        }

        public String toString() {
            delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();

            return "Прошло " + delta.toString() + " микросекунд.";
        }
    }
}
