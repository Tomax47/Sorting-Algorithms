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

        simpleAscendingSort(array);
        simpleDescendingSort(array);
    }


    //Simple sorting algorithm
    public static void simpleAscendingSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
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
