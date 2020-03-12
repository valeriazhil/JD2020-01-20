package by.it.cherkas.jd02_05;

import by.it.cherkas.jd02_05.translate.Message;
import by.it.cherkas.jd02_05.translate.User;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

class Runner {
    public static void main(String[] args) {
        Locale locale;
        Scanner sc = new Scanner(System.in);
        if (args.length == 2){
            String lang = args[0];
            String country = args[1];
            locale = new Locale(lang, country);
            printStuff(locale);
        }
        while (true){
            String lang = sc.nextLine();
            if (lang.equals("end")){
                break;
            }
            switch (lang){
                case "be":{
                    locale = new Locale("be", "BY");
                    printStuff(locale);
                    break;
                }
                case "ru":{
                    locale = new Locale("ru", "RU");
                    printStuff(locale);
                    break;
                }
                case "en":{
                    locale = new Locale("en", "US");
                    printStuff(locale);
                    break;
                }
                default:{
                    break;
                }
            }
        }
    }

    private static void printStuff(Locale locale) {
        ResMan manager = ResMan.INSTANCE;
        manager.setLocale(locale);
        System.out.println(manager.get(Message.WELCOME));
        System.out.println(manager.get(Message.QUESTION));
        System.out.println(manager.get(User.FIRSTNAME));
        System.out.println(manager.get(User.LASTNAME));
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
        System.out.println(dateFormat.format(new Date()));
    }
}