package by.it.dolgiy.jd02_01;

class Runner {

    static boolean pensioner;
    static int countBuyers = 1;
    static int countOut = 1;

    public static void main(String[] args) {
        System.out.println("The market opened");
        String buyerStr;
        for (int minute = 0; minute < 2; minute++) {
            for (int second = 0; second < 60; second++) {
                int currentCount = Helper.random(3);
                for (int count = 0; count < currentCount; count++) {
                    buyerStr = typeOfBuyer(countBuyers);
                    Buyer buyer = new Buyer(countBuyers++,buyerStr);
                    buyer.start();
                    buyerInMarket(second, buyer);
                }
                Helper.sleep(10);
            }
        }
        Helper.sleep(10000);
        System.out.println("The market closed");
    }

    private static void buyerInMarket(int time, Buyer buyer) {
        if (countBuyers-countOut>=40-(30-time)){
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.out.println("Error:"+e);
            }
        }
    }

    private static String typeOfBuyer(int countBuyers) {
        String buyerStr;
        if (countBuyers%4==0){
            pensioner= Helper.random();
            if (pensioner){
                buyerStr = " pensioner";
            }
            else{
                buyerStr = "";
            }
        }
        else {
            pensioner=false;
            buyerStr = "";
        }
        return buyerStr;
    }

}
