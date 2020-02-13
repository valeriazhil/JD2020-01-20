package by.it.degtyaryov.jd01_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Runner {

    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<>();
        List<String> myList = new ListA<>();

        System.out.println("Начальный размер arrayList: "
                + arrayList.size());
        System.out.println("Начальный размер myList: "
                + myList.size());

        arrayList.add("C");
        arrayList.add("A");
        arrayList.add("E");
        arrayList.add("B");
        arrayList.add("D");
        arrayList.add("F");
        arrayList.add("F");
        arrayList.add(1, "A2");
        arrayList.set(0, "C2");

        myList.add("C");
        myList.add("A");
        myList.add("E");
        myList.add("B");
        myList.add("D");
        myList.add("F");
        myList.add("F");
        myList.add(1, "A2");
        myList.set(0, "C2");

        System.out.println("Размер arrayList после добавления: "
                + arrayList.size());
        System.out.println("Размер myList после добавления: "
                + myList.size());

        System.out.println("Содержимое arrayList: " + arrayList);
        System.out.println("Содержимое myList: " + myList);
        System.out.println(arrayList.get(0));
        System.out.println(myList.get(0));

        arrayList.remove("F");
        arrayList.remove(2);
        myList.remove("F");
        myList.remove(2);

        System.out.println("Размер arrayList после удаления: "
                + arrayList.size());
        System.out.println("Размер myList после удаления: "
                + myList.size());
        System.out.println("Содержимое of arrayList: " + arrayList);
        System.out.println("Содержимое of myList: " + myList);

        List<String> removeElements = Arrays.asList("C2", "A2", "AA", "F");
        System.out.println("Содержимое arrayList до removeAll: "
                + arrayList);
        System.out.println("Содержимое myList до removeAll: "
                + myList);

        arrayList.removeAll(removeElements);
        myList.removeAll(removeElements);
        System.out.println("Содержимое arrayList после removeAll: " + arrayList);
        System.out.println("Содержимое myList после removeAll: " + myList);


        List<String> arrayList2 = Arrays.asList("1", "2");

        System.out.println("arrayList до добавления " + arrayList);
        System.out.println("myList до добавления " + myList);

        arrayList.addAll(arrayList2);
        myList.addAll(arrayList2);
        System.out.println("arrayList после добавления " + arrayList);
        System.out.println("myList после добавления " + myList);

        arrayList.clear();
        myList.clear();

        System.out.println("arrayList после очистки " + arrayList);
        System.out.println("myList после очистки " + myList);
    }

}
