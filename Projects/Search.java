
import java.util.Random;

public class Unsorted {
    public static void main(String[] args) {
            int[] myIntArray = new int[100];
            for (int i = 0; i < myIntArray.length; i++) {
                myIntArray[i] = (int) (Math.random() * 100);
            }
            System.out.println(Arrays.toString(myIntArray));

            double[] myDoubleArray = new double[100];
            for (int i = 0; i < myDoubleArray.length; i++) {
                myDoubleArray[i] = Math.random() * 100;
            }

            System.out.println(Arrays.toString(myDoubleArray));
        }

    }