package by.it.zhuravaskarabahataya.jd02_02;

class Cashier implements Runnable {

    private String name;
    private int number;
    private boolean isNeeded = false;

    void setNeededFalse() {
        this.isNeeded = false;
    }

    void setNeededTrue() {
        this.isNeeded = true;
    }

    Cashier(int number) {
        name = "\tCashier № " + number;
        this.number = number;
        CashierManager.addToCashierQueue(this);

        System.out.println(this + "created");
    }

    String getName() {
        return name;
    }

    int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        while (isNeeded) {
            Buyer buyer = null;
            if (QueuePens.getQueueLength() != 0) {
                buyer = QueuePens.extract();
                System.out.println(this + " has a client");
            } else if (QueueBuyers.getQueueLength() != 0) {
                buyer = QueueBuyers.extract();
                System.out.println(this + " has a client");
            }
            if (buyer != null) {
                ScreenPrinter.printSmthCashier(this," started to service " + buyer + ".");
                int timeout = TimingHelper.random(2000, 5000);
                TimingHelper.sleep(timeout / Dispatcher.K_SPEED);
                Dispatcher.payForGoods(buyer.personalBasket.totalPrice);
                ScreenPrinter.printBill(buyer, this);
                ScreenPrinter.printSmthCashier(this, " finished to service " + buyer + ".");
                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (buyer) {
                    buyer.notify();
                }
            }
        }
        ScreenPrinter.printSmthCashier(this, " closed.");
    }
}
