package by.it.lomazki.Example.yuriy_Tkach;

@Service(name = "VerylazyInit")
public class LazyService {


    @Init
    public void lazyInit() throws Exception {
        System.out.println("this method lazyInit and class LazyService");
    }
}
