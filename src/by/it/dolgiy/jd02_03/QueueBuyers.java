package by.it.dolgiy.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {

    private static final BlockingDeque<Buyer> QUEUE = new LinkedBlockingDeque<>(30);

    public static BlockingDeque<Buyer> getQUEUE() {
        return QUEUE;
    }

    static void add(Buyer buyer) {
        try {
            QUEUE.putLast(buyer);
        } catch (InterruptedException e) {
            System.out.println("Error:"+e);
        }
    }

    static Buyer extract() {
        return QUEUE.pollFirst();
    }

}
