package by.it.zhuravaskarabahataya.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//переделать!!!!!!!!!!!!
//TaskC1. Нужно ввести с консоли текст до строки end.
// Во входном тексте  хранятся наименования некоторых объектов, по одному в строке.
// Строки иногда повторяются.
//  Построить список C1, элементы которого содержат наименования и уникальные шифры данных объектов,
// причем элементы списка должны быть упорядочены по возрастанию шифров
// (шифр – некоторое случайное, но гарантированно уникальное число).
//  Затем нужно «сжать» список C1, удаляя дублирующийся наименования объектов.
//  Выведите полученный ассоциативный массив в консоль

class TaskC1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String str;
        while (!(str = sc.nextLine()).equals("end")) {
            sb.append(str).append("\n");
        }
        System.out.println(makeUniqueMap(makeSortedMap(sb)));
    }

    private static Map makeUniqueMap(LinkedHashMap sortedMap) {
        Map<Integer, String> result = new LinkedHashMap<>();
        Set<String> uniqueNames = new LinkedHashSet<>(sortedMap.values());
        Set<Map.Entry<Integer, String>> entries = sortedMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            if (uniqueNames.contains(entry.getValue())) {
                result.put(entry.getKey(), entry.getValue());
                uniqueNames.remove(entry.getValue());
            }
        }
        return result;
    }

    private static LinkedHashMap makeSortedMap(StringBuilder sb) {
        Map<Integer, String> names = new HashMap<>();
        String[] strings = sb.toString().split("\n");
        for (String string : strings) {
            System.out.println(string);
            Pattern pattern = Pattern.compile("\"[a-zA-Zа-яА-ЯёЁ]+\"");
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                String name = matcher.group();
                names.put((int) (Math.random() * 100 + 1), name);
            }
        }
        System.out.println(names);
        ArrayList<Integer> sorted = new ArrayList<>(names.keySet());
        Collections.sort(sorted);
        LinkedHashMap<Integer, String> namesSortedByKey = new LinkedHashMap<>();
        for (Integer integer : sorted) {
            namesSortedByKey.put(integer, names.get(integer));
        }
        System.out.println(sorted);
        System.out.println(namesSortedByKey);
        return namesSortedByKey;
    }
}
