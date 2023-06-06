import java.util.Arrays;

public class CountingSort {

    //Sorting time : n + k
    private int[] array;

    public CountingSort(int[] array) {
        this.array = array;
    }


    public void sort (int min, int max) {
        int[] countArray = new int[max - min + 1];

        for (int value : array) {
            countArray[max - min]++;
        }

        int index =0;
        for (int i = 0; i < max - min + 1; i++) {
            while (countArray[i]>0) {
                array[index] = i + min;
                countArray[i]--;
                index++;
            }
        }
    }

    public void sort () {
        int min = Arrays.stream(array).min().orElse(0);
        int max = Arrays.stream(array).max().orElse(Integer.MAX_VALUE);
        
        int[] countArray = new int[max - min + 1];
        
        for (int value : array) {
            countArray[value - min]++;
        }

        int index =0;
        for (int i = 0; i < max - min + 1; i++) {
            while (countArray[i]>0) {
                array[index] = i + min;
                countArray[i]--;
                index++;
            }
        }
    }
}
