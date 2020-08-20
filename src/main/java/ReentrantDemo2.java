import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantDemo2 {

    public static void main(String[] args) {

        MyThread2 t1 = new MyThread2();
        MyThread2 t2 = new MyThread2();
        t1.start();
        t2.start();

    }
}


class MyThread2 extends Thread {
    static ReentrantLock l = new ReentrantLock();

    public void run() {

        do {


            try {
                if (l.tryLock(5000, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().getName() + "has Started Working");

                    Thread.sleep(30000);
                    l.unlock();
                    System.out.println(Thread.currentThread().getName() + "Releases The Lock");
                    break;
                } else {

                    System.out.println(Thread.currentThread().getName() + " dint Get the Lock so Performing other Operations");

                }
            } catch (Exception e) {

            }


        } while (true);


    }
}