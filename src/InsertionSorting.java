import java.util.Random;
import java.util.Scanner;

public class InsertionSorting {
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
        insertionSort(array);
        System.out.println("\nSelection-Sorted Array : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }


    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;

    }
    public static void insertionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int j = 1;
            int[] newArray = new int[i+1];
            for (int k = 0; k < newArray.length; k++) {
                newArray[k] = array[k];
            }
            for (int k = 0; k < newArray.length - 1; k++) {
                if(array[k] > array[j]) {
                    swap(array,k,j);
                    System.out.println("Swaped "+k+" & "+j);
                }
                j++;
            }
        }
    }
}
