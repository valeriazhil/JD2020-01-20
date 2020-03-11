package by.it.degtyaryov.calc.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {
    INSTANCE;

    private static final String PATH = "by.it.degtyaryov.calc.i18n.translate.strings";
    private ResourceBundle bundle;

    ResManager() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(PATH, locale);
        Locale.setDefault(locale);
    }

    public Locale getLocale() {
        return bundle.getLocale();
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}
