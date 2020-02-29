package by.it.kondratev.jd02_01;

import java.util.*;

class Market {

    static List<String> goods_list = Good.goods_list;                    // список товаров
    static Map<String, Integer> price_map = Good.make_map();             // карта товар-цена

    public static void main(String[] args) {

        Map<Buyer, Backet> backets = new HashMap<>();

        System.out.println("Открытие магазина");
        int buyers_counter = 0;
        List<Buyer> buyerList = new ArrayList<>(125);

        for (int second = 0; second < 5; second++) {
            int every_second = Helper.random(0, 2);
            for (int i = 0; i < every_second; i++) {
                Buyer buyer = new Buyer(++buyers_counter);
                buyerList.add(buyer);
                buyer.start();

            }
            Helper.sleep(1000);
        }

        for (Buyer buyer : buyerList) {
            try {
                buyer.join();
                backets.put(buyer, buyer.backet);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Магазин закрывается, все вон!");
        System.out.println(backets);

    }

}
