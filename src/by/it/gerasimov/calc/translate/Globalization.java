package by.it.gerasimov.calc.translate;

import java.text.DateFormat;
import java.util.Locale;

public class Globalization {

    private static ResMan manager = ResMan.INSTANCE;

    public static void switchLang(String lang) {
        lang = lang.trim();
        String[] params = {"", "", ""};
        String[] split = lang.split("_");
        System.arraycopy(split, 0, params, 0, split.length);
        Locale locale = new Locale(params[0], params[1], params[2]);
        manager.setLocale(locale);
    }

    public static void greetings() {
        System.out.println(manager.get(Messages.HELLO) + ", " + manager.get(Messages.USER_NAME));
        System.out.println(getCurrentDate());
    }

    public static String getCurrentDate() {
        return DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault())
            .format(System.currentTimeMillis());
    }
}
