public class ShellSorting <T extends Comparable<T>>{
    private final T[] array;

    public ShellSorting(T[] array) {
        this.array = array;
    }

    public void shellSort() {
        for (int gap = array.length/2; gap > 0; gap/=2 ) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                while (j >= gap && array[j].compareTo(array[j - gap]) < 0) {
                    swap(array,j,(j-gap));
                    j -= gap;
                }
            }
        }
    }

    public void swap(T[] array, int firstElement, int secElement) {
        T temp = array[firstElement];
        array[firstElement] = array[secElement];
        array[secElement] = temp;
    }


    public void printArray(){
        for (T element : array) {
            System.out.print(element+" ");
        }
    }
}
