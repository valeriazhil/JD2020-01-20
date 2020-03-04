package by.it.zhuravaskarabahataya.jd02_03;

class Cashier implements  Runnable{

    private String name;
    private int number;
    static final Integer MY_MONITOR = new Integer(0);
    static int cashierNeeded;
//    public String getName() {
//        return name;
//    }

    Cashier(int number) {
        //super("\tCashier №" + number);
        name = "\tCashier № " + number;
        this.number = number;

      //  CashierManager.addToNotWorkingCashiers(this);
       // Market.threads.add(this);
        System.out.println(this + "created");
    }


    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
            while (!Dispatcher.marketIsClosed()) {
//                cashierNeeded = Dispatcher.getBuyersInQueue() / 5
//                        + (Dispatcher.getBuyersInQueue() % 5 > 0 ? 0 : 1);
//                if (this.number <= cashierNeeded) {
                    Buyer buyer = null;
                    if (QueuePens.getQueueLength() != 0) {
                        buyer = QueuePens.extract();
                        System.out.println(this + " has a client");
                    } else if (QueueBuyers.getQueueLength() != 0) {
                        buyer = QueueBuyers.extract();
                        System.out.println(this + " has a client");
                    }
                    if (buyer != null) {
                        System.out.println(this + " started to service " + buyer + ".");
                        int timeout = TimingHelper.random(2000, 5000);
                        TimingHelper.sleep(timeout / Dispatcher.K_SPEED);
                        Dispatcher.payForGoods(buyer.personalBasket.totalPrice);
                        ScreenPrinter.printBill(buyer, this);
                        System.out.println(this + " finished to service " + buyer + ".");
                        synchronized (buyer) {
                            buyer.setWaitingState(false);
                            buyer.notify();
                        }
                    } else {
                        //покупательно должен разбудить кассира
//                    }
                }
            }
            System.out.println(this + " closed................");
    }
}
