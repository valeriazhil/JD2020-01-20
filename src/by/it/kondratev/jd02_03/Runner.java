package by.it.kondratev.jd02_03;

public class Runner {

    public static void main(String[] args) {
        String goodsName = "Хурма";
        System.out.println(WorkDay.PRICE_LIST);
        System.out.println(WorkDay.PRICE_LIST.get(goodsName));
    }
}
