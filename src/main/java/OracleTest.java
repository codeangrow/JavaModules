






public class OracleTest extends Thread{

    public void run(){

        for (int i = 1 ; i <=3 ; i++) {
            try {
                Thread.sleep(500);
            }catch (Exception e){
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        OracleTest t1= new OracleTest();
        OracleTest t2= new OracleTest();
        OracleTest t3= new OracleTest();

            t1.start();
            try{
                t1.join();
            }catch (Exception e){
                System.out.println(e);
            }


            t2.start();
        try{
            t2.join();
        }catch (Exception e){
            System.out.println(e);
        }
            t3.start();
    }



}


