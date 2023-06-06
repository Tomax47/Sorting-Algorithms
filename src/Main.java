import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

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


        //CountingSort
        int[] arr = {-1,0,4,2,2,-4,9,7,9,3,1,0,-3,10};
        System.out.println("\n\nArray before count sorting : ");
        System.out.println(Arrays.toString(arr));
        System.out.println("\nArray after count sorting : ");
        new CountingSort(arr).sort();
        System.out.println(Arrays.toString(arr));


        //RadixSorting
        System.out.println("\n\nThe unsorted number array : ");
        int[] numbers = {387, 468, 134, 123, 68, 221, 769, 37, 7};
        System.out.println(Arrays.toString(numbers));
        RedixSort.sort(numbers);
        System.out.println("\nThe Radix sorted array : ");
        System.out.println(Arrays.toString(numbers));

        //Bucket Sorting

        System.out.println("\n\nUnsorted array :");
        BucketSorting sorter = new BucketSorting();
        List<Integer> rawArray = Arrays.asList(80,50,60,30,20,10,70,0,40,500,600,602,200,15);
        printArrayList(rawArray);
        List<Integer> resulted = Arrays.asList(0,10,15,20,30,40,50,60,70,80,200,500,600,602);
        List<Integer> sortedArray = sorter.sort(rawArray);

        if (equalArray(resulted, sortedArray)) {
            System.out.println("\nBucket sorting matched!\nSorted array : ");
            printArrayList(sortedArray);
        }else {
            System.out.println("\nBucket sorting didn't match!");
            printArrayList(sortedArray);
        }

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

    public static boolean equalArray(List<java.lang.Integer> array1, List<java.lang.Integer> array2) {
        return array1.equals(array2);
    }

    public static void printArrayList(List<java.lang.Integer> array) {
        for (int i = 0; i < array.toArray().length; i++) {
            System.out.print(array.toArray()[i]+" ");
        }
        System.out.println();
    }
}
