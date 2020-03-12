package by.it.makarenko.jd02_05;

import by.it.makarenko.jd02_05.trans.Message;

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
        ResMan manager = ResMan.INSTANCE;
        Locale locale = Locale.getDefault();
        if (args.length == 2){
            String lang = args[0];
            String country = args[1];
            locale = new Locale(lang,country);
        }
        manager.setLocale(locale);

        System.out.println(manager.get(Message.WELCOME));
        System.out.println(manager.get(Message.QUESTION));
        System.out.println(manager.get(Message.FIRSTNAME));
        System.out.println(manager.get(Message.LASTNAME));
    }
}
