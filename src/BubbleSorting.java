import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSorting {
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
        bubbleSort(array);
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

//    public static int getSmallest(int[] array, int i) {
//        int j =i+1;
//        if (array[i] < array[j]) {
//            j = i;
//        }
//
//        return j;
//    }

    public static void bubbleSort(int[] array) {

        int i = 0;
        int a = 0;
        int j = a + 1;

        int t = 1;

        while(i < Math.pow(array.length - 1,2)) {
            if (array[j] < array[a]) {
                swap(array,a,j);
                System.out.println("Take"+t+" | Swapped "+a+" & "+j);
            }

            if (a == array.length - 2) {
                a = 0;
                j = a + 1;
                t++;
            } else {
                a++;
                j++;
            }
            i++;
        }
    }
}
