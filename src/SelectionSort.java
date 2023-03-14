import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();


        System.out.print("Enter the size of the array : ");
        int n = scan.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(0, 20);
        }

        System.out.println("\nOriginal Array : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }


        //Calculating the start & the end time
        long start = System.currentTimeMillis();
        selectionSort(array);
        long end = System.currentTimeMillis();

        System.out.println("\nSelection-Sorted Array : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        //Printing out the time it took to do the sorting
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("\nExecution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }

    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;

    }

    public static int locateSmallest(int[] array, int a) {
        int i = a;
        int j = i;

        while (i < array.length) {
            if (array[i] < array[j]) {
                j = i;
            }
            i++;
        }

        return j;
    }

    public static void selectionSort(int[] array) {
        int i =0;
        while (i < array.length) {
            int j = locateSmallest(array, i);
            swap(array,i,j);
            i++;
        }
    }


}
