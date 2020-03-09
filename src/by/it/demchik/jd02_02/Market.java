package by.it.demchik.jd02_02;

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
        List<Thread> threads = new ArrayList<>(128);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        while (Dispatcher.marketIsOpened()) {
            int currentCount = Helper.random(2);
            for (int i = 0; i < currentCount && Dispatcher.marketIsOpened(); i++) {
                int number = Dispatcher.numberBuyer;
                Buyer buyer = new Buyer(++number);
                threads.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }

//        bad solution
//        while (countBuyers>Dispatcher.completeBuyer)
//            Helper.sleep(1);

        System.out.println("The market closed");
    }

}
