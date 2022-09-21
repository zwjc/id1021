import java.util.Random;

public class BinarySearch{
    public static void main(String[] args){
        int[] lengths = {100, 1000, 10000, 100000, 1000000, 16000000, 64000000};
        Random rndm = new Random();
        int trialRuns = 1000;
        int nKeys = 1;
        int[] keys = new int [nKeys];
        double totalTime = 0;
        double averageTime = 0;
        System.out.printf("%-10s%-10s\n", "Size", "Time Sorted Binary Search");

        int[] test;
        for (int i : lengths){
            totalTime = 0;
            for (int j = 0; j < trialRuns; j++){
                test = generateSorted(i);
                for (int k = 0; k < nKeys; k++){
                    keys[k] = rndm.nextInt(test[i-1]);
                    long t0 = System.nanoTime();
                    binarySearch(test, keys[k]);
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

    public static boolean binarySearch(int[] array, int key){
        int first = 0;
        int last = array.length - 1;
        while(true){
            int index = first + (last-first)/2;
            if (array[index] == key){
                return true;
            }
            if (array[index] < key && index < last){
                first = index + 1;
                continue;
            }
            if (array[index] > key && index > first){
                last = index - 1;
                continue;
            }
            return false;
        }
    }
}