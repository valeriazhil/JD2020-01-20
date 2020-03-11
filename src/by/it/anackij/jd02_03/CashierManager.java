package by.it.anackij.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

class CashierManager extends Thread {
    private static BlockingDeque<Cashier> cashiersCreated = new LinkedBlockingDeque<>();
    private static BlockingDeque<Cashier> cashiersWorking = new LinkedBlockingDeque<>();
    ExecutorService executor = Executors.newFixedThreadPool(5);
    static int cashiersOpened = 0;

    @Override
    public void run() {
        createCashiers();
        while (Dispatcher.marketIsOpened()) {
            checkCashiers();
        }
        //noinspection StatementWithEmptyBody
        while (Dispatcher.completedBuyers.get() < 100) {
            checkCashiers();
        }
        executor.shutdown();
        releaseCashiers();

        System.out.println("Petrovich went home.");

    }

    public static void createCashiers() {
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
        }
    }

    private void checkCashiers() {
        if (checkIfCashiersLessThenNeed()) {
            Cashier myCashier = getACashier();
            myCashier.setNeededTrue();
            cashiersWorking.addLast(myCashier);
            myCashier.setNeededTrue();
            executor.execute(myCashier);
        } else if (checkIfCashiersMoreThenNeed()) {
            if (cashiersOpened > 1) {
                closeACashier();
            }
        }
    }

    private static void closeACashier() {
        Cashier closableCashier = cashiersWorking.pollFirst();
        if (closableCashier != null) {
            closableCashier.setNeededFalse();
        }
        cashiersOpened--;
    }

    private static Cashier getACashier() {
        Cashier openedNowCashier = cashiersCreated.pollFirst();
        cashiersOpened++;
        cashiersCreated.addLast(openedNowCashier);
        return openedNowCashier;
    }

    static void addToCashierQueue(Cashier cashier) {
        cashiersCreated.addLast(cashier);
    }

    private void releaseCashiers() {
        if (!cashiersWorking.isEmpty()) {
            for (Cashier cashier : cashiersWorking) {
                cashier.setNeededFalse();
                cashiersOpened--;
            }
        }
    }

    private boolean checkIfCashiersLessThenNeed() {
        if (cashiersOpened == 5){
            return false;
        }
        return cashiersOpened < countCashiersNeed();
    }

    private boolean checkIfCashiersMoreThenNeed() {
        return cashiersOpened > countCashiersNeed();
    }

    private static int countCashiersNeed() {
        int peopleInQueues = QueueBuyers.getQueueLength() + QueuePens.getQueueLength();
        int cashiersNeed;
        if (peopleInQueues == 0) {
            cashiersNeed = 0;
        } else {
            cashiersNeed = peopleInQueues / 5 + (peopleInQueues % 5 == 0 ? 0 : 1);
        }
        return cashiersNeed;
    }
}
