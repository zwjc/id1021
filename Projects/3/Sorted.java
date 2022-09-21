
import java.util.Random;

public class Sorted2{
    public static void main(String[] args){
        int[] lengths = {100, 200, 400, 800, 1600, 3200, 6400};
        Random rndm = new Random();
        int trialRuns = 1000;
        int nKeys = 1000;
        int[] keys = new int [nKeys];
        double totalTime = 0;
        double averageTime = 0;
        System.out.printf("%-10s%-10s\n", "Size", "Time Sorted");

        int[] test;
        for (int i : lengths){
            totalTime = 0;
            for (int j = 0; j < trialRuns; j++){
                test = generateSorted(i);
                for (int k = 0; k < nKeys; k++){
                    keys[k] = rndm.nextInt(test[i-1]);
                    long t0 = System.nanoTime();
                    searchSorted(test, keys[k]);
                    long t1 = System.nanoTime();
                    totalTime += t1-t0;
                }
            }
            averageTime = totalTime / nKeys / trialRuns;
            System.out.printf("%-10s%-10s\n", i, averageTime);
        }
    }

    public static int[] generateSorted(int n){
        Random rndm = new Random();
        int[] array = new int[n];
        int next = 0;
        for (int i = 0; i < n; i++){
            next = next + rndm.nextInt(10) + 1;
            array[i] = next;
        }
        return array;
    }

    public static boolean searchSorted(int[] array, int key){
        for (int i = 0; i < array.length; i++){
            if (array[i] > key){
                return false;
            }
            if (array[i]  == key){
                return true;
            }
        }
        return false;
    }
}