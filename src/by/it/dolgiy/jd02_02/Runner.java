package by.it.dolgiy.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Runner {

    static boolean pensioner;
    static String buyerStr;

    public static void main(String[] args) {
        System.out.println("The market opened");
        List<Thread> threads = new ArrayList<>();

//        for (int i = 1; i <= 2; i++) {
//            Cashier cashier = new Cashier(i);
//            Thread thread = new Thread(cashier);
//            threads.add(thread);
//            thread.start();
//        }

        while (Dispatcher.marketIsOpened()){
//            for (int minute = 0; minute < 2; minute++) {
//                for (int second = 0; second < 60; second++) {
            int currentCount = Helper.random(2);
            for (int count = 0; count < currentCount && Dispatcher.marketIsOpened(); count++) {
                buyerStr = typeOfBuyer();
                int number = Dispatcher.numberBuyer;
                Buyer buyer = new Buyer(number,buyerStr);
                buyer.start();
//                        buyerInMarket(second, buyer);
            }
            Helper.sleep(1000);
            openCash(threads);
//                }
//            }
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Error:"+e);
            }
        }

        System.out.println("The market closed");
    }

    private static void openCash(List<Thread> threads) {
        if (QueueBuyers.QUEUE.size()>threads.size()*5 && threads.size()<5) {
            Cashier cashier = new Cashier(threads.size() + 1);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
//            if (QueueBuyers.QUEUE.size()<threads.size()*5 && threads.size()>1){
//                Helper.sleep(1000);
//                thread.interrupt();
//                threads.remove(1);
//            }
        }
    }

//    private static void buyerInMarket(int time, Buyer buyer) {
//        if (Dispatcher.buyersInMarket>=40-(30-time)){
//            try {
//                buyer.join();
//            } catch (InterruptedException e) {
//                System.out.println("Error:"+e);
//            }
//        }
//    }

    private static String typeOfBuyer() {
        String buyerStr;
        if (Dispatcher.numberBuyer%4==0){
            pensioner= Helper.random();
            if (pensioner){
                buyerStr = " pensioner";
            }
            else{
                buyerStr = "";
            }
        }
        else {
            pensioner=false;
            buyerStr = "";
        }
        return buyerStr;
    }

}
