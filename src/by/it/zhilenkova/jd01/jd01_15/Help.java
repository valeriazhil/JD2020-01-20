package by.it.zhilenkova.jd01.jd01_15;

import java.io.File;

public class Help {

    private Help() {
    }

    static String getPath(Class<?> clazz) {
        String simpleName = clazz.getSimpleName();
        String path = clazz.getName().replace(simpleName, "");
        path = path.replace(".", File.separator);
        String root = System.getProperty("user.dir");
        String result = root + File.separator + "src" + File.separator + path;
        return result;
    }

    static String getPath() {
        return getPath(by.it.zhilenkova.jd01.jd01_15.Help.class);
    }

    static String getPath(String filename) {
        return getPath() + filename;
    }
}