package by.it.zhuravaskarabahataya.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    static final AtomicInteger numberBuyers = new AtomicInteger(0);
    static final AtomicInteger completedBuyers = new AtomicInteger(0);
    static final AtomicInteger buyersInMarket = new AtomicInteger(0);
    private static final int PLANNED_BUYERS = 10;
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

    static void newBuyerEnterToMarket(){
        numberBuyers.getAndIncrement();
        buyersInMarket.getAndIncrement();

    }

    static void buyerLeaveTheMarket(){
        completedBuyers.getAndIncrement();
        buyersInMarket.getAndDecrement();
    }

    static boolean marketIsClosed(){
        return completedBuyers.get() == PLANNED_BUYERS;
    }

    static boolean marketIsOpened(){
        return (completedBuyers.get() + buyersInMarket.get() )
                < PLANNED_BUYERS;
    }

}
