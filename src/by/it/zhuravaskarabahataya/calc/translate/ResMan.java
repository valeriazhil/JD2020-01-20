package by.it.zhuravaskarabahataya.calc.translate;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private String baseName = "by.it.zhuravaskarabahataya.calc.translate.lang.lang";

    ResourceBundle bundle;

    private ResMan() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale){
        bundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String get(String key){
        return bundle.getString(key);
    }

}
