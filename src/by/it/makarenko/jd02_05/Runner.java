package by.it.makarenko.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
//ResMan manager = ResMan.INSTANCE;
        Locale locale = Locale.getDefault();
        if (args.length == 2){
            String lang = args[0];
            String country = args[1];
            Locale local = new Locale(lang,country);
        }
//        manager.setLocale(locale);

        //ResourceBundle.getBundle()
        // sout(manager.get(Message.WELCOME))
    // sout(manager.get(Message.QUESTION))
        // sout(manager.get(Message.FIRSTNAME))
        // sout(manager.get(Message.LASTNAME))
    }
}
