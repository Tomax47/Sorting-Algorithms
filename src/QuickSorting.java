import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

public class QuickSorting {
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

        System.out.println("\n");

        //Calculating the start & the end time
        long start = System.currentTimeMillis();
        quickSort(array, 0 , array.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("\nQuick-Sorted Array : ");
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

    public static void quickSort(int[] array, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return;
        }

        int pivot = array[highIndex];
        int lPointer = lowIndex;
        int rPointer = highIndex;


        while (lPointer < rPointer) {

            while (array[lPointer] <= pivot && lPointer < rPointer) {
                lPointer++;
            }

            while (array[rPointer] >= pivot && rPointer > lPointer) {
                rPointer--;
            }
            swap(array, lPointer, rPointer);
        }

        swap(array, lPointer, highIndex);

        quickSort(array,lowIndex,lPointer - 1);
        quickSort(array, lPointer + 1, highIndex);
    }
}
