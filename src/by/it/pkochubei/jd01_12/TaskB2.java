package by.it.pkochubei.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> peolpesArray = new ArrayList<>();
        peolpesArray.add("Vasya");
        peolpesArray.add("Lola");
        peolpesArray.add("Herbert");
        peolpesArray.add("Elena");
        peolpesArray.add("koka");
        peolpesArray.add("Boba");
        peolpesArray.add("Biba");
        peolpesArray.add("Marya");
        peolpesArray.add("Tom");
        LinkedList<String> peolpesLinked = new LinkedList<>();
        peolpesLinked.add("Vasya");
        peolpesLinked.add("Lola");
        peolpesLinked.add("Herbert");
        peolpesLinked.add("Elena");
        peolpesLinked.add("koka");
        peolpesLinked.add("Boba");
        peolpesLinked.add("Biba");
        peolpesLinked.add("Marya");
        peolpesLinked.add("Tom");

        System.out.println(process(peolpesArray));
        System.out.println(process(peolpesLinked));
    }

    static String process(ArrayList<String> peoples) {
        int counter = 1;
        while (peoples.size() != 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (counter == 2) {
                    iterator.remove();
                    counter--;
                } else {
                    counter++;
                }
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        int counter = 1;
        while (peoples.size() != 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (counter == 2) {
                    iterator.remove();
                    counter--;
                } else {
                    counter++;
                }
            }
        }
        return peoples.get(0);
    }

}
