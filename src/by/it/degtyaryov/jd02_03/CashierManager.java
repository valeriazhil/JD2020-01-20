package by.it.degtyaryov.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

class CashierManager {

    public static final int MAX_CASHIER = 5;
    private static final int BUYERS_PER_CASHIER = 5;

    private final BlockingDeque<Cashier> pausedCashiers = new LinkedBlockingDeque<>(MAX_CASHIER);
    private final BlockingDeque<Cashier> workedCashiers = new LinkedBlockingDeque<>(MAX_CASHIER);
    private final ExecutorService executor = Executors.newFixedThreadPool(MAX_CASHIER);
    // TODO: убрать переменную "кол-во кассиров в работе", а определять это значнение по размеру OPENED_CASHIERS.size()
    private final AtomicInteger workCashierCount = new AtomicInteger();

    private final Market market;

    public CashierManager(Market market) {
        this.market = market;
    }

    public void launchCashiers() {
        for (int i = 0; i < MAX_CASHIER; i++) {
            Cashier cashier = new Cashier(this);
            executor.submit(cashier);
            pausedCashiers.offerLast(cashier);
        }
        executor.shutdown();
    }

    public void check() {
        int mustBeOpenCashier = getCashiersMustBeOpened(market.getQueue().size());
        System.out.printf("DISPATCHER: now in queue %d buyers, working cashiers - %d.%n", market.getQueue().size(), workCashierCount.get());
        if (mustBeOpenCashier > workCashierCount.get()) {
            if (workCashierCount.get() < MAX_CASHIER) {
                System.out.printf("DISPATCHER: need to open one more cashier.%n");
                startCashier();
            }
        } else if (mustBeOpenCashier < workCashierCount.get()) {
            System.out.printf("DISPATCHER: need to close one cashier.%n");
            stopCashier();
        }
    }

    private int getCashiersMustBeOpened(int queueSize) {
        return (queueSize / BUYERS_PER_CASHIER) + 1;
    }

    private void startCashier() {
        workCashierCount.getAndIncrement();
        Cashier cashier = pausedCashiers.pollFirst();
        if (cashier != null) {
            workedCashiers.offerLast(cashier);
            cashier.resume();
        }
    }

    private void stopCashier() {
        workCashierCount.getAndDecrement();
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
