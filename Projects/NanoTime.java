import java.util.Random;

public class NanoTime {
    /**public static void main (String[] args){
        for (int i = 0; i < 10; i++) {
            long n0 = System.nanoTime();
            long n1 = System.nanoTime();
            System.out.println("resolution " + (n1 - n0) + " nanoseconds");
        }
    }
    public static void main (String[] args){
        int[] given = {1,2,3,4,5,6,7,8,9,0};
        int sum = 45;
        for (int i = 0; i < 10; i++) {
        long t0 = System.nanoTime();
        long t1 = System.nanoTime();
        System.out.println(" resolution " + (t1 - t0) + " nanoseconds");
        }
        
    }**/
    /**private static double access(int n) {
        int k = 1_000_000;
        int l = n;
        Random rnd = new Random();
      
        int[] indx = new int[l];
        for (int i = 0; i < l ; i++) {
         indx[i] = rnd.nextInt(n);
        }
      
        // fill the indx array with random number from 0 to n (not including n)
        int[] array = new int[n];
        for (int i = 0; i < n ; i++) {
         array[i] = 1;
        }
      
        // fill the array with dummy values (why not 1)
        int sum = 0;
        long t0 = System.nanoTime();
        for (int j = 0; j < k; j++) {
         for (int i = 0; i < l; i++) {
          sum += array[indx[i]];
          // access the array with the index given by indx[i]
          // sum up the result
         }
        }
        long t_access = (System.nanoTime() - t0);
        t0 = System.nanoTime();
      
        for (int j = 0; j < k; j++) {
         for (int i = 0; i < l; i++) {
          sum += indx[i];
          // access the array with the index given by indx[i]
          // sum up the result
         }
        }
        // do the same loop iteration but only do a dummy add operation
        long t_dummy = (System.nanoTime() - t0);
        return ((double)(t_access - t_dummy))/((double)k*(double)l);
       }
      
      
      
      
       public static void main(String[] args) {
        System.out.println(access(1));
        System.out.println(access(10));
        System.out.println(access(50));
        System.out.println(access(100));
        System.out.println(access(1000));
        System.out.println(access(5000));
        System.out.println(access(10000));
       }
    }**/
    public static double linearSeq (int m, int n)  {
        int[] keys = new int[m];
        int[] array = new int[n];
        int k = 1_000_000;
        int sum = 0;
        long t_total = 0;
        Random rnd = new Random();


        for (int j = 0; j < k; j++) {
            for(int i = 0; i < m; i++) {
                keys[i] = rnd.nextInt(10 * n);
            }
            for (int b = 0; b < n; b++) {
                array[b] = rnd.nextInt(10 * n);
            }
            long t0 = System.nanoTime();
            for (int ki = 0; ki < m; ki++) {
                int key = keys[ki];
                for (int i = 0; i < n ; i++) {
                    if (array[i] == key) {
                        sum++;
                        break;
                    }
                }
            }
            t_total += (System.nanoTime() - t0);
        }

        return t_total;
    }
    public static void main(String[] args) {
        System.out.println(linearSeq(1000, 100));
        System.out.println(linearSeq(1000, 200));
        System.out.println(linearSeq(1000, 500));
        System.out.println(linearSeq(1000, 1000));
        System.out.println(linearSeq(1000, 5000));
       }
    }
