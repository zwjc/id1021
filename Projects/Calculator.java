import java.util.Random;

public class Tester {
    public static void main (String [] args)
    {
        double [] arr = timerStaticStack(100);
        System.out.println("Pushing until static stack is full takes: " + arr[0] + "ns");
        System.out.println("Popping until static stack is empty takes: " + arr[1] + "ns");
        System.out.println("In total: " + arr[2] + "ns");

    }
    public static double [] timerStaticStack (int dataSize)
    {
        StaticStack stack = new StaticStack(dataSize);
        Random rand = new Random();
        double timeRecords [] = new double [3];
        long t0 = System.nanoTime();
        for(int i = 0; i < dataSize; i++)
        {
            stack.push(rand.nextInt(10 * dataSize));
        }
        timeRecords[0] = (System.nanoTime() - t0);
        t0 = System.nanoTime();
        for(int i = 0; i < dataSize; i++)
        {
            stack.pop();
        }

        timeRecords[1] = (System.nanoTime() - t0);
        timeRecords[2] = timeRecords[0] + timeRecords[1];
        return timeRecords;
    }
}