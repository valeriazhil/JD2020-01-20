package by.it.degtyaryov.calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class VarSaver {

    private static final String VARS_FILE = Helper.getPath(Var.class, "var.txt");
    private static Map<String, Var> variables = new HashMap<>();

    public static Var saveVariable(String key, Var value) {
        Var var = variables.put(key, value);
        saveVars();
        return var;
    }

    public static void loadVars() throws IOException, CalcException {
        try (BufferedReader reader = new BufferedReader(new FileReader(VARS_FILE))) {
            String var;
            while ((var = reader.readLine()) != null) {
                String[] split = var.trim().split("=");
                variables.put(split[0], VarCreator.create(split[1]));
            }
        }
    }

    private static void saveVars() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(VARS_FILE))) {
            for (Map.Entry<String, Var> entry : variables.entrySet()) {
                String line = String.format("%s=%s%n", entry.getKey(), entry.getValue());
                Logger.getInstance().log(line);
                writer.printf(line);
            }
        } catch (IOException e) {
            Logger.getInstance().log(e.getMessage());
            e.printStackTrace();
        }
    }

    public static Map<String, Var> getVariables() {
        return variables;
    }
}
