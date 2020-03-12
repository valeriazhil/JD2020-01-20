package by.it.kondratev.Proghub;

class MyThread implements Runnable{

    Thread thrd;
    TickTock ttOb;

    MyThread (String name, TickTock tt) {
        thrd = new Thread(this,name);
        ttOb = tt;
    }

    public static MyThread createAndStart(String name, TickTock tt) {
        MyThread myThread = new MyThread(name,tt);
        myThread.thrd.start();
        return  myThread;
    }

    @Override
    public void run() {

        if(thrd.getName().equals("Tick")) {
            for (int i = 0; i < 5; i++) {
                ttOb.tick(true);
                ttOb.tick(false);
            }
        }
        else for (int i = 0; i < 5; i++) {
            ttOb.tock(true);
            ttOb.tock(false);
        }
    }
}
