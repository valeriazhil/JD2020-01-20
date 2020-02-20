package by.it.lomazki.Example.yuriy_Tkach;

@Service(name = "superSimpleService")
public class SimpleService {


    @Init
    public void initService() {
        System.out.println("this method initService and class SimpleService");
    }
}
