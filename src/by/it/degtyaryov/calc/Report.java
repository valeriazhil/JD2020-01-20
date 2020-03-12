package by.it.degtyaryov.calc;

import by.it.degtyaryov.calc.i18n.ResManager;
import by.it.degtyaryov.calc.i18n.TextResource;

import java.util.ArrayList;
import java.util.List;

class Report {

    private String title = "";
    private String startTime = "";
    private String endTime = "";
    private List<String> operations = new ArrayList<>();

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setOperations(List<String> operations) {
        this.operations = operations;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append('\n')
                .append(ResManager.INSTANCE.get(TextResource.START_TIME)).append(" ").append(startTime).append('\n')
                .append(ResManager.INSTANCE.get(TextResource.END_TIME)).append(" ").append(endTime).append("\n");
        for (String operation : operations) {
            sb.append('\n').append(operation);
        }
        return sb.toString();
    }
}
