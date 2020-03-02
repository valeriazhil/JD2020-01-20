package by.it.makarenko.jd02_02;

import java.lang.management.PlatformLoggingMXBean;

public class Dispatcher {
    static final int K_SPEED = 10;

    static int numberBuyers =0;

    private volatile static int buyersInMarket =0;
    private volatile static int completeBuyers=0;
    private static final int PLAN=100;

    synchronized static void newBuyer(){
        numberBuyers++;
        buyersInMarket++;
    }
    synchronized static void buyerLeaveInMarket(){
        buyersInMarket--;
        completeBuyers++;
    }
    static boolean marketIsOpend(){
        return completeBuyers+buyersInMarket<PLAN;
    }

    static boolean marketIsClosed(){
        return PLAN==completeBuyers;
    }

    static int completeBuyer = 0;
}
