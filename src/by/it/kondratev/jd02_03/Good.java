package by.it.kondratev.jd02_03;

import java.util.*;

class Good {

        static List<String> goodsList() {
        List<String> list = new ArrayList<>(20);
        list.add("Яблоко ");
        list.add("Груша ");
        list.add("Банан ");
        list.add("Апельсин ");
        list.add("Киви ");
        list.add("Грейпфрут ");
        list.add("Виноград ");
        list.add("Гранат ");
        list.add("Хурма ");
        list.add("Лимон ");
        return list;
    }



    static Map<String, Integer> make_price_list() {
        Map<String, Integer> price_map = new HashMap<>(20);
        Iterator<String> iterator = goodsList().iterator();
        for (int i = 0; i < goodsList().size(); i++) {
            price_map.put(iterator.next(), Helper.random(1,10));
        }
        return price_map;
    }

}
