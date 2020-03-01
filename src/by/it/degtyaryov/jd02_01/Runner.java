package by.it.degtyaryov.jd02_01;

class Runner {

    private static final int WORK_TIME = 120;

    public static void main(String[] args) {
        Market market = new Market();
        System.out.println("Market is opened");
        market.startWork(WORK_TIME);
        market.endWork();
        System.out.println("Marked is closed");
    }
}
