package by.it.zhuravaskarabahataya.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private String baseName = "by.it.zhuravaskarabahataya.jd02_05.translate.lang";

    ResourceBundle bundle;

    private ResMan() {
        setLocale(Locale.getDefault());
    }

    void setLocale(Locale locale){
        bundle = ResourceBundle.getBundle(baseName, locale);
    }

    String get(String key){
        return bundle.getString(key);
    }

}
