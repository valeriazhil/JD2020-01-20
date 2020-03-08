package by.it.kondratev.jd02_02;

class Cashier extends Thread {

    Buyer buyer;

    Cashier (int number) {
        super("Касса № " + number);
    }

    public void run() {
        System.out.println("Открылась " + getName());
        cashierWork();
        System.out.println("Закрылась " + getName());
    }

    private void cashierWork() {
        boolean freeBuyer;
        do {  
            freeBuyer = false;
            synchronized (Market.MONITOR) {
                if (!Market.queue.isEmpty()) {
                    this.buyer = Market.queue.removeLast();
                    System.out.println(this.buyer.getName() + " обслуживается в " + getName());
                    freeBuyer = true;
                }
                if (freeBuyer) {
                    serveOneBuyer(this.buyer);
                    this.buyer.inLine = false;
                    Market.MONITOR.notifyAll();
                }
            }
        } while (Market.compliteBuyers < 10);
    }

    private void serveOneBuyer(Buyer buyer) {
        int sum = 0;
        String goodsName;
        StringBuilder sb = new StringBuilder("Чек  для " + buyer.getName() + ":\n");

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




