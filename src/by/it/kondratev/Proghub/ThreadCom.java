package by.it.kondratev.Proghub;

public class ThreadCom {
    public static void main(String[] args) {

        TickTock tickTock = new TickTock();

        MyThread mt1 = MyThread.createAndStart("Tick", tickTock);
        MyThread mt2 = MyThread.createAndStart("Tock", tickTock);

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
