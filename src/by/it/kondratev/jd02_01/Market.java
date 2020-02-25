package by.it.kondratev.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {

        System.out.println("Открытие магазина");
        int buyers_counter = 0;
        List<Buyer> list = new ArrayList<>(125);

        for (int second = 0; second < 120; second++) {
            int every_second = Helper.random(0,2);
            for (int i = 0; i < every_second; i++) {
                Buyer buyer = new Buyer(++buyers_counter);
                list.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }

        for (Buyer buyer : list) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Магазин закрывается, все вон!");
    }

}
