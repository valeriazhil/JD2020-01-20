package by.it.zhilenkova.jd02.ZhilenkovaCalcAll;


class Printer {

    Logger logger = Logger.getLogger();

    void print(String result) {
        if (result != null)
            System.out.println(result);
    }

    void showError(CalcException e) {
        System.err.println(e.getMessage());
    }

}
