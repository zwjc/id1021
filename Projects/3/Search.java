package 3;
import java.util.Random;

public class Search{
    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }

    public static void main (String[] args){
        int[] array = new int[1000];
        int key = 4;
        if (search_unsorted(array, key))
          System.out.print("yes");
        else
          System.out.print("No");
    }
}
