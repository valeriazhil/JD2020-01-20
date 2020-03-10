package by.it.dolgiy.jd02_05;

import by.it.dolgiy.jd02_05.translation.Welcome;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResMan manager = ResMan.INSTANCE;
        Locale.setDefault(Locale.US);
        Locale locale/* = Locale.getDefault()*/;
        switch (scanner.nextLine()) {
            case "ru":
                locale = new Locale("ru", "RU");
                break;
            case "be":
                locale = new Locale("be", "BY");
                break;
            case "en":
                locale = new Locale("en", "US");
                break;
            default:
                locale = Locale.getDefault();
                break;
        }
//        if (args.length==2){
//            String lang = args[0];
//            String country = args[1];
//            locale = new Locale(lang,country);
//        }
        manager.changeResource(locale);
        System.out.println(manager.getString(Welcome.WELCOME));
        System.out.println(manager.getString(Welcome.USER_FIRST_NAME));
        System.out.println(manager.getString(Welcome.USER_LAST_NAME));

        Date moment = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date d = null;
        String str = dateFormat.format(moment);
        try {
            d = dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dateFormat = DateFormat.getDateInstance(DateFormat.FULL,locale);
        System.out.println(dateFormat.format(d));
    }
}
