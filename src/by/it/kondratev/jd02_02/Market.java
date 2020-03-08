package by.it.kondratev.jd02_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Market {

    int buyersCounter = 0;
    static int compliteBuyers = 0;
    final static Object MONITOR = new Object();
    List<Buyer> buyerList = new ArrayList<>(200);
    static LinkedList <Buyer> queue = new LinkedList<>();

    Cashier cashier1 = new Cashier(1);
    Cashier cashier2 = new Cashier(2);

    void theDayStarted() {
        cashier1.start();
        cashier2.start();
        while (buyersCounter < 10)  {
            int every_second = Helper.random(0, 2);
            for (int i = 0; i < every_second; i++) {
                Buyer buyer = new Buyer(++buyersCounter);
                buyerList.add(buyer);
                buyer.start();
                if (buyersCounter == 10) break;
            }
            Helper.sleep(1000);
        }
    }

    void theDayEnded() {
        for (Buyer buyer : buyerList) {
            try {
                buyer.join();
                compliteBuyers++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            cashier1.join();
            cashier2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
