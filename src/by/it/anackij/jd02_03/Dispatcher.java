package by.it.anackij.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    static final AtomicInteger numberBuyers = new AtomicInteger(0);
    static final AtomicInteger completedBuyers = new AtomicInteger(0);
    static final AtomicInteger buyersInMarket = new AtomicInteger(0);
    private static final int PLANNED_BUYERS = 100;
    static final int K_SPEED = 1;
    private static int todayEarning = 0;
    private static final Integer EARNING_MONITOR = 1;

    static int getBuyersInQueue(){
        return QueueBuyers.getQueueLength()+QueuePens.getQueueLength();
    }

    static void payForGoods(int billSum){
        synchronized (EARNING_MONITOR){
            todayEarning += billSum;
        }
    }

    static int getRevenue(){
        return todayEarning;
    }

    synchronized static void newBuyerEnterToMarket(){
        numberBuyers.getAndIncrement();
        buyersInMarket.getAndIncrement();
    }

    synchronized static void buyerLeaveToMarket(){
        completedBuyers.getAndIncrement();
        buyersInMarket.getAndDecrement();
    }

    synchronized static boolean marketIsOpened(){
        return (completedBuyers.get()
                + buyersInMarket.get() ) < PLANNED_BUYERS;
    }

}
