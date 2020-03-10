package by.it.akhmelev.calc20.translate;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private String baseName = "by.it.akhmelev.calc20.translate.lang.strings";

    ResourceBundle bundle;

    ResMan() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(baseName, locale);
        Locale.setDefault(locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}
