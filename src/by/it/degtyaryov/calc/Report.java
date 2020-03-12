package by.it.degtyaryov.calc;

class Report {

    private String title = "";
    private String startTime = "";
    private String endTime = "";
    private String operation = "";

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Report{" +
                "title='" + title + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }
}
