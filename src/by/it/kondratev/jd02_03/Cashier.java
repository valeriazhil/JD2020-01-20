package by.it.kondratev.jd02_03;

class Cashier extends Thread {

    Buyer buyer;
    int number;
    boolean nextCashierWorks;
    boolean continueWork;

    Cashier (int number) {
        super("Касса № " + number);
        this.number = number;
    }

    public void run() {
        System.out.println("Открылась " + getName());
        cashierWork();
        System.out.println("Закрылась " + getName());
    }

    private void cashierWork() {
        nextCashierWorks = false;
        boolean freeBuyer;
        do {  
            freeBuyer = false;
            synchronized (Market.MONITOR) {
                if (!Market.queue.isEmpty()) {
                    this.buyer = Market.queue.removeFirst();
                    System.out.println(this.buyer.getName() + " обслуживается в " + getName());
                    freeBuyer = true;
                }
                if (freeBuyer) {
                    serveOneBuyer(this.buyer);
                    this.buyer.inLine = false;
                    Market.MONITOR.notifyAll();
                    cashierManage();
                }
            }
            yield();
            Helper.sleep(10);
        } while (Market.compliteBuyers < Market.MAX_BUYERS);
    }

    private void cashierManage() {
        if (Market.queue.size()>this.number*5
                && !nextCashierWorks
                && this.number!=5) {
            Cashier next = new Cashier(this.number+1);
                    next.start();
            nextCashierWorks = true;
        }

    }

    private void serveOneBuyer(Buyer buyer) {
        int sum = 0;
        String goodsName;
        StringBuilder sb = new StringBuilder("Чек  для " + buyer.getName() + ":\n");
        Helper.sleep(Helper.random(2000,5000) / Dispatcher.SPEED);

        for (int i = 0; i < buyer.basket.list.size(); i++) {
            goodsName = buyer.basket.list.get(i);
            sum += WorkDay.PRICE_LIST.get(goodsName);
            sb.append(i + 1).append(") ").append(goodsName).append(".....").
                    append(WorkDay.PRICE_LIST.get(goodsName)).append('\n');
        }
        sb.append("Итого к оплате: ").append(sum);
        System.out.println(sb);
    }
}




