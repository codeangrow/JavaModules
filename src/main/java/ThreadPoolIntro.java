import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolIntro {
    public static void main(String[] args) {

        MyPool[] pools = {
                new MyPool("Cleaning"),
                new MyPool("Wiping"),
                new MyPool("Cooking"),
                new MyPool("Sweeping"),
                new MyPool("Washing"),
                new MyPool("Irrigation"),
                new MyPool("CarWash"),
                new MyPool("Breakfast Preparation"),

        };

        ExecutorService service = Executors.newFixedThreadPool(8);


        for (MyPool p : pools) {
            service.submit(p);
        }
        service.shutdown();
    }
}

class MyPool implements Runnable {

    String name;

    public MyPool(String name) {
        this.name = name;
    }

    public void run() {

        System.out.println(name + " Job Started By " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }

        System.out.println(name + " Job Completed By: " + Thread.currentThread().getName());
    }
}