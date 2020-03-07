package by.it.zhuravaskarabahataya.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class CashierManager extends Thread {
    private static Deque<Cashier> cashiersCreated = new LinkedList<>();
    private static Deque<Cashier> cashiersWorking = new LinkedList<>();

    static int cashiersOpened = 0;

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
        System.out.println(cashier + "added to Cashier Queue");
        cashiersCreated.addLast(cashier);
    }

    @Override
    public void run() {
        createCashiers();
        while (Dispatcher.marketIsOpened()) {
            checkCashiers();
        }
        //noinspection StatementWithEmptyBody
        while (Dispatcher.completedBuyers < 100) {
            checkCashiers();

        }
        releaseCashiers();
        System.out.println("Petrovich went home.");

    }

    private void releaseCashiers() {
        if (!cashiersWorking.isEmpty()) {
            for (Cashier cashier : cashiersWorking) {
                cashier.setNeededFalse();
                cashiersOpened--;
            }
        }
    }

    private void checkCashiers() {
        if (checkIfCashiersLessThenNeed()) {
            Cashier myCashier = getACashier();
            myCashier.setNeededTrue();
            cashiersWorking.addLast(myCashier);
            Thread cashierThread = new Thread(myCashier);
            cashierThread.start();
        } else if (checkIfCashiersMoreThenNeed()) {
            if (cashiersOpened > 1) {
                closeACashier();
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

    public static void createCashiers() {
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
        }
    }
}
