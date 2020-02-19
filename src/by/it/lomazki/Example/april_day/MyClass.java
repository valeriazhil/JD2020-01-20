package by.it.lomazki.Example.april_day;

public class MyClass {

    public static void operation(String scMonth) {
        // может подаваться:
        // январь Январь ЯНВАРЬ JANUARY
        // 3

        String [] months = new String[]{
                "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY",
                "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"
        };

        int [] days = new int[] {
                31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        String [] ru = new String[] {
                "ЯНВАРЬ", "ФЕВРАЛЬ", "МАРТ", "АПРЕЛЬ", "МАЙ", "ИЮНЬ", "ИЮЛЬ",
                "АВГУСТ", "СЕНТЯБРЬ", "ОКТЯБРЬ", "НОЯБРЬ", "ДЕКАБРЬ"
        };

            for (int i = 0; i < months.length; i++) {
                if (scMonth.equals(months[i]))
                    System.out.println(months[i]);
            }

            for (int i = 0; i < ru.length; i++) {
                if (scMonth.equals(ru[i]))
                    System.out.println(ru[i]);
            }

            if(Integer.parseInt(scMonth) <= 12  && Integer.parseInt(scMonth) >= 1)
                System.out.println(ru[Integer.parseInt(scMonth)-1]);
        }

}
