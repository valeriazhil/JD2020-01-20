package by.it.degtyaryov.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

class CashierManager {

    public static final int MAX_CASHIER = 5;
    private static final int BUYERS_PER_CASHIER = 5;

    private final ExecutorService executor = Executors.newFixedThreadPool(MAX_CASHIER);
    private final BlockingDeque<Cashier> pausedCashiers = new LinkedBlockingDeque<>(MAX_CASHIER);
    private final BlockingDeque<Cashier> workedCashiers = new LinkedBlockingDeque<>(MAX_CASHIER);
    private final Market market;


    public CashierManager(Market market) {
        this.market = market;
    }

    public void createCashiers() {
        for (int i = 0; i < MAX_CASHIER; i++) {
            Cashier cashier = new Cashier(this);
            executor.submit(cashier);
            pausedCashiers.offerLast(cashier);
        }
        executor.shutdown();
    }

    /**
     * Проверка нужно ли открывать еще кассы (зависит от количества покупателей в оччереди)
     */
    public void check() {
        int cashiersMustWorks = getCashiersMustWorks(market.getQueue().size());
        System.out.printf("DISPATCHER: now in queue %d buyers, working cashiers - %d.%n", market.getQueue().size(), workedCashiers.size());
        if (cashiersMustWorks > workedCashiers.size()) {
            if (workedCashiers.size() < MAX_CASHIER) {
                System.out.printf("DISPATCHER: need to open one more cashier.%n");
                startCashier();
            }
        } else if (cashiersMustWorks < workedCashiers.size()) {
            System.out.printf("DISPATCHER: need to close one cashier.%n");
            stopCashier();
        }
    }

    private int getCashiersMustWorks(int queueSize) {
        return (queueSize / BUYERS_PER_CASHIER) + 1;
    }

    private void startCashier() {
        Cashier cashier = pausedCashiers.pollFirst();
        if (cashier != null) {
            workedCashiers.offerLast(cashier);
            cashier.resume();
        }
    }

    private void stopCashier() {
        Cashier cashier = workedCashiers.pollLast();
        if (cashier != null) {
            pausedCashiers.offerFirst(cashier);
            cashier.pause();
        }
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    public Market getMarket() {
        return market;
    }
}
