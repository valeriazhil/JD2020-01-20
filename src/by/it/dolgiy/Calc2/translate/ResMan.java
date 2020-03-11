package by.it.dolgiy.Calc2.translate;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private ResourceBundle bundle;

    ResMan() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        String baseName = "by.it.dolgiy.Calc.translate.lang.calc_errors";
        bundle = ResourceBundle.getBundle(baseName, locale);
        Locale.setDefault(locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}
