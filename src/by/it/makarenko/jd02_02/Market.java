package by.it.makarenko.jd02_02;



import java.util.ArrayList;
import java.util.List;

public class Market {


            public static void main (String[]args){

                System.out.println("Open market");
                List<Thread> threads = new ArrayList<>(128);

                for (int i = 1; i <= 2; i++) {
                    Cashier cashier = new Cashier(i);
                    Thread thread = new Thread(cashier);
                    threads.add(thread);
                    thread.start();

                }


                while (Dispatcher.marketIsOpend()) {
                    int currentCount = HelperTime.random(2);
                    for (int i = 0; i < currentCount&&Dispatcher.marketIsOpend(); i++) {
                        int number = Dispatcher.numberBuyers;
                        Buyer buyer = new Buyer(++number);
                        threads.add(buyer);
                        buyer.start();
                    }
                    HelperTime.sleep(1000);
                }
                for (Thread thread : threads) {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        System.err.println("Hmmmm");
                    }

                }
                System.out.println("Close Market");
    }
}

