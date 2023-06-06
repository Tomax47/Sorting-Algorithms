import java.util.Arrays;
import java.util.Random;

public class HSMain extends HeapSort{
    public static void main(String[] args) {
        Random rnd = new Random();

        HeapSort numbers = new HeapSort();

        numbers.fillArray();
        numbers.printArray();

        System.out.println("\nPeek : "+numbers.getPeek());
        System.out.println("\nPoll : "+numbers.poll());
        numbers.printArray();

        int n = 9;
        System.out.println("\nAdd : "+n);
        numbers.add(n);
        numbers.printArray();

        System.out.println("\nHeapify down : ");
        numbers.heapifyDown();
        numbers.printArray();
    }
}
