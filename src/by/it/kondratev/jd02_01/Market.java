package by.it.kondratev.jd02_01;

import java.util.*;

class Market {

    int buyers_counter = 0;
    List<Buyer> buyerList = new ArrayList<>(200);

    void theDayStarted() {
        for (int second = 0; second < 5; second++) {
            int every_second = Helper.random(0, 2);
            for (int i = 0; i < every_second; i++) {
                Buyer buyer = new Buyer(++buyers_counter);
                buyerList.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }
    }

    void theDayEnded() {
        for (Buyer buyer : buyerList) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
