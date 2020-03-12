package by.it.gerasimov.calc;

import by.it.gerasimov.calc.translate.Globalization;
import by.it.gerasimov.calc.translate.Messages;
import by.it.gerasimov.calc.translate.ResMan;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

abstract class ReportBuilder {

    Deque<String> logs = new LinkedList<>();
    StringBuilder report = new StringBuilder();

    abstract void addHeader();

    void addRunningTime() {
        report.append(Globalization.getCurrentDate()).append('\n');
    }

    abstract void addLines();

    void print() {
        System.out.println(report.toString());
    }

    void readLog() {
        try (BufferedReader br = new BufferedReader(new FileReader(Settings.pathToLog))) {
            String line;
            while ((line = br.readLine()) != null) {
                logs.addLast(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class ShortReportBuilder extends ReportBuilder {

    @Override
    void addHeader() {
        report.append("Short report:\n");
    }

    @Override
    void addLines() {
        readLog();
        for (String log : logs) {
            if (log.contains(ResMan.INSTANCE.get(Messages.ERROR))) {
                report.append(log).append('\n');
            }
        }
    }
}

class FullReportBuilder extends ReportBuilder {

    @Override
    void addHeader() {
        report.append("Full report:\n");
    }

    @Override
    void addLines() {
        readLog();
        for (String log : logs) {
            report.append(log).append('\n');
        }
    }
}