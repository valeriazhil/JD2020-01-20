package by.it.akhmelev.jd02_05;

import by.it.akhmelev.jd02_05.translate.Message;
import by.it.akhmelev.jd02_05.translate.User;

import java.util.Locale;

public class Runner {

    public static void main(String[] args) {
        ResMan manager=ResMan.INSTANCE;
        Locale locale = Locale.getDefault();
        if (args.length == 2) {
            String lang = args[0];
            String country = args[1];
            locale = new Locale(lang, country);
        }
        manager.setLocale(locale);
        
        
        System.out.println(manager.get(Message.WELCOME));
        System.out.println(manager.get(Message.QUESTION));
        System.out.println(manager.get(User.FIRST_NAME));
        System.out.println(manager.get(User.LAST_NAME));
    }


}
