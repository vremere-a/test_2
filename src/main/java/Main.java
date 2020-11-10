public class Main {
    public static void main(String[] args) {
        Partition.run(5, new int[]{1, 3});
        System.out.println("#t " + (Partition.result - 1));
    }
}
