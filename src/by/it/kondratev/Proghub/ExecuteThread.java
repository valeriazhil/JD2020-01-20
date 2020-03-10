package by.it.kondratev.Proghub;

public class ExecuteThread {

    public static void main(String[] args) {
        System.out.println("Старт основного потока");

        MyThread mt1 = new MyThread("Обычный приоритет");
        MyThread mt2 = new MyThread("Низкий приоритет");
        MyThread mt3 = new MyThread("Высокий приоритет");
        MyThread mt4 = new MyThread("Самый высокий приоритет");
        MyThread mt5 = new MyThread("Самый низкий приоритет");

        mt2.thrd.setPriority(Thread.NORM_PRIORITY-1);
        mt3.thrd.setPriority(Thread.NORM_PRIORITY+1);
        mt4.thrd.setPriority(Thread.NORM_PRIORITY+2);
        mt5.thrd.setPriority(Thread.NORM_PRIORITY-2);


        mt1.thrd.start();
        mt2.thrd.start();
        mt3.thrd.start();
        mt4.thrd.start();
        mt5.thrd.start();

        try {
            mt1.thrd.join();
            mt2.thrd.join();
            mt3.thrd.join();
            mt4.thrd.join();
            mt5.thrd.join();
        } catch (InterruptedException e) {
            System.out.println("Прерывание основного потока");
        }

        System.out.println("Счетчик обычный приоритет: " + mt1.count);
        System.out.println("Счетчик низкий приоритет: " + mt2.count);
        System.out.println("Счетчик высокий приоритет: " + mt3.count);
        System.out.println("Счетчик с.высокий приоритет: " + mt4.count);
        System.out.println("Счетчик с.низкий приоритет: " + mt5.count);
    }
}
