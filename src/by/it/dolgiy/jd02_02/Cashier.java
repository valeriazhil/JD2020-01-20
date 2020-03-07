package by.it.dolgiy.jd02_02;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Cashier implements Runnable {

    private String name;
    private int numberCash;
    private int cash;

    Cashier (int number){
        name = "\tCashier № " + number + " ";
        numberCash=number;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Dispatcher.marketClosed()){
            Buyer buyer = QueueBuyers.extract();
            if (buyer!=null){
//                if (!Thread.currentThread().isInterrupted()){
                    System.out.println(this + "started service for " + buyer);
                    shoppingList(buyer);
                    System.out.println("\t\tbuyer in queue "+ QueueBuyers.QUEUE.size());
                    System.out.println(this + "Cash " +cash + " RUB");
                    int timeout = Helper.random(2000,5000);
                    Helper.sleep(timeout);
                    System.out.println(this + "finished service for " + buyer);
                    synchronized (buyer){
                        buyer.notify();
                    }
//                }
//                else {
//                    System.out.println(this + "closed");
//                    synchronized (buyer){
//                        buyer.goToQueue();
//                    }
//                    break;
//                }
            }
            else {
                Helper.sleep(1);
            }
        }
        System.out.println(this + "closed");
    }

    private void shoppingList(Buyer buyer) {
        Set<Map.Entry<String, Integer>> basket = Helper.shoppingList.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = basket.iterator();
        StringBuffer shopList = new StringBuffer(this  +"basket :: " + buyer + " ");
        StringBuffer sum = new StringBuffer(this  +"check  :: " + buyer + " ");
        for (int i = 0; i < numberCash; i++) {
            shopList.append("\t\t\t||| ");
            sum.append("\t\t\t||| ");
        }
        int countProducts = Helper.random(1,4);
        int getSum = 0;
        for (int i = 0; i < countProducts; i++) {
            int timeout = Helper.random(500,2000);
            if (Runner.pensioner){
                timeout = (int) (timeout*1.5);
            }
            Helper.sleep(timeout);
            int choice = Helper.random(1);
            for (int ch = 0; ch < choice; ch++) {
                iterator.next();
            }
            Map.Entry<String, Integer> next = iterator.next();
            shopList.append(next.getKey()).append(':').append(next.getValue()).append("; ");
            getSum +=next.getValue();
        }
        cash+=getSum;
        sum.append(getSum).append(" RUB");
        System.out.println(shopList);
        System.out.println(sum);
    }

}
