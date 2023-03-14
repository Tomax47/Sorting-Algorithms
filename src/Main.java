import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();


        System.out.print("Enter the size of the array : ");
        int n = scan.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(0,20);
        }

        System.out.println("\nOriginal Array : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }

        //Calculating the start & the end time for each simpleAscendingSort(array) & simpleDescendingSort(array)
        System.out.println("\n");
        long start = System.currentTimeMillis();
        simpleAscendingSort(array);
        long end = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        simpleDescendingSort(array);
        long end2 = System.currentTimeMillis();

        //Printing out the time it took to do the sorting for the simpleAscendingSort(array);
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("\nExecution time is for simpleAscendingSort() " + formatter.format((end - start) / 1000d) + " seconds");

        //Printing out the time it took to do the sorting simpleDescendingSort(array);
        NumberFormat formatter2 = new DecimalFormat("#0.00000");
        System.out.print("\nExecution time is for simpleDescendingSort() " + formatter2.format((end2 - start2) / 1000d) + " seconds");
    }


    //Simple sorting algorithm
    public static void simpleAscendingSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    System.out.println("Swapped "+i+" & "+j);
                }
            }
        }


        System.out.println("\n\nSimple Ascending Sorting Algorithm : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void simpleDescendingSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[j] > array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }


        System.out.println("\n\nSimple Descending Sorting Algorithm : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

}
