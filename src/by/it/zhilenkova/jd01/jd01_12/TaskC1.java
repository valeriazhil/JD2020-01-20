package by.it.zhilenkova.jd01.jd01_12;

import java.util.*;

/*
TaskC1. Нужно ввести с консоли текст до строки end. Во входном тексте хранятся
наименования некоторых объектов, по одному в строке. Строки иногда
повторяются.
 Построить список C1, элементы которого содержат наименования и уникальные
шифры данных объектов, причем элементы списка должны быть упорядочены по
возрастанию шифров (шифр – некоторое случайное, но гарантированно
уникальное число).
 Затем нужно «сжать» список C1, удаляя дублирующийся наименования объектов.
 Выведите полученный ассоциативный массив в консоль
 */
public class TaskC1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> list = new TreeMap<>();
        int k = 1;
        String word;
        while(sc.hasNext() && !(word = sc.next()).equals("end")){
            list.put(k++, word);
        }
        System.out.println("Before: " + list);
        HashSet<String> names = new HashSet<>();
        Iterator<String> iterator = list.values().iterator();
        while (iterator.hasNext()){
            if (!names.add(iterator.next())){
                iterator.remove();
            }
        }
        System.out.println("After: " + list);
    }

}
