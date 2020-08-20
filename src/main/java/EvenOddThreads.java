public class EvenOddThreads {

    public static void main(String[] args) {


        MyThread1 t1= new MyThread1();

        t1.start();
        try {
            Thread.currentThread().wait();
        }catch (InterruptedException e){
            System.out.println(e);
        }

        for (int i = 0; i < 100; i++) {

            if (i%2!=0){
                System.out.println(i);
            }


        }


    }
}

class MyThread1 extends Thread{



    public void run(){

        for (int i = 0; i < 100; i++) {
            if (i%2==0){

                System.out.println(i);
                notify();
                try {
                    wait();
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        }
    }
}
