package by.it.cherkas.Calculator.translate;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private static final String BASE_NAME = "by.it.cherkas.Calcj.translate.lang.strings";
    ResourceBundle bundle;

    ResMan() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
        Locale.setDefault(locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}