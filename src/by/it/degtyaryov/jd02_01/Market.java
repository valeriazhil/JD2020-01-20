package by.it.degtyaryov.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static int buyerInMarket = 0;

    public static void main(String[] args) {
        int enterCount = 0;
        boolean pensioner;
        List<Buyer> listBuyer = new ArrayList<>(128);

        System.out.println("Market is opened.");
        for (int time = 0; time < 120; time++) {

            int buyersToEnter = (time < 30 || (time >= 60 && time <= 90)) ?
                    Helper.getRandom(time + 10) : 
                    Helper.getRandom(40 + (30 - time));
            for (int buyerCount = 0; buyerCount < buyersToEnter; buyerCount++) {
                pensioner = Helper.getRandom(1, 4) % 4 == 0;
                buyerInMarket++;
                Buyer buyer = new Buyer(++enterCount, pensioner);
                listBuyer.add(buyer);
                buyer.start();
            }
			System.out.println("Time: "+time+" now in market: "+buyerInMarket+" buyers");
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
