import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class CallableIntro {


    public static void main(String[] args) throws Exception {


        MyCallable[] jobs= {
            new MyCallable(10),
            new MyCallable(20),
            new MyCallable(30),
            new MyCallable(40),
            new MyCallable(50)};


       ExecutorService service= Executors.newFixedThreadPool(3);


        for (MyCallable job:jobs) {

            Future future= service.submit(job);
            System.out.println(future.get());
        }
        service.shutdown();
    }
}

class MyCallable implements Callable{


    private int number;
    private int sum;

    public MyCallable(int number) {
        this.number = number;
    }

    public Object call() throws Exception{
        System.out.println("Printing Sum of first "+ number+ " Numbers");
        for (int i = 1; i <=number ; i++) {

            sum= sum+i;
        }

        return sum;
    }
}
