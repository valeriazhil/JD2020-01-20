package by.it.anackij.jd02_02;

class Dispatcher {
    volatile static int numberBuyers = 0;
    volatile static int completedBuyers = 0;
    volatile static int buyersInMarket = 0;
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
        numberBuyers++;
        buyersInMarket++;
    }

    synchronized static void buyerLeaveToMarket(){
        completedBuyers++;
        buyersInMarket--;
    }

    synchronized static boolean marketIsOpened(){
        return (completedBuyers + buyersInMarket ) < PLANNED_BUYERS;
    }

}
