package by.it.kondratev.Proghub;

public class MyThread implements Runnable {
    int count;
    Thread thrd;
    static boolean stop = false;
    static String currentName;

    MyThread(String name) {
        thrd = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    public void run() {
        System.out.println(thrd.getName() + " - запуск . ");
        do {
            count++;
            /*if ( currentName . compareTo ( thrd . getName () ) !=0) {
                currentName = thrd . getName ( ) ;
            System . out . println ( " B " + currentName ) ; }*/
        } while (stop == false && count < 10000000);
        stop = true;
    }
}

             //       System . out . print l n ("\n" + thrd . getName () +
               //     " - прерывание .") ;

            /*

    static int count;
    static boolean stop = false;

    MyThread (String name) {
        super(name);
    }

    public forPriority(String name, int priority) {
        MyThread thrd = new MyThread(name);
        int count = 0;
        myThrd.setPriority(priority);

    }

    @Override
    public void run() {
        do {
            count++;

        } while (stop == false && count<10000000);
        stop = true;

    }

    public int count() {
        return count;
    }
}
*/