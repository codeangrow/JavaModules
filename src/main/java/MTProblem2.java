/**
 * Given by Ritesh Sir
 * Print Even and  Odd Threads one by one
 */

public class MTProblem2 {


    public static void main(String[] args) throws Exception {

        final MThread1 t1 = new MThread1();

        t1.start();

        Thread t = new Thread(new Runnable() {
            public void run() {
                t1.display();
            }
        });

        t.start();
        synchronized (MThread1.class) {

            for (int i = 0; i < 10; i++) {

                MThread1.class.wait();
                if (i % 2 == 0) {
                    System.out.println("T2 " + i);
                }
                MThread1.class.notify();
            }
        }


    }
}


class MThread1 extends Thread {


    public void run() {
        synchronized (MThread1.class) {
            for (int i = 0; i < 10; i++) {
                if (i % 2 != 0) {
                    System.out.println("T1 " + i);
                }

                try{
                    this.wait();


                }catch (InterruptedException e){
                    System.out.println("Exception Occured");
                }
            }
        }

    }

    public void display() {

        System.out.println("Printing Something");

    }
}

