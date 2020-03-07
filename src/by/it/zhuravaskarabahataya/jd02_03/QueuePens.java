package by.it.zhuravaskarabahataya.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueuePens {
    private static final BlockingDeque<Buyer> QUEUE_PENSIONERS = new LinkedBlockingDeque<>();

    static void add(Buyer buyer){
        synchronized (QUEUE_PENSIONERS) {
            QUEUE_PENSIONERS.addLast(buyer);
        }
    }

    static int getQueueLength(){
        synchronized (QUEUE_PENSIONERS){
            return QUEUE_PENSIONERS.size();
        }
    }

    static Buyer extract(){
        synchronized (QUEUE_PENSIONERS) {
            return QUEUE_PENSIONERS.pollFirst();
        }
    }

    static void print(){
        System.out.println("QUEUE PENS");
        for (Buyer queueBuyer : QUEUE_PENSIONERS) {
            System.out.print(queueBuyer+" ");
        }
        System.out.println();
    }
}
