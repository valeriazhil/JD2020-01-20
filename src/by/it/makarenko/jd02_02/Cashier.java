package by.it.makarenko.jd02_02;


public class Cashier implements Runnable{
    private String name;

    public Cashier(int number){
        name="\tCashier № "+number+" ";
    }

    @Override
    public void run() {
        System.out.println(this+"Open");
        while (Dispatcher.marketIsOpend()){
            Buyer buyer = QueueBuyer.extract();
            if (buyer!=null){
                System.out.println(this+"start to service "+buyer);
                int timeout = HelperTime.random(500,2000);
                HelperTime.sleep(timeout);
                System.out.println(this+"finish to service "+buyer);
                synchronized (buyer){
                    buyer.notify();
                }
            }else{
                HelperTime.sleep(1); //подумать, по поводу того, что будить нужно продовца
            }
        }

        System.out.println(this+"Close");
    }

    @Override
    public String toString(){
        return name;
    }
}
