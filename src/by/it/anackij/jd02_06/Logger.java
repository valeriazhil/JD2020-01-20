package by.it.anackij.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
    private static volatile Logger logger;

    void log(String message) throws IOException {
        try (
                PrintWriter Writer = new PrintWriter((new FileWriter("D:\\courses\\Git\\JD2020-01-20\\src\\by\\it\\anackij\\jd02_06log.txt", true)));
        ){

        }
    }

    private Logger() {
    }

    public static Logger getInstance() {
        Logger local = logger;
        if (logger == null) {
            synchronized (Logger.class) {
                local = logger;
                if (local == null) {
                    logger = local = new Logger();
                }
            }
        }
        return local;
    }
}
