package by.it.kondratev.jd02_03;

public class CashierDispatcher extends Thread {

    int cashierCount = 5;

    Cashier cashier1 = new Cashier(1);
    Cashier cashier2 = new Cashier(2);
    Cashier cashier3 = new Cashier(3);
    Cashier cashier4 = new Cashier(4);
    Cashier cashier5 = new Cashier(5);


    public void run() {
        cashier1.start();
        cashier2.start();
        cashier3.start();
        cashier4.start();
        cashier5.start();
    }

    //void cashierDispatcher() {        if (Market.queue.size())    }

}
