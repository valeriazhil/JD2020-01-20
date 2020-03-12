package by.it.degtyaryov.calc;

class Expression {

    private String operation;
    private String result;


    public Expression(String operation, String result) {
        this.operation = operation;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
