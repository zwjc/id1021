public class Main {
    public static void main(String[] args) {
        System.out.printf("N\tSelection Sort\tInsertion Sort\tMerge Sort\tMerge Sort Arrays");
        TaskFunctions.benchmark();
        Runtime. getRuntime(). gc();
    }
}