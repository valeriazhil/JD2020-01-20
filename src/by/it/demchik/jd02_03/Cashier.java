package by.it.demchik.jd02_03;

class Cashier implements Runnable {

    private String name;

    public Cashier(int number) {
        name = "\tCashier № " + number + " ";
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Dispatcher.marketClosed()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                //если есть кого обслуживать, то начинаем это делать
                System.out.println(this + "started service for " + buyer);
                int timeout = Helper.random(2000, 5000);
                Helper.sleep(timeout);
                System.out.println(this + "finished service for " + buyer);
                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (buyer) {
                    buyer.endWait();
                    buyer.notify(); //разбудили покупателя
                }
            } else {
                //подумайте, как тут правильно
                // сделать wait для кассира
                Helper.sleep(1);
            }
        }
        System.out.println(this + "closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
