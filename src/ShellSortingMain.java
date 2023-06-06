import java.util.Arrays;

public class ShellSortingMain {

    public static void main(String[] args) {

        Integer[] numbers = {1,4,2,12,77,23,3,0,9};
        String[] names = {"Jake", "Alexis","Dima","Lukas","Gregory"};

        System.out.println("Arrays pre-sorting : ");
        System.out.println(Arrays.toString(numbers)+"\n"+Arrays.toString(names));
        System.out.println("Sorted arrays : ");
        //Value-based sorting the array
        ShellSorting<Integer> numbersSorted = new ShellSorting<>(numbers);
        numbersSorted.shellSort();
        numbersSorted.printArray();

        System.out.println();
        //An alphabetic sorting is applied on the names
        ShellSorting<String> namesSorted = new ShellSorting<>(names);
        namesSorted.shellSort();
        namesSorted.printArray();

    }

}
