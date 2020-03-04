//package by.it.zhuravaskarabahataya.jd02_03;
//
//import java.util.Deque;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//class CashierManager {
//
//    private static Deque<Cashier> cashiersNotWorking = new LinkedList<>();
//    private static Deque<Cashier> cashiersWorking = new LinkedList<>();
//    private static HashMap<Cashier, Integer> cashiersAndMonitors = new HashMap<>();
//
//    static void close() {
//        for (Cashier cashier : cashiersNotWorking) {
//            cashier.interrupt();
//        }
//        for (Cashier cashier : cashiersWorking) {
//            cashier.interrupt();
//        }
//    }
//
//    static void printCashiers(){
//        for (Cashier cashier : cashiersNotWorking) {
//            System.out.print(cashier+" ");
//        }
//        System.out.println();
//    }
//
//    static void addToWorkingCashiers(Cashier cashier) {
//        synchronized (cashiersWorking) {
//            cashiersWorking.addLast(cashier);
//        }
//    }
//
//    static void addToNotWorkingCashiers(Cashier cashier) {
//        synchronized (cashiersNotWorking) {
//            cashiersNotWorking.addLast(cashier);
//        }
//    }
//
//    static int getWorkingCashiersNumber() {
//        synchronized (cashiersWorking) {
//            return cashiersWorking.size();
//        }
//    }
//
//    static int getNotWorkingCashiersNumber() {
//        synchronized (cashiersNotWorking) {
//            return cashiersNotWorking.size();
//        }
//    }
//
//    static Cashier extractFromWorking() {
//        synchronized (cashiersWorking) {
//            return cashiersWorking.pollFirst();
//        }
//    }
//
//    static Cashier extractFromNotWorking() {
//        synchronized (cashiersNotWorking) {
//            return cashiersNotWorking.pollFirst();
//        }
//    }
//
//    static void checkCashiers() {
//        System.out.println("STARTED CHECKING CASHIERS");
//        if (checkIfCashierGoodNumber()) {
//            return;
//        } else if (checkIfCashiersNeeded()) {
//            Cashier newCashier = extractFromNotWorking();
//            if (newCashier != null) {
//                activate(newCashier);
//                           }
//        } else if (checkIfCashiersMoreThenNeeded()) {
//            Cashier newCashier = extractFromWorking();
//            if (newCashier != null) {
//                inactivate(newCashier);
//
//            }
//        }
//    }
//
//    private static void inactivate(Cashier newCashier) {
//        System.out.println("\t\t\t\t\t\tInactivaating "+ newCashier.toString());
//        try {
//            Cashier.MY_MONITOR.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        addToNotWorkingCashiers(newCashier);
//    }
//
//    private static void activate(Cashier newCashier) {
//        System.out.println("\t\t\t\t\t\tActivaating "+ newCashier.toString());
//        if (newCashier.getState() == Thread.State.NEW){
//            newCashier.start();
//        }
//        else {
//            Cashier.MY_MONITOR.notify();
//        }
//        addToWorkingCashiers(newCashier);
//    }
//
//    static boolean checkIfCashierGoodNumber() {
//        int cashierNumber = getWorkingCashiersNumber();
//        int peopleInQueues = Dispatcher.getBuyersInQueue();
//        int cashierNeeded = peopleInQueues / 5 + (peopleInQueues % 5 > 0 ? 0 : 1);
//        return cashierNumber == cashierNeeded;
//    }
//
//    static boolean checkIfCashiersNeeded() {
//        int cashierNumber = getWorkingCashiersNumber();
//        int peopleInQueues = Dispatcher.getBuyersInQueue();
//        int cashierNeeded = peopleInQueues / 5 + (peopleInQueues % 5 > 0 ? 0 : 1);
//        return cashierNumber < cashierNeeded;
//    }
//
//    static boolean checkIfCashiersMoreThenNeeded() {
//        if (getWorkingCashiersNumber() == 1){
//            return false;
//        }
//        int cashierNumber = getWorkingCashiersNumber();
//        int peopleInQueues = Dispatcher.getBuyersInQueue();
//        int cashierNeeded = peopleInQueues / 5 + (peopleInQueues % 5 > 0 ? 0 : 1);
//        return cashierNumber > cashierNeeded;
//    }
//
//}
