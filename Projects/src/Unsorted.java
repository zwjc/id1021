import java.util.Random;

public class Unsorted{
    public static void main(String[] args){
        int[] lengths = {100, 1000, 10000, 100000, 1000000};
        Random rndm = new Random();
        //trialRuns for average
        int trialRuns = 10000;
        int nKeys = 1;
        int[] keys = new int [nKeys];
        double totalTime = 0.0;
        double averageTime = 0.0;
        System.out.printf("%-10s%-10s\n", "Size", "Time for Unsorted");

        int[] test;
        for (int i : lengths){
            totalTime = 0;
            for (int j = 0; j < trialRuns; j++){
                test = generateUnsorted(i);
                for (int k = 0; k < nKeys; k++){
                    keys[k] = rndm.nextInt(test[i-1]);
                    long t0 = System.nanoTime();
                    searchUnsorted(test, keys[k]);
                    long t1 = System.nanoTime();
                    totalTime += t1-t0;
                }
            }
            averageTime = totalTime / nKeys / trialRuns;
            System.out.printf("%-10s%-10s\n", i, averageTime);
        }
    }

    //generate a randomly sorted array between 1 - 10
    public static int[] generateUnsorted(int n){
        Random rndm = new Random();
        int[] array = new int[n];
        int next = 0;
        for (int i = 0; i < n; i++){
            //each one is larger than previous +=
            next = rndm.nextInt(10) + 1;
            array[i] = next;
        }
        return array;
    }

    public static boolean searchUnsorted(int[] array, int key){
        for (int index = 0; index < array.length; index++){
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }
}