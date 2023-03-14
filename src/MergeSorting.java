import java.util.Random;
import java.util.Scanner;

public class MergeSorting {
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
        mergeSort(array);
        System.out.println("\nMerge-Sorted Array : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void mergeSort(int[] array) {

        while (array.length < 2) {
            return;
        }

        int midPoint = array.length / 2;

        int[] leftArray = new int[midPoint];
        int[] rightArray = new int[array.length - midPoint];

        for (int i = 0; i < midPoint; i++) {
            leftArray[i] = array[i];
        }

        for (int i = midPoint; i < array.length; i++) {
            rightArray[i - midPoint] = array[i];
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        //Merge all the arrays
        merge(array,leftArray,rightArray);
    }

    public static void merge(int[] array ,int[] leftArray ,int[] rightArray) {
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                array[k] = leftArray[i];
                i++;
                System.out.println("Swapped "+i+" & "+j);
            } else {
                array[k] = rightArray[j];
                j++;
                System.out.println("Swapped "+i+" & "+j);
            }
            k++;
        }

        while (i < leftArray.length) {
            array[k] = leftArray[i];
            i++;
            k++;
            System.out.println("Added "+i+" to the end\n");
        }

        while (j < rightArray.length) {
            array[k] = rightArray[j];
            j++;
            k++;
            System.out.println("Added "+j+" to the end\n");
        }
    }
}
