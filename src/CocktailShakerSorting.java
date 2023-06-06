public class CocktailShakerSorting {
    public static void main(String[] args) {

        int[] array = {1,4,2,12,77,23,3,0,9};
        System.out.println("Original array : ");
        printArray(array);

        //sorted array
        shakerSort(array);
        System.out.println("Sorted array : ");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int number : array) {
            System.out.print(number+" ");
        }
    }

    private static void shakerSort(int[] array) {
        int left = 0; // left pointer
        int right = array.length - 1; // right pointer

        while (left < right) {
            // Forward pass
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    System.out.println("Swapped "+array[i]+" & "+array[i + 1]);
                }
            }
            right--;

            // Backward pass
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    System.out.println("Swapped "+array[i]+" & "+array[i - 1]);
                }
            }
            left++;
        }
    }
}
