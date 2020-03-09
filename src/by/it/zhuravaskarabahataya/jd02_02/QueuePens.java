package by.it.zhuravaskarabahataya.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class QueuePens {
    private static final Deque<Buyer> QUEUE_PENSIONERS = new LinkedList<>();

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
