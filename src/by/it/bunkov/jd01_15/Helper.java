package by.it.bunkov.jd01_15;

import java.io.File;

class Helper {

    private static final String root = System.getProperty("user.dir");

    static String getPath(Class<?> aClass, String fileName) {
        String name = aClass.getName();
        String path=name
                .replace(aClass.getSimpleName(),"")
                .replace(".", File.separator);
        return root+File.separator+"src"+File.separator+path+fileName;
    }

}
