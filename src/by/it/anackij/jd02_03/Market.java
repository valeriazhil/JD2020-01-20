package by.it.anackij.jd02_03;

import java.util.ArrayList;
import java.util.List;

class Market {
    static List<Buyer> buyers = new ArrayList<>(128);

    public static void main(String[] args) {
        System.out.println("Market is open!");
        new Warehouse();
        CashierManager managerPetrovich = new CashierManager();
        managerPetrovich.start();
        int seconds = 0;
        while (Dispatcher.marketIsOpened()) {
            ScreenPrinter.printThis("-----------------------------------------------------------\n");
            ScreenPrinter.printThis("\t\tSECOND " + seconds++ + "\n");
            ScreenPrinter.printThis("Buyers In Market " + Dispatcher.buyersInMarket);
            ScreenPrinter.printThis("Completed Buyers " + Dispatcher.completedBuyers);
            if (seconds < 30) {
                QueueBuyers.print();
                QueuePens.print();
                for (int i = 0; i < 5; i++) {
                    if (Dispatcher.buyersInMarket.get() < seconds + 10 && Dispatcher.marketIsOpened()) {
                        Buyer buyer = new Buyer(Dispatcher.numberBuyers.get() + 1);
                        buyer.start();
                        buyers.add(buyer);
                    }
                }

            } else if (seconds <= 59) {
                QueueBuyers.print();
                QueuePens.print();
                if (Dispatcher.buyersInMarket.get() < (70 - seconds)) {
                    Buyer buyer = new Buyer(Dispatcher.numberBuyers.get() + 1);
                    buyer.start();
                    buyers.add(buyer);
                }
            }
            if (seconds == 59) {
                seconds = 0;
            }
            TimingHelper.sleep(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.err.println("Something happened.");
            }
        }
        try {
            managerPetrovich.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ScreenPrinter.printThis("CompletedBuyers " + Dispatcher.completedBuyers.get() + ".");
        ScreenPrinter.printThis("Earning today is " + Dispatcher.getRevenue() + " coins.");
        ScreenPrinter.printThis("Market is closed...");
    }
}
