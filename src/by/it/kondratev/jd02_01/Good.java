package by.it.kondratev.jd02_01;

import java.util.*;

class Good {

    static List<String> goods_list = make_list();

    static List<String> make_list() {
        List<String> list = new ArrayList<>(20);
        list.add("Яблоко");
        list.add("Груша");
        list.add("Банан");
        list.add("Апельсин");
        list.add("Киви");
        list.add("Грейпфрут");
        list.add("Виноград");
        list.add("Гранат");
        list.add("Хурма");
        list.add("Лимон");
        return list;
    }

    static Map<String, Integer> price_map = make_map();

    static Map<String, Integer> make_map() {
        Map<String, Integer> price_map = new HashMap<>(20);
        Iterator<String> iterator = goods_list.iterator();
        for (int i = 0; i < goods_list.size(); i++) {
            price_map.put(iterator.next(), Helper.random(1,10));
        }
        return price_map;
    }



}
