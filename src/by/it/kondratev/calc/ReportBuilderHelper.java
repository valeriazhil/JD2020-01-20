package by.it.kondratev.calc;

import java.util.Date;

class ReportBuilderHelper {

    Date calendar = new Date();

    String dateAndTime() {
        String date = String.format("%1$td.%1$tm.%1$tY", calendar);
        String time = String.format("%tH:%tM:%tS", calendar, calendar, calendar);
        return date + " ||  " + time + " ||\n";
    }

    String reportTitle(int i) {
        String result;
        switch (i) {
            case 1:
                result = "Отчет о событиях\n"; break;
            case 2:
                result = "Полный отчет об ошибках\n"; break;
            default:
                result = "Краткий отчет об ошибках\n"; break;
        }
        return result;
    }
}
