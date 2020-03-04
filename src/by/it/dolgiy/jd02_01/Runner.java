package by.it.dolgiy.jd02_01;

class Runner {

    static boolean pensioner;
    static int countBuyers = 1;
    static int countOut = 1;

    public static void main(String[] args) {
        System.out.println("The market opened");
        String buyerStr;
        for (int time = 0; time < 120; time++) {
            int currentCount = Helper.random(3)/*getCurrentCount(time)*/;
                for (int i = 0; i < currentCount; i++) {
                    buyerStr = typeOfBuyer(countBuyers);
                    Buyer buyer = new Buyer(countBuyers++,buyerStr);
                    buyer.start();
                    buyerInMarket(time, buyer);
                }
            Helper.sleep(10);
        }
        Helper.sleep(10000);
        System.out.println("The market closed");
    }

    private static void buyerInMarket(int time, Buyer buyer) {
        if (time<30){
            if (countBuyers-countOut>=time+10){
                try {
                    buyer.join();
                } catch (InterruptedException e) {
                    System.out.println("Error:"+e);
                }
            }
        }
        else if (time<60){
            if (countBuyers-countOut>=40+(30-time)){
                try {
                    buyer.join();
                } catch (InterruptedException e) {
                    System.out.println("Error:"+e);
                }
            }
        }
        else if (time<90){
            if (countBuyers-countOut>=time-60+10){
                try {
                    buyer.join();
                } catch (InterruptedException e) {
                    System.out.println("Error:"+e);
                }
            }
        }
        else {
            if (countBuyers-countOut>=40+(30-time-60)){
                try {
                    buyer.join();
                } catch (InterruptedException e) {
                    System.out.println("Error:"+e);
                }
            }
        }
    }

//    private static int getCurrentCount(int time) {
//        int currentCount;
//        if (time<=30){
//            currentCount = Helper.random(time,(time+10));
//        }
//        else if (time<=60){
//            currentCount = Helper.random((30-(30-time)),(40-(30-time)));
//        }
//        else if (time<=90){
//            currentCount = Helper.random(time-60,(time-60+10));
//        }
//        else{
//            currentCount = Helper.random((30-(30-time-60)),(40-(30-time-60)));
//        }
//        return currentCount;
//    }

    private static String typeOfBuyer(int countBuyers) {
        String buyerStr;
        if (countBuyers%4==0){
            pensioner= Helper.random();
            if (pensioner){
                buyerStr = " pensioner";
            }
            else
                buyerStr = "";
        }
        else {
            pensioner=false;
            buyerStr = "";
        }
        return buyerStr;
    }
}
