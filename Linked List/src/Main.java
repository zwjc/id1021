public class Main {

    public static void main(String[] args) {
        int iterations = 10_000;
        LinkedList linkedList = new LinkedList();
        ArrayAppend arAppend = new ArrayAppend();
        System.out.println("Append increasing size array infront of of fixed size array");
        int arraySize = 10000;

        for (int i = 100; i <= arraySize; i += 100) {
            System.out.printf("%d\t %f%n", i, arAppend.benchmarkArrayAppendEnd(i, iterations));
        }
    }
}