package by.it.degtyaryov.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {
        int enterCount = 0;
        List<Buyer> listBuyer = new ArrayList<>(128);

        System.out.println("Market is opened.");
        for (int time = 0; time < 120; time++) {
            int buyersToEnter = Helper.getRandom(2);
            for (int buyerCount = 0; buyerCount < buyersToEnter; buyerCount++) {
                Buyer buyer = new Buyer(++enterCount);
                listBuyer.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }

        for (Buyer buyer : listBuyer) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market is closed.");
    }
}
