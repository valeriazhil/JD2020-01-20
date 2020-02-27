package by.it.gerasimov.jd02_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Shop {

    public static void main(String[] args) {
        Helper.setSpeed(100);
        List<Buyer> buyers = new ArrayList<>();
        for (int i = 0; i < Helper.getSteps(); i++) {
            for (int j = 0; j < Helper.getBuyersCountByStep(); j++) {
                Buyer buyer = new Buyer(i, j);
                if (new Random().nextDouble() <= 0.25) {
                    buyer.setPensioner(true);
                }
                buyers.add(buyer);
                buyer.start();
            }
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.out.println("The shop don't wait " + buyer.getName());
            }
        }
        System.out.println("The shop closed");
    }
}
