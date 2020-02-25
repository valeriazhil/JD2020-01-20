package by.it.dolgiy.jd02_01;

class Runner {
    public static void main(String[] args) {
        int countBuyers = 0;
        for (int time = 0; time < 120; time++) {
            int currentCount = Helper.random(2);
            for (int i = 0; i < currentCount; i++) {
                Buyer buyer = new Buyer(++countBuyers);
                buyer.start();
            }
            Helper.sleep(100);
        }
    }
}
