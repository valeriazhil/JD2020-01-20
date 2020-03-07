package by.it.dolgiy.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Runner {

    static boolean pensioner;
    static String buyerStr;
    static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("The market opened");
        while (Dispatcher.marketIsOpened()){
            openCash(threads);
            int currentCount = Helper.random(2);
            for (int count = 0; count < currentCount && Dispatcher.marketIsOpened(); count++) {
                buyerStr = typeOfBuyer();
                int number = Dispatcher.numberBuyer;
                Buyer buyer = new Buyer(number,buyerStr);
                buyer.start();

            }
            Helper.sleep(1000);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Error:"+e);
            }
        }

        System.out.println("The market closed");
    }

    private static void openCash(List<Thread> threads) {
        Cashier cashier = new Cashier(threads.size() + 1);
        Thread thread = new Thread(cashier);
        if (QueueBuyers.QUEUE.size()>threads.size()*5 && threads.size()<5) {
            threads.add(thread);
            thread.start();
        }
        Helper.sleep(10);
//        if (QueueBuyers.QUEUE.size()/5<=threads.size() && threads.size()>1){
//            thread.interrupt();
//            threads.remove(thread);
//        }
    }

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
