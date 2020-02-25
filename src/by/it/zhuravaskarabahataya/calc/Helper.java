package by.it.zhuravaskarabahataya.calc;

import java.io.*;
import java.util.HashMap;

class Helper {
    private static final String root = System.getProperty("user.dir");

    static String getPath(String fileName, Class<?> cl) {
        String name = cl.getName();
        String path = name
                .replace(cl.getSimpleName(), "")
                .replace('.', File.separatorChar);
        path = root + File.separator + "src" + File.separator + path + fileName;
        return path;
    }

    static void varToFile(String varName, Var var, String filename) {
        try (FileWriter pw = new FileWriter(filename, true)) {
            pw.write(varName + "=" + var + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void exceptionToFile (String fileName, String text){
        try (FileWriter pw = new FileWriter(fileName, true)) {
            pw.write(text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static HashMap<String, Var> getMapFromFile(String filename) {
        HashMap<String, Var> mapa = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        try (
                FileReader fr = new FileReader(filename)) {
            while (fr.ready()) {
                sb.append((char) fr.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (sb.length() > 1) {
            StringBuilder name = new StringBuilder();
            StringBuilder var = new StringBuilder();
            int eqNum = 0;
            int newLineNum = 0;
            int i = 0;
            while (true) {

                if (eqNum == 0 || newLineNum == 0) {
                    if (sb.charAt(i) == '=') {
                        eqNum = i;
                        name.append(sb, 0, i);
                    }
                    if (sb.charAt(i) == '\n') {
                        newLineNum = i;
                        var.append(sb, eqNum + 1, newLineNum);
                        sb.delete(0, newLineNum + 1);
                        break;
                    }
                }
                i++;
            }
            try {
                mapa.put(name.toString(), Var.create(var.toString()));
            } catch (CalcException e) {
                e.printStackTrace();
            }
        }
        return mapa;
    }

}
