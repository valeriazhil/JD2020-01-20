package by.it.zhuravaskarabahataya.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    ResourceBundle bundle;

    ResMan() {
        setLocale(Locale.getDefault());
    }

    void setLocale(Locale locale){
        String baseName = "by.it.zhuravaskarabahataya.jd02_05.translate.lang";
        bundle = ResourceBundle.getBundle(baseName, locale);
    }

    String get(String key){
        return bundle.getString(key);
    }

}
