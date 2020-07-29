/**
 * Given by Ritesh Sir
 * Print Even and  Odd Threads one by one
 */

public class MTProblem2 {


    public static void main(String[] args) throws Exception {

        MThread1 t1 = new MThread1();
        t1.start();

        synchronized (Thread.currentThread()) {

            Thread.currentThread().wait();

            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.println("T2 " + i);
                }
                Thread.currentThread().wait();

            }
        }


    }
}


class MThread1 extends Thread {

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                if (i % 2 != 0) {
                    System.out.println("T1 " + i);
                }
                this.notify();
            }
        }


    }
}

