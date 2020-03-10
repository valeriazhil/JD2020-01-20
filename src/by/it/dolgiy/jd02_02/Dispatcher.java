package by.it.dolgiy.jd02_02;



class Dispatcher extends Thread{

    static final int K_SPEED = 100;
    static volatile int numberBuyer = 0;

    volatile static int buyersInMarket = 0;
    private volatile static int completeBuyers = 0;
    private static final int PLAN = 100;

    synchronized static void newBuyer() {
        numberBuyer++;
        buyersInMarket++;
    }

    synchronized static void buyerLeaveTheMarket() {
        buyersInMarket--;
        completeBuyers++;
    }

    static boolean marketIsOpened() {
        return completeBuyers+buyersInMarket < PLAN;
    }

    static boolean marketClosed() {
        return PLAN==completeBuyers;
    }

//    static List<Thread> threads = new ArrayList<>();
//
//    @Override
//    public void run() {
//        while (completeBuyers<PLAN){
//            if (QueueBuyers.QUEUE.size()>threads.size()*5 && threads.size()<5){
//                Cashier cashier = new Cashier(threads.size() + 1);
//                Thread thread = new Thread(cashier);
//                threads.add(thread);
//                thread.start();
//            }
//            Helper.sleep(1000);
//        }
//    }
}
