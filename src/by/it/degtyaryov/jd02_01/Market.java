package by.it.degtyaryov.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {
        int enterCount = 0;
        boolean isPensioner;
        List<Buyer> listBuyer = new ArrayList<>(2000);

        System.out.println("Market is opened.");
        for (int time = 0; time < 120; time++) {
            int mustBeInMarket = calcMustBeInMarket(time);
            int buyersToEnter = (Dispatcher.buyerInMarket > mustBeInMarket) ? 0 : mustBeInMarket - Dispatcher.buyerInMarket;

            for (int i = 0; i < buyersToEnter; i++) {
                isPensioner = Helper.getRandom(1, 4) % 4 == 0;
                Buyer buyer = new Buyer(++enterCount, isPensioner);
                listBuyer.add(buyer);
                buyer.start();
            }
            System.out.printf("Time: %d sec. Now in market: %d buyers.%n", time, Dispatcher.buyerInMarket);
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

    static int calcMustBeInMarket(int currentTime) {
        int number = 0;
        if (currentTime < 30) {
            number = currentTime + 10;
        } else if (currentTime < 60) {
            number = 40 + (30 - currentTime);
        } else if (currentTime < 90) {
            number = currentTime - 60 + 10;
        } else if (currentTime < 120) {
            number = 40 + (30 - currentTime - 60);
        }
        return number;
    }
}
