import java.util.concurrent.locks.*;
public class ReentrantLockDemo {

    public static void main(String[] args) {

        Display d= new Display();

        MyThreadLock t1= new MyThreadLock(d, "Siddharth");
        MyThreadLock t2= new MyThreadLock(d, "Ayush");
        t1.start();
        t2.start();


    }
}
class Display{
    ReentrantLock l= new ReentrantLock();
    public void wish(String name){
        l.lock();
        for (int i = 0; i <10 ; i++) {

            System.out.println(name + " Working");
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("got Interrupted");
            }

        }
        l.unlock();

    }
}

class MyThreadLock extends Thread{

    Display d;
    String name;

    public MyThreadLock(Display d, String name) {
        this.d = d;
        this.name = name;
    }
    public void run(){

        d.wish(name);
    }

}