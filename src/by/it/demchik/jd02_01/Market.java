package by.it.demchik.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {

//    public static void main(String[] args) {
//        for (int i = 0; i < 1000; i++) {
//            Dispatcher.completeBuyer=0;
//            main2(args);
//        }
//    }

    public static void main(String[] args) {

        System.out.println("The market opened");
        List<Buyer> buyers=new ArrayList<>(128);

        int countBuyers = 0;
        for (int time = 0; time < 120; time++) {
            int currentCount = Helper.random(2);
            for (int i = 0; i < currentCount; i++) {
                Buyer buyer = new Buyer(++countBuyers);
                buyers.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }

        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.err.println("Something stupid");
            }
        }

//        bad solution
//        while (countBuyers>Dispatcher.completeBuyer)
//            Helper.sleep(1);

        System.out.println("The market closed");
    }

}
