package by.it.zhuravaskarabahataya.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Проверка ListA, ListB");
        List<String> standartList = new ArrayList<>();
        List<String> myListA = new ListA<>();
        List<String> myListB = new ListB<>();
        //проверка Add(T e)
        standartList.add("Понедельник");
        standartList.add("Вторник");
        standartList.add("Среда");
        myListA.add("Понедельник");
        myListA.add("Вторник");
        myListA.add("Среда");
        myListB.add("Понедельник");
        myListB.add("Вторник");
        myListB.add("Среда");
        System.out.println("Стандартный: " + standartList);
        System.out.println("Мой список A: " + myListA);
        System.out.println("Мой список B: " + myListB);
        System.out.println();
        //проверка Add(int index, T e)
        standartList.add(2, "Внезапно");
        myListA.add(2, "Внезапно");
        myListB.add(2, "Внезапно");
        System.out.println("Стандартный: " + standartList);
        System.out.println("Мой список A: " + myListA);
        System.out.println("Мой список B: " + myListB);
        System.out.println();
        //проверка Remove(int index)
        standartList.remove(1);
        myListA.remove(1);
        myListB.remove(1);
        System.out.println("Стандартный: " + standartList);
        System.out.println("Мой список A: " + myListA);
        System.out.println("Мой список B: " + myListB);
        System.out.println();

        //проверка get(int index)
        int ind = 2;
        System.out.println("Стандартный: номер " + ind + " " + standartList.get(ind));
        System.out.println("Мой список A: номер " + ind + " " + myListA.get(ind));
        System.out.println("Мой список B: номер " + ind + " " + myListB.get(ind));
        System.out.println();
        //проверка set(int index, T e)
        standartList.set(1, "Новый день");
        myListB.set(1, "Новый день");
        System.out.println("Стандартный после set: " + standartList);
        System.out.println("Мой список B после set: " + myListB);
        System.out.println();
        myListB.addAll(standartList);
        System.out.println("Мой список В после addALL: " + myListB);
        System.out.println();

        Set<String> standartSet = new HashSet<>();
        Set<String> copySet = new HashSet<>();
        Set<String> mySet = new SetC<>();
        standartSet.add("Эники");
        standartSet.add("Бэники");
        standartSet.add("Ели");
        standartSet.add("Вареники");

        standartSet.add(null);
        copySet.add("Вкусные");
        copySet.add("Стоп");
        copySet.add("Вареники");
        copySet.add(null);
        copySet.add(null);
        copySet.add("377");
        List<String> added = new ArrayList<>();
        added.add("A");
        added.add("A");
        added.add("BBB");
        added.add(null);
        added.add(null);

        mySet.add("Эники");
        mySet.add("Бэники");
        mySet.add("Ели");
        mySet.add("Вареники");
        System.out.println("Стандартный HashSet: " + standartSet + " size " + standartSet.size());
        System.out.println("Мой HashSet:          " + mySet + " size " + mySet.size());
        mySet.addAll(added);
        standartSet.addAll(added);
        System.out.println("Мой copyList:         " + added + " size " + added.size());
        System.out.println("Стандартный после copyAll: " + standartSet + " size " + standartSet.size());

        System.out.println("Мой HashSet после copyAll: " + mySet + " size " + mySet.size());
        System.out.println(standartSet.isEmpty());
        System.out.println(mySet.isEmpty());
        mySet.remove("Ели");
        System.out.println(mySet);
        System.out.println(mySet.containsAll(added));
        mySet.removeAll(added);
        System.out.println(mySet);
        mySet.clear();
        System.out.println(mySet);

    }
}
