package by.it.pkochubei.jd02_03;

import java.util.Map;

public class Cashier extends Thread {
    private String name;
    public boolean stop = true;
    private static final Object monitor = new Object();
    private static final Object monitorForPrint = new Object();
    protected static int totalsum;

    public Cashier(int number) {
        name = "---- Cashier №" + number + ":";
    }

    @Override
    public void run() {
        while (!Dispatcher.marketClosed()) {
            Buyer buyer;
            if (stop) {
                synchronized (this) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            buyer = QueueBuyer.extract();
            if (buyer == null) Util.sleep(1);
            else {
                int time = Util.random(2000, 5000);
                Util.sleep(time);
                int sum = 0;
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, Integer> entry : buyer.choosenGoods.entrySet()) {
                    sb.append(entry.getKey() + " price:" + entry.getValue() + "\n");
                    sum += entry.getValue();
                    synchronized (monitor) {
                        totalsum += entry.getValue();
                    }
                    synchronized (monitorForPrint){
                        printresult(entry);
                    }
                }
                printSumAndQueue(sum);
                synchronized (buyer) {
                    buyer.notify();
                }
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean getStatus() {
        return stop;
    }
    private static synchronized int getsum(){
        return totalsum;
    }
    public void goToWork() {
        this.stop = false;
        synchronized (this) {
            notify();
        }
    }

    public void close() {
        this.stop = false;
        synchronized (this) {
            notify();
        }
    }
    public void printresult(Map.Entry<String,Integer> entry){

        if(this.toString().contains("1")){
            System.out.printf("%20s|%20s|%20s|%20s|%20s|%20s|%10s|\n",entry.getKey()+": "+entry.getValue()," "," "," "," "," "," ");
        }
        if(this.toString().contains("2")){
            System.out.printf("%20s|%20s|%20s|%20s|%20s|%20s|%10s|\n"," ",entry.getKey()+": "+entry.getValue()," "," "," "," "," ");
        }
        if(this.toString().contains("3")){
            System.out.printf("%20s|%20s|%20s|%20s|%20s|%20s|%10s|\n"," "," ",entry.getKey()+": "+entry.getValue()," "," "," "," ");
        }
        if(this.toString().contains("4")){
            System.out.printf("%20s|%20s|%20s|%20s|%20s|%20s|%10s|\n"," "," "," ",entry.getKey()+": "+entry.getValue()," "," "," ");
        }
        if(this.toString().contains("5")){
            System.out.printf("%20s|%20s|%20s|%20s|%20s|%20s|%10s|\n"," "," "," "," ",entry.getKey()+": "+entry.getValue()," "," ");
        }
    }
    public void printSumAndQueue(int sum){
        if(this.toString().contains("1")){
            System.out.printf("%20s|%20s|%20s|%20s|%20s|%20s|%10d|\n","Сумма: "+sum," "," "," "," ", QueueBuyer.buyers.size()+"(пенсионеров "+ Dispatcher.pensioneerBuyerInQueueu.toString()+")",getsum());
        }
        if(this.toString().contains("2")){
            System.out.printf("%20s|%20s|%20s|%20s|%20s|%20s|%10d|\n"," ","Сумма: "+sum," "," "," ", QueueBuyer.buyers.size()+"(пенсионеров "+ Dispatcher.pensioneerBuyerInQueueu.toString()+")",getsum());
        }
        if(this.toString().contains("3")){
            System.out.printf("%20s|%20s|%20s|%20s|%20s|%20s|%10d|\n"," "," ","Сумма: "+sum," "," ", QueueBuyer.buyers.size()+"(пенсионеров "+ Dispatcher.pensioneerBuyerInQueueu.toString()+")",getsum());
        }
        if(this.toString().contains("4")){
            System.out.printf("%20s|%20s|%20s|%20s|%20s|%20s|%10d|\n"," "," "," ","Сумма: "+sum," ", QueueBuyer.buyers.size()+"(пенсионеров "+ Dispatcher.pensioneerBuyerInQueueu.toString()+")",getsum());
        }
        if(this.toString().contains("5")){
            System.out.printf("%20s|%20s|%20s|%20s|%20s|%20s|%10d|\n"," "," "," "," ","Сумма: "+sum, QueueBuyer.buyers.size()+"(пенсионеров "+ Dispatcher.pensioneerBuyerInQueueu.toString()+")",getsum());
        }
    }
}
