package by.it.makarenko.jd02_01;



import java.util.ArrayList;
import java.util.List;

public class Market {

 //  public static void main(String[] args) {
 //      for (int i = 0; i < 1000; i++) {
 //          Dispatcher.completeBuyer = 0;
 //          main2(args);
 //      }
 //  }
            public static void main (String[]args){

                System.out.println("Open market");
                List<Buyer> buyers = new ArrayList<>(128);

                int countBuyer = 0;
                for (int time = 0; time < 120; time++) {
                    int currentCount = HelperTime.random(2);
                    for (int i = 0; i < currentCount; i++) {
                        Buyer buyer = new Buyer(countBuyer++);
                        buyers.add(buyer);
                        buyer.start();
                    }
                    HelperTime.sleep(1000);
                }
                for (Buyer buyer : buyers) {
                    try {
                        buyer.join();
                    } catch (InterruptedException e) {
                        System.err.println("Hmmmm");
                    }

                }
                System.out.println("Close Market");
    }
}

