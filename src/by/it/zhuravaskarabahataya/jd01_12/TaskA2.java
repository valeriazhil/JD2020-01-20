package by.it.zhuravaskarabahataya.jd01_12;

// В main класса TaskA2 определите два множества (a и b) на основе целых чисел.
//  Создайте статические методы для определения пересечения множеств getCross
// и объединения множеств getUnion.
//  Покажите работу этих методов на примере двух разных множеств (например, HashSet a и TreeSet b).
//Пробуем с собственными интераторамИ!!!!!!!

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TaskA2 {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 4));
        Set<Integer> b = new TreeSet<>(Arrays.asList(3, 1, 1, 5, 9, 2, 6, 20, 21, 22));
        System.out.println(getCross(a, b));
        System.out.println(getUnion(a, b));
    }

    private static Set<Integer> getCross(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

}
