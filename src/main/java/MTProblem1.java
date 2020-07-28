/** First Problem By Ritesh Sir
 * Creates a Thread
 * keep main thread in waiting
 * complete newly created thread first and then execute main thread
 */

public class MTProblem1 {


    public static void main(String[] args) throws Exception {


        MyThread t1= new MyThread();
        t1.start();

        t1.join();
        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread Executing");
        }

    }

}

class MyThread extends Thread{


    public void run(){
        for (int i = 0; i <5 ; i++) {

            System.out.println("Child Thread Executing");
        }
    }
}