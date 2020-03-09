package by.it.makarenko.jd01_14;

import java.io.File;

public class HelperB {
    private static final String root = System.getProperty("user.dir");

    static String getPath(Class<?> bClass, String fileName){
        String name = bClass.getName();
        String path = name
                .replace(bClass.getSimpleName(),"")
                .replace(".", File.separator);
        return root+File.separator+"src"+File.separator+path+fileName;
    }


}
