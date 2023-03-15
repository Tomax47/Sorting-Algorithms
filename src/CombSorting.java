import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

public class CombSorting {
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
        combSort(array);
        long end = System.currentTimeMillis();
        System.out.println("\nMerge-Sorted Array : ");
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

    public static void combSort(int[] array) {

        int gap = (int) (array.length/ 1.3);

//        while (gap >= 1) {
//            for (int i = 0; i < array.length; i++) {
//                for (int j = gap; j < array.length; j++) {
//                    if (array[j] < array[i]) {
//                        swap(array, j, i);
//                        System.out.println("Swapped " + gap + " & " + i);
//                    }
//                }
//                gap = (int) (gap / 1.3);
//            }
//        }


        //ASCENDING ORDER SORT
        while (gap >= 1) {
            for (int i = 0; i < array.length - gap; i++) {
                int j = i + gap;
                while (j < array.length) {
                    if (array[i] > array[j]) {
                        swap(array, i, j);
                        System.out.println("Swapped " + array[i] + " & " + array[j]);
                    }
                    j += gap;
                }
            }
            gap = (int) (gap / 1.3);
        }

    }
}
