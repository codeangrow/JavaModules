import java.util.Arrays;
import java.util.Collections;

public class TekSystemCode {

    public static void main(String[] args) throws Exception {


        int[] array = {20, 5, 10, 60, 30,89};


        array = move(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }


    }

    public static int[] move(int[] array) throws Exception {

        Arrays.sort(array);
        int totalMovements = 0;
        int maxSize = array[array.length - 1];
        int sum = 0;

        int buffer = 0;

        for (int i = 0; i < array.length; i++) {

            sum += array[i];
        }

        int avg = sum / array.length;



        for (int i = array.length - 1; i >= 0; i--) {

            System.out.println("Current Stack Size: " + array[i]);
            int temp = 0;
            if (array[i] > avg) {
                temp = array[i] - avg;
                System.out.println("Excess in current Stack is : " + temp);
                array[i] = array[i] - temp;
                buffer = buffer + temp;
                System.out.println("Stack Size after Movement: " + array[i]);
                System.out.println("Now Buffer is: " + buffer);
                int bufferTem = buffer;
                totalMovements = totalMovements + bufferTem;
            } else {
                System.out.println("Current Stack Size: " + array[i]);
                int require = avg - array[i];
                System.out.println("Required to meet Average Size(25) is : " + require);
                if (buffer >= require) {
                    array[i] = array[i] + require;
                    buffer = buffer - require;
                    System.out.println("Stack Size after Movement: " + array[i]);
                    System.out.println("Now Buffer is: " + buffer);
                }
            }
            System.out.println("----------------------------------");
            Thread.sleep(2000);

        }

        System.out.println("Total Number of Movements required are : " + totalMovements);
        return array;
    }


}
