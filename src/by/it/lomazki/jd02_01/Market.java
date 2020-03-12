package by.it.lomazki.jd02_01;

class Market {
    public static void main(String[] args) {
        int countBuyers = 0;
        for (int time = 0; time < 120; time++) {
            int currentCount = TimerHelper.random(2);
            for (int i = 0; i < currentCount; i++) {
                Buyer buyer = new Buyer(++countBuyers);
                buyer.start();
            }
            TimerHelper.sleep(1000);
        }
        TimerHelper.sleep(5000);
        System.out.println("in: " + countBuyers);
        System.out.println("out: " + countBuyers);
    }
}
